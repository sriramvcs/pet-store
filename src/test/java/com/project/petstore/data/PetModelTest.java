package com.project.petstore.data;

import com.project.petstore.enums.PetStatus;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sriramvcs on 2016-12-04.
 */
@Data
public class PetModelTest {

    private Long id;
    private Long petId;
    private String name;
    private CategoryModelTest category;
    private List<TagModelTest> tags = new ArrayList<>();
    private String status;
    private String photoUrls; // comma separated list

}
