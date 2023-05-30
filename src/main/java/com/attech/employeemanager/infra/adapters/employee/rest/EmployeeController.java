package com.attech.employeemanager.infra.adapters.employee.rest;

import com.attech.employeemanager.domain.common.usecase.UseCaseHandler;
import com.attech.employeemanager.domain.employee.model.Employee;
import com.attech.employeemanager.domain.employee.usecase.EmployeeCreate;
import com.attech.employeemanager.domain.employee.usecase.EmployeeRetrieve;
import com.attech.employeemanager.infra.adapters.employee.rest.dto.EmployeeCreateRequest;
import com.attech.employeemanager.infra.adapters.employee.rest.dto.EmployeeResponse;
import com.attech.employeemanager.infra.common.rest.BaseController;
import com.attech.employeemanager.infra.common.rest.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController extends BaseController {

    private final UseCaseHandler<Employee, EmployeeCreate> employeeCreateUseCaseHandler;
    private final UseCaseHandler<Employee, EmployeeRetrieve> employeeEmployeeRetrieveUseCaseHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Response<EmployeeResponse> createEmployee(@Valid @RequestBody EmployeeCreateRequest employeeCreateRequest) {
        var employee = employeeCreateUseCaseHandler.handle(employeeCreateRequest.toUseCase());
        return respond(EmployeeResponse.from(employee));
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response<EmployeeResponse> retrieveEmployee(@PathVariable Long id) {
        var useCase = EmployeeRetrieve.builder().id(id).build();
        var employee = employeeEmployeeRetrieveUseCaseHandler.handle(useCase);
        return respond(EmployeeResponse.from(employee));
    }

}
