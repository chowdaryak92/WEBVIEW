package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=(WebView)findViewById(R.id.wv);
        progressBar=(ProgressBar)findViewById(R.id.pb);
        webView.loadUrl("https://www.google.co.in/");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(
                new WebViewClient()
                {

                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                        String url= request.getUrl().toString();
                        webView.loadUrl(url);
                        return  true;
                    }

                    @Override
                    public void onPageStarted(WebView view, String url, Bitmap favicon) {
                        super.onPageStarted(view, url, favicon);
                        Toast.makeText(MainActivity.this,"Loading Started",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);
                        Toast.makeText(MainActivity.this,"Loading Finished",Toast.LENGTH_LONG).show();
                    }

                }

        );





        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                getSupportActionBar().setTitle(title);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }



        }



        );

//viva what  is the difference between setwebview client and setwebchromeclient methods


    }

    public void onBackPresses()
    {
        if (webView.canGoBack())
        {

        }
    }
}
