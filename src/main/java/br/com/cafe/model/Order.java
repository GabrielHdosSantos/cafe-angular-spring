package br.com.cafe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Order implements Serializable {

    private final static long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Customer> customer;

    @OneToOne
    private Product product;


    public Order(List<Customer> customer, Product product) {
        this.customer = customer;
        this.product = product;
    }

    @Deprecated
    public Order() {
    }

}
