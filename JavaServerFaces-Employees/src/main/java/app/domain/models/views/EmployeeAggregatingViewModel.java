package app.domain.models.views;

import java.math.BigDecimal;

public class EmployeeAggregatingViewModel {
    private BigDecimal totalSalary;
    private BigDecimal avgSalary;

    public EmployeeAggregatingViewModel(BigDecimal totalSalary, BigDecimal avgSalary) {
        this.totalSalary = totalSalary;
        this.avgSalary = avgSalary;
    }

    public BigDecimal getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(BigDecimal totalSalary) {
        this.totalSalary = totalSalary;
    }

    public BigDecimal getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(BigDecimal avgSalary) {
        this.avgSalary = avgSalary;
    }
}
