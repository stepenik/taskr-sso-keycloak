package com.evil.inc.taskrssokeycloak;

import com.evil.inc.taskrssokeycloak.domain.Task;
import com.evil.inc.taskrssokeycloak.domain.Priority;
import com.evil.inc.taskrssokeycloak.repository.TaskRepository;
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
	public CommandLineRunner commandLineRunner(TaskRepository taskRepository){
		return args -> {
			taskRepository.save(new Task("Read!", "Start reading, at least 30 minutes per day", Priority.HIGH, "johndoe"));
			taskRepository.save(new Task("Workout", "Need to workout", Priority.HIGH, "johndoe"));
			taskRepository.save(new Task("Meditate", "Get some mindfulness", Priority.MEDIUM, "johndoe"));
			taskRepository.save(new Task("Be nice", "Give smiles", Priority.LOW, "johndoe"));
			taskRepository.save(new Task("Eat bananas", "One banana a day, keeps the doctor away", Priority.LOW, "johndoe"));
		};
	}
}
