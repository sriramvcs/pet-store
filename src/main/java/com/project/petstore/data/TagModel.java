package com.project.petstore.data;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by sriramvcs on 2016-12-11.
 */
@Getter
@Setter
public class TagModel {

    private Long id;
    private String name;

    public TagModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
