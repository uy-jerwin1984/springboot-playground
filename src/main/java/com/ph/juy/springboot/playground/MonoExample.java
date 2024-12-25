package com.ph.juy.springboot.playground;

import reactor.core.publisher.Mono;

public class MonoExample {

    public static void main(String[] args) {
        Mono<String> param = Mono.just("test");

        param.checkpoint("1")
                .flatMap(e -> Mono.just(e + "i"))
                .checkpoint("2")
                .subscribe(System.out::println);
    }
}
