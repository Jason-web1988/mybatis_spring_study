package mybatis_spring_study.mapper;

import java.util.List;

import mybatis_spring_study.dto.Employee;

public interface EmployeeMapper {
	int insertEmployee(Employee employee);
	
	int deleteEmployee(Employee employee);
	
	int updateEmployee(Employee employee);
	
	List<Employee> selectEmployeeByAll();
	
	Employee selectEmployeeByNo(Employee employee);
}
