package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Sort;

import com.example.demo.service.EmpService;
import com.example.demo.model.*;
import com.example.demo.repository.EmpRepository;
import io.swagger.annotations.ApiOperation;

@RestController
public class DemoController {

	@Autowired
	EmpService empService;

	@Autowired
	EmpRepository empRepository;

	// Getting all employees
	
	  @ApiOperation("Get All Empolyees")
	  
	  @GetMapping("/employees") public ResponseEntity<List<Employee>>
	  getAllEmployes() { List<Employee> empList = null; empList =
	  empService.getAllEmployes(); return ResponseEntity.ok(empList); }
	 
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> retrieveEmployee (@RequestBody Employee emp) {
			return ResponseEntity.ok(empRepository.save(emp));
	}
	
	@ApiOperation("Add new Empolyees")
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
	return ResponseEntity.ok(empRepository.save(emp));
	}
		
	
	@ApiOperation("Update Empolyee")
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee>  updateEmployee(@RequestBody Employee emp) {
	return ResponseEntity.ok(empRepository.save(emp));
	}

	@ApiOperation("Delete Empolyee")
	@DeleteMapping("/employees/{id}") 
	ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) { 
	empRepository.deleteById(id);
	return ResponseEntity.ok("Record deleted successfully"); }
	 
	
/*
 * @ApiOperation("Get All Empolyees By Order")
 * 
 * @GetMapping("/employees") public ResponseEntity<List<Employee>>
 * getEmployeesByOrder() { List<Employee> empList =
 * empRepository.findAll(Sort.by(Sort.Direction.ASC, "name")); return
 * ResponseEntity.ok(empList); }
 */
	
	//List<Passenger> findByLastName(String lastName, Sort sort);
	
	/*
	 * @ApiOperation("Get All Empolyees using PageRequest")
	 * 
	 * @GetMapping("/employees") public ResponseEntity<List<Employee>>
	 * getAllEmployesPageReq() { List<Employee> empList = null; empList =
	 * empService.getAllEmployesPageReq(1,10); return ResponseEntity.ok(empList); }
	 */
	
	@ApiOperation("Get First Name of Employee")
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> employeeExpBelow5(){
		return ResponseEntity.ok(empRepository.findByExp());		
	}
	
	@ApiOperation("Get First Name of Employee")
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getfindByExp10(){
		return ResponseEntity.ok(empRepository.findByExp10());		
	}
	
	@ApiOperation("Get First Name of Employee")
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getfindByExpBetween(){
		return ResponseEntity.ok(empRepository.findByExpBetween());		
	}
	
	
}
