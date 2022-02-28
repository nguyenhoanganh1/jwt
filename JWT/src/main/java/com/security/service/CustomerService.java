package com.security.service;

import com.security.entity.Customer;
import com.security.entity.Role;
import com.security.model.UserDTO;
import com.security.repository.CustomerRepository;
import com.security.repository.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService{
    private PasswordEncoder passwordEncoder;
    private CustomerRepository customerRepository;
    private RoleRepository roleRepository;
    public CustomerService(CustomerRepository customerRepository,
                           PasswordEncoder passwordEncoder
                            ,RoleRepository roleRepository) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public Customer Register(UserDTO model){
        Customer customer = new Customer();
        customer.setId(model.getUsername());
        customer.setPassword(passwordEncoder.encode(model.getPassword()));
        Role role = roleRepository.findByName("user");
        customer.addRole(role);
        customer.setActivated(true);

       return customerRepository.save(customer);
    }
}
