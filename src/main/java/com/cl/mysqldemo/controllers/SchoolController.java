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
    public Long addSchool(@RequestBody SchoolDTO dto) {
        return schoolService.createSchool(dto.getSchoolName(), dto.getSchoolLocation());
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
    public SchoolDTO updateSchool(@RequestBody SchoolDTO dto) {
        return SchoolDTO.convrToDTO(schoolService.updateSchool(dto.getSchoolId(),dto.getSchoolName(), dto.getSchoolLocation()));
    }


    @DeleteMapping("deleteById")
    public Boolean deleteSchool(@RequestParam Long id){
        return schoolService.deletById(id);
    }
}
