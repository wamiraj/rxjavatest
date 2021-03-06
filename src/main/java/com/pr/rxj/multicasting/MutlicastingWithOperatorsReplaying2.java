package com.pr.rxj.multicasting;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class MutlicastingWithOperatorsReplaying2 {
    public static void main(String[] args) {
        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS)
                .replay(1)
                .autoConnect();

        //Observable1
        seconds.take(5).subscribe(s -> System.out.println("Observer 1: " + s));

        sleep(3000);


        //Observer2
        seconds.take(2).subscribe(s -> System.out.println("Observer 2: " + s));

        sleep(3000);

    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
