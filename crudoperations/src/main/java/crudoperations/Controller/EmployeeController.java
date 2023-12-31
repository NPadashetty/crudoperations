package crudoperations.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudoperations.Model.Employee;
import com.crudoperations.Repository.Employeerepository;
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)


public class EmployeeController {
	
 @Autowired
private Employeerepository employeeRepository;

   

		// get all employeee

		@GetMapping("/employee")
		public List<Employee> getAllEmployee() {
			return employeeRepository.findAll();

		}
		// create employee rest api
		@PostMapping("/employee")
		public Employee createEmployee(@RequestBody Employee employee) {
			return employeeRepository.save(employee);
		}

		// get employee by id rest api
	    
@GetMapping("/employee/{id}")
		public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
			Employee employee = employeeRepository.getById(id);
			return ResponseEntity.ok(employee);

		}
		// update employee rest api
		@PutMapping("/employee/{id}")
		public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
			Employee employee = employeeRepository.getById(id);
			employee.setFirstName(employeeDetails.getFirstName());
			employee.setLastName(employeeDetails.getLastName());
			employee.setEmailId(employeeDetails.getEmailId());
			Employee updateEmployee = employeeRepository.save(employee);
			return ResponseEntity.ok(updateEmployee);
		}

		// delete employee rest api
		@DeleteMapping("/employee/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
			Employee employee = employeeRepository.getById(id);
			employeeRepository.delete(employee);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}


}
