package realproject.hrms.mernis;

import org.springframework.stereotype.Service;

@Service
public class RealPersonValidation {
	public boolean checkPerson(String firstName,String lastName,String nationalityId) {
		if(firstName.contains("dede") && lastName.contains("derya") && nationalityId.contains("11111111199")) return true;
		return false;
	}
}
