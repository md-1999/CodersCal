package com.example.coderscal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class CcWeb extends AppCompatActivity {
    private WebView ccweb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cc_web);
        ccweb=(WebView)findViewById(R.id.ccweb);
        ccweb.setWebViewClient(new WebViewClient());
        SharedPreferenceConfig spconfig = new SharedPreferenceConfig(getApplicationContext());
        ccweb.loadUrl("https://www.codechef.com/users/"+spconfig.readcc());
        WebSettings ws=ccweb.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setLoadWithOverviewMode(true);
        ws.setUseWideViewPort(true);
        ws.setBuiltInZoomControls(true);
    }
    @Override
    public void onBackPressed() {
        if (ccweb.canGoBack()) {
            ccweb.goBack();
        } else {
            super.onBackPressed();
        }
    }
}