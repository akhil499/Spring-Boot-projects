package com.example.restapi.service;

import com.example.restapi.model.Product;
import com.example.restapi.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private Logger LOG = LoggerFactory.getLogger(ProductService.class);
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(String id) {
        LOG.info("Getting the product with given id: " + id);
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        Product productToSave;
        try {
            LOG.info("Saving product...");
            productToSave = productRepository.save(product);
            return productToSave;
        } catch (Exception e) {
            LOG.error("An error occurred during the product saving: " + e.getMessage());
        }
        return new Product();
    }

    public Product updateProduct(Product productToUpdate, String id) {

        Product foundProduct = productRepository.findById(id).orElse(null);
        try {
            foundProduct.setName(productToUpdate.getName());
            foundProduct.setDescription(productToUpdate.getDescription());
            foundProduct.setType(productToUpdate.getType());
            foundProduct.setCategory(productToUpdate.getCategory());
        } catch (Exception e) {
            LOG.error("An occurred during the update product: " + e.getMessage());
        }
        return productToUpdate;
    }

    public void deleteProduct(String id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            LOG.error("An error occurred during deletion of the product: " + e.getMessage());
        }

    }
}
