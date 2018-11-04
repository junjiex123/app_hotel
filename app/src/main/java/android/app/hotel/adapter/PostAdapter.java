package android.app.hotel.adapter;

import android.app.hotel.R;
import android.app.hotel.model.post.Post;
import android.app.hotel.model.room.Room;
import android.app.hotel.view.post.PostItent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PostAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Post> posts;
    private RecyclerView.ViewHolder viewHolder = null;

    public PostAdapter(Context context, int layout, List<Post> posts) {
        this.context = context;
        this.layout = layout;
        this.posts = posts;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class ViewHolder {
        public TextView txttieude, txtNoiDung, txtCreate, txtAdmin;
        private ImageView imgPost;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        PostAdapter.ViewHolder holder;

        if (convertView == null){
            LayoutInflater inflater;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(layout, null);

            holder = new PostAdapter.ViewHolder();
            holder.txttieude = (TextView) vi.findViewById(R.id.txtTieuDe);
            holder.imgPost = (ImageView) vi.findViewById(R.id.image);
            holder.txtNoiDung = (TextView) vi.findViewById(R.id.txtNoiDung);
            holder.txtCreate = (TextView) vi.findViewById(R.id.txtcreate);
            holder.txtAdmin = (TextView) vi.findViewById(R.id.txtadmin);

            vi.setTag(holder);
        } else {
            holder = (PostAdapter.ViewHolder) vi.getTag();
        }

        holder.txttieude.setText(posts.get(position).getTitle());
        holder.txtNoiDung.setText(posts.get(position).getShortDescription());
        holder.txtCreate.setText(posts.get(position).getAgo());
        holder.txtAdmin.setText(posts.get(position).getAdmin());
        Picasso.get().load(posts.get(position).getImage()).into(holder.imgPost);

        final int _position = position;
        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),PostItent.class);
                intent.putExtra("Title", posts.get(_position).getTitle());
                intent.putExtra("Image", posts.get(_position).getImage());
                intent.putExtra("Admin", posts.get(_position).getAdmin());
                intent.putExtra("Ago", posts.get(_position).getAgo());
                intent.putExtra("Tag", posts.get(_position).getTag());
                intent.putExtra("DescriptionLong", posts.get(_position).getLongDescription());
                v.getContext().startActivity(intent);

            }
        });

        return vi;
    }

    public void setData(List<Post> posts) {
        this.posts.clear();
        this.posts = posts;
    }

}
