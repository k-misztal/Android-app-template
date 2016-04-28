package pl.misztal.template.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import pl.misztal.template.App;
import pl.misztal.template.dagger.component.ActivityComponent;
import pl.misztal.template.dagger.component.DaggerActivityComponent;
import pl.misztal.template.dagger.module.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity {
    private ActivityComponent component;
    ProgressDialog progressDialog;

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
        // no injection by default in activities
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

    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        // TODO: 28.04.2016
    }
}
