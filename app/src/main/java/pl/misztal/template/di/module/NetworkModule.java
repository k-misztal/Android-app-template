package pl.misztal.template.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import pl.misztal.template.BuildConfig;
import pl.misztal.template.di.module.provider.RestServiceProvider;
import pl.misztal.template.model.api.RestService;
import toothpick.config.Module;

public class NetworkModule extends Module {

    public NetworkModule() {
        bind(Gson.class).toInstance(provideGson());
        bind(OkHttpClient.class).toInstance(provideOkHttpClient());
        bind(RestService.class).toProvider(RestServiceProvider.class);
    }


    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor())
                .build();
    }

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
