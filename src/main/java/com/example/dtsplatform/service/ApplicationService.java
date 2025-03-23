package com.example.dtsplatform.service;

import com.example.dtsplatform.entity.Application;

import java.io.IOException;
import java.util.List;

public interface ApplicationService {
    List<Application> getAllApplications();

    Application saveApplication(Application application);

    void deleteApplication(Long id);

    byte[] exportToExcel() throws IOException;

}
