package org.example.ddd.controller.http;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.example.ddd.application.service.event.EventAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.SecureRandom;


@RestController
@RequestMapping("/hello")
public class HiController {

    @Autowired
    private EventAppService eventAppService;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/hi")
    @RateLimiter(name = "backendA", fallbackMethod = "fallbackHello")
    public String hello() {
        return eventAppService.sayHi("Hi");
    }

    public String fallbackHello(Throwable throwable) {
        return "fallback hello";
    }

    @GetMapping("/hi/v1")
    public String sayHi() {
        return eventAppService.sayHi("H1 v1");
    }

    private static final SecureRandom secureRandom = new SecureRandom();
    @GetMapping("/circuit/breaker")
    @CircuitBreaker(name = "checkRandom", fallbackMethod = "fallbackCircuitBreaker")
    public String circuitBreaker() {
        int productId = secureRandom.nextInt(20) + 1;
        String url = "https://fakestoreapi.com/products/"+ productId;
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackCircuitBreaker(Throwable throwable) {
        return throwable.getMessage();
    }
}
