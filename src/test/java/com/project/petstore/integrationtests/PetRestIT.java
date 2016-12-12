package com.project.petstore.integrationtests;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.project.petstore.data.CategoryModelTest;
import com.project.petstore.data.PetModelTest;
import com.project.petstore.data.TagModelTest;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by sriramvcs on 2016-12-03.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PetRestIT {

    private static final String CREATE_PET_ENDPOINT = "/pet";
    private static final String LIST_PETS_ENDPOINT = "/pets";
    private static final String LIST_PET_ENDPOINT = "/pet/1000";

    private static final String DELETE_PET_ENDPOINT = "/pet/1000";

    @Test
    public void test1CreatePet() {

        PetModelTest data = new PetModelTest();
        data.setPetId(1000l);
        data.setName("Sriram");
        data.setStatus("Available");
        data.setCategory(new CategoryModelTest(1l,"Dog"));
        List<TagModelTest> tags = new ArrayList<>();
        tags.add(new TagModelTest(1l,"clean"));
        tags.add(new TagModelTest(3l,"sleepy"));
        data.setTags(tags);
        data.setPhotoUrls("1,2,3,4");

        given().contentType(ContentType.JSON).body(data)
                .when().post(CREATE_PET_ENDPOINT).then()
                .assertThat().statusCode(equalTo(HttpStatus.OK.value()));
    }

    @Test
    public void test2findPet() {
        when().get(LIST_PETS_ENDPOINT).then().assertThat().body("[0].name",equalTo("Sriram"))
                .body("[0].status",equalTo("Available"));
    }

    @Test
    public void test3findPetByPetId() {
        Response response = when().get(LIST_PET_ENDPOINT).then().contentType(ContentType.JSON).extract().response();
        String str = response.asString();
    }

    @Test
    public void test4DeletePetbyPetId() {
        when().delete(DELETE_PET_ENDPOINT).then().assertThat().statusCode(HttpStatus.OK.value());
    }





}
