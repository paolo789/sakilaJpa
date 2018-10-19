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
import it.objectmethod.sakila.sakilaJpa.repository.CategoryRepository;
import it.objectmethod.sakila.sakilaJpa.repository.FilmRepository;



@Controller
public class FilmController {
	@Autowired
	private FilmRepository fr;
	
	@Autowired
	private AttoriRepository ar;
	
	@RequestMapping("/cercafilm")
	public String cercaFilm(ModelMap map,@RequestParam("film") String film) {
		List<FilmBean> filmList=fr.findByTitleContaining(film);
		map.addAttribute("films", filmList);
		return "forward:prima";
	}

	@RequestMapping("/listafilmattore")
	public String listaFilmAttore(ModelMap map, @RequestParam("Attore") String attore) {
		//List<FilmBean> actorFilmList=fr.getFilmByActor(attore);
		AttoriBean a=ar.findOne(Integer.parseInt(attore));
		List<FilmBean> actorFilmList=a.getFilmList();
		map.addAttribute("filmsattore",actorFilmList);
		return "forward:prima";
	}
	
	@RequestMapping("/cercagenere")
	public String setCategory(ModelMap map, @RequestParam("filmgenere") String filmGenere) {
		List<FilmBean> categoryFilmList=fr.getFilmByCategory(filmGenere);
		map.addAttribute("categoryFilm", categoryFilmList);
		return "forward:prima";
	}
	
}
