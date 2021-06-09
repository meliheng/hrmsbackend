package realproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import realproject.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	JobPosition findByjobname(String jobName);

}
