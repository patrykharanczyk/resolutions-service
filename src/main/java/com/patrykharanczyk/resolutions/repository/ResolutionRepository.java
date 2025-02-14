package com.patrykharanczyk.resolutions.repository;

import com.patrykharanczyk.resolutions.model.Resolution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResolutionRepository extends JpaRepository<Resolution, Long> {

}
