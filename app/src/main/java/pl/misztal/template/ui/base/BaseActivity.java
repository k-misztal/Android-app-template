package pl.misztal.template.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpView;

import pl.misztal.template.ExceptionHandler;
import pl.misztal.template.di.scope.ActivitySingleton;
import toothpick.Scope;
import toothpick.Toothpick;
import toothpick.smoothie.module.SmoothieSupportActivityModule;

public abstract class BaseActivity<V extends MvpView, P extends BasePresenter<V>> extends MvpActivity<V, P> {
    ProgressDialog progressDialog;

    protected ExceptionHandler exceptionHandler;
    protected Scope scope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initializeInjector();
        super.onCreate(savedInstanceState);
        inject();
    }

    @Override
    protected void onDestroy() {
        dismissProgressDialog();
        Toothpick.closeScope(this);
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
        Toothpick.inject(this, scope);
    }

    private void initializeInjector() {
        scope = Toothpick.openScopes(getApplication(), this);
        scope.installModules(new SmoothieSupportActivityModule(this));
        scope.bindScopeAnnotation(ActivitySingleton.class);
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
