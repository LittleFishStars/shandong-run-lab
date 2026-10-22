package com.byazt.sgn;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.el.SSWebView;
import com.byazt.ete.ic;
import com.byazt.lbn.TTViewStub;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 211, 42})
public class i extends AlertDialog {
    public static volatile AtomicInteger uj = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f29010a;
    public SSWebView c;
    public com.byazt.dyf.tt da;
    public TextView i;
    public FrameLayout m;
    public LinearLayout n;
    public int nu;
    public Intent sl;
    public ImageView sp;
    public String t;
    public Context tt;
    public com.byazt.vo.tt u;
    public c ve;
    public TextView x;
    public TTViewStub yp;
    public TTViewStub z;

    public interface c {
        void c(Dialog dialog);
    }

    public i(Context context, Intent intent) {
        super(context);
        this.nu = 0;
        this.tt = context;
        this.sl = intent;
    }

    public static /* synthetic */ int tt(i iVar) {
        int i = iVar.nu;
        iVar.nu = i - 1;
        return i;
    }

    public static /* synthetic */ int ve(i iVar) {
        int i = iVar.nu;
        iVar.nu = i + 1;
        return i;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        uj.set(0);
        c cVar = this.ve;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        ic icVar;
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.vfu.sp.tt(this);
        getWindow().clearFlags(131072);
        getWindow().setBackgroundDrawable(new ColorDrawable(-1));
        LinearLayout linearLayout = new LinearLayout(this.tt);
        this.n = linearLayout;
        linearLayout.setBackgroundColor(-1);
        this.n.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.n.setOrientation(1);
        this.c = new SSWebView(this.tt);
        if (this.sl != null && (icVar = TTDelegateActivity.c) != null) {
            this.u = icVar.wq();
            this.t = this.sl.getStringExtra("event_tag");
        }
        setContentView(com.byazt.vfu.a.nb(this.tt));
        tt();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        getWindow().getAttributes().height = pf.n(this.tt) - pf.ve(this.tt, 50.0f);
    }

    private void ve() {
        TTViewStub tTViewStub;
        this.m = (FrameLayout) findViewById(2114387634);
        this.yp = (TTViewStub) findViewById(2114387770);
        this.z = (TTViewStub) findViewById(2114387792);
        this.m.addView(this.c, new LinearLayout.LayoutParams(-1, -1));
        int iMd = com.byazt.omf.x.m().md();
        if (iMd == 0) {
            TTViewStub tTViewStub2 = this.yp;
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
        } else if (iMd == 1 && (tTViewStub = this.z) != null) {
            tTViewStub.setVisibility(0);
        }
        ImageView imageView = (ImageView) findViewById(2114387705);
        this.f29010a = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.i.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    i.uj.set(0);
                    SSWebView sSWebView = i.this.c;
                    if (sSWebView != null && sSWebView.canGoBack() && i.this.nu > 1) {
                        i.this.c.goBack();
                        i.tt(i.this);
                        return;
                    }
                    i.this.dismiss();
                    i iVar = i.this;
                    c cVar = iVar.ve;
                    if (cVar != null) {
                        cVar.c(iVar);
                    }
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.sp = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.i.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    i.uj.set(0);
                    i.this.dismiss();
                    i iVar = i.this;
                    c cVar = iVar.ve;
                    if (cVar != null) {
                        cVar.c(iVar);
                    }
                }
            });
        }
        this.x = (TextView) findViewById(2114387952);
        TextView textView = (TextView) findViewById(2114387627);
        this.i = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.i.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    i.this.c();
                }
            });
        }
    }

    public void c() {
        com.byazt.vo.tt ttVar;
        Context context = this.tt;
        if (context == null || (ttVar = this.u) == null) {
            return;
        }
        if (this.da == null) {
            com.byazt.dyf.tt ttVar2 = new com.byazt.dyf.tt(context, ttVar, this.t, true, com.byazt.xky.tt.c());
            this.da = ttVar2;
            com.byazt.tl.ve.c(this.tt, TTDelegateActivity.c, ttVar2);
        }
        this.da.showDislikeDialog();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void tt() {
        ic icVar;
        ve();
        if (this.x != null && (icVar = TTDelegateActivity.c) != null && !TextUtils.isEmpty(icVar.v_())) {
            this.x.setText(TTDelegateActivity.c.v_());
        }
        com.byazt.jwd.tt.c(this.tt).c(false).tt(false).c(this.c);
        this.c.setWebViewClient(new com.byazt.jwd.uj(this.tt, null, 0 == true ? 1 : 0) { // from class: com.byazt.sgn.i.4
            @Override // com.byazt.jwd.uj
            public boolean c(WebView webView, WebResourceRequest webResourceRequest) {
                this.x = i.uj;
                return super.c(webView, webResourceRequest);
            }

            @Override // com.byazt.jwd.uj, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (webView == null) {
                    return true;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        return true;
                    }
                    String scheme = Uri.parse(str).getScheme();
                    if (TextUtils.isEmpty(scheme)) {
                        return true;
                    }
                    String lowerCase = scheme.toLowerCase(Locale.getDefault());
                    if (!lowerCase.contains("http") && !lowerCase.contains("https")) {
                        return true;
                    }
                    webView.loadUrl(str);
                    i.ve(i.this);
                    return true;
                } catch (Exception e) {
                    com.byazt.nr.m.c(e);
                    return true;
                }
            }

            @Override // com.byazt.jwd.uj
            public boolean c(WebView webView, String str) {
                this.x = i.uj;
                return super.c(webView, str);
            }
        });
        this.c.setJavaScriptEnabled(true);
        this.c.setDisplayZoomControls(false);
        this.c.setCacheMode(2);
        this.c.loadUrl("https://phoniex.toutiao.com");
    }

    public i c(c cVar) {
        this.ve = cVar;
        return this;
    }
}
