package com.attech.employeemanager.infra.adapters.employee.rest.dto;

import com.attech.employeemanager.domain.employee.usecase.EmployeeCreate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreateRequest {

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String jobTitle;

    @NotNull
    private String phone;

    public EmployeeCreate toUseCase() {
        return EmployeeCreate.builder()
                .name(name)
                .email(email)
                .jobTitle(jobTitle)
                .phone(phone)
                .imageUrl("/default.jpg")
                .employeeCode(UUID.randomUUID().toString())
                .build();
    }
}
