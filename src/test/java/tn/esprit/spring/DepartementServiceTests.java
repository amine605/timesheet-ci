package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartementService;

@SpringBootTest
class DepartementServiceTests {


	@Autowired
	IDepartementService ds;

	@Test
	public void testAddDepartement() {
		Departement dept = new Departement("IT");
		Departement savedDept = ds.addDepartement(dept);
		assert savedDept.getName() == dept.getName();
	}
	
	@Test
	public void testUpdateDepartement()  {
		Departement dept = new Departement("IT");
		Departement savedDept = ds.addDepartement(dept);
		Departement updatedDept = ds.updateDepartement(savedDept.getId(),"IT2");
		assert updatedDept.getName() == "IT2";
	}
	
	@Test
	public void testgetDepartement() {
		Departement dept = new Departement("IT");
		Departement savedDept = ds.addDepartement(dept);
		Departement fetchedDept = ds.getDepartement(savedDept.getId());
		assert fetchedDept.getName().equals("IT");
		
	}
	
	@Test
	public void testDeleteDepartement() {
		Departement dept = new Departement("IT");
		Departement savedDept = ds.addDepartement(dept);
		int deletedDeptId = ds.deleteDepartement(savedDept.getId());
		Departement fetchedDept = ds.getDepartement(deletedDeptId);
		assert fetchedDept == null;
	}

}
