package com.example.coderscal;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HeWeb extends AppCompatActivity {
    private WebView heweb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.he_web);
        heweb=(WebView)findViewById(R.id.heweb);
        heweb.setWebViewClient(new WebViewClient());
        SharedPreferenceConfig spconfig = new SharedPreferenceConfig(getApplicationContext());
        heweb.loadUrl("https://www.hackerearth.com/@"+spconfig.readhe());
        WebSettings ws=heweb.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setLoadWithOverviewMode(true);
        ws.setUseWideViewPort(true);
        ws.setBuiltInZoomControls(true);
    }
    @Override
    public void onBackPressed() {
        if (heweb.canGoBack()) {
            heweb.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
