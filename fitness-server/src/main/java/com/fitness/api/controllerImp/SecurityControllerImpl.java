package com.fitness.api.controllerImp;

import com.fitness.api.controller.SecurityController;
import com.fitness.api.dto.security.AuthInfoDto;
import com.fitness.api.dto.security.BaseUserCreateDto;
import com.fitness.api.dto.security.LoginUserDto;
import com.fitness.api.dto.security.currentUser.BaseUserDto;
import com.fitness.api.security.SecurityUser;
import com.fitness.api.service.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class SecurityControllerImpl implements SecurityController {

    private final SecurityService securityService;

    @Override
    public ResponseEntity<AuthInfoDto> loginUser(LoginUserDto loginUserDto) {
        var auth = securityService.loginUser(loginUserDto);
        return auth != null
                ? new ResponseEntity<AuthInfoDto>(auth, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Object> createBaseUser(BaseUserCreateDto baseUserCreateDto) {
        securityService.createBaseUser(baseUserCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BaseUserDto> currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated()) {
            new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(securityService.getCurrentUser(authentication.getName()), HttpStatus.OK);
    }
}
