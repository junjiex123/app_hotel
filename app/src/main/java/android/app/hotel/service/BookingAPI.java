package android.app.hotel.service;

import android.app.hotel.model.service.RestResponseService;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BookingAPI {

    @GET("api/v1/bookings")
    Call<RestResponseService>  getResults();
}
