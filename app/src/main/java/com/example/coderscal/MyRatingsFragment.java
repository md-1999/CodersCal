package com.example.coderscal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyRatingsFragment extends Fragment {
    private Button ccbut,cfbut,topbut,hebut,hrbut;
    Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myratings, container, false);

        context = view.getContext();
        ccbut = (Button) view.findViewById(R.id.but1);
        ccbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent;
                intent = new Intent(context,CcWeb.class);
                startActivity(intent);
            }
        });
        cfbut = (Button) view.findViewById(R.id.but2);
        cfbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent;
                intent = new Intent(context,CfWeb.class);
                startActivity(intent);
            }
        });
        topbut = (Button) view.findViewById(R.id.but3);
        topbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent;
                intent = new Intent(context,TopWeb.class);
                startActivity(intent);
            }
        });
        hebut = (Button) view.findViewById(R.id.but4);
        hebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent;
                intent = new Intent(context,HeWeb.class);
                startActivity(intent);
            }
        });
        hrbut = (Button) view.findViewById(R.id.but5);
        hrbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent intent;
                intent = new Intent(context,HrWeb.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
