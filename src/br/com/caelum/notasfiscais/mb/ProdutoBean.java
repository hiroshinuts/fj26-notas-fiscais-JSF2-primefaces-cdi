package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;

@Model
@Transactional
public class ProdutoBean {
	
	@Inject
	private ProdutoDao dao;
	
	private List<Produto> produtos;
	private Produto produto = new Produto();

	public Produto getProduto() {
		return produto;
	}
	
	public void grava() {
		if(produto.getId() == null) {
			dao.adiciona(produto);
		}else {
			dao.atualiza(produto);
		}
		this.produtos = dao.listaTodos();
		this.produto = new Produto();
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos(){
		if(produtos == null) {
			System.out.println("Carregando produtos...");
			produtos = dao.listaTodos();
		}
		return produtos;
	}
	
	public void remove(Produto produto) {
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}

	public void cancela() {
		System.out.println("Cancela a edicao");
		this.produto = new Produto();
	}
}
