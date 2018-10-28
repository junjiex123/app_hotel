package android.app.hotel.view.huongdan;

import android.app.hotel.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HuongDanIntent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huong_dan_intent);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Chi Tiết Hướng dẫn");
        setSupportActionBar(toolbar);

        ArrayList string = new ArrayList<>();
        string.add("Đăng ký");
        string.add("Đặt phòng khách sạn");
        string.add("Xem tin tức");
        string.add("Xem thông tin cá nhân");
        string.add("Xem Phòng khách sạn");
        string.add("Xem dịch vụ khách sạn");
        string.add("Thay dổi mật khảu cá nhân");
        string.add("Báo cáo bài viết");
        string.add("Xem phòng đã đặt");
        string.add("Xem Sự kiện giảm giá");
        string.add("khảo sát");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, string);
        ListView recyclerView = (ListView) findViewById(R.id.RecyView);
        recyclerView.setAdapter(arrayAdapter);

        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position > 1){
                    Toast.makeText(view.getContext(), "Giá trị nhấn: " + position, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
