package com.attech.employeemanager.infra.adapters.employee.jpa.entity;

import com.attech.employeemanager.domain.employee.model.Employee;
import com.attech.employeemanager.infra.common.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name= "employee")
public class EmployeeEntity extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String jobTitle;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false, columnDefinition = "varchar(255) default '/default.jpg'")
    private String imageUrl;

    @Column(nullable = false, updatable = false)
    private String employeeCode;

    public Employee toModel() {
        return Employee.builder()
                .id(super.getId())
                .name(name)
                .employeeCode(employeeCode)
                .phone(phone)
                .email(email)
                .imageUrl(imageUrl)
                .jobTitle(jobTitle)
                .createdAt(super.getCreatedAt())
                .build();
    }

}
