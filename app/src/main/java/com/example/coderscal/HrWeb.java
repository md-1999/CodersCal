package com.example.coderscal;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HrWeb extends AppCompatActivity {
    private WebView hrweb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hr_web);
        hrweb=(WebView)findViewById(R.id.hrweb);
        hrweb.setWebViewClient(new WebViewClient());
        SharedPreferenceConfig spconfig = new SharedPreferenceConfig(getApplicationContext());
        hrweb.loadUrl("https://www.hackerrank.com/profile/"+spconfig.readhr());
        WebSettings ws=hrweb.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setLoadWithOverviewMode(true);
        ws.setUseWideViewPort(true);
        ws.setBuiltInZoomControls(true);
    }
    @Override
    public void onBackPressed() {
        if (hrweb.canGoBack()) {
            hrweb.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
