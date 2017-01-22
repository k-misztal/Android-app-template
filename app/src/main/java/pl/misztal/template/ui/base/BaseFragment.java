package pl.misztal.template.ui.base;

import android.content.Context;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.hannesdorfmann.mosby.mvp.MvpView;

import butterknife.Unbinder;
import pl.misztal.template.dagger.component.DaggerFragmentComponent;
import pl.misztal.template.dagger.component.FragmentComponent;
import pl.misztal.template.dagger.module.FragmentModule;

public abstract class BaseFragment<V extends MvpView, P extends BasePresenter<V>> extends MvpFragment<V, P> {
    private FragmentComponent fragmentComponent;
    protected Unbinder unbinder;

    @Override
    public void onDestroyView() {
        if (unbinder != null) {
            unbinder.unbind();
        }

        super.onDestroyView();
    }

    protected void inject() {
        //no injection by default
    }

    private void initDagger() {
        fragmentComponent = DaggerFragmentComponent.builder()
                .activityComponent(((BaseActivity) getActivity()).getComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    public final FragmentComponent getComponent() {
        return fragmentComponent;
    }

    protected void onAttachToContext(Context context) {
        initDagger();
        inject();
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
