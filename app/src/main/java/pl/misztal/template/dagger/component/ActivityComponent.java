package pl.misztal.template.dagger.component;

import android.content.Context;

import dagger.Component;
import pl.misztal.template.App;
import pl.misztal.template.ExceptionHandler;
import pl.misztal.template.dagger.module.ActivityModule;
import pl.misztal.template.dagger.scope.PerActivity;
import pl.misztal.template.model.DataManager;
import pl.misztal.template.ui.base.BaseActivity;

@PerActivity
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {
    BaseActivity activity();

    Context context();

    App app();

    ExceptionHandler exceptionHandler();

    DataManager dataManager();
}
