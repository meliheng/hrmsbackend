package realproject.hrms.business.abstracts;

import realproject.hrms.core.utilities.results.DataResult;
import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.entities.concretes.CoverLetter;

import java.util.List;

public interface CoverLetterService {
    Result add(CoverLetter coverLetter);
    DataResult<List<CoverLetter>> getAll();
}
