package com.cl.mysqldemo.dto;

import com.cl.mysqldemo.entities.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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

        @Positive
        private Long studentId;
        private Long schoolId;

        @NotBlank(message = "student name cannot be blank")
        @Size(min = 3, max = 20, message = "student name  has to be between 2 and 20 characters ")
        private String studentName;

        @NotBlank(message = "parent name cannot be blank")
        @Size(min = 3, max = 20, message = "parent name  has to be between 2 and 20 characters ")
        private String parentName;

        @NotBlank(message = "Student Major cannot be blank")
        @Size(min = 3, max = 20, message = "Student Major has to be between 2 and 20 characters ")
        private String studentMajor;

        @NotBlank(message = "student PhoneNumber cannot be blank")

        private String studentPhoneNumber;

        @NotBlank(message = "Gender cannot be blank")
        private String gender;


        public  static StudentDTO convertToDTO(Student entity){
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

        public  static List<StudentDTO> convertToDTO(List<Student> entityList){
            List<StudentDTO> dtos = new ArrayList<>();
            for (Student s: entityList){
                dtos.add(convertToDTO(s));
            }
            return dtos;
        }
    }




