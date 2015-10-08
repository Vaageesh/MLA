package com.omega.mlapp;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class WebAppInterface {
    private Context mContext;
    private WebView view;
    private String url;

    /**
     * Instantiate the interface and set the context
     */
    public WebAppInterface(WebView view1,String refreshurl) {
        view = view1;
        url = refreshurl;
    }

    /**
     * Show a toast from the web page
     */
    @JavascriptInterface
    public void refresh() {
        view.post(new Runnable() {
            @Override
            public void run() {
                view.loadUrl(url);
            }
        });
    }
}