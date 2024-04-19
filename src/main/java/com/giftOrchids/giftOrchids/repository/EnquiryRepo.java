package com.giftOrchids.giftOrchids.repository;

import com.giftOrchids.giftOrchids.models.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EnquiryRepo extends JpaRepository<Enquiry, Integer> {
}
