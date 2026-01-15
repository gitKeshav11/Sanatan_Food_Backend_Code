package com.sanatan.request;

import java.time.LocalDateTime;
import java.util.List;

import com.sanatan.model.Address;
import com.sanatan.model.ContactInformation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRestaurantRequest {

	private Long id;
	private String name;
	private String description;
	private String cuisineType;
	private Address address;
	private ContactInformation contactInformation;
	private String openingHours;
	private List<String> images;
    private LocalDateTime registrationDate;
}
