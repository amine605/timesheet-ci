package tn.esprit.spring.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.MissionExterne;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {

	  private static final Logger logger = LogManager.getLogger(DepartementServiceImpl.class);  

	
	@Autowired
	DepartementRepository deptRepoistory;

	@Override
	public Departement addDepartement(Departement dept) {
		try {
			logger.info("Started Adding Departmenet");
			deptRepoistory.save(dept);
			logger.info("Departmenet Added");

			return dept;
		} catch (Exception ex) {
			logger.error(ex.getMessage());

			return null;
		}
	}

	@Override
	public Departement updateDepartement(int deptid, String deptName) {
		try {
			logger.info("Started updating Departmenet");

			Departement departement = deptRepoistory.findById(deptid).get();
			departement.setName(deptName);
			deptRepoistory.save(departement);
			logger.info(" Departemenet updated");

			return departement;
		} catch (Exception ex) {
			logger.error(ex.getMessage());

			return null;
		}
	}

	@Override
	public int deleteDepartement(int deptid) {
		try {
			logger.info("Started deleting Departmenet");

			Departement departement = deptRepoistory.findById(deptid).get();
			deptRepoistory.delete(departement);
			logger.info(" Departemenet deleted");

			return departement.getId();
		} catch (Exception ex) {
			logger.error(ex.getMessage());

			return 0;
		}
	}

	@Override
	public Departement getDepartement(int deptid) {
		try {
			logger.info("Get Departmenet by Id");

			Departement departement = deptRepoistory.findById(deptid).get();
			logger.info(" get department successful");

			return departement;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return null;
		}
	}

}
