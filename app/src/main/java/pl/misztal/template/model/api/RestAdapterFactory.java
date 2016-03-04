package pl.misztal.template.model.api;

import pl.misztal.template.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestAdapterFactory {

    private RestAdapterFactory() {
    }

    public static Retrofit create() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.ENDPOINT)
                .client(HttpClientFactory.build())
                .addConverterFactory(GsonConverterFactory.create(GsonFactory.create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}