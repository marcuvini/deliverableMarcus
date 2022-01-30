package com.OSF.deliverableMarcus.service;


import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OSF.deliverableMarcus.entity.Staff;
import com.OSF.deliverableMarcus.exception.ResourceExceptionHandler;
import com.OSF.deliverableMarcus.repository.StaffRepository;


@Service
public class StaffService {

	private ResourceExceptionHandler resExHand;
		
	private StaffRepository staffRepository;
	
	@Autowired
	public StaffService(StaffRepository staffRepository) {
		super();
		this.staffRepository = staffRepository;
	}

	// GET ALL STAFF
	
	public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

	// GET STAFF BY ID
	
    public Staff getStaff(long id) {
        return staffRepository
          .findById(id)
          .orElseThrow(() -> resExHand.new ResourceNotFoundException("Staff not found"));
    }
 	
    // CREATE NEW STAFF
    
 		public void addNewStaff(Staff staff) {
		this.staffRepository.save(staff);
	}
 		
 	// DELETE STAFF
 		
 		public void deleteStaff(long staffId) {
 			staffRepository.findById(staffId);
 			boolean exists = staffRepository.existsById(staffId);
 			if (!exists) {
 				throw new IllegalStateException("Staff with id" + staffId + "does not exists.");
 				
 			}
 			 	staffRepository.deleteById(staffId);			
 		}

 	// UPDATE STAFF
 		
 		@Transactional
		public void updateStaff(Staff staff, long staffId) {
 			// staffRepository.findById(staffId);
			Staff existingStaff = this.staffRepository.findById(staffId)
					.orElseThrow(() -> new IllegalStateException("staff with id" + staffId + "does not exists."));
 			 
			if (staff.getFirstName() != null &&
				staff.getFirstName().length() > 0 &&
				!Objects.equals(staff.getFirstName(), existingStaff.getFirstName())) {
				existingStaff.setFirstName(staff.getFirstName());				
			}
			
			if (staff.getLastName() != null &&
					staff.getLastName().length() > 0 &&
					!Objects.equals(staff.getLastName(), existingStaff.getLastName())) {
					existingStaff.setLastName(staff.getLastName());				
			}
			
			if (staff.getEmail() != null &&
					staff.getEmail().length() > 0 &&
					!Objects.equals(staff.getEmail(), existingStaff.getEmail())) {
					existingStaff.setEmail(staff.getEmail());				
			}
			
			if (staff.getPhone() != null &&
					staff.getPhone().length() > 0 &&
					!Objects.equals(staff.getPhone(), existingStaff.getPhone())) {
					existingStaff.setPhone(staff.getPhone());				
			}
			
			if (staff.getActive() > 0 &&
					!Objects.equals(staff.getActive(), existingStaff.getActive())) {
						existingStaff.setActive(staff.getActive());				
			}
				
			if (staff.getStoreId() > 0 &&
					!Objects.equals(staff.getStoreId(), existingStaff.getStoreId())) {
							existingStaff.setStoreId(staff.getStoreId());				
			}
				
			if (staff.getManagerId() > 0 &&
					!Objects.equals(staff.getManagerId(), existingStaff.getManagerId())) {
							existingStaff.setManagerId(staff.getManagerId());				
			}
		}

 		
} 		
