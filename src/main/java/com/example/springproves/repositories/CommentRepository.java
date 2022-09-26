package com.example.springproves.repositories;

import com.example.springproves.models.filmfy.Comment;
import com.example.springproves.models.filmfy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    public List<Comment> getCommentByUsers(Optional<User> user);
}