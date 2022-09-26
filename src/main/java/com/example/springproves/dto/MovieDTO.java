package com.example.springproves.dto;

import com.example.springproves.models.filmfy.Category;

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
    Set<ListsDTO> lists;
    Set<String> categories;

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


    public Set<ListsDTO> getLists() {
        return lists;
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

    public void setLists(Set<ListsDTO> lists) {
        this.lists = lists;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO entity = (MovieDTO) o;
        return Objects.equals(this.title, entity.title) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.releaseDate, entity.releaseDate) &&
                Objects.equals(this.image, entity.image) &&
                Objects.equals(this.runtime, entity.runtime) &&
                Objects.equals(this.lists, entity.lists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, releaseDate, image, runtime, lists);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "title = " + title + ", " +
                "description = " + description + ", " +
                "releaseDate = " + releaseDate + ", " +
                "image = " + image + ", " +
                "runtime = " + runtime + ", " +
                "lists = " + lists + ")";
    }
}
