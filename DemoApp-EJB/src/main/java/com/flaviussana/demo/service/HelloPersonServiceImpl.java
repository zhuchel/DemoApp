package com.flaviussana.demo.service;
 
import javax.ejb.Stateless;
import javax.jws.WebService;
import nl.example.hello_person.service.generated.HelloPersonServiceRequestType;
import nl.example.hello_person.service.generated.HelloPersonServiceResponseType;

@Stateless
@WebService(serviceName = "HelloPersonService", targetNamespace = "http://example.nl/hellopersonservice/1.0", endpointInterface="nl.example.hello_person.service.generated.HelloPersonServicePortType")
public class HelloPersonServiceImpl implements nl.example.hello_person.service.generated.HelloPersonServicePortType {
 
    @Override
    public HelloPersonServiceResponseType greetPerson(HelloPersonServiceRequestType helloPersonServiceRequest) {
        HelloPersonServiceResponseType helloPersonServiceResponse = new HelloPersonServiceResponseType();
        helloPersonServiceResponse.setGreetings("Hello " + helloPersonServiceRequest.getPerson().getFirstName() + " " + helloPersonServiceRequest.getPerson().getLastName() + "!");
        return helloPersonServiceResponse;
    }
 
}