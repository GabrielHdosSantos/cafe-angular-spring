package br.com.cafe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
@Table(name = "pedidos")
public class Order implements Serializable {

    private final static long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany()
    @JsonIgnore
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
