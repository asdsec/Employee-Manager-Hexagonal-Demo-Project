package com.attech.employeemanager.domain.employee.usecase;

import com.attech.employeemanager.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeRetrieve implements UseCase {
    private Long id;
}
