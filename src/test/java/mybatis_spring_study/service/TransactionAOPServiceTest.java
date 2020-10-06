package mybatis_spring_study.service;

import static org.junit.Assert.*;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/context-root.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransactionAOPServiceTest {
	private static final Log log = LogFactory.getLog(TransactionAOPServiceTest.class);
	
	@After
	public void tearDown() throws Exception {
	System.out.println();
	}
	
	@Autowired
	private TransactionAOPService service;
	
	
	@Test(expected = DuplicateKeyException.class)
	public void testATrRegister_Fail_Department() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(1, "인사", 10); // DuplicateKeyException
		Employee employee = new Employee(1006, "박규영", "과장", new Employee(4377), 4100000, department);
		
		service.trRegister(department, employee);
	}
	@Test(expected = DuplicateKeyException.class)
	public void testBTrRegister_Fail_Employee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(7, "인사", 10); // DuplicateKeyException
		Employee employee = new Employee(4377, "박규영", "과장", new Employee(4377), 4100000, department);
		
		service.trRegister(department, employee);
	}
	@Test
	public void testCTrRegister_Success() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(7, "인사", 10); // DuplicateKeyException
		Employee employee = new Employee(1006, "박규영", "과장", new Employee(4377), 4100000, department);
		
		service.trRegister(department, employee);
	}

	@Test(expected=RuntimeException.class)
	public void testDTrUnRegister_Fail_Department() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(100);// 정상삭제
		Employee employee = new Employee(1006);// RuntimeException -> rollback
		service.trUnRegister(department, employee);
	}
	@Test(expected=RuntimeException.class)
	public void testETrUnRegister_Fail_Employee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(100);// 정상삭제
		Employee employee = new Employee(9999);// RuntimeException -> rollback
		service.trUnRegister(department, employee);
	}
	@Test
	public void testFTrUnRegister_Success() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Department department = new Department(7);// 정상삭제
		Employee employee = new Employee(1006);
		service.trUnRegister(department, employee);
	}

}
