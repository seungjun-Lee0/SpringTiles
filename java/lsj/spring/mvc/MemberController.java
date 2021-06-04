package lsj.spring.mvc;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lsj.spring.service.MemberService;
import lsj.spring.vo.Member;

@Controller
public class MemberController {

	@Autowired
	private MemberService msrv;
	
	@RequestMapping("/join")
	public String join() {
		
		return "join.tiles";
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "login.tiles";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public ModelAndView joinok(Member m, ModelAndView mv) {
		
		int cnt = msrv.newMember(m);
		if(cnt > 0) mv.setViewName("redirect:/login");
		else {
			mv.addObject("error","회원가입에 실패했음");
			mv.setViewName("join.tiles");
		
		}
		return mv;
	}
	
	// 아이디/비번 일치 => myinfo 로 redirect
	//					=> 로그인 성공한 계정을 세션에 등록함
	// 아이디/비번 불일치 => login 으로 redirect
	//					  => 로그인 실패 메세지 함께 출력 
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView loginok(Member m, ModelAndView mv,
			HttpSession sess) {
		int cnt = msrv.loginMember(m);
		
		if (cnt>0) {
			sess.setAttribute("userid", m.getUserid());
			mv.setViewName("redirect:/myinfo");
		}else {
			mv.setViewName("login.tiles");
			mv.addObject("error", "로그인 실패");
		}
		return mv;
	}
	
	@RequestMapping("/myinfo")
	public ModelAndView myinfo(HttpSession sess, ModelAndView mv) {
		
		Member m = msrv.readOneMember(
				(String)sess.getAttribute("userid"));
		
		mv.setViewName("myinfo.tiles");
		mv.addObject("m",m);
		
		return mv;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession sess) {
		sess.invalidate();
		return "redirect:/index";
	}
}
