package com.project.CRUD_Application.services;
import com.project.CRUD_Application.exceptions.ProductNotFoundExeption;
import com.project.CRUD_Application.models.Product;
import com.project.CRUD_Application.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> listProducts()
        {
            return productRepository.findAll();
        }

    public Product saveProduct(Product product)
        {
            product.setCreateTime(LocalDateTime.now());
            product.setLastUpdateQuantity(LocalDateTime.now());
            return productRepository.save(product);
        }

    public void deleteProduct(UUID id)
        {
             productRepository.deleteById(id);
        }

    public Product getProductById(UUID id)
        {
            return productRepository.findById(id).orElseGet(() -> {throw new ProductNotFoundExeption(id);});
        }
    public Product updateQuantityProductById(UUID id,int newQuantity)
        {
            Product prod = productRepository.findById(id).orElseGet(() -> {throw new ProductNotFoundExeption(id);});
            prod.setQuantity(newQuantity);
            prod.setLastUpdateQuantity(LocalDateTime.now());
            return productRepository.save(prod);
        }


}
