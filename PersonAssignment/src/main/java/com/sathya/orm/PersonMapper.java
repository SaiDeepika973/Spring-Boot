package com.sathya.orm;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sathya.orm.entity.PersonDetails;
import com.sathya.orm.model.Person;

@Component
public class PersonMapper {
	
	//This method taking model class as input and return entity class as output
	
		public Person modelToEntityConversion(PersonDetails personDetails)
		{
			Person person = new Person();
			person.setId(personDetails.getId());
			person.setFirstName(personDetails.getFirstName());
			person.setLastName(personDetails.getLastName());
			person.setEmail(personDetails.getEmail());
			person.setAge(personDetails.getAge());
			person.setCreatedBy(System.getProperty("user.name"));
			person.setCreatedAt(LocalDateTime.now());
			
			return person;
		}
		
		public List<Person> modelListToEntityConversion(List<PersonDetails> personDetails)
		{
			List<Person> personlist = new ArrayList<Person>();
			
			for(PersonDetails persondetail : personDetails)
			{
				Person person = new Person();
				person.setId(persondetail.getId());
				person.setFirstName(persondetail.getFirstName());
				person.setLastName(persondetail.getLastName());
				person.setEmail(persondetail.getEmail());
				person.setAge(persondetail.getAge());
				person.setCreatedBy(System.getProperty("user.name"));
				person.setCreatedAt(LocalDateTime.now());
				
				personlist.add(person);
			}
			return personlist;
		}

}
