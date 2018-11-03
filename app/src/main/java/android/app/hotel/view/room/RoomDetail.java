package android.app.hotel.view.room;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.hotel.R;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RoomDetail extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView txtName, txtPrice, txtAcreage, txtDescription;
    private ImageView imgRoom;


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

        setValue();

    }

    public void mapped(){
        txtName = (TextView) findViewById(R.id.txtName);
        txtPrice = (TextView) findViewById(R.id.txtPrice);
        txtAcreage = (TextView) findViewById(R.id.txtAcreage);
        txtDescription = (TextView) findViewById(R.id.txtDescription);

        imgRoom = (ImageView) findViewById(R.id.imgRoom);

    }

    public void setValue(){
        Intent intent = getIntent();

        txtName.setText(intent.getStringExtra("name"));
        txtPrice.setText(intent.getStringExtra("price") + " Vnđ / Đêm");
        txtAcreage.setText(intent.getStringExtra("acreage") + " cm");

        Picasso.get().load(intent.getStringExtra("image")).into(imgRoom);
        txtDescription.setText(intent.getStringExtra("description"));
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
