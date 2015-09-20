package com.flaviussana.demo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorldEJB
 */
@Stateless
@LocalBean
public class HelloWorldEJB {

    /**
     * Default constructor.
     */
    public HelloWorldEJB() {
        // TODO Auto-generated constructor stub
    }
   
    public String sayHello(String name) {
       return "Hello " + name + "!";
    }

}
