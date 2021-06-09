package realproject.hrms.business.abstracts;

import java.util.List;

import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	
	List<JobPosition> getAll();
	Result add(JobPosition jobPosition);

}
