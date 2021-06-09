package realproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import realproject.hrms.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience,Integer> {
}
