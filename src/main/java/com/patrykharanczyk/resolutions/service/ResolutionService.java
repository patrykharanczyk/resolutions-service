package com.patrykharanczyk.resolutions.service;

import com.patrykharanczyk.resolutions.model.resolution.ResolutionDto;

import java.util.List;

public interface ResolutionService {
    List<ResolutionDto> getResolutions();

    ResolutionDto addResolution(ResolutionDto resolution);

    ResolutionDto updateResolution(long id, ResolutionDto resolution);

    void deleteResolution(long id);
}
