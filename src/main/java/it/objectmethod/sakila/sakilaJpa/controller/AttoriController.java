package it.objectmethod.sakila.sakilaJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.sakila.sakilaJpa.entity.AttoriBean;
import it.objectmethod.sakila.sakilaJpa.entity.FilmBean;
import it.objectmethod.sakila.sakilaJpa.repository.AttoriRepository;
import it.objectmethod.sakila.sakilaJpa.repository.FilmRepository;

@Controller
public class AttoriController {
	
	@Autowired
	private AttoriRepository ar;
	
	@Autowired
	private FilmRepository fr;
	
	@RequestMapping("/cercaattori")
	public String cercaAttori(ModelMap map,@RequestParam("actor") String actor) {
		List<AttoriBean> actorlist=ar.findByLastNameContaining(actor);
		map.addAttribute("attori", actorlist);
		return "forward:prima";
	}
	
	

	@RequestMapping("/listaattorifilm")
	public String attoriFilm(ModelMap map,@RequestParam("Film") String film ) {
		//List<AttoriBean> actorsFilmList=ar.getActorsByFilm(film);
		FilmBean f=fr.findOne(Integer.parseInt(film));
		List<AttoriBean> actorsFilmList=f.getAttoreList();
		map.addAttribute("actorsfilm", actorsFilmList);
		return "forward:prima";
	}
	
}