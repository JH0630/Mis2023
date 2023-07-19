package com.mis.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })

public class MyBatisTest {
	private static final Logger logger = LoggerFactory.getLogger(MyBatisTest.class);

	@Inject
	private SqlSessionFactory sqlFactory;
	
	//Mybatis의 SqlSessionFactory와 연결되었는지 test
	@Test
	public void testFactory() throws Exception {
		logger.info("testFactory: " + sqlFactory);
	}
	
	//SqlSessionFactory에 openSession메소드를 이용해 데이터베이스와 논리적으로 연결되었는지 test
	@Test
	public void testSession() throws Exception {

		try (SqlSession session = sqlFactory.openSession()) {

			logger.info("testSession: " + session);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
