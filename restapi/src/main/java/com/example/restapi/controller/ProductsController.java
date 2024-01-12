package com.example.restapi.controller;

import com.example.restapi.model.Product;
import com.example.restapi.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/products/")
public class ProductsController {

    private ProductRepository productRepository;

    private Logger LOG = LoggerFactory.getLogger(ProductsController.class);

    @Autowired
    public void productRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable(name = "id") String id) {
        return productRepository.findById(id).orElse(null);
    }

    @PostMapping("")
    public Product saveProduct(@RequestBody Product product) {

        return productRepository.save(product);
    }

    @PutMapping("{id}")
    public Product updateProduct(@RequestBody Product productToUpdate, @PathVariable(name = "id") String id) {
        Product foundProduct = productRepository.findById(id).orElse(null);
        if(foundProduct != null) {
            foundProduct.setName(productToUpdate.getName());
            foundProduct.setDescription(productToUpdate.getDescription());
            foundProduct.setType(productToUpdate.getType());
            foundProduct.setCategory(productToUpdate.getCategory());


            return productRepository.save(foundProduct);


        } else {
            LOG.info("NO product with id");
            return productToUpdate;
        }

    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable(name = "id") String id) {
        Product foundProduct = productRepository.findById(id).orElse(null);

        if(foundProduct != null) {
            productRepository.deleteById(id);
        }
    }

}
