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
@Table(name="Projects")
public class Project
{

  private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_id")
	private Long projectId;
	
	@Column(name="title")
	private String title;
	
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable( name="project_employee", joinColumns= { @JoinColumn(name="project_id") }, inverseJoinColumns= { @JoinColumn( name="employee_id") })
	private Set<Employee> employees=new HashSet<Employee>();
	
}
