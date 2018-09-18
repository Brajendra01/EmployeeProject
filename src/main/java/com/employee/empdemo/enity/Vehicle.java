package com.employee.empdemo.enity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// One to one mapping, employee has one vehicle or will come via one vehicle.
// its not ambedded, 
//its separate class and will have separate table, later will have one to one relation with employee table.

@Entity
public class Vehicle {
	
	@Id
	@GeneratedValue
	private int vehId;
	
	private String vehName;
	
	@ManyToOne    // all vehicle has owner
	private Employee  employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

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
