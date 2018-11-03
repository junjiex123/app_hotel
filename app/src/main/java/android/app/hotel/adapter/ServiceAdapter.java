package android.app.hotel.adapter;

import android.app.hotel.R;
import android.app.hotel.model.room.Room;
import android.app.hotel.model.service.Service;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ServiceAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Service> services;
    private RecyclerView.ViewHolder viewHolder = null;

    public ServiceAdapter(Context context, int layout, List<Service> services) {
        this.context = context;
        this.layout = layout;
        this.services = services;
    }

    public class ViewHolder {
        public TextView txtName;
    }


    @Override
    public int getCount() {
        return services.size();
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


            vi.setTag(holder);
        } else {
            holder = (ViewHolder) vi.getTag();
        }

        holder.txtName.setText(services.get(position).getName());


        return vi;
    }
}
