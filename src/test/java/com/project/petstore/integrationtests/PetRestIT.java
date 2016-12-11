package com.project.petstore.integrationtests;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

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
        get("/echo/sriram").then().assertThat().body("message", equalTo("sriram"));
    }

//    @Test
//    public void test2CreatePet() {
//        PetModelTest pet = new PetModelTest(10l,"Sriram");
//        given().contentType(ContentType.JSON).body(pet)
//                .when().post(PET_ENDPOINT).then()
//                .assertThat().statusCode(equalTo(HttpStatus.OK.value()));
//    }


}
