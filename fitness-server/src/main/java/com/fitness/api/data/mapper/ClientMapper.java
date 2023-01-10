package com.fitness.api.data.mapper;

import com.fitness.api.data.entity.ClientEntity;
import com.fitness.api.dto.client.ClientCreateDto;
import com.fitness.api.dto.security.currentUser.ClientInfoDto;
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
            @Mapping(source = "birthday", target = "birthday"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "phone", target = "phone"),

    })
    ClientEntity clientDtoToClient(ClientCreateDto clientCreateDto);

    @Mappings({
            @Mapping(source = "baseUserEntity.username", target = "username"),
            @Mapping(source = "baseUserEntity.role", target = "role"),
            @Mapping(source = "birthday", target = "birthday"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "phone", target = "phone"),

    })
    ClientInfoDto clientEntityToClientInfoDto(ClientEntity clientEntity);


}
