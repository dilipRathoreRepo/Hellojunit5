package org.example;

public class GreetingImpl implements Greeting{
    private GreetingService service;

    @Override
    public String greet(String name) {
        return service.greet(name);
    }
}
