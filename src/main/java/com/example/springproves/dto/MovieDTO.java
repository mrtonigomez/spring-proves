package com.example.springproves.dto;

import com.example.springproves.EntitiesDTO;
import com.example.springproves.models.filmfy.Category;
import com.example.springproves.models.filmfy.Entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class MovieDTO implements Serializable {

    String title;
    String description;
    LocalDate releaseDate;
    String image;
    Integer runtime;
    Set<String> categories;
    Set<String> actors;
    Set<String> directors;
    Set<String> writters;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getImage() {
        return image;
    }

    public Integer getRuntime() {
        return runtime;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }

    public Set<String> getActors() {
        return actors;
    }

    public void setActors(Set<String> actors) {
        this.actors = actors;
    }

    public Set<String> getDirectos() {
        return directors;
    }

    public void setDirectos(Set<String> directos) {
        this.directors = directos;
    }

    public Set<String> getWritters() {
        return writters;
    }

    public void setWritters(Set<String> writters) {
        this.writters = writters;
    }
}
