package com.qsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.theatre_management_system.dto.Movie;
import com.qsp.theatre_management_system.dto.Screen;
import com.qsp.theatre_management_system.repo.MovieRepo;
import com.qsp.theatre_management_system.repo.ScreenRepo;

@Repository
public class ScreenDao {

	@Autowired
	ScreenRepo screenRepo;
	
	@Autowired
	MovieRepo movieRepo;

	public Screen saveScreen(Screen screen) {
		return screenRepo.save(screen);
	}

	public Screen fetchScreenById(int screenId) {
		Optional<Screen> screen = screenRepo.findById(screenId);
		if (screen.isEmpty()) {
			return null;

		} else
			return screen.get();
	}

	public List<Screen> fetchAllScreen() {
		return screenRepo.findAll();
	}

	public Screen deleteScreenById(int screenId) {
		Screen screen = screenRepo.findById(screenId).get();
		screenRepo.delete(screen);
		return screen;
	}

	public Screen updateScreenById(int oldScreenId, Screen screen) {
		screen.setScreenId(oldScreenId);
		screenRepo.save(screen);
		return screen;
	}
	
	public Screen addExistsingScreenToExistsingMovie(int screenId , int movieId) {
		Screen screen = fetchScreenById(screenId);
		Movie movie = movieRepo.findById(movieId).get();
		screen.setMovie(movie);
		return saveScreen(screen);
	}

}
