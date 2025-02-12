package com.patrykharanczyk.resolutions.service;

import com.patrykharanczyk.resolutions.model.Resolution;
import com.patrykharanczyk.resolutions.repository.ResolutionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResolutionServiceImpl implements ResolutionService {
    private ResolutionRepository resolutionRepository;

    public ResolutionServiceImpl(ResolutionRepository resolutionRepository) {
        this.resolutionRepository = resolutionRepository;
    }

    @Override
    public List<Resolution> getResolutions() {
        return resolutionRepository.getResolutions();
    }
}
