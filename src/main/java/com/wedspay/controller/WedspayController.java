package com.wedspay.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lowagie.text.DocumentException;
import com.wedspay.entity.Payment;
import com.wedspay.entity.Person;
import com.wedspay.entity.User;
import com.wedspay.generatePDF.PDFGenerator;
import com.wedspay.service.PaymentService;
import com.wedspay.service.PersonService;
import com.wedspay.service.UserService;

@Controller
@RequestMapping("/user")
public class WedspayController {
	
	@Autowired
	private PersonService personService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private UserService userService;
	
	// giving home page here.
	@RequestMapping("/home")
	public String showHome() {
		return "home";
	}
	
	// showing login form here
	@RequestMapping("/showMyLoginPage")
	public String showLoginForm() {
		return "LoginForm";
	}
	
	// showing payment form here.
	@RequestMapping("/showForm")
	public String showPaymentForm(Model model) {
		Payment pay = new Payment();
		model.addAttribute("payment", pay);
		return "Payment";
	}
	
	// saving payment details here.
	@RequestMapping("/savePayment")
	public String savePayment(@Valid @ModelAttribute("payment") Payment p, BindingResult bind, Model model) {
		if(bind.hasErrors()) {
			model.addAttribute("payment", p);
			return "Payment";
		}
		Person person = personService.getPersonByMarriageId(p.getMarriageId());
		if(person == null) {
			model.addAttribute("error", "Invalid marriage Id");
			return "Payment";
		}else {
			person.add(p);
			p.setPerson(person);
			paymentService.savePayment(p);
			return "success";
		}
	}
	
	// showing marriage registration form here.
	@RequestMapping("/showReg")
	public String showRegistration(Model model) {
		Person p = new Person();
		model.addAttribute("person", p);
		return "personReg";
	}
	
	
	// saving marriage details here.
	@RequestMapping("/saveDetails")
	public String saveDetails(@Valid @ModelAttribute("person") Person person, BindingResult bind,@CurrentSecurityContext(expression = "authentication?.name") String userName, Model model) {
		if(bind.hasErrors()) {
			model.addAttribute("person", person);
			return "personReg";
		}
		User user = userService.getUserByUserName(userName);
		user.add(person);
		String marriageId = person.getGirlName()+user.getMobile();
		// let check if marriageId is already present.
		if(personService.getPersonByMarriageId(marriageId) != null) {
			model.addAttribute("error", "MarriageId exist!");
			return "personReg";
		}
		person.setMarriageId(marriageId);
		person.setUser(user);
		personService.savePerson(person);
		model.addAttribute("marriageId", marriageId);
		return "regSuccess";
	}
	
	// marriage list here.
	@RequestMapping("/marriageList")
	public String marriageList(@CurrentSecurityContext(expression = "authentication?.name") String userName, Model model) {
		List<Person> list = userService.getPersonsList(userName);
		model.addAttribute("marriages", list);
		return "marriage-list";
	}
	
	// payments particular person(Shagun payments details)
	@RequestMapping("/paymentList")
	public String paymentList(@RequestParam("personId") Long id,@CurrentSecurityContext(expression = "authentication?.name") String userName, Model model) {
		List<Person> list = userService.getPersonsList(userName);
		boolean flag = checkPersonId(id, list);
		if(flag) {
			Person person = personService.getPerson(id);
			model.addAttribute("personId", id);
			model.addAttribute("payments", person.getPayments());
			return "payment-list";
		}else {
			return "errorPage";
		}
		
	}
	@RequestMapping("/errorPage")
	public String sendErrorPage() {
		return "errorPage";
	}
	// PDF download method.
	@RequestMapping("/pdf")
	public void generatePDF(@RequestParam("personId") Long id,@CurrentSecurityContext(expression = "authentication?.name") String userName, HttpServletResponse response) throws DocumentException, IOException{
		List<Person> list2 = userService.getPersonsList(userName);
		boolean flag = checkPersonId(id, list2);
		if(flag) {
			Person person = personService.getPerson(id);
			List<Payment> list = person.getPayments();
			response.setContentType("application/pdf");
			String headerkey = "Content-Disposition";
			String headervalue = "attachment; filename=pdf_"+ person.getMarriageDate() + ".pdf";
			response.setHeader(headerkey, headervalue);
			PDFGenerator generator = new PDFGenerator(list);
			generator.setBoyName(person.getBoyName());
			generator.setGirlName(person.getGirlName());
			generator.setMarriageDate(person.getMarriageDate());
			generator.generate(response);
		}else {
			response.sendRedirect("errorPage");
		}
		
	}
	
	// check if list have personId or not.
	public boolean checkPersonId(Long id, List<Person> list) {
		for(Person p : list) {
			if(p.getId() == id) {
				return true;
			}
		}
		return false;
	}
	@InitBinder
	public void initBinder(WebDataBinder data) {
		StringTrimmerEditor string = new StringTrimmerEditor(true);
		data.registerCustomEditor(String.class, string);
	}

}
