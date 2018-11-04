package android.app.hotel.view.Home;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.hotel.R;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    final Calendar calendar = Calendar.getInstance();
    int ngay = calendar.get(Calendar.DATE);
    int thang = calendar.get(Calendar.MONTH);
    int nam = calendar.get(Calendar.YEAR);
    int counterpeople = 0;

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
        final EditText edTongPhong = (EditText)view.findViewById(R.id.edTongPhong);
        final EditText ednguoi = (EditText)view.findViewById(R.id.ednguoi);

        final Button btntrunguoi = (Button) view.findViewById(R.id.bttrunguoi);
        final Button btncongnguoi = (Button) view.findViewById(R.id.btcongnguoi);
//
        btntrunguoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterpeople <= 0){
                    counterpeople = 0;
                } else {
                    counterpeople--;
                    ednguoi.setText(String.valueOf(counterpeople));
                    edTongPhong.setText("1" + " - " + "Phòng" + " | " + String.valueOf(counterpeople) + " - " + "Người");
                }
            }
        });

        btncongnguoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterpeople >= 4){
                    counterpeople = 4;
                    Toast.makeText(view.getContext(),"Số người quá giới hạn cho phép", Toast.LENGTH_SHORT).show();
                }else {
                    counterpeople++;
                    ednguoi.setText(String.valueOf(counterpeople));
                    edTongPhong.setText("1" +  " - " + "Phòng" + " | " + String.valueOf(counterpeople) + " - " + "Người");

                }
            }
        });

        return view;
    }
}
