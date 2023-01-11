package com.fitness.api.data.mapper;

import com.fitness.api.data.entity.TrainingProgramEntity;
import com.fitness.api.dto.trainingProgram.TrainingProgramCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TrainingProgramMapper {

    TrainingProgramMapper INSTANCE = Mappers.getMapper(TrainingProgramMapper.class);

    @Mappings({
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "type", target = "type"),

    })
    TrainingProgramEntity trainingProgramCreateDtoToTrainingProgram(TrainingProgramCreateDto trainingProgramCreateDto);

}
