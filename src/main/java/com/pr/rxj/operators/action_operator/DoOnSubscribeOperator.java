package com.pr.rxj.operators.action_operator;

import io.reactivex.Observable;

public class DoOnSubscribeOperator {
    public static void main(String[] args) {
        // Peek on each emission coming out of an operator and going to the next
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .doOnSubscribe(s-> System.out.println("OnSubscribed!"))
                .map(String::length)
                .subscribe(i-> System.out.println("Received: " + i));
    }
}
