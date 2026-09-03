package com.cl.mysqldemo.services;

import com.cl.mysqldemo.entities.School;
import com.cl.mysqldemo.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
        return schoolRepository.getAllSchool();
    }

    public School getById(Long id) {
        Optional<School> school = schoolRepository.findById(id);
        if (school.isPresent() && school.get().getIsActive()) {
            return school.get();
        }
        return new School();
    }

    public School updateSchool(Long id ,String name, String location) throws Exception{
        School schoolToUpdate = schoolRepository.getById(id);
        if (schoolToUpdate== null){
           throw new Exception("school not found by id");
        }
        schoolToUpdate.setCreatedDate(new Date());
        schoolToUpdate.setName(name);
        schoolToUpdate.setLocation(location);
        schoolToUpdate = schoolRepository.save(schoolToUpdate);
        return schoolToUpdate;
    }


    public Boolean deletById(Long id ){
        School schoolToUpdate = schoolRepository.getById(id);
        if (schoolToUpdate== null){
            return false;
        }
        schoolToUpdate.setIsActive(false);
        schoolToUpdate.setUpdatedDate(new Date());
        schoolRepository.save(schoolToUpdate);
        return true;
    }


}
