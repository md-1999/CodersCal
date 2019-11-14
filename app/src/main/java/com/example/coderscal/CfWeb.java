package com.example.coderscal;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CfWeb extends AppCompatActivity {
    private WebView cfweb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cf_web);
        cfweb = (WebView) findViewById(R.id.cfweb);
        cfweb.setWebViewClient(new WebViewClient());
        SharedPreferenceConfig spconfig = new SharedPreferenceConfig(getApplicationContext());
        cfweb.loadUrl("http://codeforces.com/profile/"+spconfig.readcf());
        WebSettings ws = cfweb.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setLoadWithOverviewMode(true);
        ws.setUseWideViewPort(true);
        ws.setBuiltInZoomControls(true);
    }
    @Override
    public void onBackPressed() {
        if (cfweb.canGoBack()) {
            cfweb.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
