package pl.misztal.template.ui.base;

import android.app.Activity;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.hannesdorfmann.mosby.mvp.MvpView;

import butterknife.Unbinder;
import pl.misztal.template.di.scope.FragmentSingleton;
import toothpick.Scope;
import toothpick.Toothpick;

public abstract class BaseFragment<V extends MvpView, P extends BasePresenter<V>> extends MvpFragment<V, P> {
    private Scope scope;
    protected Unbinder unbinder;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        initToothpick();
        inject();
    }

    @Override
    public void onDestroyView() {
        if (unbinder != null) {
            unbinder.unbind();
        }

        super.onDestroyView();
    }

    protected void inject() {
        Toothpick.inject(this, scope);
    }

    private void initToothpick() {
        scope = Toothpick.openScopes(getActivity().getApplication(), this);
        scope.bindScopeAnnotation(FragmentSingleton.class);
    }

    public void showError(Throwable e, boolean pullToRefresh) {
        ((BaseActivity) getActivity()).showError(e, pullToRefresh);
    }

    public void showLoadingDialog(int titleResId, int messageResId) {
        //TODO;
    }

    public void showLoadingDialog(String title, String message) {
        //TODO
    }

    public void hideLoadingDialog() {
        //TODO
    }
}
