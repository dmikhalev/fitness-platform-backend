package com.fitness.api.data.mapper;

import com.fitness.api.data.entity.CoachEntity;
import com.fitness.api.dto.coach.CoachCreateDto;
import com.fitness.api.dto.security.currentUser.CoachInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CoachMapper {
    CoachMapper INSTANCE = Mappers.getMapper(CoachMapper.class);

    @Mappings({
            @Mapping(source = "username", target = "baseUserEntity.username"),
        //    @Mapping(source = "role", target = "baseUserEntity.role"),
            @Mapping(source = "birthday", target = "birthday"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "middleName", target = "middleName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "profileDescription", target = "profileDescription"),
            @Mapping(source = "workExperience", target = "workExperience"),
    })
    CoachEntity coachDtoToCoach(CoachCreateDto coachCreateDto);

    @Mappings({
            @Mapping(source = "baseUserEntity.username", target = "username"),
            @Mapping(source = "baseUserEntity.role", target = "role"),
            @Mapping(source = "birthday", target = "birthday"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "middleName", target = "middleName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "profileDescription", target = "profileDescription"),
            @Mapping(source = "workExperience", target = "workExperience"),
    })
    CoachInfoDto coachEntityToCoachInfoDto(CoachEntity coachEntity);
}
