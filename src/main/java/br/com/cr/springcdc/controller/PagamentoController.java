package br.com.cr.springcdc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cr.springcdc.model.CarrinhoCompras;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {
	
	@Autowired
	private CarrinhoCompras carrinho;
	
	@PostMapping("finalizar")
	public ModelAndView finalizar(RedirectAttributes attr) {
		
		attr.addFlashAttribute("message", "Pagamento realizado com sucesso!");
		
		System.out.println(carrinho.getTotal());
		
		return new ModelAndView("redirect:/produto");
	}
	
}
