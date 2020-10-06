package mybatis_spring_study.mapper;

import static org.junit.Assert.fail;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;

import mybatis_spring_study.dto.Department;
import mybatis_spring_study.dto.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/context-root.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeMapperTest {
	protected static final Log log = LogFactory.getLog(EmployeeMapperTest.class);

	@After
	public void tearDow() throws Exception{
		System.out.println();
	}
	
	@Autowired
	private EmployeeMapper mapper;

	@Test
	public void test02InsertEmployee() {
		  log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		  Employee emp = new Employee(1004, "이유영", "인턴", new Employee(1003), 5000000, new Department(1));
		  int res = mapper.insertEmployee(emp);
		  Assert.assertEquals(1, res);
	}

	@Test
	public void test05DeleteEmployee() {
		  log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		  Employee emp = new Employee(1004, "이현석", "인턴", new Employee(1003), 5000000, new Department(3));
		  int res = mapper.deleteEmployee(emp);
		  Assert.assertEquals(1, res);
	}

	@Test
	public void test03UpdateEmployee() {
		  log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		  Employee emp = new Employee(1004, "이현석", "인턴", new Employee(1003), 5000000, new Department(3));
		  int res = mapper.updateEmployee(emp);
		  Assert.assertEquals(1, res);
	}

	@Test
	public void test01SelectEmployeeByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Employee> list = mapper.selectEmployeeByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test04SelectEmployeeByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Employee emp = mapper.selectEmployeeByNo(new Employee(3011));
		Assert.assertNotNull(emp);
		log.debug(emp.toString());
	}

}
