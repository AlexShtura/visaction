package com.teachmeskills.visaction.service.impl;

import com.teachmeskills.visaction.model.Order;
import com.teachmeskills.visaction.repository.OrderRepo;
import com.teachmeskills.visaction.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderRepo orderRepo;

    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public List<Order> findAllOrder() {
        return orderRepo.findAll();
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepo.getById(id);
    }

    @Override
    public Order saveOrder(Order order) {
        orderRepo.save(order);
        return order;
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepo.delete(order);
    }
}
