package pl.misztal.template.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import pl.misztal.template.presenter.fragment.BasePresenter;

public abstract class BasePresenterFragment extends BaseFragment {

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

    protected abstract BasePresenter getPresenter();
}
