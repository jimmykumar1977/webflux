package app.bootstrap;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.atomic.AtomicInteger;

public class JSubscriber implements Subscriber<String> {

    private Subscription subscription;
    private AtomicInteger a = new  AtomicInteger(0);

    @Override
    public void onSubscribe(Subscription s) {
        subscription = s;
        System.out.println(" onSubscribe got = "+s);

        subscription.request(1);
    }

    @Override
    public void onNext(String s) {
        System.out.println("onNext got :"+s);
        int i = a.incrementAndGet();
        if (i==3){
            throw new RuntimeException("error ");
        }

        subscription.request(1);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("onError "+t);
    }

    @Override
    public void onComplete() {
        System.out.println("onComplete");
    }
}
