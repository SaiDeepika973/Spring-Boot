package com.sathya.orm.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.orm.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

}
