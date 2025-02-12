package com.patrykharanczyk.resolutions.controller;

import com.patrykharanczyk.resolutions.model.Resolution;
import com.patrykharanczyk.resolutions.service.ResolutionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resolutions")
public class ResolutionController {

    private final ResolutionService resolutionService;

    public ResolutionController(ResolutionService resolutionService) {
        this.resolutionService = resolutionService;
    }

    @GetMapping
    public List<Resolution> getResolutions(){
        return resolutionService.getResolutions();
    }
}
