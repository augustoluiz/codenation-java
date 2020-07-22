package br.com.orderservice.service;

import br.com.orderservice.model.OrderItem;
import br.com.orderservice.model.Product;
import br.com.orderservice.repository.ProductRepository;
import br.com.orderservice.repository.ProductRepositoryImpl;

import java.util.*;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService{


    private ProductRepository productRepository = new ProductRepositoryImpl();
    private final double DESCONTO = 0.20;

    public List<Product> listAll(){
        return productRepository.findAll();
    }
    /**
     * Calculate the sum of all OrderItems
     */
    @Override
    public Double calculateOrderValue(List<OrderItem> items) {
        return items.stream().map((item) -> {
            Product product = this.productRepository.findById(item.getProductId()).get();
            Double preco = product.getValue() * item.getQuantity();
            return product.getIsSale() ? preco - (preco * this.DESCONTO) : preco;
        }).reduce((anterior, atual) -> atual + anterior ).get();
    }

    /**
     * Map from idProduct List to Product Set
     */
    @Override
    public Set<Product> findProductsById(List<Long> ids) {
        return ids.stream().map(id -> this.productRepository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

    /**
     * Calculate the sum of all Orders(List<OrderIten>)
     */
    @Override
    public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
        return orders.stream().map(items -> calculateOrderValue(items)).reduce((anterior, atual) -> atual + anterior).get();
    }

    /**
     * Group products using isSale attribute as the map key
     */
    @Override
    public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
        return findProductsById(productIds).stream().collect(Collectors.groupingBy(Product::getIsSale));
    }

}