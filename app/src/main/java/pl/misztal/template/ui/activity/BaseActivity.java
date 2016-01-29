package pl.misztal.template.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pl.misztal.template.App;
import pl.misztal.template.injection.component.ActivityComponent;
import pl.misztal.template.injection.component.DaggerActivityComponent;
import pl.misztal.template.injection.module.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity {
    private ActivityComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initializeInjector();
        super.onCreate(savedInstanceState);
        inject();
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

    public void showLoadingDialog(String title, String message) {
        //TODO
    }

    public void hideLoadingDialog() {
        //TODO
    }
}
