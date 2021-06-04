package lsj.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TilesController {
		
		@RequestMapping("/index")
		public String index() {
			
			return "index.tiles";
		}
		
		
		@RequestMapping("/loginok")
		public String loginok() {
			
			return "loginok.tiles";
		}

		/*
		 * @RequestMapping("/logout") public String logout() {
		 * 
		 * return "logout.tiles"; }
		 */
		
		
		
		@RequestMapping("/board/list")
		public String list() {
			
			return "board/list.tiles";
		}

		@RequestMapping("/board/view")
		public String view() {
			
			return "board/view.tiles";
		}
		
		@RequestMapping("/board/write")
		public String write() {
			
			return "board/write.tiles";
		}
		
		@RequestMapping("/board/writeok")
		public String writeok() {
			
			return "board/writeok.tiles";
		}

		
		
}
