package org.example.order;

import org.example.category.CategoryEntity;
import org.example.category.CategoryRepository;

import java.util.List;
import java.util.UUID;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(OrderEntity order){
        orderRepository.addOrder(order);
    }

    public void removeOrder(UUID id){
        orderRepository.removeOrder(id);
    }

    public OrderEntity findById(UUID id){
        return orderRepository.findById(id);
    }

    public List<OrderEntity> findAll(){
        return orderRepository.findAll();
    }

    public void upDate(UUID id, OrderEntity order){
        orderRepository.upDate(id, order);
    }
}
