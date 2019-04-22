package br.com.cr.springcdc.controller;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cr.springcdc.model.CarrinhoCompras;
import br.com.cr.springcdc.model.DadosPagamento;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {
	
	@Autowired
	private CarrinhoCompras carrinho;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("finalizar")
	public Callable<ModelAndView> finalizar(RedirectAttributes attr) {
		
		return () -> {
			
			try {
				
				String uri = "http://book-payment.herokuapp.com/payment";
				String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);
				
				attr.addFlashAttribute("message", response);
				
				System.out.println(response);
				
				return new ModelAndView("redirect:/produto");
				
			}catch (HttpClientErrorException ex) {
				attr.addFlashAttribute("message", "Valor maior que o permitido.");
				ex.printStackTrace();
				return new ModelAndView("redirect:/produto");
			}
			
		};
		
	}
	
}
