package com.qsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.qsp.theatre_management_system.dto.Branch;
import com.qsp.theatre_management_system.dto.Owner;
import com.qsp.theatre_management_system.dto.Theater;
import com.qsp.theatre_management_system.dto.Viewer;
import com.qsp.theatre_management_system.repo.TheaterRepo;
import com.qsp.theatre_management_system.repo.ViewerRepo;

@Repository
public class TheaterDao {

	@Autowired
	TheaterRepo theaterRepo;

	@Autowired
	BranchDao branchDao;

	@Autowired
	ViewerDao viewerDao;

	public Theater saveTheater(Theater theater) {
		return theaterRepo.save(theater);
	}

	public Theater fetchTheaterById(int theaterId) {
		Optional<Theater> theater = theaterRepo.findById(theaterId);
		if (theater.isEmpty()) {
			return null;
		} else {
			return theater.get();
		}
	}

	public Theater updateOwnerById(int oldId, Theater newtheater) {

		newtheater.setTheaterId(oldId);
		theaterRepo.save(newtheater);
		return newtheater;

	}

	public List<Theater> fetchAllTheater() {
		return theaterRepo.findAll();

	}

	public Theater deleteTheaterById(int theaterId) {
		Theater theater = fetchTheaterById(theaterId);
		theaterRepo.delete(theater);
		return theater;
	}

	public Theater updateTheaterById(int oldTheaterId, Theater newTheater) {
		newTheater.setTheaterId(oldTheaterId);
		theaterRepo.save(newTheater);
		return newTheater;
	}

	public Theater addExistingBranchToExistingTheater(int branchId, int theaterId) {
		Theater theater = fetchTheaterById(theaterId);
		Branch branch = branchDao.fetchBranchById(branchId);
		List<Branch> list = theater.getBranch();
		list.add(branch);
		theater.setBranch(list);
		return theaterRepo.save(theater);
	}

	public Theater addNewBranchToExistedTheater(Branch newBranch, int theaterId) {
		Theater theater = fetchTheaterById(theaterId);
		List<Branch> list = theater.getBranch();
		list.add(newBranch);
		theater.setBranch(list);
		return saveTheater(theater);
	}

	public Theater addExistingViewrToExistingThater(int theaterId, int viwerId) {
		Theater theater = fetchTheaterById(theaterId);
		Viewer viewer = viewerDao.fetchViewerById(viwerId);
		List<Viewer> list = theater.getViewers();
		list.add(viewer);
		theater.setViewers(list);
		
		return saveTheater(theater);
	}

}
