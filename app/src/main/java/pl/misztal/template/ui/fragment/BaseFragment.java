package pl.misztal.template.ui.fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;

import butterknife.ButterKnife;
import pl.misztal.template.injection.component.DaggerFragmentComponent;
import pl.misztal.template.injection.component.FragmentComponent;
import pl.misztal.template.injection.module.FragmentModule;
import pl.misztal.template.ui.activity.BaseActivity;

public abstract class BaseFragment extends Fragment {
    private FragmentComponent fragmentComponent;

    @TargetApi(23)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onAttachToContext(context);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            onAttachToContext(activity);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
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
