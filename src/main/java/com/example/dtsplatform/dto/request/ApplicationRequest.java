package com.example.dtsplatform.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class ApplicationRequest {
    private String companyName;
    private String registrationNumber;
    private Integer yearEstablished;
    private String address;
    private String city;
    private String website;
    private String contactPerson;
    private String contactEmail;
    private String phoneNumber;

    private String companyType;
    private Double localOwnership;
    private String shareholders;

    private String industrySector;
    private String mainProducts;
    private Boolean isExportActive;
    private Double exportRatio;
    private String keyExportMarkets;

    private String employeeCount;
    private String annualTurnover;

    private String digitalizationLevel;
    private String existingDigitalTools;
    private List<String> digitalChallenges;
    private String digitalGoals;

    private Boolean hasDigitalLeader;
    private Boolean hasDigitalStrategy;
    private Boolean executivesCommitted;

    private Boolean requiresFinancialAssistance;
    private Double estimatedBudget;

    private String registrationCertificate;
    private String financialStatements;
    private String digitalTransformationPlans;

    private Boolean confirmAccuracy;
    private Boolean agreeToContact;
}
