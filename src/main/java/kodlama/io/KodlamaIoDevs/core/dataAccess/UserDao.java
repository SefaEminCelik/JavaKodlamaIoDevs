package kodlama.io.KodlamaIoDevs.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.KodlamaIoDevs.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

	
	User findByEmail(String email);
}
