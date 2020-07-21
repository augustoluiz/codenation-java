package br.com.orderservice.repository;

import br.com.orderservice.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {


    List<Product> findAll();

    List<Product> findByName(String name);

    Optional<Product> findById(Long id);

}
