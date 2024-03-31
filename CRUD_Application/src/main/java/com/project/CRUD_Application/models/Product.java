package com.project.CRUD_Application.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product
    {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;
        @Column(name = "title")
        private String title;

        private String description;

        private double price;

        private String category;

        private int quantity;

        private LocalDateTime createTime;

        private LocalDateTime lastUpdateQuantity;


        public void setId(UUID id)
            {
                this.id = id;
            }

        public void setTitle(String title)
            {
                this.title = title;
            }

        public void setDescription(String description)
            {
                this.description = description;
            }

        public void setPrice(double price)
            {
                this.price = price;
            }

        public void setCategory(String category)
            {
                this.category = category;
            }

        public void setQuantity(int quantity)
            {
                this.quantity = quantity;
            }

        public void setCreateTime(LocalDateTime createTime)
            {
                this.createTime = createTime;
            }

        public void setLastUpdateQuantity(LocalDateTime lastUpdateQuantity)
            {
                this.lastUpdateQuantity = lastUpdateQuantity;
            }
    }
