package kodlama.io.KodlamaIoDevs.business.abstracts;

import kodlama.io.KodlamaIoDevs.core.entities.User;
import kodlama.io.KodlamaIoDevs.core.utilities.results.DataResult;
import kodlama.io.KodlamaIoDevs.core.utilities.results.Result;

public interface UserService {

	Result add (User user);
	
	DataResult<User> findByEmail(String email);
}
