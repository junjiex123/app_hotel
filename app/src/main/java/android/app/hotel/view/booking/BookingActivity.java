package android.app.hotel.view.booking;

import android.app.hotel.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BookingActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button btnDatPhong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Đặt phòng");
        setSupportActionBar(toolbar);


        btnDatPhong = (Button)findViewById(R.id.btnDatPhong);
        btnDatPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BookingActivity.this,"Đặt phòng",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home)
        {
            return false;
        }

        return super.onOptionsItemSelected(item);
    }
}
