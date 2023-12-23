package com.reactive;

import com.reactive.service.FluxAndMonoServices;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class FluxAndMonoServicesTest {
    FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

    @Test
    public void fruitsFlux(){
        var ftuitsFlux = fluxAndMonoServices.fruitsFlux();
        StepVerifier.create(ftuitsFlux)
                .expectNext("Mango","Orange","Banana")
                .verifyComplete();
    }

    @Test
    public void fruitMono(){
        var fruitsMono = fluxAndMonoServices.fruitMono();
        StepVerifier.create(fruitsMono)
                .expectNext("Mango")
                .verifyComplete();
    }

    @Test
    public void fruitsFluxMapTest(){
        var fruitsFlux = fluxAndMonoServices.fruitsFluxMap();
        StepVerifier.create(fruitsFlux)
                .expectNext("MANGO","ORANGE","BANANA")
                .verifyComplete();
    }
@Test
    public void fruitsFluxFilterTest(){
        var fruitsFluxFilter = fluxAndMonoServices.fruitsFluxFilter(5).log();
        StepVerifier.create(fruitsFluxFilter)
                .expectNext("Orange","Banana")
                .verifyComplete();
    }

    @Test
    public void fruitsFluxFilterMapTest(){
        var fruitFluxMap = fluxAndMonoServices.fruitsFluxFilterMap(5);
        StepVerifier.create(fruitFluxMap)
                .expectNext("ORANGE","BANANA")
                .verifyComplete();
    }
    @Test
    public void fruitsFluxFilterFlatmapTest(){
        var fruiltFlatMap = fluxAndMonoServices.fruitsFluxFilterFlatmap();
        StepVerifier.create(fruiltFlatMap)
                .expectNextCount(17)
                .verifyComplete();
    }
    @Test
    public void fruitsFluxFilterFlatmapAsyncTest(){
        var fruiltFlatMap = fluxAndMonoServices.fruitsFluxFilterFlatmapAsync();
        StepVerifier.create(fruiltFlatMap)
                .expectNextCount(17)
                .verifyComplete();
    }

    @Test public void fruitMonoFlatMapTest(){
        var fruitMonoFlat = fluxAndMonoServices.fruitMonoFlatMap();
        StepVerifier.create(fruitMonoFlat)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    public void fruitFluxConcatMapTest(){
        var fruitFluxConcat = fluxAndMonoServices.fruitFluxConcatMap();
        StepVerifier.create(fruitFluxConcat)
                .expectNextCount(17)
                .verifyComplete();
    }
    @Test
    public void fruitMonoFlatMapManyTest(){
        var fruitMonoFlatMap = fluxAndMonoServices.fruitMonoFlatMapMany();
        StepVerifier.create(fruitMonoFlatMap)
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    public void fruitsFluxTransformTest(){
        var fruitMonoFlatMap = fluxAndMonoServices.fruitsFluxTransform(5);
        StepVerifier.create(fruitMonoFlatMap)
                .expectNext("Orange","Banana")
                .verifyComplete();
    }

}
