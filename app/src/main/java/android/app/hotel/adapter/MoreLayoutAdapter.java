package android.app.hotel.adapter;

import android.app.hotel.R;
import android.app.hotel.model.more.MoreLayout;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MoreLayoutAdapter extends ArrayAdapter<MoreLayout>  {

    private final Context context;
    private final ArrayList<MoreLayout> moreLayouts;

    public MoreLayoutAdapter(Context context, ArrayList<MoreLayout> moreLayouts){
        super(context, R.layout.more_item, moreLayouts);

        this.context = context;
        this.moreLayouts = moreLayouts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = null;

        if (!moreLayouts.get(position).isGroupHeader()){
            view = inflater.inflate(R.layout.more_item, parent, false);

            ImageView imgView = (ImageView) view.findViewById(R.id.item_icon);
            TextView titleView = (TextView) view.findViewById(R.id.item_title);

            imgView.setImageResource(moreLayouts.get(position).getIcon());
            titleView.setText(moreLayouts.get(position).getTitle());
        } else {
            view = inflater.inflate(R.layout.group_header_item, parent, false);
        }
        return view;
    }
}
