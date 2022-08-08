/*
 * Autor: Carlos Basaez
 * Fecha: 02/08/2022
 */
package com.gestion.juegos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.juegos.repositorio.JuegoRepositorio;
import com.gestion.juegos.excepciones.ResourceNotFoundException;
import com.gestion.juegos.modelo.Juego;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins  = "http://localhost:4200")
public class JuegoControlador {

	@Autowired
	private JuegoRepositorio repositorio;
	
	//este metodo sirve para listar todos los juegos
	@GetMapping("/juegos")
	public List<Juego> ListarTodosLosJuegos(){
		return repositorio.findAll();
	}
	
	//este metodo nos guarda un juego nuevo
	@PostMapping("/juegos")
	public Juego guardarjuego(@RequestBody Juego juego) {
		return repositorio.save(juego);
	}
	
	//este metodo nos permite buscar juegos por id
	@GetMapping("/juegos/{id}")
	public ResponseEntity<Juego> ObtenerJuegoPorId(@PathVariable Long id){
		Juego juego = repositorio.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("no existe juego con id: " + id));
		return ResponseEntity.ok(juego);
	}
	
	//metodo para actualizar juego
	@PutMapping("/juegos/{id}")
	public ResponseEntity<Juego> ActualizarJuego(@PathVariable Long id, @RequestBody Juego detalleJuego){
		Juego juego = repositorio.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("no existe juego con id: " + id));
		juego.setNombre_juego(detalleJuego.getNombre_juego());
		juego.setPlataforma(detalleJuego.getPlataforma());
		juego.setTipo_juego(detalleJuego.getTipo_juego());
		juego.setCalificacion(detalleJuego.getCalificacion());
		
		Juego juegoActualizado = repositorio.save(juego);
		return ResponseEntity.ok(juegoActualizado);
	}
	
	//este metodo sirve para eliminar un juego
		@DeleteMapping("/juegos/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarJuego(@PathVariable Long id){
			Juego juego = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el juego con el ID : " + id));
			repositorio.delete(juego);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	
}
		}
