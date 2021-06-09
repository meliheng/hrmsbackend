package realproject.hrms.business.abstracts;
import java.util.List;

import realproject.hrms.core.utilities.results.DataResult;
import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.entities.concretes.Employer;
public interface EmployerService {
	
	DataResult<List<Employer>> getAll();
	
	Result add(Employer employer);
}
