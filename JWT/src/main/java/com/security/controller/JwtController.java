package com.security.controller;

import com.security.model.JwtRequest;
import com.security.model.JwtResponse;
import com.security.jwt.JwtUtil;
import com.security.model.UserDTO;
import com.security.oauth2.UserDetailService;
import com.security.service.CustomerService;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class JwtController {
    private UserDetailService UserDetailService;
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;
    private PasswordEncoder bcryptEncoder;
    private CustomerService customerService;


    public JwtController(UserDetailService UserDetailService,
                         JwtUtil jwtUtil,
                         AuthenticationManager authenticationManager,
                         CustomerService customerService
                         ) {
        this.UserDetailService = UserDetailService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.customerService = customerService;

    }


    @PostMapping("/authentication")
    public ResponseEntity<?> JwtLogin(@RequestBody JwtRequest authenticationRequest) throws Exception{
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                    (authenticationRequest.getUsername(),authenticationRequest.getPassword()));
        }catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        UserDetails userDetails =  UserDetailService.loadUserByUsername(authenticationRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails);

        System.out.println("Json Web Token: " + token);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userModel) throws Exception{
        return ResponseEntity.ok(customerService.Register(userModel));
    }

    @GetMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(HttpServletRequest request) throws Exception {
        // From the HttpRequest get the claims
        DefaultClaims claims = (io.jsonwebtoken.impl.DefaultClaims) request.getAttribute("claims");
        Map<String, Object> expectedMap = getMapFromIoJsonwebtokenClaims(claims);
        String token = jwtUtil.doGenerateRefreshToken(expectedMap, expectedMap.get("sub").toString());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public Map<String, Object> getMapFromIoJsonwebtokenClaims(DefaultClaims claims) {
        Map<String, Object> expectedMap = new HashMap<String, Object>();
        for (Map.Entry<String, Object> entry : claims.entrySet()) {
            expectedMap.put(entry.getKey(), entry.getValue());
        }
        return expectedMap;
    }
}
