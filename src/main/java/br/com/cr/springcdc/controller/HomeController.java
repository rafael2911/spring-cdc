package br.com.cr.springcdc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cr.springcdc.dao.ProdutoDao;
import br.com.cr.springcdc.model.Produto;

@Controller
public class HomeController {
	
	@Autowired
	private ProdutoDao produtoDao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("home/home");
		
		List<Produto> produtos = produtoDao.findAll();
		
		modelAndView.addObject("produtos", produtos);
		
		return modelAndView;
	}
	
}
