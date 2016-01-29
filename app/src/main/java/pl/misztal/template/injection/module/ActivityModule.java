package pl.misztal.template.injection.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import pl.misztal.template.injection.scope.PerActivity;
import pl.misztal.template.ui.activity.BaseActivity;

@Module
public class ActivityModule {
    final BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    public BaseActivity provideActivity() {
        return activity;
    }

    @Provides
    @PerActivity
    public FragmentManager provideFragmentManager() {
        return activity.getSupportFragmentManager();
    }
}
