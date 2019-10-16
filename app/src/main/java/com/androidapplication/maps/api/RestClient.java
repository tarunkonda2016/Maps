package com.androidapplication.maps.api;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.androidapplication.maps.Constants;
import com.androidapplication.maps.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private static String TAG = RestClient.class.getName();
    private static HPCLApi API_CLIENT;
    private static Retrofit retrofit;
    String authKey_global;
    private Context context;

    public RestClient(Context context, String authKey) {
        this.context = context;
        setupRestClient(authKey);
    }

    public static HPCLApi getApiClient() {
        return API_CLIENT;
    }

    public static Retrofit retrofit() {
        return retrofit;
    }

    public void setupRestClient(final String authKey) {
        OkHttpClient.Builder builderOkHttp = new OkHttpClient.Builder();
        int TIME_OUT_DURATION = 300;
        builderOkHttp.connectTimeout(TIME_OUT_DURATION, TimeUnit.SECONDS);
        builderOkHttp.readTimeout(TIME_OUT_DURATION, TimeUnit.SECONDS);
        builderOkHttp.writeTimeout(TIME_OUT_DURATION, TimeUnit.SECONDS);
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builderOkHttp.addInterceptor(httpLoggingInterceptor);
        builderOkHttp.networkInterceptors().add(new Interceptor() {
            @Override
            public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
                Request.Builder requestBuilder = chain.request().newBuilder();
                requestBuilder.addHeader("Content-Type", "application/json");
                requestBuilder.addHeader("browser", "");
                requestBuilder.addHeader("source", "2");
                if (authKey != null && authKey.trim().length() > 0) {
                    requestBuilder.addHeader("Authorization", "Bearer " + authKey);
                }
                return chain.proceed(requestBuilder.build());
            }
        });


        OkHttpClient client = builderOkHttp.build();
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.LOCAL_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        API_CLIENT = retrofit.create(HPCLApi.class);
    }

    /**
     * Return default time zone. e.g "Asia/Calcutta"
     */
    public String getTimeZone() {
        String timeZone = TimeZone.getDefault().getID();
        return timeZone;
    }


    @SuppressWarnings("unchecked")
    public void makeApiRequest(final Context activity, Object call, final ApiResponseListener apiResponseListener, final int reqCode, boolean showProgressDialog) {
        try {

            if (Utils.getInstance().isNetworkAvailable(activity)) {


                final Call<Object> objectCall = (Call<Object>) call;
                objectCall.enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(@NonNull Call<Object> call, @NonNull retrofit2.Response<Object> response) {

                        /** Returns true if code() is in the range [200..300). */
                        if (response.isSuccessful()) {
                                apiResponseListener.onApiResponse(call, response, reqCode);

                        } else {
                            Toast.makeText(activity, "error", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<Object> call, @NonNull Throwable t) {
                        //there is more than just a failing request (like: no internet connection)
                        Toast.makeText(activity, "error", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Toast.makeText(activity, "error", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(activity, "error", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Return Error message.
     * If error code is 404 then return error message which comes in error body.
     * For other ocde just return name of error(e.g Unauthorization, Bad Request)
     */



}

/*****
 * l 151
 *
 *     try {
 String object= response.errorBody().string();
 apiResponseListener.onApiError(call, object, reqCode);
 } catch (IOException e) {
 e.printStackTrace();
 apiResponseListener.onApiError(call, errorMessage, reqCode);
 }
 *
 */
