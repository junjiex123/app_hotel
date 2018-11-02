package android.app.hotel.service.post;

import android.app.hotel.service.PostAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostService {
    private Retrofit retrofit;

    public PostAPI getAPI(){
        String BASE_URL = "https://apihotel.herokuapp.com/";

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(PostAPI.class);
    }
}
