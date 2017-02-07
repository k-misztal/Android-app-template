package pl.misztal.template;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import pl.misztal.template.di.module.DataModule;
import pl.misztal.template.di.module.NetworkModule;
import pl.misztal.template.di.module.SchedulerModule;
import timber.log.Timber;
import toothpick.Scope;
import toothpick.Toothpick;
import toothpick.configuration.Configuration;
import toothpick.registries.FactoryRegistryLocator;
import toothpick.registries.MemberInjectorRegistryLocator;
import toothpick.smoothie.module.SmoothieApplicationModule;

public class App extends Application {

    private static App app;
    private Scope scope;

    @Override
    public void onCreate() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }

        super.onCreate();
        app = this;

        initializeToothpick();
        initializeTimber();
        LeakCanary.install(this);
        // TODO: Add Crashlytics!
    }

    private void initializeToothpick() {
        Toothpick.setConfiguration(Configuration.forProduction().disableReflection());
        FactoryRegistryLocator.setRootRegistry(new pl.misztal.template.FactoryRegistry());
        MemberInjectorRegistryLocator.setRootRegistry(new pl.misztal.template.MemberInjectorRegistry());

        scope = Toothpick.openScope(this);
        scope.installModules(new SmoothieApplicationModule(this),
                new NetworkModule(), new DataModule(), new SchedulerModule());
    }

    private void initializeTimber() {
        if (BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree());

    }

    public static App get() {
        return app;
    }
}
