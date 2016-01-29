package pl.misztal.template.model.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import pl.misztal.template.BuildConfig;

public class HttpClientFactory {

    private HttpClientFactory() {
    }

    public static OkHttpClient build() {

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor())
                .build();

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
