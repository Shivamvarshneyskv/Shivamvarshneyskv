package com.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable( name="employees_Projects", joinColumns= { @JoinColumn(name="employee_id") }, inverseJoinColumns= { @JoinColumn( name="project_id") })
	Set<Project> Projects=new HashSet<Project>();

	public Employee(String firstName, String lastName, Set<Project> projects) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Projects = projects;
	}
	
	

	
	

}
