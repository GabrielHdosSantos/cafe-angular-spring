package br.com.cafe.controller;

import br.com.cafe.dto.CustomerOrderDTO;
import br.com.cafe.model.Customer;
import br.com.cafe.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> addingCustomer(@RequestBody Customer customer){
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Customer> updateCustomer (@RequestBody Customer customer, @PathVariable("id") Long id){
        Customer newCustomer = customerService.updateCustomer(customer, id);
        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> customers (){
        List<Customer> customers = customerService.all();

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Long id){
        Customer customer = customerService.findById(id);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerOrderDTO>>  findallOrders(){

        List<CustomerOrderDTO> customers = customerService.findAllOrders();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

}
