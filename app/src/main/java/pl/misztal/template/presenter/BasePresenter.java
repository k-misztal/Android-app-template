package pl.misztal.template.presenter;


import android.os.Bundle;

public abstract class BasePresenter<CALLBACKS extends Callbacks> {
    private CALLBACKS callbacks;

    public BasePresenter() {
    }

    public void onCreate(Bundle savedInstanceState) {

    }

    @SuppressWarnings("unchecked")
    public void onAttach(Object callbacks) {
        this.callbacks = (CALLBACKS) callbacks;
    }

    public void onDetach() {
        callbacks = null;
    }

    public void onSaveInstanceState(Bundle outState) {

    }

    protected CALLBACKS getCallbacks() {
        return callbacks;
    }
}