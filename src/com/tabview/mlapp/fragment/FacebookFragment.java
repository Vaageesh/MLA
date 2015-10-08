package com.tabview.mlapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.omega.mlapp.R;
import com.omega.mlapp.WebAppInterface;

/**
 * Created by vageesh on 8/24/15.
 */
public class FacebookFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.newsupdate, container, false);
        String url = "https://www.facebook.com/ramakrishnas.doddamani.9";
        //WebView loadWeb = new WebView();
        //   browser = ((WebView)(getView().findViewById(R.id.webView1)));
        final WebView webview = (WebView) rootView.findViewById(R.id.webView1);
        //ConnectivityManager cm = (ConnectivityManager) this.getActivity().getSystemService(Activity.CONNECTIVITY_SERVICE);
        //if(cm != null && cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected()){
        webview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        //}
        //else{
        //  webview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //}
        webview.getSettings().setJavaScriptEnabled(true);
        webview.addJavascriptInterface(new WebAppInterface(webview,url), "Android");
        //webview.setWebViewClient(new webClient());
        /*webview.setWebChromeClient(new WebChromeClient(){
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                webview.loadUrl("file:///android_asset/html/no_internet.html");
            }
        });*/
        webview.setWebViewClient(new WebViewClient(){
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                if(errorCode == 404){
                    webview.loadUrl("file:///android_asset/html/404_error.html");
                }else {
                    webview.loadUrl("file:///android_asset/html/no_internet.html");
                }
            }
            /*@Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                getActivity().getApplicationContext().startActivity(i);
                return true;

            }*/
        });
        webview.loadUrl(url);
        return rootView;

        //setContentView(R.layout.newsupdate);
        //browser = (WebView)findViewById(R.id.webView1);
        //browser.setWebViewClient(new WebViewClient());
    }

    public void loadUrl(String url) {
        ((WebView)(getView().findViewById(R.id.webView1))).loadUrl(url);
    }
    private class webClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.reload();
            return true;

        }

    }

}
