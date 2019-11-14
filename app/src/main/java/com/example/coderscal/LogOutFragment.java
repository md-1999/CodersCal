package com.example.coderscal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LogOutFragment extends Fragment {
    Button bt;
    Context context;
    private SharedPreferenceConfig spconfig;
    TextView tv,tv2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_logout,container,false);

        bt=(Button)view.findViewById(R.id.out);
        tv=(TextView)view.findViewById(R.id.tvlog);
        context=view.getContext();

        spconfig = new SharedPreferenceConfig(context);
        String user=spconfig.readUser();
        tv.setText("GoodBye "+user+".");

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spconfig.writeLoginStatus(false,"");
                Intent intent=new Intent(context,MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }
}
