package com.example.dtsplatform.service.impl;

import com.example.dtsplatform.entity.Application;
import com.example.dtsplatform.repository.ApplicationRepository;
import com.example.dtsplatform.service.ApplicationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Transactional
    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public byte[] exportToExcel() throws IOException {
        List<Application> applications = applicationRepository.findAll();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Applications");

        Row headerRow = sheet.createRow(0);
        String[] columns = {"ID", "Company Name", "Company Registration Number", "Year of Establishment", "Company Address",
                "City/Region", "Website", "Primary Contact Person", "Contact Email", "Company Type", "Local Ownership",
                "Shareholders", "Industry Sector", "Main Products", "Is Export Active", "Export Ratio",
                "Key Export Markets", "Employee Count", "Annual Turnover", "Digitalization Level",
                "Existing Digital Tools", "Digital Challenges", "Digital Goals", "Has Digital Leader",
                "Has Digital Strategy", "Executives Committed", "Requires Financial Assistance",
                "Estimated Budget", "Registration Certificate", "Financial Statements",
                "Digital Transformation Plans", "Confirm Accuracy", "Agree To Contact"};

        for (int i = 0; i < columns.length; i++) {
            headerRow.createCell(i).setCellValue(columns[i]);
        }

        int rowNum = 1;
        for (Application app : applications) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(app.getId());
            row.createCell(1).setCellValue(app.getCompanyName());
            row.createCell(2).setCellValue(app.getCompanyRegistrationNumber());
            row.createCell(3).setCellValue(app.getYearOfEstablishment());
            row.createCell(4).setCellValue(app.getCompanyAddress());
            row.createCell(5).setCellValue(app.getCityRegion());
            row.createCell(6).setCellValue(app.getWebsite());
            row.createCell(7).setCellValue(app.getPrimaryContactPerson());
            row.createCell(8).setCellValue(app.getContactEmail());
            row.createCell(9).setCellValue(app.getCompanyType());
            row.createCell(10).setCellValue(app.getLocalOwnership());
            row.createCell(11).setCellValue(app.getShareholders());
            row.createCell(12).setCellValue(app.getIndustrySector());
            row.createCell(13).setCellValue(app.getMainProducts());
            row.createCell(14).setCellValue(app.getIsExportActive());
            row.createCell(15).setCellValue(app.getExportRatio());
            row.createCell(16).setCellValue(app.getKeyExportMarkets());
            row.createCell(17).setCellValue(app.getEmployeeCount());
            row.createCell(18).setCellValue(app.getAnnualTurnover());
            row.createCell(19).setCellValue(app.getDigitalizationLevel());
            row.createCell(20).setCellValue(app.getExistingDigitalTools());
            row.createCell(21).setCellValue(String.join(", ", app.getDigitalChallenges()));
            row.createCell(22).setCellValue(app.getDigitalGoals());
            row.createCell(23).setCellValue(app.getHasDigitalLeader());
            row.createCell(24).setCellValue(app.getHasDigitalStrategy());
            row.createCell(25).setCellValue(app.getExecutivesCommitted());
            row.createCell(26).setCellValue(app.getRequiresFinancialAssistance());
            row.createCell(27).setCellValue(app.getEstimatedBudget());
            row.createCell(28).setCellValue(app.getRegistrationCertificate());
            row.createCell(29).setCellValue(app.getFinancialStatements());
            row.createCell(30).setCellValue(app.getDigitalTransformationPlans());
            row.createCell(31).setCellValue(app.getConfirmAccuracy());
            row.createCell(32).setCellValue(app.getAgreeToContact());
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        workbook.close();
        return out.toByteArray();
    }
}
