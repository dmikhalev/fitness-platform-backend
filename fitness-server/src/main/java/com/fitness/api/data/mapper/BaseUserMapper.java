package com.fitness.api.data.mapper;

import com.fitness.api.data.entity.BaseUserEntity;
import com.fitness.api.dto.security.BaseUserCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BaseUserMapper {

    BaseUserMapper INSTANCE = Mappers.getMapper(BaseUserMapper.class);


    @Mappings({
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "role", target = "role"),

    })
    BaseUserEntity baseUserCreateDtoToEntity(BaseUserCreateDto baseUserCreateDto);

}
