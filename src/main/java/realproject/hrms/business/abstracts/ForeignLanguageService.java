package realproject.hrms.business.abstracts;

import realproject.hrms.core.utilities.results.DataResult;
import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.entities.concretes.ForeignLanguage;

import java.util.List;

public interface ForeignLanguageService {
    Result add(ForeignLanguage foreignLanguage);
    DataResult<List<ForeignLanguage>> getAll();
}
