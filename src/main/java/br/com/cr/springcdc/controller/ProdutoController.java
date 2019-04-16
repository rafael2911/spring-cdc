package br.com.cr.springcdc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cr.springcdc.dao.ProdutoDao;
import br.com.cr.springcdc.model.Produto;
import br.com.cr.springcdc.model.TipoPreco;
import br.com.cr.springcdc.validator.ProdutoValidator;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoDao produtoDao;
	
	/* Registra o validador criado para a classe produto */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidator());
	}
	
	@GetMapping("form")
	public ModelAndView form(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("produto/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		
		return modelAndView;
	}
	
	@PostMapping
	public ModelAndView salvar(@Valid Produto produto, BindingResult result, RedirectAttributes attr) {
		
		/* verifica se validacao retorna erros */
		if(result.hasErrors()) {
			return form(produto);
		}
		
		produtoDao.save(produto);
		
		attr.addFlashAttribute("message", "Produto cadastrado com sucesso!");
		
		return new ModelAndView("redirect:/produto/");
	}
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("produto/lista");
		modelAndView.addObject("produtos", produtoDao.findAll());
		return modelAndView;
	}
	
}
