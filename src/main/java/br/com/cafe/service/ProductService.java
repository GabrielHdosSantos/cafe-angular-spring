package br.com.cafe.service;

import br.com.cafe.model.Product;
import br.com.cafe.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product addProduct(Product product){
      return productRepo.save(product);
    }

    public Product updateProduct(Product product, Long id){
        product.setId(id);
        return productRepo.save(product);
    }

    public List<Product> all(){
        return productRepo.findAll();
    }

    public Product findProductById(Long id){
        return productRepo.getById(id);
    }

    public void deleteProduct(Long id){
        productRepo.deleteById(id);
    }

}
