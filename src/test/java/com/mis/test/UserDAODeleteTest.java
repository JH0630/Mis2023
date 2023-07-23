package com.mis.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.persistence.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })

public class UserDAODeleteTest {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOSelectTest.class);

	@Inject
	private UserDAO dao;

	@Test
	public void testDelete() throws Exception {

		logger.info("testDelete :" + "user11");

		dao.delete("user11");

	}
}
