package com.pgs.javadev.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Phone {

  @Id
  private String number;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "USER_ID")
  private User user;
}
