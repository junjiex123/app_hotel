package android.app.hotel.service;

import android.app.hotel.model.home.RestResponseHome;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HomeAPI {

    @GET("api/v1/rooms/222222")
    Call<RestResponseHome>  getResults();

}
