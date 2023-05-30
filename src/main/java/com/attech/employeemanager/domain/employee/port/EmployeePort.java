package com.attech.employeemanager.domain.employee.port;

import com.attech.employeemanager.domain.employee.model.Employee;
import com.attech.employeemanager.domain.employee.usecase.EmployeeCreate;

public interface EmployeePort {
    Employee retrieve(Long id);
    Employee create(EmployeeCreate employeeCreate);
}
