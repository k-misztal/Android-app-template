package pl.misztal.template;

import android.os.Handler;

import javax.inject.Inject;

import pl.misztal.template.injection.scope.PerActivity;
import pl.misztal.template.model.DataManager;
import pl.misztal.template.ui.activity.BaseActivity;

@PerActivity
public class ExceptionHandler {
    BaseActivity activity;
    DataManager dataManager;

    @Inject
    public ExceptionHandler(BaseActivity activity, DataManager dataManager) {
        this.activity = activity;
        this.dataManager = dataManager;
    }

    public void onException(final Throwable e) {
        Handler handler = new Handler(activity.getMainLooper());
        handler.post(() -> handleException(e));
    }

    private void handleException(Throwable t) {

    }
}
