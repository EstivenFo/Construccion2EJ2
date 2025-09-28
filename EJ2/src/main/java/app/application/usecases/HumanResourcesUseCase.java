package app.application.usecases;

import app.domain.services.CreateUser;
import app.domain.services.UpdateUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.User;
@Service
public class HumanResourcesUseCase {
	@Autowired
	private CreateUser createUser;

	public void createUser(User user) throws Exception {
		createUser.createUser(user);
	}
	@Autowired
	private UpdateUser updateUser;

	public void updateUser(User user) throws Exception {
		updateUser.update(user);
	}
}
