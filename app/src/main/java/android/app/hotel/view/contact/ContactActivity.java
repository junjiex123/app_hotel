package android.app.hotel.view.contact;

import android.app.hotel.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class ContactActivity extends AppCompatActivity {

    Toolbar toolbar;

    TextView mLienHe = null;
    String LienHe = "Với mong muốn đem đến những giây phút nghỉ ngơi tuyệt vời nhất cho quý khách hàng, AVA Hotel & Apartment sẽ không ngừng hoàn thiện và nâng cao chất lượng dịch vụ. Hãy liên hệ với chúng tôi khi có bất kì thắc mắc, phản hồi hoặc có nhu cầu muốn đặt phòng.\n" +
            "\n" +
            "Chúng tôi rất hân hạnh được phục vụ quý khách!\n" +
            "Địa chỉ: 39 Trần Bạch Đằng,  An Thượng 1, Phường Mỹ An, Quận Ngũ Hành Sơn, Tp Đà Nẵng\n" +
            "\n" +
            "Tel: 0236 3530920 \n" +
            "\n" +
            "Hotline 1: 0936.821.818\n" +
            "Hotline 2: 0935.291.898\n" +
            "Hotline 3: 0942.688.569\n" +
            "\n" +
            "Email: avahoteldn@gmail.com\n" +
            "\n" +
            "Facebook: www.facebook.com/avahoteldn";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Hotel Manager");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mLienHe = (TextView)findViewById(R.id.txtLienHe);
        mLienHe.setText(LienHe);
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
