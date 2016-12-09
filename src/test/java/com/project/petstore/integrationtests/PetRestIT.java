package com.project.petstore.integrationtests;

import com.jayway.restassured.http.ContentType;
import com.project.petstore.data.PetModel;
import com.project.petstore.data.PetModelTest;
import lombok.Data;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by sriramvcs on 2016-12-03.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class PetRestIT {

    private static final String PET_ENDPOINT = "/pet/";
    @Test
    public void test1EchoTest() {
        get("/echo/sriram").then().assertThat().body("message",equalTo("sriram"));
    }

//    @Test
//    public void test2CreatePet() {
//        PetModelTest pet = new PetModelTest(10l,"Sriram");
//        given().contentType(ContentType.JSON).body(pet)
//                .when().post(PET_ENDPOINT).then()
//                .assertThat().statusCode(equalTo(HttpStatus.OK.value()));
//    }



}
