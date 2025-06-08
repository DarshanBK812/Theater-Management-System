package com.qsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.theatre_management_system.dto.Viewer;
import com.qsp.theatre_management_system.dto.Viewer;
import com.qsp.theatre_management_system.repo.ViewerRepo;

@Repository
public class ViewerDao {

	@Autowired
	ViewerRepo viewerRepo;

	public Viewer saveViewer(Viewer seat) {
		return viewerRepo.save(seat);
	}

	public Viewer fetchViewerById(int seatId) {
		Optional<Viewer> viewer = viewerRepo.findById(seatId);
		if(viewer.isEmpty()) {
			return null;
		} else {
			return viewer.get();
		}
	}

	public List<Viewer> fetchAllViewer() {
		return viewerRepo.findAll();
	}

	public Viewer deleteViewerById(int empId) {
		Viewer seat = viewerRepo.findById(empId).get();
		viewerRepo.delete(seat);
		return seat;
	}

	public Viewer updateViewerById(int oldSeatId, Viewer newViewer) {
		newViewer.setViewerId(oldSeatId);
		viewerRepo.save(newViewer);
		return newViewer;

	}

}
