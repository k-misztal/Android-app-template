package pl.misztal.template.presenter.activity;

import android.os.Bundle;

import pl.misztal.template.ui.activity.BasePresenterActivity;

public class BasePresenter {
    private BasePresenterActivity activity;

    public BasePresenter() {
    }

    public void onCreate(Bundle savedInstanceState) {

    }

    public void onAttach(BasePresenterActivity activity) {
        this.activity = activity;
    }

    public void onDetach() {
        activity = null;
    }

    public void onSaveInstanceState(Bundle outState) {

    }

    protected BasePresenterActivity getActivity() {
        return activity;
    }
}
