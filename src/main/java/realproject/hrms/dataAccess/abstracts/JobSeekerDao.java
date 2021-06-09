package realproject.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import realproject.hrms.entities.concretes.JobSeeker;



public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{
	JobSeeker findBynationalityId(String name);
	JobSeeker findByemail(String email);
	
}

