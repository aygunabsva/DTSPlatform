package com.example.dtsplatform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    // Ownership & Legal Structure
    private String companyType;
    private Double localOwnership;
    private String shareholders;

    // Industry & Business Operations
    private String industrySector;
    private String mainProducts;
    private Boolean isExportActive;
    private Double exportRatio;
    private String keyExportMarkets;

    // Company Size
    private String employeeCount;
    private String annualTurnover;

    // Digital Readiness & Transformation Needs
    private String digitalizationLevel;
    private String existingDigitalTools;

    @ElementCollection
    private List<String> digitalChallenges; // Checkbox-lar
    private String digitalGoals;

    // Leadership & Commitment
    private Boolean hasDigitalLeader;
    private Boolean hasDigitalStrategy;
    private Boolean executivesCommitted;

    // Funding & Financial Support Needs
    private Boolean requiresFinancialAssistance;
    private Double estimatedBudget;

    // Additional Supporting Documents
    private String registrationCertificate;
    private String financialStatements;
    private String digitalTransformationPlans;

    // Declaration & Consent
    private Boolean confirmAccuracy;
    private Boolean agreeToContact;

}
