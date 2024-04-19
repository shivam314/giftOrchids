package com.giftOrchids.giftOrchids.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    private int cid;
    private String categoryName;
    private String categoryDescription;
}
