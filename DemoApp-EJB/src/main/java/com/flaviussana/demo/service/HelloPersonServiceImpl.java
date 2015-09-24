package com.flaviussana.demo.service;
 
import javax.jws.WebService;
import nl.example.hello_person.service.generated.HelloPersonServiceRequestType;
import nl.example.hello_person.service.generated.HelloPersonServiceResponseType;
 
@WebService(endpointInterface="nl.example.hello_person.service.generated.HelloPersonServicePortType")
public class HelloPersonServiceImpl implements nl.example.hello_person.service.generated.HelloPersonServicePortType {
 
    @Override
    public HelloPersonServiceResponseType greetPerson(HelloPersonServiceRequestType helloPersonServiceRequest) {
        HelloPersonServiceResponseType helloPersonServiceResponse = new HelloPersonServiceResponseType();
        helloPersonServiceResponse.setGreetings("Hello " + helloPersonServiceRequest.getPerson().getFirstName() + " " + helloPersonServiceRequest.getPerson().getLastName() + "!");
        return helloPersonServiceResponse;
    }
 
}