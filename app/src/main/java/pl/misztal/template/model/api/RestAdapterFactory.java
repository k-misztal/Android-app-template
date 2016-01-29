package pl.misztal.template.model.api;

import pl.misztal.template.BuildConfig;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class RestAdapterFactory {

    private RestAdapterFactory() {
    }

    public static Retrofit create() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.ENDPOINT)
                .client(HttpClientFactory.build())
                .addConverterFactory(GsonConverterFactory.create(GsonFactory.create()))
                .build();
    }

}