package com.example.coderscal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateNames extends AppCompatActivity {
    EditText cc,cf,top,he,hr;
    Button savebut;
    Context context;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_names);

        context=getApplicationContext();
        final SharedPreferenceConfig spconfig = new SharedPreferenceConfig(context);
        sp = context.getSharedPreferences(context.getResources().getString(R.string.login_preference), Context.MODE_PRIVATE);

        cc = (EditText) findViewById(R.id.settingsccuser);
        cc.setText(spconfig.readcc());

        cf = (EditText) findViewById(R.id.settingscfuser);
        cf.setText(spconfig.readcf());

        top = (EditText) findViewById(R.id.settingstopuser);
        top.setText(spconfig.readtop());

        he = (EditText) findViewById(R.id.settingsheuser);
        he.setText(spconfig.readhe());

        hr = (EditText) findViewById(R.id.settingshruser);
        hr.setText(spconfig.readhr());

        savebut = (Button) findViewById(R.id.settings_but_save);
        savebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ccu = cc.getText().toString().trim();
                String cfu = cf.getText().toString().trim();
                String topu = top.getText().toString().trim();
                String heu = he.getText().toString().trim();
                String hru = hr.getText().toString().trim();

                if (ccu.equals("") || cfu.equals("") || topu.equals("") || heu.equals("") || hru.equals("")) {
                    Toast.makeText(context, "Please Enter Complete Details", Toast.LENGTH_SHORT).show();
                } else {
                    DataBase db = new DataBase(context);
                    String u = spconfig.readUser();
                    db.updatecc(u, ccu);
                    db.updatecf(u, cfu);
                    db.updatetop(u, topu);
                    db.updatehe(u, heu);
                    db.updatehr(u, hru);
                    db.close();
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString(context.getResources().getString(R.string.login_ccuser), ccu);
                    editor.putString(context.getResources().getString(R.string.login_cfuser), cfu);
                    editor.putString(context.getResources().getString(R.string.login_topuser), topu);
                    editor.putString(context.getResources().getString(R.string.login_heuser), heu);
                    editor.putString(context.getResources().getString(R.string.login_hruser), hru);
                    editor.commit();
                    Toast.makeText(context, "Successfully Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
