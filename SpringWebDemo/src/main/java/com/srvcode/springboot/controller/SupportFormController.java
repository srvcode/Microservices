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
public class SupportFormController {

	@GetMapping("/support")
	public String complaintForm(Model model) {
		
		model.addAttribute("supportDetails", new SupportForm());
		
		List<String> membershipList = Arrays.asList("Platinum", "Gold", "Silver");
		model.addAttribute("membershipList", membershipList);
		
		return "support";
	}
	
	@PostMapping("/support")
	public String submitComplaint(@ModelAttribute SupportForm supportDetails, Model model) {
		model.addAttribute("supportDetails", supportDetails);
		return "submit";
	}
	
}
