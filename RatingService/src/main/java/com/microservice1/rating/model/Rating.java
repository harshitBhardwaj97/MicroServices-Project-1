package com.microservice1.rating.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rating")
public class Rating {

	@Id
	private String id;
	
	@Column(name = "user_id",nullable = false)
	private String userId;
	
	@Column(name = "hotel_id",nullable = false)
	private String hotelId;
	
	private int rating;
	
	private String feedback;
}

