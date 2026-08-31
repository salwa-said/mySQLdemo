package com.cl.mysqldemo.services;

import com.cl.mysqldemo.entities.School;
import com.cl.mysqldemo.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    SchoolRepository schoolRepository;
    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public Long createSchool(String name,String location){
        School school= new School();
        school.setIsActive(true);
        school.setCreatedDate(new Date());
        school.setName(name);
        school.setLocation(location);

        school= schoolRepository.save(school);

        return school.getId();
    }


    public List<School> getAllSchools(){
        return schoolRepository.findAll();
    }

    public School getById(Long id) {
        Optional<School> school = schoolRepository.findById(id);
        if (school.isPresent() && school.get().getIsActive()) {
            return school.get();
        }
            return new School();
        }
}
