package com.giftOrchids.giftOrchids.service;

import com.giftOrchids.giftOrchids.models.Enquiry;
import com.giftOrchids.giftOrchids.repository.EnquiryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnquiryService {

    @Autowired
    EnquiryRepo enquiryRepo;

    public Optional<Enquiry> getEnquiry(Integer eid) {
        return enquiryRepo.findById(eid);
    }

    public List<Enquiry> getEnquiries() {
        return enquiryRepo.findAll();
    }

    public void addEnquiry(Enquiry enquiry) {
        enquiryRepo.save(enquiry);
    }
}
