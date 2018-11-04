package android.app.hotel.view;


import android.app.hotel.R;
import android.app.hotel.adapter.MoreLayoutAdapter;
import android.app.hotel.model.more.MoreLayout;
import android.app.hotel.view.contact.ContactActivity;
import android.app.hotel.view.huongdan.HuongDanIntent;
import android.app.hotel.view.introduce.IntroduceActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {


    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        ListView listView = (ListView) view.findViewById(R.id.lvMore);
        MoreLayoutAdapter moreLayoutAdapter = new MoreLayoutAdapter(this.getContext(), generateData());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getActivity(), RoomDetail.class);
//                intent.putExtra("name", services.get(position).getName());

//                startActivity(intent);

                switch (position)
                {
                    case 0:
                        //Toast.makeText(getActivity(),"Hello Giới thiệu",Toast.LENGTH_SHORT).show();
                        Intent iGioiThieu = new Intent(getActivity(), IntroduceActivity.class);
                        startActivity(iGioiThieu);

                        break;
                    case 1:
                        //Toast.makeText(getActivity(),"Hello Liên hệ",Toast.LENGTH_SHORT).show();
                        Intent iLienHe = new Intent(getActivity(), ContactActivity.class);
                        startActivity(iLienHe);
                        break;
                    case 4:
                        Intent iHuongDan = new Intent(getActivity(), HuongDanIntent.class);
                        startActivity(iHuongDan);
                        break;

                        default:
                            break;
                }

            }
        });

        listView.setAdapter(moreLayoutAdapter);

        return view;
    }

    public ArrayList<MoreLayout> generateData(){
        ArrayList<MoreLayout> moreLayouts = new ArrayList<MoreLayout>();

        moreLayouts.add(new MoreLayout(R.drawable.ic_home, "Giới thiệu"));
        moreLayouts.add(new MoreLayout(R.drawable.ic_action_news, "Liên hệ"));
        moreLayouts.add(new MoreLayout());
        moreLayouts.add(new MoreLayout(R.drawable.ic_assignment_ind, "Thông tin tài khoản"));
        moreLayouts.add(new MoreLayout(R.drawable.ic_action_help, "Hướng dẫn"));
        moreLayouts.add(new MoreLayout(R.drawable.ic_action_import, "Đăng nhập"));


        return  moreLayouts;
    }



}
