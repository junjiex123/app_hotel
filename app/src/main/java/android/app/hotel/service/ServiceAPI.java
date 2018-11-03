package android.app.hotel.service;

import android.app.hotel.model.room.RestResponse;
import android.app.hotel.model.service.RestResponseService;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceAPI {

    @GET("api/v1/admin/categories")
    Call<RestResponseService>  getResults();
}
