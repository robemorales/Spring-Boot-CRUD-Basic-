package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Persona;

public interface IPersona extends CrudRepository<Persona, Integer> {
	

}
