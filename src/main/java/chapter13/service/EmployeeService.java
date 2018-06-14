package chapter13.service;

import chapter13.domain.Employee;

public interface EmployeeService {

    Employee getHighestPaidEmployee(int employeeCategory);
	
}
