package com.example.coderscal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    EditText et_name,et_password,et_confirm,cc_user,cf_user,top_user,he_user,hr_user;
    Button bt_register;
    TextView tv_login;
    DataBase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        db=new DataBase(this);
        et_name=(EditText)findViewById(R.id.signname);
        cc_user=(EditText)findViewById(R.id.signccuser);
        cf_user=(EditText)findViewById(R.id.signcfuser);
        top_user=(EditText)findViewById(R.id.signtopuser);
        he_user=(EditText)findViewById(R.id.signheuser);
        hr_user=(EditText)findViewById(R.id.signhruser);
        et_password=(EditText)findViewById(R.id.signpassword);
        et_confirm=(EditText)findViewById(R.id.confirm_password);
        bt_register=(Button)findViewById(R.id.but_register);
        tv_login=(TextView)findViewById(R.id.login);
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent= new Intent(SignUp.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=et_name.getText().toString().trim();
                String pass=et_password.getText().toString().trim();
                String confirm=et_confirm.getText().toString().trim();
                String cc=cc_user.getText().toString().trim();
                String cf=cf_user.getText().toString().trim();
                String top=top_user.getText().toString().trim();
                String he=he_user.getText().toString().trim();
                String hr=hr_user.getText().toString().trim();

                if(user.equals("") || cc.equals("")|| cf.equals("") || top.equals("") || he.equals("") || hr.equals("") || pass.equals("") || confirm.equals("")) {
                    Toast.makeText(SignUp.this, "Please Enter Complete Details", Toast.LENGTH_SHORT).show();
                }

                else {
                    if (pass.equals(confirm)) {
                        boolean va=db.check(user);
                        if(va==true){
                            Toast.makeText(SignUp.this,"UserName Already Registered",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            long val = db.addUser(user,pass,cc,cf,top,he,hr);
                            if (val > 0) {
                                Toast.makeText(SignUp.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUp.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(SignUp.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Toast.makeText(SignUp.this, "Password Not Matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        db.close();
    }
}

