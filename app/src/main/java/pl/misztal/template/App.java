package pl.misztal.template;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import pl.misztal.template.dagger.component.ApplicationComponent;
import pl.misztal.template.dagger.component.DaggerApplicationComponent;
import pl.misztal.template.dagger.module.NetworkModule;
import timber.log.Timber;

public class App extends Application {
    private static ApplicationComponent component;

    @Override
    public void onCreate() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }

        initializeDagger();
        super.onCreate();
        initializeTimber();
        LeakCanary.install(this);
    }

    private void initializeTimber() {
        if (BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree());

    }

    private void initializeDagger() {
        component = DaggerApplicationComponent.builder()
                .networkModule(new NetworkModule(this))
                .build();
    }

    public static ApplicationComponent getComponent() {
        return component;
    }
}
