package mybatis_spring_study.service;

import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;

public interface TransactionAOPService {
	void trRegister(Department department, Employee employee);
	
	void trUnRegister(Department department, Employee employee);
}
