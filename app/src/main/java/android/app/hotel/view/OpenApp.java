package android.app.hotel.view;

import android.app.hotel.R;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class OpenApp extends AppCompatActivity {
    LinearLayout mLayoutFlash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_app);
        mLayoutFlash = findViewById(R.id.LayoutFlash);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    Intent wellcome = new Intent(OpenApp.this,MainActivity.class);
                    startActivity(wellcome);
                    finish();
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                OpenApp.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (mLayoutFlash!=null)
                        {
                            mLayoutFlash.setVisibility(View.GONE);
                        }
                    }
                });
            }
        }).start();
    }
}
