package com.giftOrchids.giftOrchids.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "enquiry")
public class Enquiry {
    @Id
    private int eid;
    private String name;
    private String message;
    private String contact;
    private String emailId;
    private String enquiryType;
}
