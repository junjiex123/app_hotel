package android.app.hotel.adapter;

import android.app.hotel.R;
import android.app.hotel.model.service.Service;
import android.app.hotel.model.service.ServiceCategory;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ServiceAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<ServiceCategory> serviceCategories;
    private RecyclerView.ViewHolder viewHolder = null;

    public ServiceAdapter(Context context, int layout, List<ServiceCategory> serviceCategories) {
        this.context = context;
        this.layout = layout;
        this.serviceCategories = serviceCategories;
    }

    public class ViewHolder {
        public TextView txtName;
    }


    @Override
    public int getCount() {
        return serviceCategories.size();
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


            LinearLayout servicesLayout = vi.findViewById(R.id.layoutServices);
            final View _vi = vi;
            final LinearLayout _servicesLayout = servicesLayout;
            holder.txtName = (TextView) vi.findViewById(R.id.txtName);
            final ImageButton expandButton = vi.findViewById(R.id.btnExpand);

            expandButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int arrowID = android.R.drawable.arrow_down_float;
                    int expandStaus = _servicesLayout.getVisibility();
                    if(expandStaus == View.VISIBLE) {
                        expandStaus = View.GONE;
                        arrowID = android.R.drawable.arrow_down_float;
                    } else {
                        expandStaus = View.VISIBLE;
                        arrowID = android.R.drawable.arrow_up_float;

                    }
                    _servicesLayout.setVisibility(expandStaus);
                    expandButton.setBackgroundResource(arrowID);
                }
            });


//            int arrowID = android.R.drawable.arrow_down_float;
//            int expandStaus = _servicesLayout.getVisibility();
//            if(expandStaus == View.VISIBLE) {
//                expandStaus = View.GONE;
//                arrowID = android.R.drawable.arrow_down_float;
//            } else {
//                expandStaus = View.VISIBLE;
//                arrowID = android.R.drawable.arrow_up_float;
//
//            }
//            _servicesLayout.setVisibility(expandStaus);
//            expandButton.setBackgroundResource(arrowID);

            List<Service> services = serviceCategories.get(position).getServices();

            for (Service service: services) {
                TextView serviceName = new TextView(vi.getContext());
                serviceName.setText(service.getNameService());
                serviceName.setTextSize(18);
                _servicesLayout.addView(serviceName);
            }

            vi.setTag(holder);
        } else {
            holder = (ViewHolder) vi.getTag();

        }

        holder.txtName.setText(serviceCategories.get(position).getName());


        return vi;
    }
}
