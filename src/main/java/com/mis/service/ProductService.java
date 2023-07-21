package com.mis.service;

import java.util.List;

import com.mis.domain.ProductVO;
import com.mis.domain.SearchCriteria;

public interface ProductService {

	public void register(ProductVO vo) throws Exception;

	public ProductVO read(int pno) throws Exception;

	public void modify(ProductVO vo) throws Exception;

	public void remove(int pno) throws Exception;

	public List<ProductVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;

}
