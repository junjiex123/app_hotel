package android.app.hotel.adapter;

import android.app.hotel.R;
import android.app.hotel.model.home.Home;
import android.app.hotel.view.room.RoomDetail;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Home> homes;
    private RecyclerView.ViewHolder viewHolder = null;

    public HomeAdapter(Context context, int layout, List<Home> homes) {
        this.context = context;
        this.layout = layout;
        this.homes = homes;
    }

    @Override
    public int getCount() {
        return homes.size();
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
        public TextView txtName, txtDescription, txtPrice;
        private ImageView imgRoom;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolder holder;

        if (convertView == null){
            LayoutInflater inflater;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(layout, null);

            holder = new ViewHolder();
            holder.txtName = (TextView) vi.findViewById(R.id.txtName);
            holder.imgRoom = (ImageView) vi.findViewById(R.id.imgRoom);
            holder.txtDescription = (TextView) vi.findViewById(R.id.txtDescription);
            holder.txtPrice = (TextView) vi.findViewById(R.id.txtPrice);

            vi.setTag(holder);
        } else {
            holder = (ViewHolder) vi.getTag();
        }

        holder.txtName.setText(homes.get(position).getName());
        holder.txtDescription.setText(homes.get(position).getShortDescription());
        holder.txtPrice.setText(homes.get(position).getPrice() + " Vnđ / Đêm");
        Picasso.get().load(homes.get(position).getLinkImg()).into(holder.imgRoom);

        final int _position = position;
        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),RoomDetail.class);
                intent.putExtra("name", homes.get(_position).getName());
                intent.putExtra("price", "" +homes.get(_position).getPrice());
                intent.putExtra("image", homes.get(_position).getLinkImg());
                intent.putExtra("acreage", "" + homes.get(_position).getAcreage());
                intent.putExtra("description", homes.get(_position).getDescription());

                v.getContext().startActivity(intent);

            }
        });


        return vi;
    }
    public void setData(List<Home> homes) {
        this.homes.clear();
        this.homes = homes;
    }
}
