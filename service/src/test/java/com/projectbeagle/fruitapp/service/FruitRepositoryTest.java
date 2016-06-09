package com.projectbeagle.fruitapp.service;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 
import com.jayway.restassured.RestAssured;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.IntegrationTest;
import java.util.Arrays;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.web.WebAppConfiguration;


import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.hasItems;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
@WebAppConfiguration
@IntegrationTest("server.port:0") 
public class FruitRepositoryTest {


	@Autowired   
    FruitRepository repository;

    Fruit tFruit;
    Fruit tFruit2;

   	@Value("${local.server.port}")
    private int serverPort;

    @Before
    public void setUp() {
        // 7
        tFruit = new Fruit();
        tFruit2 = new Fruit();

        tFruit.setFruitName("T1");
        tFruit.setFruitDescription("T1");
        tFruit2.setFruitName("T2");
        tFruit2.setFruitDescription("T2");
        


        repository.deleteAll();
        repository.save(tFruit);
        repository.save(tFruit2);

 	       RestAssured.port = serverPort;

 
    }

	@Test
	public void testFetchAll() {

		 String ret = 
                 get("/fruits").asString();


        System.out.println("Ret: "+ret);

		when().
                get("/fruits").
        then().
                statusCode(HttpStatus.SC_OK).
                body("_embedded.fruits.fruitName",hasItems("T1","T2"));

        

	}
}
