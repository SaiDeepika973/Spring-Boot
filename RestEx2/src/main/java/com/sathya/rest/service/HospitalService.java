package com.sathya.rest.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.rest.entity.Hospital;
import com.sathya.rest.model.HospitalDetails;
import com.sathya.rest.repository.HospitalRepository;

@Service
public class HospitalService {
	
	@Autowired
	HospitalRepository hospitalRepository;
	
	public Hospital createHospital(HospitalDetails hospitalDetails)
	{
		//Reading the data from model class and set the data to entity class
		Hospital hospital = new Hospital();
		
		hospital.setName(hospitalDetails.getName());
		hospital.setLocation(hospitalDetails.getLocation());
		hospital.setRating(hospitalDetails.getRating());
		hospital.setCreatedAt(LocalDateTime.now());
		hospital.setCreatedBy(System.getProperty("user.name"));
		
		//save method create save the hospital in database return the hospital
		
		Hospital savedHospital = hospitalRepository.save(hospital);
		return savedHospital;
	}
	
	public Hospital getHospital(long id)
	{
		Optional<Hospital> hospital = hospitalRepository.findById(id);
		
		if(hospital.isPresent())
		{
			return hospital.get();
		}
		else
		{
			return null;
		}
	}
	
	public List<Hospital> getHospitals()
	{
		List<Hospital> hospitals = hospitalRepository.findAll();
		return hospitals;
	}
	
	public void deleteById(long id)
	{
		hospitalRepository.deleteById(id);
	}

	public List<Hospital> createHospitals(List<HospitalDetails> hospitalDetails)
	{
		List<Hospital> hospitals = new ArrayList<>();
		
		//Reading the data from model class and set to entity class
		for(HospitalDetails hdetails : hospitalDetails)
		{
			Hospital hospital = new Hospital();
			hospital.setName(hdetails.getName());
			hospital.setLocation(hdetails.getLocation());
			hospital.setRating(hdetails.getRating());
			hospital.setCreatedAt(LocalDateTime.now());
			hospital.setCreatedBy(System.getProperty("user.name"));
			
			hospitals.add(hospital);
		}
		return hospitalRepository.saveAll(hospitals);
	}
	
	public Hospital updateHospital(long id,HospitalDetails hospitalDetails)
	{
		Optional<Hospital> hospital = hospitalRepository.findById(id);
		
		if(hospital.isPresent())
		{
			Hospital updatedHospital = new Hospital();
			updatedHospital.setId(hospital.get().getId());
			updatedHospital.setName(hospitalDetails.getName());
			updatedHospital.setLocation(hospitalDetails.getLocation());
			updatedHospital.setRating(hospitalDetails.getRating());
			updatedHospital.setCreatedAt(LocalDateTime.now());
			updatedHospital.setCreatedBy(System.getProperty("user.name"));
			
			return hospitalRepository.save(updatedHospital);
			
		}
		else
		{
			return null;
		}
		
		
	}
}
