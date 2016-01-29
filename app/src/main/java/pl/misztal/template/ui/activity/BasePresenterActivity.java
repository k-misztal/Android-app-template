package pl.misztal.template.ui.activity;

import android.os.Bundle;

import pl.misztal.template.presenter.activity.BasePresenter;

public abstract class BasePresenterActivity<PRESENTER extends BasePresenter> extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().onCreate(savedInstanceState);
        getPresenter().onAttach(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        getPresenter().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        getPresenter().onDetach();
        super.onDestroy();
    }

    protected abstract PRESENTER getPresenter();
}
