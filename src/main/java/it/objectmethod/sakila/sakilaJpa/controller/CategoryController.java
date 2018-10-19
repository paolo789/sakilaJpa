package it.objectmethod.sakila.sakilaJpa.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import it.objectmethod.sakila.sakilaJpa.entity.CategoryBean;
import it.objectmethod.sakila.sakilaJpa.repository.CategoryRepository;


@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository cr;
	
	
	@RequestMapping("/prima")
	public String getCategory(ModelMap map) {
		List<CategoryBean> categorylist=cr.findAll();
		map.addAttribute("category", categorylist);
		return "Ricerca";
	}

}
