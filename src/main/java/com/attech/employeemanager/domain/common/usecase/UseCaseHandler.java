package com.attech.employeemanager.domain.common.usecase;

import com.attech.employeemanager.domain.common.model.UseCase;

public interface UseCaseHandler<E, T extends UseCase> {
    E handle(T useCase);
}
