package com.patrykharanczyk.resolutions.controller;

import com.patrykharanczyk.resolutions.model.resolution.Resolution;
import com.patrykharanczyk.resolutions.model.resolution.ResolutionDto;
import com.patrykharanczyk.resolutions.repository.ResolutionRepository;
import com.patrykharanczyk.resolutions.service.ResolutionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resolutions")
public class ResolutionController {

    private final ResolutionService resolutionService;
    private final ResolutionRepository repo;

    public ResolutionController(ResolutionService resolutionService, ResolutionRepository repo) {
        this.resolutionService = resolutionService;
        this.repo = repo;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_resolutions:read')")
    public List<ResolutionDto> getResolutions(){
        return resolutionService.getResolutions();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_resolutions:write')")
    public ResolutionDto addResolution(@RequestBody ResolutionDto resolution){
        return resolutionService.addResolution(resolution);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_resolutions:write')")
    public ResolutionDto updateResolution(@PathVariable("id") Long id, @RequestBody ResolutionDto resolution){
        return resolutionService.updateResolution(id, resolution);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_resolutions:write')")
    public void deleteResolution(@PathVariable("id") long id){
        resolutionService.deleteResolution(id);
    }
}
