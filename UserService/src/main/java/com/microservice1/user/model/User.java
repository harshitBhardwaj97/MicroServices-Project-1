package com.microservice1.user.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	@Id
	private String userId;
	
	@Column(length = 30,nullable = false)
	private String name;
	
	private String email;
	
	private String about;
	
	@Transient
	private List<Rating> ratings = new ArrayList<>();
}
