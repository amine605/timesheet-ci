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
		Departement savedDept = ds.updateDepartement(0,"IT2");
		if(savedDept != null)  {			
			assert savedDept.getName() == "IT2";
		}
	}
	
	@Test
	public void testgetDepartement() {
		 
		Departement savedDept = ds.getDepartement(0);
		if(savedDept != null) {
			assert savedDept.getId() == 1;
		}
	}
	
	@Test
	public void testDeleteDepartement() {
		int deletedDeptId = ds.deleteDepartement(1);
		Departement dept = ds.getDepartement(deletedDeptId);
		assert dept == null;
	}

}
