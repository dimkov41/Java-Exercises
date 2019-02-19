package app.repository;

import app.domain.entities.Employee;

import java.util.List;

public interface EmployeeRepostory extends GenericRepository<Employee,Long> {
    boolean delete(String id);
}
