package com.example.coderscal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    public static ArrayList<String> list=new ArrayList<String>();
    public static ArrayAdapter<String> ad;
    ListView li;
    public static Context context;
    public static View view;
    private SharedPreferences sp;
    public static boolean iscc,iscf,istop,ishe,ishr,isothers;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        context=view.getContext();

        sp=context.getSharedPreferences(context.getResources().getString(R.string.login_preference),Context.MODE_PRIVATE);

        /*li=(ListView)view.findViewById(R.id.datalist);
        ad=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,list);
        li.setAdapter(ad);
*/
        iscc=sp.getBoolean(context.getResources().getString(R.string.listcc),true);
        iscf=sp.getBoolean(context.getResources().getString(R.string.listcf),true);
        istop=sp.getBoolean(context.getResources().getString(R.string.listtop),true);
        ishe=sp.getBoolean(context.getResources().getString(R.string.listhe),true);
        ishr=sp.getBoolean(context.getResources().getString(R.string.listhr),true);
        isothers=sp.getBoolean(context.getResources().getString(R.string.listothers),false);

        FetchData process = new FetchData();
        process.execute();

        return view;
    }
}
