package realproject.hrms.business.abstracts;

import realproject.hrms.core.utilities.results.DataResult;
import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.entities.concretes.JobBoard;
import realproject.hrms.entities.dtos.JobBoardDto;

import java.util.List;

public interface JobBoardService {
    Result add(JobBoard jobBoard);
    DataResult<List<JobBoardDto>>  getAll();
    DataResult<List<JobBoardDto>>  getAll(String companyName);
}
