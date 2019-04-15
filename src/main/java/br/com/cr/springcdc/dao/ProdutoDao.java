package br.com.cr.springcdc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cr.springcdc.model.Produto;

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
		
		return entityManager.createQuery("from Produto p", Produto.class).getResultList();
		
	}
	
}
