package com.sathya.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.rest.entity.Hospital;
import com.sathya.rest.model.HospitalDetails;
import com.sathya.rest.service.HospitalService;


import java.util.List;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {
	
	@Autowired
	HospitalService hospitalService;
	
	@PostMapping("/save")
	public Hospital createHospital(@RequestBody HospitalDetails hospitalDetails) 
	{
		return hospitalService.createHospital(hospitalDetails);
	}
	
	@GetMapping("/{id}")
	public Hospital getHospital(@PathVariable int id)
	{
		return hospitalService.getHospital(id);
	}
	
	@GetMapping("/getall")
	public List<Hospital> getHospitals()
	{
		return hospitalService.getHospitals();
	
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable long id)
	{
		hospitalService.deleteById(id);
	}
	
	@PostMapping("/saveall")
	public List<Hospital> createHospitals(@RequestBody List<HospitalDetails> hospitals)
	{
		return hospitalService.createHospitals(hospitals);
	}
	
	@PutMapping("/{id}")
	public Hospital updateHospital(@PathVariable long id, @RequestBody HospitalDetails hospitalDetails)
	{
		return hospitalService.updateHospital(id, hospitalDetails);
	}
	
	@PatchMapping("/{id}")
	public Hospital updateHospitalField(@PathVariable long id, @RequestBody HospitalDetails hospitalDetails)
	{
		return hospitalService.updateHospital(id, hospitalDetails);
	}
	

}
