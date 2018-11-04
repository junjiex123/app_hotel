package android.app.hotel.service.booking;

import android.app.hotel.service.BookingAPI;
import android.app.hotel.service.ServiceAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookingService {
    private Retrofit retrofit;

    public BookingAPI getAPI(){
        String BASE_URL = "https://apihotel.herokuapp.com/";

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(BookingAPI.class);
    }
}
