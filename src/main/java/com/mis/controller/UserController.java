package com.mis.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mis.domain.PageMaker;
import com.mis.domain.SearchCriteria;
import com.mis.domain.UserVO;
import com.mis.dto.LoginDTO;
import com.mis.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private UserService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) throws Exception {

	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, Model model) throws Exception {

		UserVO vo = service.login(dto);

		if (vo == null) {
			return;
		}

		model.addAttribute("userVO", vo);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {

		Object userVO = session.getAttribute("login");

		if (userVO != null) {
			session.removeAttribute("login");
			session.invalidate();
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {
		logger.info("register get...");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(UserVO vo) throws Exception {

		logger.info("register post...");

		// 회원 가입
		service.register(vo);

		return "redirect:/user/login";
	}

	@RequestMapping(value = "/memberRegister", method = RequestMethod.GET)
	public void memberRegisterGET() throws Exception {
		logger.info("register get...");
	}

	@RequestMapping(value = "/memberRegister", method = RequestMethod.POST)
	public String memberRegisterPost(UserVO vo) throws Exception {

		logger.info("register post...");

		// 회원 가입
		service.register(vo);

		return "redirect:/user/login";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("list get...");
		// 선택된 페이지의 게시글 정보 가져오기
		model.addAttribute("list", service.listSearch(cri));

		// 페이징 네비게이션 추가
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		// 페이징 정보 화면 전달
		model.addAttribute("pageMaker", pageMaker);

	}
	
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void readPage(@RequestParam("usid") String usid, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {
		
		logger.info("readPage get...");
		model.addAttribute(service.read(usid));
		
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public String modifyPageGET(@RequestParam("usid") String usid, HttpSession session,
			@ModelAttribute("cri") SearchCriteria cri, Model model, RedirectAttributes rttr) throws Exception {

		logger.info("modify get...");

		model.addAttribute(service.read(usid));

		return "/user/modifyPage";
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagePOST(UserVO vo, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		logger.info("modifyPage post...");
		service.modify(vo);

		// 페이징 및 검색 기능 유지
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/user/list";
	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String removePage(@RequestParam("usid") String usid, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		logger.info("remove get...");

		service.remove(usid);

		// 페이징 및 검색 기능 유지
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/board/list";

	}

}
