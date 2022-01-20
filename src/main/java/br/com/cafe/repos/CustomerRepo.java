package br.com.cafe.repos;

import br.com.cafe.dto.CustomerOrderDTO;
import br.com.cafe.model.Customer;
import br.com.cafe.model.Order;
import br.com.cafe.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Customer findCustomerByCpf(String cpf);

    @Query(value = "select p.id, c.name as \"nome\", pt.name, pt.price\n" +
            "from product pt \n" +
            "join pedidos p on p.product_id = pt.id\n" +
            "join pedidos_customer pc on pc.orders_id = p.id \n" +
            "join customer c on c.id = pc.customer_id", nativeQuery = true)
    List<Tuple> findAllOrdersBy();

}
