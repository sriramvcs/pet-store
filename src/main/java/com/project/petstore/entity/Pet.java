package com.project.petstore.entity;

import com.project.petstore.enums.PetStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by sriramvcs on 2016-12-02.
 */
@Entity
@Table(name = "pet")
@Getter
@Setter
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="pet_id",unique = true)
    protected Long petId;

    private String name;

    @ManyToOne
    @JoinColumn(name="pet_category_id")
    private Category category;

    @ManyToMany
    @JoinTable(name = "pet_tag", joinColumns = @JoinColumn(name = "pet_id",referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tag_id",referencedColumnName = "id"))
    private Set<Tag> tags;

    @Column(name = "photo_urls")
    private String photoUrls;

    @Enumerated(EnumType.STRING)
    private PetStatus status;
}
