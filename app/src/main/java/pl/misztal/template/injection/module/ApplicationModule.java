package pl.misztal.template.injection.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import pl.misztal.template.App;
import pl.misztal.template.injection.scope.PerApplication;
import pl.misztal.template.model.api.RestAdapterFactory;
import pl.misztal.template.model.api.RestService;
import retrofit2.Retrofit;

@Module
public class ApplicationModule {
    final App app;

    public ApplicationModule(App app) {
        this.app = app;
    }

    @Provides
    @PerApplication
    App provideApplication() {
        return app;
    }

    @Provides
    @PerApplication
    Context provideApplicationContext() {
        return app.getApplicationContext();
    }

    @Provides
    @PerApplication
    RestService provideRestService() {
        Retrofit retrofit = RestAdapterFactory.create();
        return retrofit.create(RestService.class);
    }
}
