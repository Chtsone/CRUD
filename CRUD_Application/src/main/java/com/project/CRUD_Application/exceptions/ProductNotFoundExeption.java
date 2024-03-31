package com.project.CRUD_Application.exceptions;

import java.util.UUID;

public class ProductNotFoundExeption extends RuntimeException
    {
        public ProductNotFoundExeption(UUID id) {super("Could not found product "+id);}
    }
