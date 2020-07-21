package br.com.orderservice.service;

import br.com.orderservice.model.OrderItem;
import br.com.orderservice.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface OrderService {

    Double calculateOrderValue(List<OrderItem> items);

    Set<Product> findProductsById(List<Long> ids);

    Double calculateMultipleOrders(List<List<OrderItem>> orders);

    Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds);

}
