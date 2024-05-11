package com.thinkitive.microservice.userservice.service;

import com.thinkitive.microservice.userservice.entity.Patient;
import com.thinkitive.microservice.userservice.entity.UserService;
import com.thinkitive.microservice.userservice.feignservice.PatientService;
import com.thinkitive.microservice.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;

@Service
public class UserServiceImpl implements ServiceUser {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PatientService patientService;

    @Override
    public UserService getUser(int id) {
        UserService getUser = userRepository.findById(id).get();
        ArrayList<Patient> patient = restTemplate.getForObject("http://PATIENT-SERVICE/patient/get/"+getUser.getId(), ArrayList.class);
//        List<Patient> patients = (List<Patient>) patientService.patient(getUser.getId());
        getUser.setPatient(patient);
        return getUser;
    }

    @Override
    public UserService createUser(UserService user) {
        UserService createUser = userRepository.save(user);
        return createUser;
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserService updateUser(int id, UserService user) {
        UserService updateInfo = userRepository.findById(id).orElse(null);
        if (updateInfo != null) {
            updateInfo.setUsername(user.getUsername());
            updateInfo.setEmail(user.getEmail());
            updateInfo.setPassword(user.getPassword());
            UserService updatedStatus = userRepository.save(updateInfo);
            return updatedStatus;
        } else {
            return null;
        }
    }
}