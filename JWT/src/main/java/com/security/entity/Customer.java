package com.security.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="Customers")
public class Customer  implements Serializable {
    @Id
    private String id;
    private String password;
    private String fullname;
    private String email;
    private String photo;
    private boolean activated = false;

    @Column(name="onetimepassword")
    private String oneTimePassword;
    @Column(name="otptime")
    private Date otpTime;

    /*@Enumerated(EnumType.STRING)
    private OAuthProvider provider;*/

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name="roledetails", joinColumns = @JoinColumn(name = "customerid"), inverseJoinColumns = @JoinColumn(name = "roleid"))
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void removeRole(Role role) {
        this.roles.remove(role);
    }


    public boolean isOTPRequired() {
        if(this.oneTimePassword == null)
        {
            return false;
        }
        long otpRequestedTimeInMillis = this.otpTime.getTime();
        if(otpRequestedTimeInMillis + OTP_VALID_DURATION < System.currentTimeMillis())
        {
            return false;
        }
        return true;
    }

    private static final long OTP_VALID_DURATION = 5 * 60 * 1000;

}
