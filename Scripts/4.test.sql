SELECT USER FROM DUAL;

SELECT DEPTNO, DEPTNAME, FLOOR FROM DEPARTMENT;

SELECT DEPTNO, DEPTNAME, FLOOR 
	FROM DEPARTMENT
	WHERE DEPTNO = 1;


UPDATE DEPARTMENT
	SET DEPTNAME = '마케팅', FLOOR = 20
	WHERE DEPTNO = 5;
	
DELETE FROM DEPARTMENT
WHERE DEPTNO = 6;	

SELECT EMPNO,EMPNAME,TITLE,MANAGER,SALARY,DNO FROM EMPLOYEE;
SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT;


