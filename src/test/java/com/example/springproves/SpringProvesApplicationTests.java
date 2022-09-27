package com.example.springproves;

import com.example.springproves.controllers.MovieController;
import com.example.springproves.models.filmfy.Movie;
import com.example.springproves.services.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringProvesApplicationTests {

    @Autowired
    MovieController movieController;
    MovieService movieService;

	@Test
	void contextLoads() {

        Movie pitList = movieService.getById(1L);

	}

}
