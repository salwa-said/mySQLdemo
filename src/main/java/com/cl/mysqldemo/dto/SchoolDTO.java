package com.cl.mysqldemo.dto;

import com.cl.mysqldemo.entities.School;
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
public class SchoolDTO {
    private Long schoolId;
    private String schoolName;
    private String schoolLocation;

    public  static SchoolDTO convrToDTO(School entity){
        SchoolDTO dto=SchoolDTO.builder()
                .schoolId(entity.getId())
                .schoolName(entity.getName())
                .schoolLocation(entity.getLocation())
                .build();

        return dto;
    }

    public static List<SchoolDTO>convrToDTO(List<School> entityList){
        List<SchoolDTO> dtos = new ArrayList<>();
        for (School s: entityList){
            dtos.add(convrToDTO(s));
        }
        return dtos;
    }

}