package com.project.petstore.data;

/**
 * Created by sriramvcs on 2016-12-04.
 */
public class PetModelTest {

        private Long id;
        private String name;

    public PetModelTest(Long id,String name) {
        this.id = id;
        this.name = name;
    }
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
}
