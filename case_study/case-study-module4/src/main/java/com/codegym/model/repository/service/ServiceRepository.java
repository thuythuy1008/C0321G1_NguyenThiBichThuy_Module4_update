package com.codegym.model.repository.service;

import com.codegym.model.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    Page<Service> findAllByServiceNameContaining(Pageable pageable, String name);
}
