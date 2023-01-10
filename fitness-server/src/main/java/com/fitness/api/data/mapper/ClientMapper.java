package com.fitness.api.data.mapper;

import com.fitness.api.data.entity.SystemUserEntity;
import com.fitness.api.dto.ClientCreationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "birthday", target = "birthday"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "phone", target = "phone"),

    })
    SystemUserEntity clientDtoToClient(ClientCreationDto clientCreationDto);
}
