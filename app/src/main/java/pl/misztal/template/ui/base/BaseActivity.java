package pl.misztal.template.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpView;

import pl.misztal.template.App;
import pl.misztal.template.ExceptionHandler;
import pl.misztal.template.dagger.component.ActivityComponent;
import pl.misztal.template.dagger.component.DaggerActivityComponent;
import pl.misztal.template.dagger.module.ActivityModule;

public abstract class BaseActivity<V extends MvpView, P extends BasePresenter<V>> extends MvpActivity<V, P> {
    private ActivityComponent component;
    ProgressDialog progressDialog;

    protected ExceptionHandler exceptionHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initializeInjector();
        super.onCreate(savedInstanceState);
        inject();
    }

    @Override
    protected void onDestroy() {
        dismissProgressDialog();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else
            super.onBackPressed();
    }

    protected void inject() {
        exceptionHandler = getComponent().exceptionHandler();
    }

    public ActivityComponent getComponent() {
        return component;
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    private void initializeInjector() {
        if (component == null)
            component = DaggerActivityComponent.builder()
                    .applicationComponent(App.getComponent())
                    .activityModule(getActivityModule())
                    .build();
    }

    public void showProgressDialog(int titleRes, int messageRes) {
        showProgressDialog(getString(titleRes), getString(messageRes));
    }

    public void showProgressDialog(String title, String message) {
        dismissProgressDialog();
        progressDialog = ProgressDialog.show(this, title, message);
    }

    public void dismissProgressDialog() {
        if (progressDialog != null)
            progressDialog.dismiss();

        progressDialog = null;
    }

    public void showError(Throwable e, boolean pullToRefresh) {
        String messageError = exceptionHandler.getMessageError(e);
        Toast.makeText(this, messageError, Toast.LENGTH_SHORT).show();

        // TODO: 22.01.2017
    }
}