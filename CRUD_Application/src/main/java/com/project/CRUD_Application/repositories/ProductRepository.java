package com.project.CRUD_Application.repositories;


import com.project.CRUD_Application.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID>
    {

    }
