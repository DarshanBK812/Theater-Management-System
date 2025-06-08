package com.qsp.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.theatre_management_system.dao.ViewerDao;
import com.qsp.theatre_management_system.dto.Employee;
import com.qsp.theatre_management_system.dto.Viewer;
import com.qsp.theatre_management_system.exception.ViewerNotFound;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;
import com.qsp.theatre_management_system.dto.Viewer;

@Service
public class ViewerService {
	
	@Autowired
	ViewerDao viewerDao;
	@Autowired
	ResponseStructure<Viewer> responseStructure;
	
	@Autowired
	ResponseStructureForAll<Viewer> responseStructureForAll;
	

	public ResponseStructure<Viewer> saveViewer(Viewer viewer) {
		responseStructure.setMessage("Viewers saved successfully in the DB");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setData(viewerDao.saveViewer(viewer));
		return responseStructure;
	}

	public ResponseStructure<Viewer> fetchViewerById(int viewerId) {
		Viewer viewer = viewerDao.fetchViewerById(viewerId);
		if(viewer != null) {
			responseStructure.setMessage("Viewers fetched successfully from the DB");
			responseStructure.setStatuscode(HttpStatus.FOUND.value());
			responseStructure.setData(viewerDao.fetchViewerById(viewerId));
			return responseStructure;
		} else {
			throw new ViewerNotFound();
		}
	}

	public ResponseStructureForAll<Viewer> fetchAllViewer() {
		responseStructureForAll.setMessage("All the Viewers fetched successfully from the DB");
		responseStructureForAll.setStatuscode(HttpStatus.FOUND.value());
		responseStructureForAll.setAllData(viewerDao.fetchAllViewer());
		return responseStructureForAll;
	}

	public ResponseStructure<Viewer> deleteViewerById(int viewerId) {
		responseStructure.setMessage("Viewers deleted successfully from the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(viewerDao.deleteViewerById(viewerId));
		return responseStructure;
	}

	public ResponseStructure<Viewer> updateViewerById(int oldviewerId, Viewer newViewer) {
		responseStructure.setMessage("Viewers updated successfully in the DB");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setData(viewerDao.updateViewerById(oldviewerId, newViewer));
		return responseStructure;
	}



}
