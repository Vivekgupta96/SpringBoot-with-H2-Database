package h2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import h2.Model.Employee;
import h2.Repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		
		List<Employee> list= employeeRepository.findAll();
		if(list==null)throw new RuntimeException("Employee not found");
		return list;
	}

	public Employee getEmployeeById(Long id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		return optionalEmployee.orElse(null);
	}

	public Employee createEmployee(Employee employee) {
		if (employee == null)
			throw new RuntimeException("Employee can not be Null");
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee Not found"));

		existingEmployee.setFirstName(updatedEmployee.getFirstName());
		existingEmployee.setLastName(updatedEmployee.getLastName());
		existingEmployee.setEmail(updatedEmployee.getEmail());
		existingEmployee.setDesignation(updatedEmployee.getDesignation());
		existingEmployee.setSalary(updatedEmployee.getSalary());

		return employeeRepository.save(existingEmployee);

	}

	public void deleteEmployeeById(Long id) {
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee Not found"));
		employeeRepository.delete(existingEmployee);
	}
}
