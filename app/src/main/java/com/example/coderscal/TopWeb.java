package com.example.coderscal;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TopWeb extends AppCompatActivity {
    private WebView topweb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_web);
        topweb=(WebView)findViewById(R.id.topweb);
        topweb.setWebViewClient(new WebViewClient());
        SharedPreferenceConfig spconfig = new SharedPreferenceConfig(getApplicationContext());
        topweb.loadUrl("https://www.topcoder.com/members/"+spconfig.readtop());
        WebSettings ws=topweb.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setLoadWithOverviewMode(true);
        ws.setUseWideViewPort(true);
        ws.setBuiltInZoomControls(true);
    }
    @Override
    public void onBackPressed() {
        if (topweb.canGoBack()) {
            topweb.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
