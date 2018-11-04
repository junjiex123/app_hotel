package android.app.hotel.view.Home;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.hotel.adapter.HomeAdapter;
import android.app.hotel.model.home.Home;
import android.app.hotel.presenter.HomePresenter;
import android.app.hotel.service.HomeAPI;
import android.content.Context;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeView{

    final Calendar calendar = Calendar.getInstance();
    int ngay = calendar.get(Calendar.DATE);
    int thang = calendar.get(Calendar.MONTH);
    int nam = calendar.get(Calendar.YEAR);

    private HomeAdapter homeAdapter;
    private ListView lvHome;
    HomePresenter homePresenter;

    Button btSearch ;
    EditText edPrice ;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        toolbar.setTitle("Trang chủ");
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

//
        final EditText edDate = (EditText)view.findViewById(R.id.edDate);
        SimpleDateFormat now = new SimpleDateFormat("dd/MM/yyyy");
        edDate.setText(now.format(calendar.getTime()));
//
        edDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickDate();
            }
            private void PickDate() {
                 DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        calendar.set(year, month, dayOfMonth);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        edDate.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                },nam, thang , ngay);
                datePickerDialog.show();
            }
        });
//
        btSearch =  (Button) view.findViewById(R.id.btxacnhan);
        edPrice =  (EditText) view.findViewById(R.id.edPrice);

        lvHome = (ListView) view.findViewById(R.id.lvGet);

        homePresenter = new HomePresenter(this);
        homeAdapter = new HomeAdapter(this.getContext(), R.layout.view_search, HomePresenter.getHomes());
        lvHome.setAdapter(homeAdapter);



        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edPrice.getText()==null || edPrice.getTextSize() ==0 || edPrice.getTextSize() == 0 || edPrice.length()==0){
                    Toast.makeText(view.getContext(), "Không thể tìm kiếm vui lòng nhập thông tin đầy đủ", Toast.LENGTH_SHORT).show();
                }else if(HomePresenter.getHomes() == null || edPrice.length() <= 6) {
                    Toast.makeText(view.getContext(), "Không có dữ liệu cần tìm...", Toast.LENGTH_SHORT).show();
                }else{
                    //update rooms list
                    homePresenter.retryHomes();
                    Toast.makeText(view.getContext(), "Đang tìm kiếm vui lòng chờ đợi...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
    @Override
    public void updateView(List<Home> homes) {
        try {
            homeAdapter.setData(homes);
            homeAdapter.notifyDataSetChanged();
        }catch (Exception e) {
            Log.d("Search:", "Error: " + e);
        }
    }

}
