package br.com.cafe.dto;

import br.com.cafe.model.Customer;
import br.com.cafe.model.Product;

public class CustomerOrderDTO {

    public Object id;
    public Object customer;
    public Object product;
    public Object price;

    public CustomerOrderDTO(Object customer, Object product, Object price,  Object id) {
        this.customer = customer;
        this.product = product;
        this.price = price;
        this.id = id;
    }

    public CustomerOrderDTO(Object customer, Object product, Object price) {
        this.customer = customer;
        this.product = product;
        this.price = price;
    }
}
