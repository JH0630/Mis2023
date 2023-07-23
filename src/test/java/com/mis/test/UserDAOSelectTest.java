package com.mis.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.domain.SearchCriteria;
import com.mis.domain.UserVO;
import com.mis.persistence.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })

public class UserDAOSelectTest {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOSelectTest.class);

	@Inject
	private UserDAO dao;

	@Test
	public void testListAll() throws Exception {

		SearchCriteria cri = new SearchCriteria();
		List<UserVO> list = dao.listSearch(cri);

		for (UserVO vo : list) {
			logger.info("testListAll :" + vo);
		}
	}

	@Test
	public void testRead() throws Exception {
		logger.info("testRead : " + dao.read("user11"));
	}
}
