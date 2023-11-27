package com.wgcode.springbootreactproject.repository;

import com.wgcode.springbootreactproject.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Students,Long> {

    Optional<Students> findByEmail(String emailExists);
}
