package com.project.petstore.dao;

import com.project.petstore.entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sriramvcs on 2016-12-08.
 */
@Repository
public interface TagRepository extends CrudRepository<Tag,Long> {
}
