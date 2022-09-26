package com.example.springproves.repositories;

import com.example.springproves.models.Comment;
import com.example.springproves.models.GamesDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDetailsRepository extends JpaRepository<Comment, Integer> {

    @Query(
            value = "SELECT * FROM comments ",
            nativeQuery = true
    )
    public List<Comment> findWithRelation();
}