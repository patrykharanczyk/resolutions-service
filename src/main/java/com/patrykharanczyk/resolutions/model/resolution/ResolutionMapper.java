package com.patrykharanczyk.resolutions.model.resolution;

import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface ResolutionMapper {

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCustomerFromDto(ResolutionDto dto, @MappingTarget Resolution entity);


    ResolutionDto toDto(Resolution user);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Resolution toEntity(ResolutionDto userDTO);
}
