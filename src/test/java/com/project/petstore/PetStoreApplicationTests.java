package com.project.petstore;

import com.project.petstore.integrationtests.PetDaotest;
import com.project.petstore.unittests.PetServiceTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@SpringBootTest
@Suite.SuiteClasses({PetServiceTests.class,
		PetDaotest.class})
public class PetStoreApplicationTests {


}
