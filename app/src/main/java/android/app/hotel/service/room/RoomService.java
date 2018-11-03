package android.app.hotel.service.room;

import android.app.hotel.service.RoomAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RoomService {
    private Retrofit retrofit;

    public RoomAPI getAPI(){
        String BASE_URL = "https://apihotel.herokuapp.com/";

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RoomAPI.class);
    }
}
