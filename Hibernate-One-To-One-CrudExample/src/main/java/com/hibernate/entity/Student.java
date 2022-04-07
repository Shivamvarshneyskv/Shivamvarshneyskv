package com.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name="student")
public class Student {

     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     @Column(name="id")
	private int id;
     
     @Column(name="firstName")
	private String firstName;
     
     @Column(name="lastName")
	private String lastName;
     
     @Column(name="email")
	private String email;
     
     @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private StudentDetails studentdetails;
     
     public Student(String firstName,String lastName,String email)
     {
    	 this.firstName=firstName;
    	 this.lastName=lastName;
    	 this.email=email;
    	 
     }
	
}
