package com.example.demo.controlador;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.IpersonaService;
import com.example.demo.modelo.Persona;

@Controller
@RequestMapping
public class ControladorPersona {
	@Autowired
	private IpersonaService service;
	
	@GetMapping("/listar")
	public String Listar(Model model) {//le paso un modelo para poner los datos 
		List<Persona> persona = service.listar(); //pongo en la lista persona lo que vienen del servicio 
		model.addAttribute("persona", persona);//envio al formulario persona los datos de la lista de Personas
		return "index";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona", new Persona());//le paso al modelo la nueva persona
		return "insert";
	}
	/*
	 * IMPORTANTE cuando deseamos actualizar hacemos uso del mismo formulario para insertar 
	 * generalmente, para ello en otros framework necesitamos saber si se esta actualizando
	 * o eliminando y actuar en consecuencia, Spring Boot no necesita esta informacion por 
	 * defecto cuando le pasamos una ruta que no contiene un id el asume que lo queremos 
	 * insertar y en caso contrario carga los datos en los campos :D !!!:)
	 *  
	 * */
	@PostMapping("/save")
	public String save(Persona p , Model model) {
		service.save(p);
		return "redirect:/listar";
	}
	@GetMapping("/update/{id}")
	public String update(Model model, @PathVariable int id) {
		Optional<Persona> persona = service.listarid(id);
		model.addAttribute("persona", persona);
		return "insert";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
		
	}

}
