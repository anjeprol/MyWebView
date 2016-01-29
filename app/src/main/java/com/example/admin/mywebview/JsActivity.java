package com.example.admin.mywebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class JsActivity extends AppCompatActivity {

    private WebView testWebView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js);
    }

    public void onClick(View view) {
        initWebView();
        WebSettings webSettings = testWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        EditText url = (EditText) findViewById(R.id.address);
        if (!url.getText().toString().isEmpty())
        testWebView.loadDataWithBaseURL("notreal/", url.getText().toString(), "text/html", "utf-8", null);

    }
    private void  initWebView(){

        if(testWebView==null) {
            testWebView = (WebView) findViewById(R.id.webView);
            testWebView.setWebViewClient(new loadWebView());
        }

    }
    private class loadWebView extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
