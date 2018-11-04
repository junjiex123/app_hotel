package android.app.hotel.service.home;

import android.app.hotel.model.home.RestResponseHome;
import android.app.hotel.service.HomeAPI;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeService {
    private Retrofit retrofit;

    public HomeAPI getAPI(){
        String BASE_URL = "https://apihotel.herokuapp.com";

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(HomeAPI.class);
    }
}
