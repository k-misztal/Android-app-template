package pl.misztal.template.presenter.fragment;

import android.os.Bundle;

import pl.misztal.template.ui.fragment.BasePresenterFragment;

public class BasePresenter<FRAGMENT extends BasePresenterFragment> {
    private FRAGMENT fragment;

    public void onCreate(Bundle savedInstanceState) {
    }

    public void onAttach(FRAGMENT fragment) {
        this.fragment = fragment;
    }

    public void onDetach() {
        fragment = null;
    }

    public void onSaveInstanceState(Bundle outState) {
    }

    protected FRAGMENT getFragment() {
        return fragment;
    }
}
