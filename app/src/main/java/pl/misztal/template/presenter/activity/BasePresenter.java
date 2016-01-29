package pl.misztal.template.presenter.activity;

import android.os.Bundle;

import pl.misztal.template.ui.activity.BasePresenterActivity;

public class BasePresenter<ACTIVITY extends BasePresenterActivity> {
    private ACTIVITY activity;

    public BasePresenter() {
    }

    public void onCreate(Bundle savedInstanceState) {

    }

    public void onAttach(ACTIVITY activity) {
        this.activity = activity;
    }

    public void onDetach() {
        activity = null;
    }

    public void onSaveInstanceState(Bundle outState) {

    }

    protected ACTIVITY getActivity() {
        return activity;
    }
}
