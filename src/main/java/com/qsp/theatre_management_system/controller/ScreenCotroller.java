package com.qsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.theatre_management_system.dao.ScreenDao;
import com.qsp.theatre_management_system.dto.Screen;
import com.qsp.theatre_management_system.service.ScreenService;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@RestController
public class ScreenCotroller {

	@Autowired
	ScreenService screenService;

	@PostMapping("/saveScreen")
	public ResponseStructure<Screen> saveScreen(@RequestBody Screen screen) {
		return screenService.saveScreen(screen);
	}

	@GetMapping("/fetchScreenById")
	public ResponseStructure<Screen> fetchScreenById(@RequestParam int screenId) {
		return screenService.fetchScreenById(screenId);
	}

	@GetMapping("/fetchAllScreen")
	public ResponseStructureForAll<Screen> fetchAllScreen() {
		return screenService.fetchAllScreen();
	}

	@DeleteMapping("/deleteScreenById")
	public ResponseStructure<Screen> deleteScreenById(@RequestParam int screenId) {
		return screenService.deleteScreenById(screenId);
	}

	@PutMapping("/updateScreenById")
	public ResponseStructure<Screen> updateScreenById(@RequestParam int oldScreenId, Screen screen) {
		return screenService.updateScreenById(oldScreenId, screen);
	}
	
	@PutMapping("/addExistsingScreenToExistsingMovie")
	public ResponseStructure<Screen> addExistsingScreenToExistsingMovie(@RequestParam int screenId ,@RequestParam int movieId) {
		return screenService.addExistsingScreenToExistsingMovie(screenId, movieId);
	}

}
