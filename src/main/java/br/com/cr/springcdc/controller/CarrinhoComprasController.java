package br.com.cr.springcdc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.cr.springcdc.dao.ProdutoDao;
import br.com.cr.springcdc.model.CarrinhoCompras;
import br.com.cr.springcdc.model.CarrinhoItem;
import br.com.cr.springcdc.model.Produto;
import br.com.cr.springcdc.model.TipoPreco;

@Controller
@RequestMapping("/carrinho")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {
	
	@Autowired
	private ProdutoDao produtoDao;
	
	@Autowired
	private CarrinhoCompras carrinho;

	@PostMapping("add")
	public ModelAndView add(Long produtoId, TipoPreco tipoPreco) {
		ModelAndView modelAndView = new ModelAndView("redirect:/produto");
		
		CarrinhoItem item = criaItem(produtoId, tipoPreco);
		
		carrinho.add(item);
		
		return modelAndView;
	}

	private CarrinhoItem criaItem(Long produtoId, TipoPreco tipoPreco) {
		Produto produto = produtoDao.find(produtoId);
		CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipoPreco);
		
		return carrinhoItem;
	}
	
}
