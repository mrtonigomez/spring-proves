package com.example.springproves.dto;

import java.io.Serializable;
import java.util.Objects;

public class CommentCustomDTO implements Serializable {
    Long id;
    UserCustomDTO users;
    String title;
    String body;

    public Long getId() {
        return id;
    }

    public UserCustomDTO getUsers() {
        return users;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsers(UserCustomDTO users) {
        this.users = users;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentCustomDTO entity = (CommentCustomDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.users, entity.users) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.body, entity.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, users, title, body);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "users = " + users + ", " +
                "title = " + title + ", " +
                "body = " + body + ")";
    }

    public static class UserCustomDTO implements Serializable {
        String name;
        String email;

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserCustomDTO entity = (UserCustomDTO) o;
            return Objects.equals(this.name, entity.name) &&
                    Objects.equals(this.email, entity.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, email);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "name = " + name + ", " +
                    "email = " + email + ")";
        }
    }
}
