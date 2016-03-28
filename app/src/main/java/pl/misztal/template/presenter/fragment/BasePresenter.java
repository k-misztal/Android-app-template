package pl.misztal.template.presenter.fragment;

import android.os.Bundle;

import pl.misztal.template.ui.fragment.BasePresenterFragment;

public class BasePresenter<CALLBACKS> {
    private BasePresenterFragment fragment;
    private CALLBACKS callbacks;

    public void onCreate(Bundle savedInstanceState) {
    }

    @SuppressWarnings("unchecked")
    public void onAttach(BasePresenterFragment fragment) {
        this.fragment = fragment;
        this.callbacks = (CALLBACKS) fragment;
    }

    public void onDetach() {
        fragment = null;
    }

    public void onSaveInstanceState(Bundle outState) {
    }

    protected BasePresenterFragment getFragment() {
        return fragment;
    }

    protected CALLBACKS getCallbacks() {
        return callbacks;
    }
}
