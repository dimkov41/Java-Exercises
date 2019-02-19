package app.web.beans;

import app.domain.models.binding.EmployeeRegisterBindingModel;
import app.domain.models.service.EmployeeRegisterServiceModel;
import app.service.EmployeeService;
import app.util.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class EmployeeRegisterBean {
    private EmployeeRegisterBindingModel employeeRegisterBindingModel;

    private EmployeeService employeeService;
    private ModelMapper modelMapper;

    public EmployeeRegisterBean() {
    }

    @Inject
    public EmployeeRegisterBean(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeRegisterBindingModel = new EmployeeRegisterBindingModel();
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    public EmployeeRegisterBindingModel getEmployeeRegisterBindingModel() {
        return employeeRegisterBindingModel;
    }

    public void register() throws IOException {
        this.employeeService.save(
                this.modelMapper.map(employeeRegisterBindingModel,EmployeeRegisterServiceModel.class)
        );

        FacesContext.getCurrentInstance().getExternalContext().redirect("/");
    }


}
