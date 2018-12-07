package tw.lee.howard.zoodemo.data;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataClient {
    private final static String BASE_URL = "https://data.taipei/opendata/datalist/";
    public final static String SCOPE = "resourceAquire";
    public final static String ZOO_VENUE_RID = "5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a";
    public final static String ZOO_PLANT_RID = "f18de02f-b6c9-47c0-8cda-50efad621c14";
    public final static String ZOO_VENUE_URL = "https://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a";
    public final static String ZOO_PLANT_URL = "https://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=f18de02f-b6c9-47c0-8cda-50efad621c14";

    public static DataService create() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build();
        return retrofit.create(DataService.class);
    }
}