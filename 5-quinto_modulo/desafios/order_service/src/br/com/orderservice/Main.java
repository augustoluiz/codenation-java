package br.com.orderservice;

import br.com.orderservice.data.ProductsMockedData;
import br.com.orderservice.model.OrderItem;
import br.com.orderservice.model.Product;
import br.com.orderservice.service.OrderServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        OrderServiceImpl osi = new OrderServiceImpl();

        List<OrderItem> orderItems = new ArrayList<>();
        osi.listAll().forEach(p -> {
            OrderItem oi = new OrderItem(p.getId(), 1L);
            orderItems.add(oi);
            System.out.println(p.toString());
        });
        System.out.println(osi.calculateOrderValue(orderItems));


        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        osi.findProductsById(ids).forEach(p -> System.out.println(p.toString()));

        List<OrderItem> orderItems1 = new ArrayList<>();
        osi.listAll().forEach(p -> {
            OrderItem oi = new OrderItem(p.getId(), 1L);
            orderItems1.add(oi);
        });

        List<List<OrderItem>> lstOrderItems = new ArrayList<>();
        lstOrderItems.add(orderItems);
        lstOrderItems.add(orderItems1);

        System.out.println(osi.calculateMultipleOrders(lstOrderItems));



        List<Long> ids1 = new ArrayList<>();
        ids1.add(1L);
        ids1.add(2L);
        ids1.add(8L);
        System.out.println(osi.groupProductsBySale(ids1).toString());

    }

}
