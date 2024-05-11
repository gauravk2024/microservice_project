package com.thinkitive.microservice.userservice.feignservice;

import com.thinkitive.microservice.userservice.entity.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "PATIENT-SERVICE")
public interface PatientService {
    @GetMapping("get/{id}")
    public Patient patient(@PathVariable int id);
}