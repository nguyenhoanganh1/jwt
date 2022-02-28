package com.security.controller;

import com.security.repository.RoleRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
    private RestTemplate restTemplate;
    private RoleRepository roleRepository;
    public TestController(RestTemplate restTemplate, RoleRepository roleRepository) {
        this.restTemplate = restTemplate;
        this.roleRepository = roleRepository;
    }

    private static final String REGISTRATION_URL = "http://localhost:8080/register";
    private static final String AUTHENTICATION_URL = "http://localhost:8080/authentication";
    private static final String HELLO_URL = "http://localhost:8080/helloadmin";

    /*@GetMapping("/getResponse")
    public String getResponse() throws JsonProcessingException {

        String response = null;
        // create user registration object
        Customer registrationUser = getRegistrationUser();
        // convert the user registration object to JSON
        String registrationBody = getBody(registrationUser);
        // create headers specifying that it is JSON request
        HttpHeaders registrationHeaders = getHeaders();
        HttpEntity<String> registrationEntity = new HttpEntity<String>(registrationBody, registrationHeaders);

        try {
            // Register User
            ResponseEntity<String> registrationResponse = restTemplate.exchange(REGISTRATION_URL, HttpMethod.POST,
                    registrationEntity, String.class);
            // if the registration is successful
            if (registrationResponse.getStatusCode().equals(HttpStatus.OK)) {

                // create user authentication object
                User authenticationUser = getAuthenticationUser();
                // convert the user authentication object to JSON
                String authenticationBody = getBody(authenticationUser);
                // create headers specifying that it is JSON request
                HttpHeaders authenticationHeaders = getHeaders();
                HttpEntity<String> authenticationEntity = new HttpEntity<String>(authenticationBody,
                        authenticationHeaders);

                // Authenticate User and get JWT
                ResponseEntity<ResponseToken> authenticationResponse = restTemplate.exchange(AUTHENTICATION_URL,
                        HttpMethod.POST, authenticationEntity, ResponseToken.class);

                // if the authentication is successful
                if (authenticationResponse.getStatusCode().equals(HttpStatus.OK)) {
                    String token = "Bearer " + authenticationResponse.getBody().getToken();
                    HttpHeaders headers = getHeaders();
                    headers.set("Authorization", token);
                    HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
                    // Use Token to get Response
                    ResponseEntity<String> helloResponse = restTemplate.exchange(HELLO_URL, HttpMethod.GET, jwtEntity,
                            String.class);
                    if (helloResponse.getStatusCode().equals(HttpStatus.OK)) {
                        response = helloResponse.getBody();
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return response;
    }
    private Customer getRegistrationUser() {
        Customer user = new Customer();
        user.setId("admin");
        user.setPassword("admin");
        Role role = roleRepository.findByName("user");
        user.addRole(role);
        return user;
    }

    private UserModel getAuthenticationUser() {
        UserModel user = new UserModel();
        user.setUsername("javainuse");
        user.setPassword("javainuse");
        return user;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }

    private String getBody(final UserModel user) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(user);
    }*/
}
