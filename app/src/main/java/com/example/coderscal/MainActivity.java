package com.example.coderscal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText et_name,et_password;
    Button bt_login;
    TextView tv_register;
    DataBase db;
    private SharedPreferenceConfig spconfig;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        spconfig = new SharedPreferenceConfig(getApplicationContext());


        setContentView(R.layout.activity_main);

        db=new DataBase(this);
        et_name=(EditText)findViewById(R.id.name);
        et_password=(EditText)findViewById(R.id.password);
        bt_login=(Button)findViewById(R.id.but_login);
        tv_register=(TextView)findViewById(R.id.register);

        if(spconfig.readLoginStatus()){
            Intent intent=new Intent(MainActivity.this,Main.class);
            String user= spconfig.readUser();
            intent.putExtra("text",user);
            startActivity(intent);
            finish();
        }

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent= new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
                finish();
            }
        });
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=et_name.getText().toString().trim();
                String pass=et_password.getText().toString().trim();
                if(user.equals("") || pass.equals("")){
                    Toast.makeText(MainActivity.this,"Please Enter Complete Details",Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean res = db.checkUser(user, pass);
                    db.close();
                    if (res == true) {
                        Toast.makeText(MainActivity.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Main.class);
                        intent.putExtra("text", user);
                        startActivity(intent);
                        spconfig.writeLoginStatus(true,user);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}