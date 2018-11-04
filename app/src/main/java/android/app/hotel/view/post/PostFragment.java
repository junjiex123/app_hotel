package android.app.hotel.view.post;

import android.app.hotel.adapter.PostAdapter;
import android.app.hotel.model.post.Post;
import android.app.hotel.presenter.PostPresenter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.hotel.R;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostFragment extends Fragment implements PostView{

    private PostAdapter postAdapter;
    private ListView lvPost;
    PostPresenter postPresenter;


    public PostFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post, container, false);

        Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        toolbar.setTitle("Danh sách tin tức");
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        lvPost = (ListView) view.findViewById(R.id.listviewPost);

        postPresenter = new PostPresenter(this);
        postAdapter = new PostAdapter(this.getContext(), R.layout.view_post, PostPresenter.getPosts());
        lvPost.setAdapter(postAdapter);

        //update posts list
        postPresenter.retryPosts();

        return view;
    }

    @Override
    public void updateView(List<Post> posts) {
        try {
            postAdapter.setData(posts);
            postAdapter.notifyDataSetChanged();
        }catch (Exception e) {
            Log.d("POST:", "Error: " + e);
        }
    }

}
