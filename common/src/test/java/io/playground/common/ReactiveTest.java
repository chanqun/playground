package io.playground.common;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.junit.jupiter.api.Test;

public class ReactiveTest {

    @Test
    void reactive() throws InterruptedException {
        Observable.just(100, 200, 200, 400, 500)
                .doOnNext(data -> System.out.println(getThreadName() + " : doOnNext() :" + data))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .filter(number -> number > 300)
                .subscribe(num -> System.out.println(getThreadName() + " : result :" + num));

        Thread.sleep(500);
    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }
}
