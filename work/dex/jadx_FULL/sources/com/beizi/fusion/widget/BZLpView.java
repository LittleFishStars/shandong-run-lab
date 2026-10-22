package com.beizi.fusion.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.R;
import com.beizi.fusion.d9;
import com.beizi.fusion.kq;
import com.beizi.fusion.wp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BZLpView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f27918a;
    private ProgressBar b;
    private d c;

    public class b extends wp {
        public b(Activity activity) {
            super(activity);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            jsResult.confirm();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            ProgressBar progressBar = BZLpView.this.b;
            if (progressBar == null) {
                return;
            }
            if (i < 100 && progressBar.getVisibility() == 8) {
                BZLpView.this.b.setVisibility(0);
            }
            BZLpView.this.b.setProgress(i);
            if (i == 100) {
                BZLpView.this.b.setVisibility(8);
            }
        }

        @Override // com.beizi.fusion.wp, android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                BZLpView.this.removeAllViews();
                BZLpView.this.detachedFromWindow();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public interface d {
        void onDetachedFromWindow();
    }

    public BZLpView(@NonNull Context context) {
        super(context);
        a();
    }

    private void a() {
        try {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.activtiy_beizi_landingpage, (ViewGroup) null);
            viewInflate.setBackgroundColor(Color.parseColor("#FFFFFF"));
            this.f27918a = (WebView) viewInflate.findViewById(R.id.lp_web_view);
            this.b = (ProgressBar) findViewById(R.id.lp_progress_bar);
            kq.c(this.f27918a);
            this.f27918a.setWebViewClient(new a());
            if (getContext() instanceof Activity) {
                this.f27918a.setWebChromeClient(new b((Activity) getContext()));
            }
            ((ImageView) viewInflate.findViewById(R.id.lp_close_iv)).setOnClickListener(new c());
            addView(viewInflate, new RelativeLayout.LayoutParams(-1, -1));
        } catch (Exception unused) {
        }
    }

    public void detachedFromWindow() {
        try {
            d dVar = this.c;
            if (dVar != null) {
                dVar.onDetachedFromWindow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setData(String str) {
        WebView webView;
        try {
            if (TextUtils.isEmpty(str) || (webView = this.f27918a) == null) {
                return;
            }
            webView.loadUrl(str, d9.a());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOnDetachedFromWindowListener(d dVar) {
        this.c = dVar;
    }

    public BZLpView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                Uri url = webResourceRequest.getUrl();
                return (url == null || url.toString().startsWith("http")) ? false : true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return !str.startsWith("http");
        }
    }

    public BZLpView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
