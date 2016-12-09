package com.project.petstore.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by sriramvcs on 2016-12-08.
 */
@Entity
@Table(name = "tag")
@Getter
@Setter
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "tags")
    private Set<Pet> pets;
}
