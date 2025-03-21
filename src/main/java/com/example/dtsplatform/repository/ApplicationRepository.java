package com.example.dtsplatform.repository;

import com.example.dtsplatform.entity.Application;
import com.example.dtsplatform.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
