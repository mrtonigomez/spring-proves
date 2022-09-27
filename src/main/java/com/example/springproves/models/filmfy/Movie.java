package com.example.springproves.models.filmfy;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT UNSIGNED not null")
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "image", nullable = false, length = 191)
    private String image;

    @Column(name = "runtime", nullable = false)
    private Integer runtime;

    @Column(name = "status", nullable = false)
    private Boolean status = false;

    @Column(name = "trailer", nullable = false, length = 191)
    private String trailer;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "lists_movies",
            joinColumns = { @JoinColumn(name = "movies_id") },
            inverseJoinColumns = { @JoinColumn(name = "lists_id") }
    )
    Set<Lists> lists = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "categories_movies",
            joinColumns = { @JoinColumn(name = "movies_id") },
            inverseJoinColumns = { @JoinColumn(name = "categories_id") }
    )
    Set<Category> categories = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "entities_movies",
            joinColumns = { @JoinColumn(name = "movies_id") },
            inverseJoinColumns = { @JoinColumn(name = "entities_id") }
    )
    Set<Entities> entities = new HashSet<>();
}