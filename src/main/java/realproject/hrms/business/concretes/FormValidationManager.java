package realproject.hrms.business.concretes;

import org.springframework.stereotype.Service;

import realproject.hrms.business.abstracts.FormValidationService;
import realproject.hrms.entities.concretes.Employer;
import realproject.hrms.entities.concretes.JobSeeker;

@Service
public class FormValidationManager implements FormValidationService{

	@Override
	public boolean checkFieldForJobSeeker(JobSeeker jobSeeker) {
		if(jobSeeker.getFirstName().isEmpty() || jobSeeker.getLastName().isEmpty() || jobSeeker.getEmail().isEmpty() 
				|| jobSeeker.getDateOfBirth()==null || jobSeeker.getNationalityId().isEmpty() || jobSeeker.getPassword().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean checkFieldForEmployer(Employer employer) {
		if(employer.getCompanyName().isBlank() || employer.getEmail().isBlank() || employer.getPhone().isBlank() || employer.getWebsite().isBlank() || employer.getPassword().isBlank()) {
			return false;
		}
		return true;
	}

}
