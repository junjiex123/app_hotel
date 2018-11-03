package android.app.hotel.service;

import android.app.hotel.model.room.RestResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RoomAPI {

    @GET("api/v1/admin/rooms")
    Call<RestResponse>  getResults();
}
