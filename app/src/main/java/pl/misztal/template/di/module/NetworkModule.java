package pl.misztal.template.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
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
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            try {
                final Interceptor interceptor = (Interceptor) Class.forName("com.facebook.stetho.okhttp3.StethoInterceptor").newInstance();
                builder.addNetworkInterceptor(interceptor);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return builder.build();
    }

    Gson provideGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

        return builder.create();
    }

}
