package br.com.cafe.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Product implements Serializable {

    private static final long SerialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String desc;
    private double price;



    public Product(String name, String desc, double price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    @Deprecated
    public Product(){}

}
