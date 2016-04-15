package pl.misztal.template.ui.activity;

import android.os.Bundle;

import pl.misztal.template.presenter.BasePresenter;

public abstract class BasePresenterActivity extends BaseActivity implements BasePresenter.Callbacks{
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

    @Override
    public void showError(String message) {
        showErrorMessage(message);
    }

    protected abstract BasePresenter getPresenter();
}
