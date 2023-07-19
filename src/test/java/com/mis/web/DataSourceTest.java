package com.mis.web;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
// root-context에 있는 데이터베이스 연결 가져오기 위해
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })

public class DataSourceTest {
	// inject는 객체를 생성해주는 역할을 함
	@Inject
	private DataSource ds;

	private static final Logger logger = LoggerFactory.getLogger(DataSourceTest.class);

	@Test
	public void testConnection() throws Exception {

		try (Connection conn = ds.getConnection()) {

			logger.info("JUNIT: " + conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
