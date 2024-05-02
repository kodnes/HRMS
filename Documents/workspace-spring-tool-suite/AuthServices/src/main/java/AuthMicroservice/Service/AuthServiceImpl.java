package AuthMicroservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AuthMicroservice.Repository.AuthRepository;
import AuthMicroservice.entity.Auth;
@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private AuthRepository repo;
	@Override
	public void saveAuth(Auth auth) {
		repo.save(auth);
	}

}
