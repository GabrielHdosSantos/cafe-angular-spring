package br.com.cafe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;

    @ManyToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Order> orders;

    public Customer(String name, String cpf, List<Order> orders) {
        this.name = name;
        this.cpf = cpf;
        this.orders = orders;
    }

    @Deprecated
    public Customer(){}
}
