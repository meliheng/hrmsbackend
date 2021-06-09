package realproject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import realproject.hrms.business.abstracts.EducationInformationService;
import realproject.hrms.core.utilities.results.DataResult;
import realproject.hrms.core.utilities.results.Result;
import realproject.hrms.core.utilities.results.SuccessDataResult;
import realproject.hrms.core.utilities.results.SuccessResult;
import realproject.hrms.dataAccess.abstracts.EducationInformationDao;
import realproject.hrms.entities.concretes.EducationInformation;

import java.util.List;

@Service
public class EducationInformationManager implements EducationInformationService {

    private EducationInformationDao educationInformationDao;

    @Autowired
    public EducationInformationManager(EducationInformationDao educationInformationDao){
        this.educationInformationDao = educationInformationDao;
    }
    @Override
    public DataResult<List<EducationInformation>> getAll() {
        return new SuccessDataResult<>( this.educationInformationDao.findAll(Sort.by(Sort.Direction.DESC,"graduatedDate")),"data listelendi.");
    }

    @Override
    public Result add(EducationInformation educationInformation) {
        this.educationInformationDao.save(educationInformation);
        return new SuccessResult("yeni eğitim bilgisi eklendi");
    }
}
