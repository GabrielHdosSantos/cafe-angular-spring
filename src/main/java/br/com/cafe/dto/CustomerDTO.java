package br.com.cafe.dto;

import br.com.cafe.model.Customer;

import java.util.Optional;

public class CustomerDTO {

    public String name;
    public String cpf;



    public Customer dtoToObj(CustomerDTO customer) {

        Customer newCustomer = new Customer();
        newCustomer.setName(customer.name);
        newCustomer.setCpf(customer.cpf);

        return newCustomer;
    }

}
