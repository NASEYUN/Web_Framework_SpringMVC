package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.OfferService;

@Controller
public class OfferController {

	@Autowired
	private OfferService offerService;

	//학기별이수학점조회
	@RequestMapping("/semesterSubject")
	public String showOffers(Model model) {
		List<Offer> offers = offerService.getGrade();
		model.addAttribute("semesterOffer", offers);
		return "semesterSubject";

	}

	@RequestMapping("/createoffer")
	public String createoffer(Model model) {

		model.addAttribute("offer", new Offer());
		return "createoffer";

	}

	@RequestMapping("/docreate")
	public String docreate(Model model, @Valid Offer offer, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("=== Web Form data does no validated ===");
			List<ObjectError> errors = result.getAllErrors();

			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "createoffer";
		}
		System.out.println(offer); // 객체 확인하기
		offerService.insert(offer); // controller->service호출->dao호출
		return "offercreated";

	}

	// 링크 클릭시
	@RequestMapping(value = "/registerSubject", method = RequestMethod.GET)
	public String shwoSemesterSubject(@RequestParam int year, @RequestParam int semester, Model model) {
		List<Offer> offers = offerService.getOffer(year, semester);
		model.addAttribute("registerOffer", offers);

		return "registerSubject";
	}

	//수강신청조회
	 @RequestMapping("/offers") public String showCourse(Model model) {
	 List<Offer> offers = offerService.getOffers();
	 model.addAttribute("offers", offers);
	 
	 return "offers"; }
	 
}
