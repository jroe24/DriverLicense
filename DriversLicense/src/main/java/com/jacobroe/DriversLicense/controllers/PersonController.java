package com.jacobroe.DriversLicense.controllers;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jacobroe.DriversLicense.models.Person;
import com.jacobroe.DriversLicense.services.LicenseService;
import com.jacobroe.DriversLicense.services.PersonService;

@Controller
public class PersonController {
	private final LicenseService licenseService;
	
	private final PersonService personService;
	
	public PersonController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@RequestMapping(value="/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "jsp/newPerson.jsp";
	}
	
	@RequestMapping(value="/persons/create", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "/jsp/newPerson.jsp";
		}
		else {
			personService.createPerson(person);
			return "redirect:/licenses/new";
		}
	}
	
	@RequestMapping("/persons/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("license", licenseService.getLicense(id).get());
		return "/jsp/show.jsp";
	}
}