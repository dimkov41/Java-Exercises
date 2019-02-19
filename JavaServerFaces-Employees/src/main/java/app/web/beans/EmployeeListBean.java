package app.web.beans;

import app.domain.models.views.EmployeListViewModel;
import app.domain.models.views.EmployeeAggregatingViewModel;
import app.service.EmployeeService;
import app.util.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class EmployeeListBean {
    private EmployeeService employeeService;
    private ModelMapper modelMapper;

    public EmployeeListBean() {
    }

    @Inject
    public EmployeeListBean(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    public List<EmployeListViewModel> getEmployees(){
        return
                Arrays.stream(
                        this.modelMapper.map(this.employeeService.findAll(), EmployeListViewModel[].class)
                )
                        .collect(Collectors.toList());
    }

    public EmployeeAggregatingViewModel getAggregatingModel(){
        BigDecimal[] salaries = this.getEmployees().stream().map(EmployeListViewModel::getSalary).toArray(BigDecimal[]::new);

        BigDecimal sum = Arrays.stream(salaries).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal avg = sum.divide(new BigDecimal(salaries.length));

        return new EmployeeAggregatingViewModel(sum,avg);
    }
}
