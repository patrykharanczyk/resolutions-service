package com.patrykharanczyk.resolutions.model.resolution;

public class ResolutionDto {


    long id;
    private final String name;
    private final String description;
    private final boolean completed;

    public ResolutionDto(long id, String name, String description, boolean completed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }
}
