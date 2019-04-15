package br.com.cr.springcdc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cr.springcdc.dao.ProdutoDao;
import br.com.cr.springcdc.model.Produto;
import br.com.cr.springcdc.model.TipoPreco;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoDao produtoDao;
	
	@GetMapping("/form")
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("produto/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		
		return modelAndView;
	}
	
	@PostMapping("/")
	public String salvar(Produto produto) {
		System.out.println(produto);
		produtoDao.save(produto);
		return "produto/ok";
	}
	
}
