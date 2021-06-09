package realproject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import realproject.hrms.business.abstracts.SocialMediaLinkService;
import realproject.hrms.core.utilities.results.DataResult;
import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.core.utilities.results.SuccessDataResult;
import realproject.hrms.core.utilities.results.SuccessResult;
import realproject.hrms.dataAccess.abstracts.SocialMediaLinkDao;
import realproject.hrms.entities.concretes.SocialMediaLink;

import java.util.List;

@Service
public class SocialMediaLinkManager implements SocialMediaLinkService {

    private SocialMediaLinkDao socialMediaLinkDao;

    @Autowired
    public SocialMediaLinkManager(SocialMediaLinkDao socialMediaLinkDao) {
        this.socialMediaLinkDao = socialMediaLinkDao;
    }

    @Override
    public Result add(SocialMediaLink socialMediaLink) {
        this.socialMediaLinkDao.save(socialMediaLink);
        return new SuccessResult("yeni meyda eklendi");
    }

    @Override
    public DataResult<List<SocialMediaLink>> getAll() {
        return new SuccessDataResult<>(this.socialMediaLinkDao.findAll(),"data listelendi");
    }
}
