/*package com.teachmeskills.visaction.controller;

import com.teachmeskills.visaction.model.Continent;
import com.teachmeskills.visaction.model.Country;
import com.teachmeskills.visaction.model.Order;
import com.teachmeskills.visaction.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/list-of-orders")
    public ModelAndView orderList(ModelAndView modelAndView) {
        modelAndView.addObject("orders", orderService.findAllOrder());
        modelAndView.setViewName("admin/list-of-orders");
        return modelAndView;
    }

    @PostMapping("/save-order")
    public Order createOrder(@Valid @RequestBody Order order) {
        return orderService.saveOrder(order);
    }

}*/
