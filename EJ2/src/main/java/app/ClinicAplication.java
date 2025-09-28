package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.adapter.in.client.AdminStaffClient;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ClinicAplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClinicAplication.class, args);
	}

	@Autowired
	private AdminStaffClient client;

	@Override
	public void run(String... args) throws Exception {
		client.session();
	}

}
