package android.app.hotel.service.room;

import android.app.hotel.service.RoomAPI;
import android.app.hotel.service.ServiceAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceService {
    private Retrofit retrofit;

    public ServiceAPI getAPI(){
        String BASE_URL = "https://apihotel.herokuapp.com/";

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ServiceAPI.class);
    }
}
