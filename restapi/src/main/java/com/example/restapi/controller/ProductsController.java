package com.example.restapi.controller;

import com.example.restapi.model.Product;
import com.example.restapi.repository.ProductRepository;
import com.example.restapi.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/products/")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    private Logger LOG = LoggerFactory.getLogger(ProductsController.class);

    @GetMapping("{id}")
    public Product getProduct(@PathVariable(name = "id") String id) {
        return productService.getProduct(id);
    }

    @PostMapping("")
    public Product saveProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("{id}")
    public Product updateProduct(@RequestBody Product productToUpdate, @PathVariable(name = "id") String id) {
        return productService.updateProduct(productToUpdate, id);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable(name = "id") String id) {
        productService.deleteProduct(id);
    }

}
