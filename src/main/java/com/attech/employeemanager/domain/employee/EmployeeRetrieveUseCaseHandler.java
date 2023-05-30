package com.attech.employeemanager.domain.employee;

import com.attech.employeemanager.domain.common.DomainComponent;
import com.attech.employeemanager.domain.common.usecase.UseCaseHandler;
import com.attech.employeemanager.domain.employee.model.Employee;
import com.attech.employeemanager.domain.employee.port.EmployeePort;
import com.attech.employeemanager.domain.employee.usecase.EmployeeRetrieve;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DomainComponent
@RequiredArgsConstructor
public class EmployeeRetrieveUseCaseHandler implements UseCaseHandler<Employee, EmployeeRetrieve> {

    private final EmployeePort employeePort;

    @Override
    public Employee handle(EmployeeRetrieve useCase) {
        return employeePort.retrieve(useCase.getId());
    }
}
