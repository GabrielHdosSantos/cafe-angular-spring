package br.com.cafe.controller;

import br.com.cafe.dto.CustomerDTO;
import br.com.cafe.model.Order;
import br.com.cafe.service.OrderService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("{id}")
    public ResponseEntity<Order> doOrder(@RequestBody CustomerDTO dto, @PathVariable("id") Long id) {
        Order order = orderService.addOrder(dto, id);

        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable("id") Long id) {

        orderService.deleteOrder(id);
    }

    @GetMapping
    public ResponseEntity<List<Order>> ordersPedido() {
        List<Order> orders = orderService.orderPedido();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
