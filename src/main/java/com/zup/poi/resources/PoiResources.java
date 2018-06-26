package com.zup.poi.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zup.poi.models.Poi;
import com.zup.poi.repository.PoiRepository;

@RestController
@RequestMapping("/poi")
public class PoiResources {
	
	@Autowired
	private PoiRepository poiRepository;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody Iterable<Poi> listPois() {
		Iterable<Poi> listaPois = poiRepository.findAll();
		return listaPois;
	}
	
	@GetMapping(value="/{coordinatex}/{coordinatey}/{distancia}", produces = "application/json")
	public @ResponseBody List<String> listPoisByCoordinate(
			@PathVariable(value="coordinatex") long coordinatex,
			@PathVariable(value="coordinatey") long coordinatey,
			@PathVariable(value="distancia") long distancia) {
		List<String> listaPois = poiRepository.findAllByCoordinate(coordinatex, coordinatey, distancia);
		return listaPois;
	}
	
	@PostMapping()
	public Poi createPoi(@RequestBody @Valid Poi poi) {
		return poiRepository.save(poi);
	}
}
