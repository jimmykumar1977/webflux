package app.bootstrap;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class LogSubscriber  implements Subscriber<String> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription s) {
        subscription = s;
        System.out.println(" onSubscribe LOGG "+s);
        subscription.request(1);
    }

    @Override
    public void onNext(String s) {
        System.out.println("onNext LOGG "+s);
        subscription.request(1);

    }

    @Override
    public void onError(Throwable t) {
        System.out.println("onError "+t);

    }

    @Override
    public void onComplete() {
        System.out.println("onComplete LOGG");
    }
}
