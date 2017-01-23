package pl.misztal.template.dagger.module;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import pl.misztal.template.App;
import pl.misztal.template.BuildConfig;
import pl.misztal.template.dagger.scope.PerApplication;
import pl.misztal.template.model.api.RestService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    final App app;

    public NetworkModule(App app) {
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
    RestService provideRestService(OkHttpClient client, Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.ENDPOINT)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(RestService.class);
    }

    @Provides
    @PerApplication
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor())
                .build();
    }

    @Provides
    @PerApplication
    Gson provideGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

        return builder.create();
    }

    private static HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

        if (BuildConfig.DEBUG)
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        else
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);

        return loggingInterceptor;
    }
}
