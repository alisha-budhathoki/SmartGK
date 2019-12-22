package com.example.smartgk.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartgk.R;

public class VideosFragment extends Fragment {
    WebView webView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_main, container, false);

        webView = rootView.findViewById(R.id.webView);
        final ProgressBar progressBar1 = rootView.findViewById(R.id.progressBarH);

        final String frameVideo = "<html><body><iframe width=\"100%\" height=\"100%\" padding=\"0px\" margin=\"0px\" src=\"https://www.youtube.com/embed/yDKYVDntU_M\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe></body></html>";
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar1.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                Toast.makeText(getActivity(), "Error in loading", Toast.LENGTH_SHORT).show();

            }
        });

        WebSettings webSettings = webView.getSettings ();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webView.loadData(frameVideo, "text/html", "utf-8");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }

        return rootView;

    }

}
