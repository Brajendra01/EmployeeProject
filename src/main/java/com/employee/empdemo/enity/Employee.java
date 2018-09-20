package com.employee.empdemo.enity;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.h2.util.New;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@Entity(name="Employee")  // entity as table name
//@Proxy(lazy=false)  // not a better idea, we will loose lazy loading concept always
public class Employee {

	
	@Id  // for primary key
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	//@EmbeddedId  // for embeded type , means for onbject type.
	//private LoginName empId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="sal")
	private Integer sal;
	
	@Column(name="joiningDate")
	// for input string, other wise may get format exception
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	// for only to save date otherwise by default it is TIMESTAMP, by default will save date and time.
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	
	
	@Embedded
	private Phone phone;
	
	// One to one mapping, where vehicle is an Entity and a separate table.
	
	@OneToOne(cascade=CascadeType.ALL,targetEntity=Vehicle.class)
	@JoinColumn(name="VEHICLE_VEHID")
	private Vehicle vehicle;
	
	
	// One to Many
	@OneToMany(cascade=CascadeType.ALL,targetEntity=Vehicle.class)
	private Collection<Vehicle> listVeh=new ArrayList<Vehicle>();
	
	
	// Set Collection Example
	/*@ElementCollection
	@JoinTable(name="EMP_ADDRESS",
	    joinColumns=@JoinColumn(name="EMP_ID")
	   ) //giving table name, its not mandatory, by default address table will have foriegn key which refer Employee id
	private Set<Address> addrSet=new HashSet<Address>();*/
	
	// List Collection Example
	@ElementCollection  //(fetch=FetchType.EAGER)
	@JoinTable(name="EMP_ADDRESS",
				joinColumns=@JoinColumn(name="EMP_ID")
			)
	
	// collectionId is hibernate annotation and we can use to create primary key for Address table,
	// 
	/*@GenericGenerator(name="sequence-gen",strategy="sequence")
	@CollectionId(columns={@Column(name="ADDRESS_ID")}, generator="sequence-gen", type=@Type(type="long"))
	*/
	private Collection<Address> listAddr= new ArrayList<Address>();
	
	/*@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="HOME_STREET")),
		@AttributeOverride(name="city", column=@Column(name="HOME_CITY")),
		@AttributeOverride(name="state",column=@Column(name="HOME_STATE")),
		@AttributeOverride(name="pincode",column=@Column(name="HOME_PINCODE"))
	})
	private Address homeAddress;
	
	// in both case table will not be created but diffrent column will be created as street for office address and HOME_STREET for home address.
	@Embedded
	private Address officeAddress;*/

	
	public Collection<Vehicle> getListVeh() {
		return listVeh;
	}
	public void setListVeh(Collection<Vehicle> listVeh) {
		this.listVeh = listVeh;
	}
	public Collection<Address> getListAddr() {
		return listAddr;
	}
	public void setListAddr(Collection<Address> listAddr) {
		this.listAddr = listAddr;
	}
	/*public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}*/
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSal() {
		return sal;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
	/*public Set<Address> getAddrSet() {
		return addrSet;
	}
	public void setAddrSet(Set<Address> addrSet) {
		this.addrSet = addrSet;
	}*/
	
}
