package com.OSF.deliverableMarcus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OSF.deliverableMarcus.entity.Staff;
import com.OSF.deliverableMarcus.service.StaffService;

@RestController
@RequestMapping("/api/osf.staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@GetMapping(value = { "", "/" })
    public List<Staff> getStaff() {
        return this.staffService.getAllStaff();
    }
	
	@PostMapping
	public void registerNewStaff(@RequestBody Staff staff) {
		staffService.addNewStaff(staff);
	}
	
	@DeleteMapping(path= "{staffId}")
	public void deleteStaff(@PathVariable("staffId") Long staffId) {
		staffService.deleteStaff(staffId);
	}
	
	@PutMapping(path= "{staffId}")
	public void updateStaff(@RequestBody Staff staff, @PathVariable("staffId") Long staffId) {
		staffService.updateStaff(staff, staffId);
	}
	
}