package android.app.hotel.view.auth;

import android.app.hotel.R;
import android.app.hotel.view.MainActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button mbtnLogin;
    TextView mRegister;

    EditText edtusername,edtpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtusername = (EditText)findViewById(R.id.edtUsername);
        edtpassword = (EditText)findViewById(R.id.edtPassword);


        mbtnLogin = (Button)findViewById(R.id.btnLogin);
        mRegister = (TextView) findViewById(R.id.txtRegister);

        mbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checklogin(edtusername.getText().toString(),edtpassword.getText().toString());
            }
        });

        register();
    }

    public void checklogin(String username ,String password){
        String user = "admin";
        String pass = "123456";
        if ((username.equals(user)) && (password.equals(pass)))
        {
            login();
            Toast.makeText(this,"Login successful",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"Account does not exist",Toast.LENGTH_SHORT).show();
        }
    }
    public void login(){
        //Toast.makeText(LoginActivity.this,"Hello",Toast.LENGTH_LONG).show();
        Intent login = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(login);
    }

    public void register(){
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(LoginActivity.this,"Register...",Toast.LENGTH_LONG).show();
                Intent register = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(register);
            }
        });
    }
}
