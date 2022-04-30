package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.*;
@Service
public interface IpersonaService {
	public List<Persona>listar();
	public Optional<Persona>listarid(int id);
	public int save(Persona p);
	public void delete(int id);

}
