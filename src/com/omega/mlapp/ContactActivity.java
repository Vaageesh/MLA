package com.omega.mlapp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * Created by vageesh on 2/15/15.
 */
public class ContactActivity extends Activity {
    private WebView webView;
    final Activity activity = this;

    //requestWindowFeature(Window.FEATURE_PROGRESS);
    //getWindow().re
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        String url = "http://testmachine.comli.com/mla/contact.php";
        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new ContectWebViewClient() {
            public void onProgressChanged(WebView view, int progress) {
                // Activities and WebViews measure progress with different scales.
                // The progress meter will automatically disappear when we reach 100%
                activity.setProgress(progress * 1000);
            }

        });
        webView.loadUrl(url);

    }
    public class ContectWebViewClient extends WebViewClient {

        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
}
