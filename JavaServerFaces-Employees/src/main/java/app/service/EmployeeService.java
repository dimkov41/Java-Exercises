package app.service;

import app.domain.models.service.EmployeeListServiceModel;
import app.domain.models.service.EmployeeRegisterServiceModel;

import java.util.List;

public interface EmployeeService {
    EmployeeRegisterServiceModel save(EmployeeRegisterServiceModel entity);

    List<EmployeeListServiceModel> findAll();

    boolean delete(String id);
}
