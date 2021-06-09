package realproject.hrms.business.abstracts;

import realproject.hrms.core.utilities.results.DataResult;
import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.entities.concretes.EducationInformation;

import java.util.List;

public interface EducationInformationService {
    DataResult<List<EducationInformation>> getAll();
    Result add(EducationInformation educationInformation);
}
