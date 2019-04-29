package br.com.cr.springcdc.dao;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.cr.springcdc.builders.ProdutoBuilder;
import br.com.cr.springcdc.config.DataSourceConfigurationTest;
import br.com.cr.springcdc.config.JPAConfiguration;
import br.com.cr.springcdc.model.Produto;
import br.com.cr.springcdc.model.TipoPreco;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JPAConfiguration.class, ProdutoDao.class,
		DataSourceConfigurationTest.class})
@ActiveProfiles("test")
public class ProdutoDaoTest {
	
	@Autowired
	private ProdutoDao produtoDao;

	@Test
	@Transactional
	public void deveSomarTodosOsPrecosPorTipoLivro() {
		
		List<Produto> livrosImpressos = ProdutoBuilder.newProduto(TipoPreco.IMPRESSO, BigDecimal.TEN)
				.more(3).buildAll();
		List<Produto> livrosEbook = ProdutoBuilder.newProduto(TipoPreco.EBOOK, BigDecimal.TEN)
				.more(3).buildAll();
		
		livrosImpressos.stream().forEach(produtoDao::save);
		livrosEbook.stream().forEach(produtoDao::save);
		
		assertEquals(new BigDecimal(40).setScale(2), produtoDao.somaPrecosPorTipo(TipoPreco.IMPRESSO));

	}
	
}
