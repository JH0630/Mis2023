package com.mis.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.domain.ProductVO;
import com.mis.domain.SearchCriteria;
import com.mis.persistence.ProductDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/**/root-context.xml" })


public class ProductDAODeleteTest {
	private static final Logger logger = LoggerFactory.getLogger(ProductDAODeleteTest.class);
	
	@Inject
	private ProductDAO dao;
	
	@Test
	public void testDelete() throws Exception {
		
		SearchCriteria cri = new SearchCriteria();
		int pno = 1;
		
		dao.delete(pno);
		
		List<ProductVO> list = dao.listSearch(cri);
		
		for (ProductVO vo : list) {
			logger.info("listSearch :" + vo);
			
		}
	}
}
