package com.patrykharanczyk.resolutions.repository;

import com.patrykharanczyk.resolutions.model.resolution.Resolution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResolutionRepository extends JpaRepository<Resolution, Long> {

}
