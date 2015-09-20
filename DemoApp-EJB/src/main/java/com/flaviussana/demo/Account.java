/* Copyright (c) 2012,2013, Oracle and/or its affiliates. All rights reserved.  */
package com.flaviussana.demo;

import javax.persistence.Id;


public class Account {
  @Id
  private String name;
  
  private float amount;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }
  
  
}
