package br.com.cr.springcdc.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cr.springcdc.model.Produto;
import br.com.cr.springcdc.model.TipoPreco;

@Repository
@Transactional
public class ProdutoDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Produto save(Produto produto) {
		
		entityManager.persist(produto);
		
		return produto;
	}

	public List<Produto> findAll() {
		
		return entityManager.createQuery("select distinct(p) from Produto p join fetch p.precos", Produto.class).getResultList();
		
	}

	public Produto find(Long id) {
		return entityManager.createQuery("from Produto p join fetch p.precos precos"
					+ " where p.id = :id", Produto.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
	public BigDecimal somaPrecosPorTipo(TipoPreco tipoPreco) {
		
		TypedQuery<BigDecimal> query = entityManager.createQuery("select sum(preco.valor) from Produto p "
				+ "join p.precos preco where preco.tipo = :tipoPreco", BigDecimal.class);
		
		query.setParameter("tipoPreco", tipoPreco);
		
		return query.getSingleResult();
		
	}
	
}
