package com.sathya.orm;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sathya.orm.client.PersonRepository;
import com.sathya.orm.entity.PersonDetails;
import com.sathya.orm.model.Person;

@Component
public class PersonClient implements CommandLineRunner{
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	PersonMapper personMapper;

	@Override
	public void run(String... args) throws Exception {
		
		PersonDetails p1 = new PersonDetails();
		p1.setId(0);
		p1.setFirstName("Sai Deepika");
		p1.setLastName("Bhaskaruni");
		p1.setEmail("deepika.71419@gmail.com");
		p1.setAge(20);
		
		PersonDetails p2 = new PersonDetails();
		p2.setId(0);
		p2.setFirstName("Vani Keerthana");
		p2.setLastName("Danda");
		p2.setEmail("vaniKeerthana.1033@gmail.com");
		p2.setAge(21);
		
		PersonDetails p3 = new PersonDetails();
		p3.setId(0);
		p3.setFirstName("Gayathri");
		p3.setLastName("Taneeru");
		p3.setEmail("gaythriTaneeru.26101@gmail.com");
		p3.setAge(22);
		
		PersonDetails p4 = new PersonDetails();
		p4.setId(0);
		p4.setFirstName("Vyshnavi");
		p4.setLastName("Atmakuru");
		p4.setEmail("vyshuvyshnavi112@gmail.com");
		p4.setAge(22);
		
		PersonDetails p5 = new PersonDetails();
		p5.setId(0);
		p5.setFirstName("Anil Kumar");
		p5.setLastName("Munimadugula");
		p5.setEmail("anilkumar.9495@gmail.com");
		p5.setAge(28);
		
		//insert single record
		
		//conversion of persondetails to person
		Person person = personMapper.modelToEntityConversion(p1);
		
		personRepository.save(person);
		
		//inserting list of records
		
		//creating list of products
		List<PersonDetails> pdlist = List.of(p2,p3,p4,p5);
		
		//conversion of productdetails list to person list
		List<Person> plist = personMapper.modelListToEntityConversion(pdlist);
		
		personRepository.saveAll(plist);
		
		//search based on id
		Optional<Person> per = personRepository.findById(1);
		if(per.isPresent())
		{
			System.out.println(per);
		}
		else
		{
			System.out.println("No such record exists!");
		}
		
		//count the number of records
		Long count = personRepository.count();
		System.out.println("Number of records:"+count);
		
		//print all the records
		List<Person> list = personRepository.findAll();
		list.forEach(person1->System.out.println(person1));
		
		//check whether a record exists or not
		boolean exists = personRepository.existsById(2);
		System.out.println("Record exists or not:"+exists);
		
		//deleting based on id
		//personRepository.deleteById(1);
		
		//delete all records
		//personRepository.deleteAll();
	}
	
	

}
