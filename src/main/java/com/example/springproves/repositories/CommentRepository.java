package com.example.springproves.repositories;

import com.example.springproves.models.filmfy.Comment;
import com.example.springproves.models.filmfy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    public List<Comment> getCommentByUsers(User user);

    @Query(
            "SELECT c FROM Comment c WHERE c.id = :id"
    )
    Comment findByIdCustom(Long id);

    /*public List<Comment> findAllByOrderByIdAsc(Optional<User> user);*/
}