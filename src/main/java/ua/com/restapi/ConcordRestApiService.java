package ua.com.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ConcordRestApiService extends SpringBootServletInitializer {
  public static void main(String[] args) {
    SpringApplication.run(ConcordRestApiService.class, args);
  }
}
