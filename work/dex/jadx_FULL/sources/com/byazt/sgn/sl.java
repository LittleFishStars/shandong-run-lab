package com.byazt.sgn;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.el.SSWebView;
import com.byazt.nr.h;
import com.byazt.omf.gt;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 211, 158})
public class sl extends AlertDialog {
    public static volatile AtomicInteger c = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f29012a;
    public ImageView da;
    public RelativeLayout i;
    public String n;
    public ImageView sl;
    public String sp;
    public SSWebView tt;
    public TextView uj;
    public Context ve;
    public RelativeLayout x;

    public interface c {
        void c(Dialog dialog);
    }

    public sl(Context context, String str) {
        super(context);
        this.sp = str;
        this.ve = context;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        c.set(0);
        c cVar = this.f29012a;
        if (cVar != null) {
            cVar.c(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.vfu.sp.tt(this);
        setContentView(com.byazt.vfu.a.sv(this.ve));
        tt();
        c();
    }

    public void c() {
        String strFk = gt.tt().fk();
        if (TextUtils.isEmpty(strFk)) {
            this.n = "https://www.pangle.cn/privacy/partner";
        } else {
            this.n = strFk;
        }
        if (TextUtils.isEmpty(this.sp)) {
            return;
        }
        if (this.n.contains("?")) {
            this.n += "&ad_info=" + this.sp;
            return;
        }
        this.n += "?ad_info=" + this.sp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void tt() {
        this.tt = (SSWebView) findViewById(2114387763);
        TextView textView = (TextView) findViewById(2114387652);
        this.uj = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.sl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (sl.this.f29012a != null) {
                    sl.this.f29012a.c(sl.this);
                }
            }
        });
        setCanceledOnTouchOutside(false);
        this.tt.setWebViewClient(new com.byazt.jwd.uj(this.ve, null, 0 == true ? 1 : 0) { // from class: com.byazt.sgn.sl.2
            @Override // com.byazt.jwd.uj
            public boolean c(WebView webView, WebResourceRequest webResourceRequest) {
                this.x = sl.c;
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
                    String lowerCase = scheme.toLowerCase(Locale.US);
                    if (!lowerCase.contains("http") && !lowerCase.contains("https")) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }

            @Override // com.byazt.jwd.uj
            public boolean c(WebView webView, String str) {
                this.x = sl.c;
                return super.c(webView, str);
            }
        });
        this.tt.setJavaScriptEnabled(true);
        this.tt.setDisplayZoomControls(false);
        this.tt.setCacheMode(2);
        this.tt.loadUrl(this.n);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2114387883);
        this.x = relativeLayout;
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(2114387894);
        this.i = relativeLayout2;
        relativeLayout2.setVisibility(8);
        this.uj.setVisibility(8);
        this.da = (ImageView) findViewById(2114387813);
        this.sl = (ImageView) findViewById(2114387836);
        this.da.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.sl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (sl.this.f29012a != null) {
                    sl.this.f29012a.c(sl.this);
                    sl.c.set(0);
                }
            }
        });
        this.sl.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.sl.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    ((ClipboardManager) sl.this.ve.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, sl.this.n));
                    h.c(sl.this.ve, "链接复制成功", 1);
                } catch (Throwable th) {
                    com.byazt.nr.m.c(th);
                    h.c(sl.this.ve, "链接复制失败", 1);
                }
            }
        });
    }

    public sl c(c cVar) {
        this.f29012a = cVar;
        return this;
    }
}
