package com.patrykharanczyk.resolutions.repository;

import com.patrykharanczyk.resolutions.model.Resolution;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ResolutionRepositoryImpl implements ResolutionRepository {
    private List<Resolution> resolutions = List.of(
            new Resolution(UUID.randomUUID().toString(), UUID.randomUUID().toString(), "R1", "R1 decs", false),
            new Resolution(UUID.randomUUID().toString(), UUID.randomUUID().toString(), "R2", "R2 decs", true),
            new Resolution(UUID.randomUUID().toString(), UUID.randomUUID().toString(), "R3", "R3 decs", false)
    );

    @Override
    public List<Resolution> getResolutions() {
        return resolutions;
    }
}
