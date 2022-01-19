package br.com.cafe.service;

import br.com.cafe.model.Customer;
import br.com.cafe.repos.CustomerRepo;
import br.com.cafe.repos.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private OrderRepo orderRepo;

    public Customer addCustomer(Customer customer) {
        return repo.save(customer);
    }

    public Customer updateCustomer(Customer customer, Long id) {
        customer.setId(id);
        return repo.save(customer);
    }

    public List<Customer> all() {
        return repo.findAll();
    }

    public Customer findById(Long id) {
        return repo.getById(id);
    }

    public void deleteCustomer(Long id) {
        repo.deleteById(id);
    }


}
