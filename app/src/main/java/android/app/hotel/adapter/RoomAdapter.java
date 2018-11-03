package android.app.hotel.adapter;

import android.app.hotel.R;
import android.app.hotel.model.room.Room;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RoomAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Room> rooms;
    private RecyclerView.ViewHolder viewHolder = null;

    public RoomAdapter(Context context, int layout, List<Room> rooms) {
        this.context = context;
        this.layout = layout;
        this.rooms = rooms;
    }

    public class ViewHolder {
        public TextView txtName, txtDescription, txtPrice;
        private ImageView imgRoom;
    }


    @Override
    public int getCount() {
        return rooms.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
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

        holder.txtName.setText(rooms.get(position).getName());
        holder.txtDescription.setText(rooms.get(position).getShortDescription());
        holder.txtPrice.setText(rooms.get(position).getPrice() + " Vnđ / Đêm");
        Picasso.get().load(rooms.get(position).getLinkImg()).into(holder.imgRoom);

        return vi;
    }
}
