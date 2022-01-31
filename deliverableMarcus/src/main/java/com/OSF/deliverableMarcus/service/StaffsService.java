package com.OSF.deliverableMarcus.service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OSF.deliverableMarcus.entity.Staffs;
import com.OSF.deliverableMarcus.repository.StaffsRepository;


@Service
public class StaffsService {

		
	private StaffsRepository staffsRepository;
	
	@Autowired
	public StaffsService(StaffsRepository staffsRepository) {
		super();
		this.staffsRepository = staffsRepository;
	}

	// GET ALL STAFF
	
	public List<Staffs> getAllStaff() {
        return staffsRepository.findAll();
    }

	// GET STAFF BY ID
	
    public Staffs getStaff(long id) {
        return staffsRepository
          .findById(id)
          .orElseThrow(() -> new IllegalStateException("Staff not found"));
    }
 	
    // CREATE NEW STAFF
    
 		public void addNewStaff(Staffs staff) {
 			Optional<Staffs> staffOptional = staffsRepository
 					.findStaffByEmail(staff.getEmail());
 			if(staffOptional.isPresent()) {
 				throw new IllegalStateException("Email já existente");
 			}
		this.staffsRepository.save(staff);
	}
 		
 	// DELETE STAFF
 		
 		public void deleteStaff(long staffId) {
 			staffsRepository.findById(staffId);
 			boolean exists = staffsRepository.existsById(staffId);
 			if (!exists) {
 				throw new IllegalStateException("Staff with id" + staffId + "does not exists.");
 				
 			}
 			 	staffsRepository.deleteById(staffId);			
 		}

 	// UPDATE STAFF
 		
 		@Transactional
		public void updateStaff(Staffs staff, long staffId) {
 			// staffsRepository.findById(staffId);
			Staffs existingStaff = this.staffsRepository.findById(staffId)
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
