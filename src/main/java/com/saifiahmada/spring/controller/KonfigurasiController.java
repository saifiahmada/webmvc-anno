package com.saifiahmada.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saifiahmada.spring.domain.Konfigurasi;
import com.saifiahmada.spring.service.KonfigurasiService;

@Controller
@RequestMapping(value = "/konfig")
public class KonfigurasiController {
	
	@Autowired
	private KonfigurasiService konfigurasiService;
	
	@ModelAttribute("konfigurasi")
	public Konfigurasi getKonfigurasi() {
		return new Konfigurasi();
	}
	
	@RequestMapping("form")
	public String form() {
		return "konfigurasi";
	}
	
	@RequestMapping("list")
	public String list(Model model ){
		model.addAttribute("konfigurasis", konfigurasiService.findAll()); 
		return "konfigurasiList";
	}
	
	@RequestMapping(value = "/simpan" , method=RequestMethod.POST)
	public String simpan(@ModelAttribute("konfigurasi") Konfigurasi konfigurasi){
		konfigurasiService.save(konfigurasi); 
		return "redirect:/konfig/form?success=true";
	}

}
