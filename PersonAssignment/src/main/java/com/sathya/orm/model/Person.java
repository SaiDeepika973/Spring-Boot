package com.sathya.orm.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String firstName;
		private String lastName;
		private String email;
		private int age;
		
		@CreatedDate
		private LocalDateTime createdAt;
		
		@CreatedBy
		private String createdBy;
}
