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

import com.OSF.deliverableMarcus.entity.Staffs;
import com.OSF.deliverableMarcus.service.StaffsService;

@RestController
@RequestMapping("/api/osf.staffs")
public class StaffsController {
	
	@Autowired
	private StaffsService staffsService;
	
	@GetMapping(value = { "", "/" })
    public List<Staffs> getStaffs() {
        return this.staffsService.getAllStaff();
    }
	
	@GetMapping(value = {"/{id}"})
    public Staffs getStaffById(@PathVariable (value = "id") long staffId) {
        return this.staffsService.getStaff(staffId);
    }
	
	@PostMapping
	public void registerNewStaff(@RequestBody Staffs staff) {
		staffsService.addNewStaff(staff);
	}
	
	@DeleteMapping(path= "{staffId}")
	public void deleteStaff(@PathVariable("staffId") Long staffId) {
		staffsService.deleteStaff(staffId);
	}
	
	@PutMapping(path= "{staffId}")
	public void updateStaff(@RequestBody Staffs staff, @PathVariable("staffId") Long staffId) {
		staffsService.updateStaff(staff, staffId);
	}
	
}