package pl.misztal.template.presenter.fragment;

import android.os.Bundle;

import pl.misztal.template.ui.fragment.BasePresenterFragment;

public class BasePresenter {
    private BasePresenterFragment fragment;

    public void onCreate(Bundle savedInstanceState) {
    }

    public void onAttach(BasePresenterFragment fragment) {
        this.fragment = fragment;
    }

    public void onDetach() {
        fragment = null;
    }

    public void onSaveInstanceState(Bundle outState) {
    }

    protected BasePresenterFragment getFragment() {
        return fragment;
    }
}
