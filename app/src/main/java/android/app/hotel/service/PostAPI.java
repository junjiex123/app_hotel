package android.app.hotel.service;

import android.app.hotel.model.post.RestResponsePost;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostAPI {

    @GET("api/v1/admin/posts")
    Call<RestResponsePost>  getResults();
}
