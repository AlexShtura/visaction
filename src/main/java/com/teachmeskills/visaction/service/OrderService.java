package com.teachmeskills.visaction.service;

import com.teachmeskills.visaction.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAllOrder();

    Order findOrderById(Long id);

    Order saveOrder(Order order);

    void deleteOrder(Order order);
}
