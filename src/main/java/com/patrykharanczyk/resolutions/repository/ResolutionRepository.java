package com.patrykharanczyk.resolutions.repository;

import com.patrykharanczyk.resolutions.model.Resolution;

import java.util.List;

public interface ResolutionRepository {
    List<Resolution> getResolutions();
}
