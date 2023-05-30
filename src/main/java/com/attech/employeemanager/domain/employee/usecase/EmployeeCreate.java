package com.attech.employeemanager.domain.employee.usecase;

import com.attech.employeemanager.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EmployeeCreate implements UseCase {
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private String employeeCode;
    private LocalDateTime createdAt;
}
