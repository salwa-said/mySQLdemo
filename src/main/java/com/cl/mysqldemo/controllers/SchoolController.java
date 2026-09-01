package com.cl.mysqldemo.controllers;


import com.cl.mysqldemo.dto.SchoolDTO;
import com.cl.mysqldemo.entities.School;
import com.cl.mysqldemo.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("school")
public class SchoolController {

    SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("add")
    public Long addSchool(@RequestParam String schoolName, @RequestParam String location) {
        return schoolService.createSchool(schoolName, location);
    }

    @GetMapping("getAll")
    public List<SchoolDTO> getAllSchools(){
        List<SchoolDTO> schools =SchoolDTO.convrToDTO(schoolService.getAllSchools());
        return schools;
    }


    @GetMapping("getById")
    public SchoolDTO getById(@RequestParam Long id) {
        return SchoolDTO.convrToDTO(schoolService.getById(id));
    }


    @PutMapping("update")
    public SchoolDTO updateSchool(@RequestParam Long id, @RequestParam String name, @RequestParam String location) {
        return SchoolDTO.convrToDTO(schoolService.updateSchool(id, name, location));
    }


    @DeleteMapping
    public Boolean deleteSchool(@RequestParam Long id){
        return schoolService.deletById(id);
    }
}
