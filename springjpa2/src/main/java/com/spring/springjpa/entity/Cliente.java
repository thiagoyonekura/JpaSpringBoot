package com.spring.springjpa.entity;

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
public class Cliente {
	 @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;
	  private String name;
	  private String email;
	  
	
	
	
		
	
}
