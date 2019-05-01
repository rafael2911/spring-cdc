package br.com.cr.springcdc.controller;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.cr.springcdc.dao.ProdutoDao;
import br.com.cr.springcdc.dao.UsuarioDao;
import br.com.cr.springcdc.model.Produto;
import br.com.cr.springcdc.model.Role;
import br.com.cr.springcdc.model.Usuario;

@Controller
public class HomeController {
	
	@Autowired
	private ProdutoDao produtoDao;
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@RequestMapping("/")
	@Cacheable(value="produtoHome")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("home/home");
		
		List<Produto> produtos = produtoDao.findAll();
		
		modelAndView.addObject("produtos", produtos);
		
		return modelAndView;
	}
	
	@GetMapping("/url-magica-maluca-jfeowge7fsijg98mfksdgmslk33fsldkfsç8gh56urlf1f3f5f9")
	@ResponseBody
	@Transactional
	public String urlMagicaMaluca() {
		Usuario usuario = new Usuario(); 
	    usuario.setNome("Rafael");
	    usuario.setEmail("rafael@rafael.com.br");
	    usuario.setSenha("$2a$10$lt7pS7Kxxe5JfP.vjLNSyOXP11eHgh7RoPxo5fvvbMCZkCUss2DGu");
	    usuario.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
	    
	    usuarioDao.gravar(usuario);

	    return "Url Mágica executada";
	}
	
	@GetMapping("/teste")
	@ResponseBody
	public String urlTeste() {
		Usuario usuario = new Usuario(); 
	    usuario.setNome("Rafael");
	    usuario.setEmail("rafael@rafael.com.br");
	    usuario.setSenha("$2a$10$lt7pS7Kxxe5JfP.vjLNSyOXP11eHgh7RoPxo5fvvbMCZkCUss2DGu");
	    usuario.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
	    
	    usuarioDao.gravar(usuario);

	    return "Url Mágica executada";
	}
	
}
