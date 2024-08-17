package com.zikan.employee_service.repository;

import com.zikan.employee_service.model.Employee;
import com.zikan.employee_service.response.EmployeeResponse;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    EmployeeResponse getEmployeeById(int id);
}
