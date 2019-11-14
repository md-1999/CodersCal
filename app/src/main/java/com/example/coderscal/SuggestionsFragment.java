package com.example.coderscal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SuggestionsFragment extends Fragment {
    Button but;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_suggestions,container,false);

        but=(Button)view.findViewById(R.id.sugbut);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_SUBJECT,"Suggestion for App");
                String[] to={"madhurbudhiraja99@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL,to);
                intent.setType("message/rfc822");
                Intent chooser=intent.createChooser(intent,"Choose Email Apps Only");
                startActivity(chooser);
            }
        });
        return view;
    }
}
