package app.web.beans;


import app.service.EmployeeService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class EmployeeRemoveBean {
    private EmployeeService employeeService;

    public EmployeeRemoveBean() {
    }

    @Inject
    public EmployeeRemoveBean(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void remove(String id) throws IOException {
        this.employeeService.delete(id);

        FacesContext.getCurrentInstance().getExternalContext().redirect("/");
    }
}
