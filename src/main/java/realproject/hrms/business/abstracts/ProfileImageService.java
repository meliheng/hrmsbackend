package realproject.hrms.business.abstracts;

import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.entities.concretes.ProfileImage;

import java.io.IOException;

public interface ProfileImageService {
    Result add(ProfileImage profileImage) throws IOException;
}
