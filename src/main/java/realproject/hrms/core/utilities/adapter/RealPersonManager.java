package realproject.hrms.core.utilities.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import realproject.hrms.mernis.RealPersonValidation;

@Service
public class RealPersonManager implements RealPersonService{

	RealPersonValidation realPersonValidation;
	
	@Autowired
	public RealPersonManager(RealPersonValidation realPersonValidation) {
		super();
		this.realPersonValidation = realPersonValidation;
	}


	@Override
	public boolean checkPerson(String firstName,String lastName,String nationalityId) {
		return this.realPersonValidation.checkPerson(firstName,lastName,nationalityId);
	}

}
