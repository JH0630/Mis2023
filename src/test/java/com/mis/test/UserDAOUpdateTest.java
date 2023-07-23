package com.mis.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.domain.UserVO;
import com.mis.persistence.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })

public class UserDAOUpdateTest {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOSelectTest.class);

	@Inject
	private UserDAO dao;

	@Test
	public void testUpdate() throws Exception {

		UserVO vo = new UserVO();
		vo.setUsid("user11");
		vo.setUpw("user11");
		vo.setUname("Groot");
		vo.setUpoint(100);

		logger.info("testUpdate :" + vo);

		dao.update(vo);
	}

}
