package tn.iit.spring.tp2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.iit.spring.tp2.dao.LangueRepo;
import tn.iit.spring.tp2.entite.Langue;

@Controller
@RequestMapping("api/language")
public class LanguageController {
	@Autowired
	private LangueRepo langueRepo;
	@GetMapping
	@ResponseBody
public List<Langue> list(){
	return langueRepo.findAll();
}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		langueRepo.delete(id);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Langue show(@PathVariable Long id){
		System.out.println(id);
		langueRepo.findOne(id);
		return  langueRepo.findOne(id);
	}
	/*
	 @PostMapping("/{value}")
	 public void add(@PathVariable String value){
		 langueRepo.save(new Langue(value));
	 }*/
	@ResponseBody
	 @PostMapping
	 public List<Langue> add(@RequestParam String value){
		 langueRepo.save(new Langue(value));
		 return langueRepo.findAll();
	 }
	@ResponseBody
	 @PutMapping
	 public void  add(@RequestBody Langue l)
	 {
		 langueRepo.save(l);
	 }
}
