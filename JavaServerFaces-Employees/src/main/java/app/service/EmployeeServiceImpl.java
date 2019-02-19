package app.service;

import app.domain.entities.Employee;
import app.domain.models.service.EmployeeListServiceModel;
import app.domain.models.service.EmployeeRegisterServiceModel;
import app.repository.EmployeeRepostory;
import app.util.ModelMapper;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepostory employeeRepostory;
    private ModelMapper modelMapper;

    @Inject
    public EmployeeServiceImpl(EmployeeRepostory employeeRepostory, ModelMapper modelMapper) {
        this.employeeRepostory = employeeRepostory;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeRegisterServiceModel save(EmployeeRegisterServiceModel entity) {
        this.employeeRepostory.save(this.modelMapper.map(entity,Employee.class));

        return entity;
    }

    @Override
    public List<EmployeeListServiceModel> findAll(){
        return Arrays.stream(
                this.modelMapper.map(this.employeeRepostory.findAll(), EmployeeListServiceModel[].class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean delete(String id) {
        return this.employeeRepostory.delete(id);
    }
}
