package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Departement;



public interface IDepartementService {
	
	public Departement addDepartement(Departement departement);
	public int deleteDepartement(int id);
	public Departement updateDepartement(int deptid, String deptName);
	public Departement getDepartement(int id);


}
