package com.pgs.javadev.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by andrzej on 05.12.16.
 */
@Data
@Builder
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  private String firstName;

  @NotEmpty
  private String lastName;
  private String displayName;

  private Boolean male;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date birthDate;

  @OneToMany(mappedBy = "user")
  private Set<Phone> phones;

  @ManyToMany
  private Set<Address> addresses;

  @NotEmpty
  private String email;
}
