package net.sparkminds.responsitory;

import org.springframework.data.repository.CrudRepository;

import net.sparkminds.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findOneByEmailIdIgnoreCaseAndPassword(String emailId, String password);
	
}