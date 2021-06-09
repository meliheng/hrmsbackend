package realproject.hrms.core.utilities.adapter;

import org.springframework.stereotype.Service;

@Service
public class EmailVerificationManager implements VerificationService{

	@Override
	public boolean emailVerification(String email) {
		return true;
	}

}
