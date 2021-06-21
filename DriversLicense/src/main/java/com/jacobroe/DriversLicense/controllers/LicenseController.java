package com.jacobroe.DriversLicense.controllers;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jacobroe.DriversLicense.models.License;
import com.jacobroe.DriversLicense.models.Person;
import com.jacobroe.DriversLicense.services.LicenseService;
import com.jacobroe.DriversLicense.services.PersonService;


@Controller
public class LicenseController {
	
	private final LicenseService licenseService;	
	
	public LicenseController(LicenseService service) {
		this.licenseService = service;
	}

	@Autowired
	private PersonService personService;
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> personList = personService.getAllPersons();
		model.addAttribute("personList", personList);
		return "jsp/newLicense.jsp";
	}
	
	@RequestMapping(value="/licenses/create", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("license") License license, BindingResult result) {
        if (result.hasErrors()) {
            return "jsp/newLicense.jsp";
        } else {
        	String number = licenseService.setLicenseNumber();
        	license.setNumber(number);
      
        	licenseService.addLicense(license);
            return "redirect:/persons/" +license.getId();
        }
	}
}