package com.security.oauth2;

import com.security.entity.Customer;
import com.security.repository.CustomerRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailService implements UserDetailsService {
    private CustomerRepository customerRepository;

    public UserDetailService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.getCustomerByUsername(username);
        if (customer == null) {
            throw new UsernameNotFoundException("Could not find user with that username");
        }
        return new org.springframework.security.core.userdetails.User(customer.getId(), customer.getPassword(),
                new ArrayList<>());
    }


    private Set getAuthority(Customer user) {
        Set authorities = new HashSet();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        });
        return authorities;
    }
}
