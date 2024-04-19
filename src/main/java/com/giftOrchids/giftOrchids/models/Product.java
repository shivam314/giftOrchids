package com.giftOrchids.giftOrchids.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    private int pid;
    private String productName;
    private String productDescription;
    private String category;
    private long procurementPrice;
    private long sellingPrice;
    private String image;
    private int availableQuantity;
}