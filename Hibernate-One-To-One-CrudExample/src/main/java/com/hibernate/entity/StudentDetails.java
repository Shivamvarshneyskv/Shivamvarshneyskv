package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="student_details")
public class StudentDetails 
 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
   private int id;
	
	@Column(name="hobby")
   private String hobby;
	
	@Column(name="youtubeChannel")
   private String youtubeChannel;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Student_id")
   private Student student;
   
   public StudentDetails(String hobby, String youtubeChannel) {
		super();
		this.hobby = hobby;
		this.youtubeChannel = youtubeChannel;
	}
   
 }
