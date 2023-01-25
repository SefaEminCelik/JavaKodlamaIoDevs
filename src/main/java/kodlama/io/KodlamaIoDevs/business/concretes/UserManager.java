package kodlama.io.KodlamaIoDevs.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.KodlamaIoDevs.business.abstracts.UserService;
import kodlama.io.KodlamaIoDevs.core.dataAccess.UserDao;
import kodlama.io.KodlamaIoDevs.core.entities.User;
import kodlama.io.KodlamaIoDevs.core.utilities.results.DataResult;
import kodlama.io.KodlamaIoDevs.core.utilities.results.Result;
import kodlama.io.KodlamaIoDevs.core.utilities.results.SuccessDataResult;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		return new SuccessDataResult<User>(this.userDao.save(user), "Kullanıcı Eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email){
		return new SuccessDataResult<User>(this.userDao.findByEmail(email), "Kullanıcı Email İle Getirildi");
	}

}
