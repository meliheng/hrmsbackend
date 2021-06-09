package realproject.hrms.business.abstracts;


import realproject.hrms.entities.concretes.Employer;
import realproject.hrms.entities.concretes.JobSeeker;

public interface FormValidationService {
	boolean checkFieldForJobSeeker(JobSeeker jobSeeker);
	boolean checkFieldForEmployer(Employer employer);
}

