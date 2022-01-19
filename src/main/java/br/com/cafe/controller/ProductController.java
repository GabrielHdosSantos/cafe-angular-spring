package br.com.cafe.controller;

import br.com.cafe.model.Product;
import br.com.cafe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("product")
@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = service.addProduct(product);

        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") Long id) {
        Product newProduct = service.updateProduct(product, id);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> all() {
        List<Product> products = service.all();

        return new ResponseEntity<>(products, HttpStatus.OK);

    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        service.deleteProduct(id);
    }

}
