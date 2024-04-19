package com.giftOrchids.giftOrchids.controller;

import com.giftOrchids.giftOrchids.models.Enquiry;
import com.giftOrchids.giftOrchids.repository.EnquiryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EnquiryController {

    @Autowired
    EnquiryRepo enquiryRepo;

    @GetMapping("/enquiry")
    public Optional<Enquiry> getEnquiry(@RequestParam Integer eid) {
        return enquiryRepo.findById(eid);
    }

    @GetMapping("/enquiries")
    public List<Enquiry> getEnquiries() {
        return enquiryRepo.findAll();
    }

    @PostMapping("/addEnquiry")
    public void addEnquiry(@RequestBody Enquiry enquiry) {
        enquiryRepo.save(enquiry);
    }

}
