package br.com.cafe.repos;

import br.com.cafe.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {


    List<Order> findAllCustomerBy();

}
