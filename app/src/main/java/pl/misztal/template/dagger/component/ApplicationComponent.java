package pl.misztal.template.dagger.component;

import android.content.Context;

import dagger.Component;
import pl.misztal.template.App;
import pl.misztal.template.ExceptionHandler;
import pl.misztal.template.dagger.module.ApplicationModule;
import pl.misztal.template.dagger.scope.PerApplication;
import pl.misztal.template.model.DataManager;

@PerApplication
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(App app);

    App app();

    Context applicationContext();

    DataManager dataManager();

    ExceptionHandler exceptionHandler();

}
