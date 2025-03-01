package com.patrykharanczyk.resolutions.service;

import com.patrykharanczyk.resolutions.model.Resolution;

import java.util.List;

public interface ResolutionService {
    List<Resolution> getResolutions();

    Resolution addResolution(Resolution resolution);

    Resolution updateResolution(long id, Resolution resolution);

    void deleteResolution(long id);
}
