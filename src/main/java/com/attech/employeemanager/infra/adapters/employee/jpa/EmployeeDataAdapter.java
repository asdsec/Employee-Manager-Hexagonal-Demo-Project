package com.attech.employeemanager.infra.adapters.employee.jpa;

import com.attech.employeemanager.domain.common.exception.DataNotFoundException;
import com.attech.employeemanager.domain.employee.model.Employee;
import com.attech.employeemanager.domain.employee.port.EmployeePort;
import com.attech.employeemanager.domain.employee.usecase.EmployeeCreate;
import com.attech.employeemanager.infra.adapters.employee.jpa.entity.EmployeeEntity;
import com.attech.employeemanager.infra.adapters.employee.jpa.repository.EmployeeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeDataAdapter implements EmployeePort {

    private final EmployeeJpaRepository employeeJpaRepository;

    @Override
    public Employee retrieve(Long id) {
        return employeeJpaRepository
                .findById(id)
                .map(EmployeeEntity::toModel)
                .orElseThrow(() -> new DataNotFoundException("employeemanager.employee.notFound"));
    }

    @Override
    public Employee create(EmployeeCreate employeeCreate) {
        var employeeEntity = new EmployeeEntity();
        employeeEntity.setEmployeeCode(employeeCreate.getEmployeeCode());
        employeeEntity.setCreatedAt(employeeCreate.getCreatedAt());
        employeeEntity.setName(employeeCreate.getName());
        employeeEntity.setEmail(employeeCreate.getEmail());
        employeeEntity.setPhone(employeeCreate.getPhone());
        employeeEntity.setImageUrl(employeeCreate.getImageUrl());
        employeeEntity.setJobTitle(employeeCreate.getJobTitle());
        return employeeJpaRepository.save(employeeEntity).toModel();
    }
}
