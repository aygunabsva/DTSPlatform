package com.example.dtsplatform.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 1 - Company Information
    private String companyName;
    private String companyRegistrationNumber;
    private Integer yearOfEstablishment;
    private String companyAddress;
    private String cityRegion;
    private String website;
    private String primaryContactPerson;
    private String contactEmail;


}
