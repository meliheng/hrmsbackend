package realproject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import realproject.hrms.business.abstracts.ProfileImageService;
import realproject.hrms.core.utilities.adapter.ImageUploadService;
import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.core.utilities.results.SuccessResult;
import realproject.hrms.dataAccess.abstracts.ProfileImageDao;
import realproject.hrms.entities.concretes.ProfileImage;

import java.io.IOException;

@Service
public class ProfileImageManager implements ProfileImageService {

    private ProfileImageDao profileImageDao;
    private ImageUploadService imageUploadService;

    @Autowired
    public ProfileImageManager(ProfileImageDao profileImageDao,ImageUploadService imageUploadService) {
        this.profileImageDao = profileImageDao;
        this.imageUploadService = imageUploadService;
    }

    @Override
    public Result add(ProfileImage profileImage) throws IOException {
        String url = imageUploadService.uploadImage(profileImage.getImageUrl());
        profileImage.setImageUrl(url);
        profileImageDao.save(profileImage);
        return new SuccessResult("profil resmi eklendi");
    }
}
