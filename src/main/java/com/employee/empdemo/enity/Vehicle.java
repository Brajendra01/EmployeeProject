package com.employee.empdemo.enity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// One to one mapping, employee has one vehicle or will come via one vehicle.
// its not ambedded, 
//its separate class and will have separate table, later will have one to one relation with employee table.

@Entity
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy=InheritanceType.JOINED)
public class Vehicle {
	
	@Id
	@GeneratedValue
	private int vehId;
	
	private String vehName;
	
/*	@ManyToOne(cascade=CascadeType.ALL)    // all vehicle has owner
	@JoinColumn(name="ID")
	private Employee  employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}*/

	public String getVehName() {
		return vehName;
	}

	public void setVehName(String vehName) {
		this.vehName = vehName;
	}

	public int getVehId() {
		return vehId;
	}

	public void setVehId(int vehId) {
		this.vehId = vehId;
	}
	
	

}
