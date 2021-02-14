package com.evil.inc.taskrssokeycloak;

import com.evil.inc.taskrssokeycloak.domain.Task;
import com.evil.inc.taskrssokeycloak.domain.Priority;
import com.evil.inc.taskrssokeycloak.domain.User;
import com.evil.inc.taskrssokeycloak.repository.TaskRepository;
import com.evil.inc.taskrssokeycloak.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskrSsoKeycloakApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskrSsoKeycloakApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TaskRepository taskRepository, UserRepository userRepository){
		return args -> {
			User user = userRepository.save(new User("thejohndoe", "john", "doe", 25));
			taskRepository.save(new Task("Read!", "Start reading, at least 30 minutes per day", Priority.HIGH, user));
			taskRepository.save(new Task("Workout", "Need to workout", Priority.HIGH, user));
			taskRepository.save(new Task("Meditate", "Get some mindfulness", Priority.MEDIUM, user));
			taskRepository.save(new Task("Be nice", "Give smiles", Priority.LOW, user));
			taskRepository.save(new Task("Eat bananas", "One banana a day, keeps the doctor away", Priority.LOW, user));
		};
	}
}
