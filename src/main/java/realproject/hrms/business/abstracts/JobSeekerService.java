package realproject.hrms.business.abstracts;

import java.util.List;

import realproject.hrms.core.utilities.results.DataResult;
import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	
	DataResult<List<JobSeeker>> getAll();
	Result add(JobSeeker jobSeeker);
	boolean isNationalityIdExists(String nationality_id);

}
