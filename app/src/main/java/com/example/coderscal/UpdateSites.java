package com.example.coderscal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class UpdateSites extends AppCompatActivity {
    private SharedPreferences sp;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sites);

        ListView listview=(ListView)findViewById(R.id.listview);
        final List<SiteModel> sites= new ArrayList<>();

        context=getApplicationContext();
        sp=context.getSharedPreferences(context.getResources().getString(R.string.login_preference),Context.MODE_PRIVATE);

        sites.add(new SiteModel(sp.getBoolean(context.getResources().getString(R.string.listcc),true),"CodeChef"));
        sites.add(new SiteModel(sp.getBoolean(context.getResources().getString(R.string.listcf),true),"Codeforces"));
        sites.add(new SiteModel(sp.getBoolean(context.getResources().getString(R.string.listtop),true),"TopCoder"));
        sites.add(new SiteModel(sp.getBoolean(context.getResources().getString(R.string.listhe),true),"HackerEarth"));
        sites.add(new SiteModel(sp.getBoolean(context.getResources().getString(R.string.listhr),true),"HackerRank"));
        sites.add(new SiteModel(sp.getBoolean(context.getResources().getString(R.string.listothers),false),"Others"));

        final CustomAdapter adapter=new CustomAdapter(this,sites);
        listview.setAdapter(adapter);
        final SharedPreferences.Editor editor=sp.edit();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SiteModel model=sites.get(position);
                if(model.isSelected()){
                    model.setSelected(false);
                    if(model.siteName.equals("CodeChef")){
                        editor.putBoolean("com.example.coderscal_listcc",false);
                    }
                    else if(model.siteName.equals("Codeforces")){
                        editor.putBoolean("com.example.coderscal_listcf",false);
                    }
                    else if(model.siteName.equals("TopCoder")){
                        editor.putBoolean("com.example.coderscal_listtop",false);
                    }
                    else if(model.siteName.equals("HackerEarth")){
                        editor.putBoolean("com.example.coderscal_listhe",false);
                    }
                    else if(model.siteName.equals("HackerRank")){
                        editor.putBoolean("com.example.coderscal_listhr",false);
                    }
                    else if(model.siteName.equals("Others")){
                        editor.putBoolean("com.example.coderscal_listothers",false);
                    }
                }
                else{
                    model.setSelected(true);
                    if(model.siteName.equals("CodeChef")){
                        editor.putBoolean("com.example.coderscal_listcc",true);
                    }
                    else if(model.siteName.equals("Codeforces")){
                        editor.putBoolean("com.example.coderscal_listcf",true);
                    }
                    else if(model.siteName.equals("TopCoder")){
                        editor.putBoolean("com.example.coderscal_listtop",true);
                    }
                    else if(model.siteName.equals("HackerEarth")){
                        editor.putBoolean("com.example.coderscal_listhe",true);
                    }
                    else if(model.siteName.equals("HackerRank")){
                        editor.putBoolean("com.example.coderscal_listhr",true);
                    }
                    else if(model.siteName.equals("Others")){
                        editor.putBoolean("com.example.coderscal_listothers",true);
                    }
                }
                editor.commit();
                sites.set(position,model);
                adapter.updateRecords(sites);
            }
        });
    }
}
