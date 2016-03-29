package pl.misztal.template;

import android.app.Application;

import pl.misztal.template.dagger.component.ApplicationComponent;
import pl.misztal.template.dagger.component.DaggerApplicationComponent;
import pl.misztal.template.dagger.module.ApplicationModule;
import timber.log.Timber;

public class App extends Application {
    private static ApplicationComponent component;

    @Override
    public void onCreate() {
        initializeDagger();
        super.onCreate();
        initializeTimber();
    }

    private void initializeTimber() {
        if (BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree());

    }

    private void initializeDagger() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static ApplicationComponent getComponent() {
        return component;
    }
}
