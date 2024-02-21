package org.authnow.security.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_profile")
public class UserProfile{

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phone;
    private Date dob;
    private String workspace;

    @OneToMany
    private HashSet<Patient> patients;
}
