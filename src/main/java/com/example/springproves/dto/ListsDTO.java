package com.example.springproves.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ListsDTO implements Serializable {
    Long id;
    String title;
    Boolean isPrivate;
    List<String> movieDTOList;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public List<String> getMovieDTOList() {
        return movieDTOList;
    }

    public void setMovieDTOList(List<String> movieDTOList) {
        this.movieDTOList = movieDTOList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListsDTO entity = (ListsDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.isPrivate, entity.isPrivate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isPrivate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "isPrivate = " + isPrivate + ")";
    }
}
