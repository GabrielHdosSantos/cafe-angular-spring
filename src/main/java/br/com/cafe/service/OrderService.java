package br.com.cafe.service;

import br.com.cafe.dto.CustomerDTO;
import br.com.cafe.model.Customer;
import br.com.cafe.model.Order;
import br.com.cafe.model.Product;
import br.com.cafe.repos.CustomerRepo;
import br.com.cafe.repos.OrderRepo;
import br.com.cafe.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProductRepo productRepo;


    public Order addOrder(CustomerDTO dto, Long id) {
        List<Customer> customers = new ArrayList<>();
        List<Order> orders = new ArrayList<>();

        //busca pelo id
        Customer customer = customerRepo.findCustomerByCpf(dto.cpf);
        if (Objects.isNull(customer)) {

            //insere no banco caso o customer nao exista
            Customer newCustomer = customerRepo.save(dto.dtoToObj(dto));

            //acha o produto pelo id passado na uri
            Product newProduct = productRepo.findProductById(id);
            customers.add(newCustomer);
            Order newOrder = new Order(customers, newProduct);
            orders.add(newOrder);
            newCustomer.setOrders(orders);
            //seta todos os objetos nos seus devidos atributos


            orderRepo.save(newOrder);
            customerRepo.save(newCustomer);

        return newOrder;

        } else if (Objects.nonNull(customer)) {

            //busca pelo id
            Product newProduct = productRepo.findProductById(id);

            //adiciona na lista
            customers.add(customer);

            //instancia um objeto com a lista e o produto retornados da base
            Order newOrder = new Order(customers, newProduct);
            orders.add(newOrder);
            customer.setOrders(orders);
            //seta os atributos nos objetos


            orderRepo.save(newOrder);
            customerRepo.save(customer);

            return newOrder;
        }
        return null;
    }

    public List<Order> all() {
        return orderRepo.findAll();
    }

    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);

    }

    public List<Order> orderPedido(){
        return orderRepo.findAllCustomerBy();
    }


}
