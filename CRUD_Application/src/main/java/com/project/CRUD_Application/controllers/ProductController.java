package com.project.CRUD_Application.controllers;


import com.project.CRUD_Application.models.Product;
import com.project.CRUD_Application.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController
    {
    private final ProductService productService;

    @GetMapping()
    public ResponseEntity getProducts()
        {
            try
                {
                    return ResponseEntity.ok(productService.listProducts());
                }
            catch (Exception e)
                {
                    return ResponseEntity.badRequest().body("Server dont work");
                }

        }



    @PostMapping()
    public ResponseEntity createProduct(@RequestBody Product product)
        {

            try
                {
                    productService.saveProduct(product) ;
                    return ResponseEntity.ok("Значение получено");
                }
            catch (Exception e)
                {
                    return ResponseEntity.badRequest().body("Ошибка");
                }
        }

    @DeleteMapping()
    public void deleteProduct(@RequestBody UUID id)
        {
            productService.deleteProduct(id);
        }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable ("id") UUID id,@RequestBody Map<String, Integer> request)
        {
            try
                {
                    int newQuantity = request.get("newQuantity");
                    productService.updateQuantityProductById(id,newQuantity);;
                    return ResponseEntity.ok("Значение изменено");
                }
            catch (Exception e)
                {
                    return ResponseEntity.badRequest().body("Ошибка");
                }
        }
    }


