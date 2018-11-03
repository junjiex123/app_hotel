package android.app.hotel.presenter;

import android.app.hotel.model.post.Post;
import android.app.hotel.model.post.RestResponsePost;
import android.app.hotel.service.post.PostService;
import android.app.hotel.view.post.PostView;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostPresenter {
    private PostView postView;
    private PostService postService;
    private RestResponsePost restResponsePost;

    public PostPresenter(PostView postViewa) {
        this.postView = postViewa;
        if (postService == null) {
            postService = new PostService();
        }
    }

    public void getposts(){
        postService
                .getAPI()
                .getResults()
                .enqueue(new Callback<RestResponsePost>() {
                    @Override
                    public void onResponse(Call<RestResponsePost> call, Response<RestResponsePost> response) {
                        restResponsePost = response.body();

                        if (restResponsePost != null && restResponsePost.getData() != null){
                            List<Post> result = restResponsePost.getData();
                            postView.postRead(result);
                        }
                    }

                    @Override
                    public void onFailure(Call<RestResponsePost> call, Throwable t) {
                        try {
                            throw  new InterruptedException("Something went wrong");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}


