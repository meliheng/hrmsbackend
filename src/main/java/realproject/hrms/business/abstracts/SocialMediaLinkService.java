package realproject.hrms.business.abstracts;

import realproject.hrms.core.utilities.results.DataResult;
import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.entities.concretes.SocialMediaLink;

import java.util.List;

public interface SocialMediaLinkService {
    Result add(SocialMediaLink socialMediaLink);
    DataResult<List<SocialMediaLink>> getAll();
}
