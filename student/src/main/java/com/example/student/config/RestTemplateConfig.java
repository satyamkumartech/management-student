package com.example.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

/**
 @Bean
 public RestTemplate getRestTemplate()
 {
 return new RestTemplate();
 }

 @Autowired
 Private RestTemplate restTemplate;

 //now I need url from second microservices

 static final String SECOND_SERVICE_URL ="http://localhost:8080/";

 //create method to get details of second ms either one details or many details

 @GetMapping("/find/{roll_no}")
 public String fetchStudent(@PathVariable int roll_no)
 {
 //now we have to invoke particular url to get a single details "http://localhost:8080/all/110"
 return restTemplate.exchange(SECOND_SERVICE_URL+"all/"+roll_no,HttpMethod.GET,null,Student/or/String.class).getBody();
 //null represent that we are not passing anything
 }

 //create a method to fetch all the student

 @GetMapping("/find")
 public String fetchAllStudent()
 {
 return restTemplate.exchange(SECOND_SERVICE_URL+"all",HttpMethod.GET,null,String.class).getBody();

 }
**/