package com.patrykharanczyk.resolutions.service;

import com.patrykharanczyk.resolutions.model.resolution.Resolution;
import com.patrykharanczyk.resolutions.model.resolution.ResolutionDto;
import com.patrykharanczyk.resolutions.model.resolution.ResolutionMapper;
import com.patrykharanczyk.resolutions.repository.ResolutionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResolutionServiceImpl implements ResolutionService {
    private final ResolutionRepository resolutionRepository;
    protected final ResolutionMapper mapper;

    public ResolutionServiceImpl(ResolutionRepository resolutionRepository , ResolutionMapper mapper) {
        this.resolutionRepository = resolutionRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ResolutionDto> getResolutions() {
        return resolutionRepository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public ResolutionDto addResolution(ResolutionDto resolutionDto) {
        Resolution newResolution = new Resolution();
        newResolution.setCompleted(false);

        mapper.updateCustomerFromDto(resolutionDto, newResolution);

        return mapper.toDto(resolutionRepository.save(newResolution));
    }

    @Override
    @Transactional
    public ResolutionDto updateResolution(long id, ResolutionDto newResolution) {
        Resolution resolutionUpdate = resolutionRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Resolution not found"));

        mapper.updateCustomerFromDto(newResolution, resolutionUpdate);

        return mapper.toDto(resolutionRepository.save(resolutionUpdate));
    }

    @Override
    public void deleteResolution(long id) {
        resolutionRepository.deleteById(id);
    }
}
