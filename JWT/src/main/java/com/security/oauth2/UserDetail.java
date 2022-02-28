package com.security.oauth2;

import com.security.entity.Customer;
import com.security.entity.OAuthProvider;
import com.security.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserDetail implements UserDetails {

    private Customer customer;

    public UserDetail(Customer customer) {
        this.customer = customer;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = customer.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role: roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.customer.getPassword();
    }

    @Override
    public String getUsername() {
        return this.customer.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.customer.isActivated();
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public String getFullname() {
        return this.customer.getFullname();
    }

    public String getPhoto() {
        return this.customer.getPhoto();
    }

    public Set<Role> getRole() {
        return this.customer.getRoles();
    }

    /*public OAuthProvider getProvider() {
        return this.customer.getProvider();
    }*/

    public String getId() {
        return this.customer.getId();
    }
}
