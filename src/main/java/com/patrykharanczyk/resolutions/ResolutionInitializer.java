package com.patrykharanczyk.resolutions;

import com.patrykharanczyk.resolutions.model.Resolution;
import com.patrykharanczyk.resolutions.repository.ResolutionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Service;

@Service
public class ResolutionInitializer implements SmartInitializingSingleton {
    private final ResolutionRepository resolutions;

    public ResolutionInitializer(ResolutionRepository resolutions) {
        this.resolutions = resolutions;
    }

    @Override
    @Transactional
    public void afterSingletonsInstantiated() {
        System.out.println("Initializing resolutions");

        this.resolutions.save(new Resolution( "R1", "R1 decs", false));
        this.resolutions.save(new Resolution( "R2", "R2 decs", true));
        this.resolutions.save(new Resolution( "R3", "R3 decs", false));

        System.out.println("Resolutions initialized");
    }
}
