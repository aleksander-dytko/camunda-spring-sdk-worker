package io.camunda.getstarted.tutorial;

import java.util.HashMap;
import java.util.Map;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.camunda.zeebe.client.api.response.ActivatedJob;

@SpringBootApplication
public class Worker {

  public static void main(String[] args) {
    SpringApplication.run(Worker.class, args);
  }

    @JobWorker(type = "transport")
    public Map<String, Object> transport(final ActivatedJob job) {

        // Do the business logic
        System.out.println("Working on the process instance: " +job.getProcessInstanceKey() + " with process variables: " + job.getVariables());

        // Add some process variables
        HashMap<String, Object> variables = new HashMap<>();
        variables.put("reservationNumber", 1);
        System.out.println("Added variables to the process instance: " + variables);
        return variables;
    }

}
