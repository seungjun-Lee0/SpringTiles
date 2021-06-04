package lsj.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lsj.spring.service.GradeService;
import lsj.spring.vo.Grade;

@Controller
public class GradeController {
	
	@Autowired
	private GradeService gsrv;
	
	@RequestMapping("/grade") // get방식으로 호출
	public String grade() {
		return "grade.tiles";
	}
	
	@RequestMapping(value= "/grade", method=RequestMethod.POST) // post방식으로 호출
	public ModelAndView gradeok(Grade gd) {
		
		gsrv.computeGrade(gd);
		
		// 컨트롤러에서 처리한 결과를 뷰에 넘기려면
		// 뷰이름과 뷰에 보여줄 데이터를 ModelAndView 
		// 객체에 담아서 처리함
		ModelAndView mv = new ModelAndView();
		mv.setViewName("gradeok.tiles");
		mv.addObject("gd",gd);
		
		return mv;
	}
	
	@RequestMapping(value="/grade2", method=RequestMethod.POST)
	public ModelAndView gradeok2(Grade gd, ModelAndView mv) {
		
		
		mv.setViewName("gradeok2.tiles");
		mv.addObject("gd", gsrv.newGrade(gd));
		return mv;
	}
	
	@RequestMapping(value="/grade2list")
	public ModelAndView gradeok2list(ModelAndView mv) {
		mv.setViewName("gradelist.tiles");
		mv.addObject("gds",gsrv.readAllGrade());
		
		return mv;
	}
	
}
