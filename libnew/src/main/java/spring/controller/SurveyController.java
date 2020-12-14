package spring.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.survey.AnsweredData;
import spring.vo.Question;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	private List<Question> createQuestions(){ //설문 내용을 만들기 위한 메소드
		Question q1 = new Question(
				"당신의 역활을 무엇 입니까?",
				Arrays.asList("서버","프론트","백엔드"));
		Question q2 = new Question(
				"많이 사용하는 개발 도구는 무엇입니까?",
				Arrays.asList("이클립스","인텔리J","넷빈즈"));
		Question q3 = new Question(
				"하고 싶은 말을 적어주세요.");
		
		return Arrays.asList(q1,q2,q3);
	}
	
	/*
	 * @RequestMapping(method=RequestMethod.GET) // 컨텍스트 패스 /survey public String
	 * form(Model model){ //폼으로 이동하는 컨트롤러 //컨트롤러 에서 생성된 데이터를 JSP 뷰로 전달 하기 위한 객체 :
	 * Model List<Question> questions = createQuestions();
	 * model.addAttribute("questions",questions);
	 * 
	 * return "survey/surveyForm"; }
	 */
	 @RequestMapping(method=RequestMethod.GET)
	 public ModelAndView form() {
		 ModelAndView mav = new ModelAndView();
		 
		List<Question> questions = createQuestions();		 
		 
		mav.addObject("questions",questions); //Model의 역활
		mav.setViewName("survey/surveyForm"); //View의 역활
		 
		 return mav;
	 }
	
	
	@RequestMapping(method=RequestMethod.POST)// 컨텍스트 패스 /survey
	public String submit(//폼으로 부터 데이터(커맨드 객체)를 전송받는 컨트롤러
			@ModelAttribute("ansData") AnsweredData data) {
		return "survey/submitted";
	}
}
