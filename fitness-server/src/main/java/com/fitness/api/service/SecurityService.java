package com.fitness.api.service;

import com.fitness.api.data.entity.BaseUserEntity;
import com.fitness.api.data.entity.CoachEntity;
import com.fitness.api.data.mapper.BaseUserMapper;
import com.fitness.api.data.mapper.ClientMapper;
import com.fitness.api.data.mapper.CoachMapper;
import com.fitness.api.data.repository.BaseUserRepository;
import com.fitness.api.dto.security.AuthInfoDto;
import com.fitness.api.dto.security.BaseUserCreateDto;
import com.fitness.api.dto.security.LoginUserDto;
import com.fitness.api.dto.security.currentUser.BaseUserDto;
import com.fitness.api.security.JwtSupplier;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class SecurityService {

    private final BaseUserRepository baseUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtSupplier jwtSupplier;

    private final ClientService clientService;
    private final CoachService coachService;


    public void createBaseUser(BaseUserCreateDto baseUserCreateDto) {
        baseUserCreateDto.setPassword(passwordEncoder.encode(baseUserCreateDto.getPassword()));
        var entity = BaseUserMapper.INSTANCE.baseUserCreateDtoToEntity(baseUserCreateDto);
        baseUserRepository.save(entity);
    }

    public AuthInfoDto loginUser(LoginUserDto loginUserDto) throws EntityNotFoundException {
        var user = findByUsername(loginUserDto.getUsername());
        if (passwordEncoder.matches(loginUserDto.getPassword(), user.getPassword())) {
            var token = jwtSupplier.createToken(user.getId(), user.getUsername(), user.getRole());
            return new AuthInfoDto(token);
        } else {
            throw new EntityNotFoundException("Invalid login or password");
        }
    }

    private BaseUserEntity findByUsername(String username) throws EntityNotFoundException {
        var baseUserEntity = baseUserRepository.findByUsername(username);
        if (baseUserEntity == null) {
            throw new EntityNotFoundException("Entity Not Found Exception");
        }
        return baseUserEntity;
    }

    public BaseUserDto getCurrentUser(String name) {
        var baseUserEntity = baseUserRepository.findByUsername(name);
        switch (baseUserEntity.getRole()) {
            case CLIENT -> {
                return ClientMapper.INSTANCE.clientEntityToClientInfoDto(clientService.getClientByBaseUser(baseUserEntity));
            }
            case COACH -> {
                return CoachMapper.INSTANCE.coachEntityToCoachInfoDto(coachService.getCoachEntityByBaseUser(baseUserEntity));
            }
        }
        throw new EntityNotFoundException();
    }

    public CoachEntity getCurrentCoach() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated()) {
            return null;
        }
        var baseUserEntity = baseUserRepository.findByUsername(authentication.getName());
        return coachService.getCoachEntityByBaseUser(baseUserEntity);
    }
}
