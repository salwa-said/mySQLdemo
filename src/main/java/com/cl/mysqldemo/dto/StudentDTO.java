package com.cl.mysqldemo.dto;

import com.cl.mysqldemo.entities.Student;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@Data
public class StudentDTO {

        private Long studentId;
        private String studentName;
        private String parentName;
        private String studentMajor;
        private String studentPhoneNumber;
        private String gender;


        public  static StudentDTO convrToDTO(Student entity){
            StudentDTO dto= StudentDTO.builder()
                    .studentId(entity.getId())
                    .studentName(entity.getName())
                    .parentName(entity.getParentName())
                    .studentMajor(entity.getMajor())
                    .studentPhoneNumber(entity.getPhoneNumber())
                    .gender(entity.getGender())
                    .build();
            return dto;
        }

        public  static List<StudentDTO> convrToDTO(List<Student> entityList){
            List<StudentDTO> dtos = new ArrayList<>();
            for (Student s: entityList){
                dtos.add(convrToDTO(s));
            }
            return dtos;
        }
    }




