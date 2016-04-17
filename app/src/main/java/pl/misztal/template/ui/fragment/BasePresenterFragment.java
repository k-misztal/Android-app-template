package pl.misztal.template.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import pl.misztal.template.presenter.BasePresenter;
import pl.misztal.template.presenter.Callbacks;

public abstract class BasePresenterFragment extends BaseFragment implements Callbacks {

    @Override
    protected void onAttachToContext(Context context) {
        super.onAttachToContext(context);
        getPresenter().onAttach(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().onCreate(savedInstanceState);
    }

    @Override
    public void onDetach() {
        getPresenter().onDetach();
        super.onDetach();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        getPresenter().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void showError(String message) {
        showErrorMessage(message);
    }

    protected abstract BasePresenter getPresenter();
}
