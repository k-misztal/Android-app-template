package pl.misztal.template.presenter;


import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

public abstract class RxPresenter<CALLBACKS extends Callbacks> extends BasePresenter<CALLBACKS> {

    private List<Subscription> subscriptions = new ArrayList<>(5);

    @Override
    public void onDetach() {
        super.onDetach();
        for (Subscription subscription : subscriptions) {
            if (subscription != null && !subscription.isUnsubscribed())
                subscription.unsubscribe();

        }
    }

    /**
     * Remembers subscribtion to unsubscribe it if needed.
     *
     * @param subscription
     */
    protected void subscribe(Subscription subscription) {
        subscriptions.add(subscription);
    }
}