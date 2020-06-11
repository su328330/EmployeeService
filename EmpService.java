package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.EmpRepository;
import org.springframework.data.domain.PageRequest;
import com.example.demo.model.Employee;


@Service
public class EmpService {
	
	@Autowired
	EmpRepository empRepository;
	
	public List<Employee> getAllEmployes()
	{
		return empRepository.findAll();
	}

	
	
	/*
	 * public List<Employee> getAllEmployesPageReq(int pageNumber, int pageSize) {
	 * return empRepository.findAll(new
	 * PageRequest(pageNumber,pageSize)).getContent(); }
	 */
	/*
	 * public List<Employee> getFirstNameOrderBy(String firstname){ return
	 * empRepository.findByFirstnameEndsWith(firstname);
	 * 
	 * }
	 */
	 
	/*
	 * public List<Employee> createEmp(Employee emp) {
	 * 
	 * return (List<Employee>) empRepository.save(emp); }
	 */
}
