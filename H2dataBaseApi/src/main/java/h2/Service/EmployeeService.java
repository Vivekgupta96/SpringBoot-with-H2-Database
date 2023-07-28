package h2.Service;

import java.util.List;

import h2.Model.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long id);

	Employee createEmployee(Employee employee);

	Employee updateEmployee(Long id, Employee updatedEmployee);

	void deleteEmployeeById(Long id);

}
