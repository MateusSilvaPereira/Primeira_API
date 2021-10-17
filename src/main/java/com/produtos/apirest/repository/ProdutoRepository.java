package com.produtos.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Produtos;

import antlr.collections.List;

public interface ProdutoRepository extends JpaRepository<Produtos, Long>{

	Optional<Produtos> findById(Long id);

}
