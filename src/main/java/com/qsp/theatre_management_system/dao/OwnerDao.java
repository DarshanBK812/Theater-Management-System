package com.qsp.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.theatre_management_system.dto.Owner;
import com.qsp.theatre_management_system.dto.Theater;
import com.qsp.theatre_management_system.repo.OwnerRepo;

@Repository
public class OwnerDao {

	@Autowired
	OwnerRepo ownerRepo;

	@Autowired
	TheaterDao theaterDao;

	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}

	public Owner fetchOwnerById(int ownerId) {
		Optional<Owner> owner = ownerRepo.findById(ownerId);

//		if (owner.isPresent()) {
//			return owner.get();
//		} else
//			return null;

		if (owner.isEmpty()) {

			return null;

		} else {

			return owner.get();
		}

	}

	public Owner updateOwnerById(int oldOwnerId, Owner newOwner) {

		newOwner.setOwnerId(oldOwnerId);
		ownerRepo.save(newOwner);
		return newOwner;

	}

	public List<Owner> fetchAllOwner() {
		return ownerRepo.findAll();

	}

	public Owner deleteOwnerById(int ownerId) {
		Owner owner = fetchOwnerById(ownerId);
		ownerRepo.delete(owner);
		return owner;
	}

	public Owner saveExistingOwnerToExistingTheater(int ownerId, int theaterId) {

		Owner owner = fetchOwnerById(ownerId);
		Theater theater = theaterDao.fetchTheaterById(theaterId);
		owner.setTheater(theater);
		return saveOwner(owner);

	}

}
