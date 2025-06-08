package com.qsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.theatre_management_system.dao.ScreenDao;
import com.qsp.theatre_management_system.dto.Employee;
import com.qsp.theatre_management_system.dto.Screen;
import com.qsp.theatre_management_system.exception.ScreenNotFound;
import com.qsp.theatre_management_system.repo.ScreenRepo;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@Service
public class ScreenService {

	@Autowired
	ScreenDao screenDao;
	@Autowired
	ResponseStructure<Screen> responseStructure;
	
	@Autowired
	ResponseStructureForAll<Screen> responseStructureForAll;

	public ResponseStructure<Screen> saveScreen(Screen screen) {
		responseStructure.setMessage("Screen saved successfully in the DB");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(screenDao.saveScreen(screen));
		return responseStructure;
	}

	public ResponseStructure<Screen> fetchScreenById(int screenId) {
		Screen screen = screenDao.fetchScreenById(screenId);
		if(screen != null) {
			responseStructure.setMessage("Screen fetched successfully from the DB");
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setData(screenDao.fetchScreenById(screenId));
			return responseStructure;
		}
		else {
			throw new ScreenNotFound();
		}
	}

	public ResponseStructureForAll<Screen> fetchAllScreen() {
		responseStructureForAll.setMessage("All Screen fetched successfully from the DB");
		responseStructureForAll.setStatuscode(HttpStatus.FOUND.value());
		responseStructureForAll.setAllData(screenDao.fetchAllScreen());
		return responseStructureForAll;
	}

	public ResponseStructure<Screen> deleteScreenById(int screenId) {
		responseStructure.setMessage(" Screen deleted successfully from the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(screenDao.deleteScreenById(screenId));
		return responseStructure;
	}

	public ResponseStructure<Screen> updateScreenById(int oldScreenId, Screen screen) {
		responseStructure.setMessage("Screen updated succesfully in the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(screenDao.updateScreenById(oldScreenId, screen));
		return responseStructure;
	}
	
	public ResponseStructure<Screen> addExistsingScreenToExistsingMovie(int screenId , int movieId) {
		responseStructure.setMessage("Screen saved successfully to movie in the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(screenDao.addExistsingScreenToExistsingMovie(screenId, movieId));
		return responseStructure;
	}


}
