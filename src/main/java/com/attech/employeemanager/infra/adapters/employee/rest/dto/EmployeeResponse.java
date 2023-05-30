package com.attech.employeemanager.infra.adapters.employee.rest.dto;

import com.attech.employeemanager.domain.employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private String employeeCode;
    private LocalDateTime createdAt;

    public static EmployeeResponse from(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .jobTitle(employee.getJobTitle())
                .phone(employee.getPhone())
                .imageUrl(employee.getImageUrl())
                .employeeCode(employee.getEmployeeCode())
                .createdAt(employee.getCreatedAt())
                .build();
    }
}
