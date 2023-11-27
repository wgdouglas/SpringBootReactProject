package com.wgcode.springbootreactproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Entity
@Setter
@Getter
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id; // primary key
    private String firstName;
    private String lastName;
    @NaturalId(mutable = true) // makes you field unique & non-modifiable if set as false
    private String email;
    private String department;

    public void setId(Long id) {
        this.id = id;
    }
}
