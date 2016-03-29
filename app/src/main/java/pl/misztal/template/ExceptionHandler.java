package pl.misztal.template;

import android.content.Context;

import javax.inject.Inject;

import pl.misztal.template.dagger.scope.PerApplication;

@PerApplication
public class ExceptionHandler {
    Context context;

    @Inject
    public ExceptionHandler(Context activity) {
        this.context = context;
    }

    public String getMessageError(Throwable throwable) {
        return null;
    }

}
