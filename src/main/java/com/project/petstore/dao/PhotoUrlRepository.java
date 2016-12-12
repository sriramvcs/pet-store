package com.project.petstore.dao;

import com.project.petstore.entity.PhotoUrl;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sriramvcs on 2016-12-11.
 */
@Repository
public interface PhotoUrlRepository extends CrudRepository<PhotoUrl,Long> {

}
