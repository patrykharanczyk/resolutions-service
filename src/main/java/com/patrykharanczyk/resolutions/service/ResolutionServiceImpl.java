package com.patrykharanczyk.resolutions.service;

import com.patrykharanczyk.resolutions.model.Resolution;
import com.patrykharanczyk.resolutions.repository.ResolutionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResolutionServiceImpl implements ResolutionService {
    private final ResolutionRepository resolutionRepository;

    public ResolutionServiceImpl(ResolutionRepository resolutionRepository) {
        this.resolutionRepository = resolutionRepository;
    }

    @Override
    public List<Resolution> getResolutions() {
        return resolutionRepository.findAll();
    }

    @Override
    public Resolution addResolution(Resolution resolution) {
        resolution.setCompleted(false);
        return resolutionRepository.save(resolution);
    }

    @Override
    @Transactional
    public Resolution updateResolution(long id, Resolution newResolution) {
        Resolution resolutionUpdate = resolutionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Resolution not found"));

        resolutionUpdate.setName(newResolution.getName());
        resolutionUpdate.setDescription(newResolution.getDescription());
        resolutionUpdate.setCompleted(newResolution.isCompleted());
        return resolutionRepository.save(resolutionUpdate);
    }

    @Override
    public void deleteResolution(long id) {
        resolutionRepository.deleteById(id);
    }
}
