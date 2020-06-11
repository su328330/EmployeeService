package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.domain.Pageable;

@Repository("employee")
public interface EmpRepository extends JpaRepository <Employee , Integer>{
	
	/*
	 * @Query(value =
	 * "select firstname from employee e where e.firstname like '%:name%' order by firstname"
	 * , nativeQuery= true) List<Employee> findByFirstnameEndsWith(@Param("name")
	 * String firstname);
	 */
	 
	@Query(value = "SELECT * FROM employee WHERE empexp < 5", nativeQuery = true)
	 List<Employee> findByExp();
	
	@Query(value = "SELECT * FROM employee WHERE empexp > 10", nativeQuery = true)
	 List<Employee> findByExp10();
	
	@Query(value = "SELECT * FROM employee WHERE empexp between (5,10)", nativeQuery = true)
	 List<Employee> findByExpBetween();
	
	//@Query(select first_name from employee e where e.empexp >)

}
