package com.reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {
    @Test
    public void testMono(){

        //String test case example
        Mono<String> mono = Mono.just("Adish").log();
        mono.subscribe(System.out::println);

    // Exception Test Case
        Mono<?> stringMono = Mono.just("Adish")
                .then(Mono.error(new RuntimeException("Exception Occured")))
                .log();
        stringMono.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));

    }

    @Test
    public void testFlux(){
 //Simple Example data
        Flux<String> just = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservice")
                .concatWithValues("AWS")
                .log();

        //Exception test case
        Flux<String> fluxException = Flux.just("Spring", "Spring Boot", "Hibernate", "Microservice")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception Occured in Flux")))
                .concatWithValues("cloud")
                .log();

        fluxException.subscribe(System.out::println);

    }

}
