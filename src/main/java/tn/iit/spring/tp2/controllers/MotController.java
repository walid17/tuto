package tn.iit.spring.tp2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.iit.spring.tp2.dao.LangueRepo;
import tn.iit.spring.tp2.dao.MotRepo;
import tn.iit.spring.tp2.entite.Langue;
import tn.iit.spring.tp2.entite.Mot;
import tn.iit.spring.tp2.entite.TranslateDto;

@Controller
@RequestMapping("api/Mot")
public class MotController {
	@Autowired
	private MotRepo motRepo;
	@Autowired
	private LangueRepo langueRepo;

	@GetMapping
	@ResponseBody
	public List<Mot> list() {
		return motRepo.findAll();
	}
	@ResponseBody
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		motRepo.delete(id);
	}
	@ResponseBody
	@GetMapping("/{id}")
	public Mot show(@PathVariable Long id) {
		return motRepo.findOne(id);
	}

	@PostMapping("/translate")
	@ResponseBody
	public List<TranslateDto> translate(@RequestParam String mot, @RequestParam long idLangueIn,
			@RequestParam long idLangueout) {
		Langue langueIn=langueRepo.findOne(idLangueIn);
		Langue langueOut=langueRepo.findOne(idLangueout);
		List<Mot> mot2= motRepo.findByLangueMot(langueIn, mot);
		List<TranslateDto> translateDtos=new ArrayList<>();
		
		for(Mot m:mot2){
			System.out.println("test");
			
			Mot dto=motRepo.findByCleLangue(m.getCle(),langueOut);
			TranslateDto t=new TranslateDto(mot,dto.getMot() , langueIn.getNom(), langueOut.getNom());
			translateDtos.add(t);
			
		}
		return translateDtos;
	}

	/*
	 * @PostMapping("/{value}") public void add(@PathVariable String value){
	 * langueRepo.save(new Langue(value)); }
	 */
	
	@PostMapping
	public void add(@RequestParam String mot, @RequestParam long idLangue, @RequestParam String mot1,
			@RequestParam long idLangue1) {
		Langue l = langueRepo.findOne(idLangue);
		Langue l1 = langueRepo.findOne(idLangue1);
		Langue lr = langueRepo.findByValue("francais");
		synchronized (this) {
			List<Mot> listMot=motRepo.findAll();
			long cle ;
			if(listMot.isEmpty())
			{
				cle=0;
			}
			 cle = motRepo.getMaxCle(lr) + 1;
			
				
			
			motRepo.save(new Mot(mot1, cle, l1));
			motRepo.save(new Mot(mot, cle, l));
		}
	}
}
