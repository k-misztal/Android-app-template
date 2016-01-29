package pl.misztal.template.injection.component;

import android.content.Context;

import dagger.Component;
import pl.misztal.template.App;
import pl.misztal.template.ExceptionHandler;
import pl.misztal.template.injection.module.ActivityModule;
import pl.misztal.template.injection.scope.PerActivity;
import pl.misztal.template.model.DataManager;
import pl.misztal.template.ui.activity.BaseActivity;

@PerActivity
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    BaseActivity activity();

    Context context();

    App app();

    ExceptionHandler exceptionHandler();

    DataManager dataManager();
}
