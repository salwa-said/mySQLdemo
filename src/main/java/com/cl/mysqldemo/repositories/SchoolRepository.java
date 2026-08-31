package com.cl.mysqldemo.repositories;

import com.cl.mysqldemo.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long>{

}
