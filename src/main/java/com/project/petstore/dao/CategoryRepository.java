package com.project.petstore.dao;

import com.project.petstore.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sriramvcs on 2016-12-08.
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
}
