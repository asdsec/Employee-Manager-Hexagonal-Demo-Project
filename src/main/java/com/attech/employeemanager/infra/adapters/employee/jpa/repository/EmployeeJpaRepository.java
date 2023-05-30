package com.attech.employeemanager.infra.adapters.employee.jpa.repository;

import com.attech.employeemanager.infra.adapters.employee.jpa.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, Long> {
}
