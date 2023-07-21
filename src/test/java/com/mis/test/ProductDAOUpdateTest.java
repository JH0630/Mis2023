package com.mis.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.domain.ProductVO;
import com.mis.persistence.ProductDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })

public class ProductDAOUpdateTest {
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOUpdateTest.class);
	
	@Inject
	private ProductDAO dao;
	
	@Test
	public void testUpdate() throws Exception {
		ProductVO vo = new ProductVO();
		vo.setPno(2);
		vo.setPname("수정된 상품");
		vo.setPrice(2111);
		vo.setContent("수정된 내용");
		vo.setWriter("상품 수정 테스터");
		
		logger.info("testUpdate : " + vo);
	
		dao.update(vo);
	}
}
