package pl.misztal.template.di.module.provider;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Inject;
import javax.inject.Provider;

import okhttp3.OkHttpClient;
import pl.misztal.template.BuildConfig;
import pl.misztal.template.model.api.RestService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestServiceProvider implements Provider<RestService> {

    private final OkHttpClient client;
    private final Gson gson;

    @Inject
    public RestServiceProvider(OkHttpClient client, Gson gson) {
        this.client = client;
        this.gson = gson;
    }


    @Override
    public RestService get() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.ENDPOINT)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(RestService.class);
    }
}
