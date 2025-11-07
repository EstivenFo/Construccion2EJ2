package app.application.usecases;

import app.domain.services.CreateUser;
import app.domain.services.UpdateUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Person;
@Service
public class HumanResourcesUseCase {
	@Autowired
	private CreateUser createUser;

	public void createUser(Person user) throws Exception {
		createUser.createUser(user);
	}
	@Autowired
	private UpdateUser updateUser;

	public void updateUser(Person user) throws Exception {
		updateUser.update(user);
	}
}
