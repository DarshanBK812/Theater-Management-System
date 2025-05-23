package com.qsp.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.theatre_management_system.dto.Viewer;
import com.qsp.theatre_management_system.dto.Viewer;
import com.qsp.theatre_management_system.service.ViewerService;
import com.qsp.theatre_management_system.util.ResponseStructure;
import com.qsp.theatre_management_system.util.ResponseStructureForAll;

@RestController
public class ViewerController {
	
	@Autowired
	ViewerService viewerService;
	
	@PostMapping("/saveViewer")
	public ResponseStructure<Viewer> saveViewer(@RequestBody Viewer viewer) {
		return viewerService.saveViewer(viewer);
	}

	@GetMapping("/fetchViewerById")
	public ResponseStructure<Viewer> fetchViewerById(@RequestParam int viewerId) {
		return viewerService.fetchViewerById(viewerId);
	}

	@GetMapping("/fetchAllViewer")
	public ResponseStructureForAll<Viewer> fetchAllViewer() {
		return viewerService.fetchAllViewer();
	}

	@DeleteMapping("/deleteViewerById")
	public ResponseStructure<Viewer> deleteViewerById(@RequestParam int viewerId) {
		return viewerService.deleteViewerById(viewerId);
	}

	@PutMapping("/updateViewerById")
	public ResponseStructure<Viewer> updateViewerById(@RequestParam int oldviewerId, @RequestBody Viewer newViewer) {
		return viewerService.updateViewerById(oldviewerId, newViewer);
	}

}
