package com.gourab.service.doctor;


import com.gourab.domain.doctor.Doctor;
import com.gourab.repository.Dao.DoctorRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;
//    @Autowired
//    private EmailService service;

    @PostConstruct
    public void initDoctor(){
        repository.saveAll(Stream.of
                        (new Doctor(103,"gourab","Cardiac"),
                                new Doctor(104,"rohan","eye"))
                .collect(Collectors.toList()));
    }

    public List<Doctor> getDoctors(){
//        service.sendEMail();
        return repository.findAll();
    }
}