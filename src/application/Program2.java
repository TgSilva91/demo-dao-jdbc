package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== Test 1: department insert ====");
		Department newDepartment = new Department(null, "D2");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		
		System.out.println();
		System.out.println("==== Test 2: department findById ====");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println();
		System.out.println("==== Test 3: department findAll ====");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for(Department d : list) {
			System.out.println(d);
		}
		
		System.out.println();
		System.out.println("==== Test 4: department update ====");
		dep = departmentDao.findById(6);
		dep.setName("Music");
		departmentDao.update(dep);
		
		System.out.println();
		System.out.println("==== Test 5: department delete ====");
		System.out.print("Enter id for delect test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Department deleted");
		
		sc.close();
	}

}
