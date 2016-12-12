package com.project.petstore.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by sriramvcs on 2016-12-08.
 */
@Entity
@Table(name = "photourl")
@Getter
@Setter
public class PhotoUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String url;

//    private Long pet_id;

    public PhotoUrl(String url) {
        this.url = url;
    }
}
