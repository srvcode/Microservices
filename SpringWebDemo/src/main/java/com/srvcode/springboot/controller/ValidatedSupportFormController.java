package com.srvcode.springboot.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.srvcode.springboot.model.SupportForm;

@Controller
public class ValidatedSupportFormController {

	@GetMapping("/validatedSupport")
	public String complaintForm(Model model) {
		
		model.addAttribute("supportDetails", new SupportForm());
		
		List<String> membershipList = Arrays.asList("Platinum", "Gold", "Silver");
		model.addAttribute("membershipList", membershipList);
		
		return "validatedSupport";
	}
	
	@PostMapping("/validatedSupport")
	public String submitComplaint(@Valid @ModelAttribute("supportDetails") SupportForm supportDetails,
			BindingResult bindingResult, Model model) {

		List<String> membershipList = Arrays.asList("Platinum", "Gold", "Silver");
		model.addAttribute("membershipList", membershipList);

		if (bindingResult.hasErrors()) {
			System.out.println("Errors found!");
			return "validatedSupport";
		}
		System.out.println("No errors found");
		
		return "validatedSubmit";
	}
	
}
