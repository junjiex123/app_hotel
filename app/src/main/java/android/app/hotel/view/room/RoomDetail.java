package android.app.hotel.view.room;

import android.app.hotel.view.auth.LoginActivity;
import android.app.hotel.view.booking.BookingActivity;
import android.app.hotel.view.booking.FillInforActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.hotel.R;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Random;

public class RoomDetail extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView txtName, txtPrice, txtAcreage, txtDescription;
    private ImageView imgRoom;
    Button btnBooing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Chi tiết phòng");

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mapped();

        clickBooking();

        setValue();

    }

    public void mapped(){
        txtName = (TextView) findViewById(R.id.txtName);
        txtPrice = (TextView) findViewById(R.id.txtPrice);
        txtAcreage = (TextView) findViewById(R.id.txtAcreage);
        txtDescription = (TextView) findViewById(R.id.txtDescription);

        imgRoom = (ImageView) findViewById(R.id.imgRoom);

        btnBooing = (Button)findViewById(R.id.btnBooing);

    }

    public void setValue(){
        Intent intent = getIntent();

        txtName.setText(intent.getStringExtra("name"));
        txtPrice.setText(intent.getStringExtra("price") + " Vnđ / Đêm");
        txtAcreage.setText(intent.getStringExtra("acreage") + " cm");

        Picasso.get().load(intent.getStringExtra("image")).into(imgRoom);
        txtDescription.setText(intent.getStringExtra("description"));
    }

    public void clickBooking(){
        btnBooing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int statusLogin = rand.nextInt(2);
                int statusInfo = rand.nextInt(2);
                Check(statusLogin,statusInfo);
            }
        });
    }

    public void Check(int statusLogin, int statusInfo){
        if (statusLogin == 1)
        {
            if (statusInfo == 1)
            {
                Intent idatphong = new Intent(RoomDetail.this, BookingActivity.class);
                startActivity(idatphong);
            }
            else {
                Intent idatphong = new Intent(RoomDetail.this, FillInforActivity.class);
                startActivity(idatphong);
            }
        }
        else {
            Intent idangnhap = new Intent(RoomDetail.this, LoginActivity.class);
            startActivity(idangnhap);
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home)
        {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
