package android.app.hotel.view.post;

import android.app.hotel.R;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PostItent extends AppCompatActivity {
    TextView re;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_itent);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Chi Tiết Tin Tức");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);;

        Intent intent = getIntent();

        final String Image = intent.getStringExtra("Image");
        final String Title = intent.getStringExtra("Title");
        final String Admin = intent.getStringExtra("Admin");
        final String Ago = intent.getStringExtra("Ago");
        final String Tag = intent.getStringExtra("Tag");
        final String DescriptionLong = intent.getStringExtra("DescriptionLong");

        if (Title.toString() == null || Image.toString() == null){
            TextView txttieude = (TextView) findViewById(R.id.textView11);
            txttieude.setText("ádasd");

            re = (TextView) findViewById(R.id.text_view_scroll);
            LoadText();
        } else {
            TextView txttieude = (TextView) findViewById(R.id.textView11);
            txttieude.setText(Title);

            TextView txtnoidung = (TextView) findViewById(R.id.text_view_scroll);
            txtnoidung.setMovementMethod(new ScrollingMovementMethod());
            txtnoidung.setText(DescriptionLong);

            TextView txtnguoitao = (TextView) findViewById(R.id.txtadmin);
            txtnguoitao.setText(Admin);

            TextView txtago = (TextView) findViewById(R.id.txtago);
            txtago.setText(Admin);

            TextView txttag = (TextView) findViewById(R.id.txttag);
            txttag.setText(Tag);
//
            Picasso.get().load(Image).into((ImageView)findViewById(R.id.imageViewHinh));

        }
    }

    private void LoadText() {
        String s = "";
        for (int x=0; x<100; x++){
            s += "Dòng chữ nội dung tin tức thứ: " +String.valueOf(x) + "\n";
        }
        re.setMovementMethod(new ScrollingMovementMethod());
        re.setText(s);
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
