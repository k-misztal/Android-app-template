package pl.misztal.template.presenter.activity;

import android.os.Bundle;

import pl.misztal.template.ui.activity.BasePresenterActivity;

public class BasePresenter<CALLBACKS> {
    private BasePresenterActivity activity;
    private CALLBACKS callbacks;

    public BasePresenter() {
    }

    public void onCreate(Bundle savedInstanceState) {

    }

    @SuppressWarnings("unchecked")
    public void onAttach(BasePresenterActivity activity) {
        this.activity = activity;
        this.callbacks = (CALLBACKS) activity;
    }

    public void onDetach() {
        activity = null;
    }

    public void onSaveInstanceState(Bundle outState) {

    }

    protected BasePresenterActivity getActivity() {
        return activity;
    }

    protected CALLBACKS getCallbacks() {
        return callbacks;
    }
}
