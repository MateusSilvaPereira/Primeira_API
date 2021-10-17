package com.produtos.apirest.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produtos;
import com.produtos.apirest.repository.ProdutoRepository;

import antlr.collections.List;

@RestController
@RequestMapping(value="/api")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public java.util.List<Produtos> listarProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto{id}")
	public Optional<Produtos> ListaProdutoUnico(@PathVariable(value= "id") Long id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produto")
	public Produtos salvarProduto(@RequestBody Produtos produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto")
	public void deletaProduto(Produtos produto) {
		produtoRepository.delete(produto);
	}
}
