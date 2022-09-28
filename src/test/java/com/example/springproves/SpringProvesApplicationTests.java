package com.example.springproves;

import com.example.springproves.controllers.MovieController;
import com.example.springproves.models.filmfy.Movie;
import com.example.springproves.services.MovieService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.util.Assert;

@RestClientTest({ MovieService.class })
class SpringProvesApplicationTests {

    /*@Autowired
    private MockRestServiceServer mockRestServiceServer;*/

    @Autowired
    private MovieService movieService;

    /*@AfterEach
    public void resetMockServer() {
        mockRestServiceServer.reset();
    }*/

	@Test
	void contextLoads() {

        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        MovieService movieService = (MovieService) context.getBean("movieService");*/

        Movie pitList = movieService.getById(1L);

        Assertions.assertEquals(pitList.getId(), 1L);
	}

}
