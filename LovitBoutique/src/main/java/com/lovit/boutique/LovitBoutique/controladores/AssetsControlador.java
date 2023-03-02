package com.lovit.boutique.LovitBoutique.controladores;

import com.lovit.boutique.LovitBoutique.servicio.AlmacenServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assets")
public class AssetsControlador {

	@Autowired
	private AlmacenServicioImpl servicio;

	//EL .+ ES PARA INDICAR LA EXTENSION PNG JPG ETC
	@GetMapping("/{filename:.+}")
	public Resource obtenerRecurso(@PathVariable("filename") String filename) {
		return servicio.cargarComoRecurso(filename);
	}
	
}
