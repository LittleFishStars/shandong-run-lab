package com.byazt.sgn;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.el.SSWebView;
import com.byazt.omf.gt;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 211, 46})
public class n extends AlertDialog {
    public static volatile AtomicInteger ve = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f29011a;
    public String c;
    public c i;
    public Context n;
    public Button sp;
    public String tt;
    public SSWebView uj;
    public Button x;

    public interface c {
        void c(Dialog dialog);

        void tt(Dialog dialog);

        void ve(Dialog dialog);
    }

    public n(Context context, String str, String str2, String str3) {
        super(context);
        this.n = context;
        this.c = str;
        this.tt = str3;
        if (TextUtils.isEmpty(str) || !(this.c.startsWith("https") || this.c.startsWith("http"))) {
            this.c = str2;
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        ve.set(0);
        c cVar = this.i;
        if (cVar != null) {
            cVar.tt(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.vfu.sp.tt(this);
        if (this.n == null) {
            this.n = gt.getContext();
        }
        c();
    }

    private View c(int i) {
        LinearLayout linearLayout = new LinearLayout(this.n);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams);
        View view = new View(this.n);
        LinearLayout.LayoutParams layoutParams2 = i == 0 ? new LinearLayout.LayoutParams(0, -1) : new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 0.38f;
        view.setLayoutParams(layoutParams2);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.n);
        LinearLayout.LayoutParams layoutParams3 = i == 0 ? new LinearLayout.LayoutParams(0, -1) : new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 0.62f;
        layoutParams3.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(pf.ve(this.n, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams3);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.n);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.n);
        this.f29011a = imageView;
        imageView.setMaxHeight(pf.ve(this.n, 46.0f));
        this.f29011a.setMaxWidth(pf.ve(this.n, 46.0f));
        this.f29011a.setMinimumHeight(pf.ve(this.n, 46.0f));
        this.f29011a.setMinimumWidth(pf.ve(this.n, 46.0f));
        this.f29011a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.byazt.vfu.ve veVar = new com.byazt.vfu.ve(pf.ve(this.n, 14.0f));
        veVar.c(-16777216);
        veVar.c(pf.ve(this.n, 2.0f));
        this.f29011a.setImageDrawable(veVar);
        relativeLayout.addView(this.f29011a);
        TextView textView = new TextView(this.n);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams4.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText(this.tt);
        textView.setLayoutParams(layoutParams4);
        relativeLayout.addView(textView);
        linearLayout2.addView(relativeLayout);
        View view2 = new View(this.n);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, pf.ve(this.n, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        this.uj = new SSWebView(this.n);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams5.weight = 1.0f;
        this.uj.setLayoutParams(layoutParams5);
        linearLayout2.addView(this.uj);
        View view3 = new View(this.n);
        view3.setLayoutParams(new LinearLayout.LayoutParams(-1, pf.ve(this.n, 1.0f)));
        view3.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view3);
        LinearLayout linearLayout3 = new LinearLayout(this.n);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int iVe = pf.ve(this.n, 16.0f);
        linearLayout3.setPadding(iVe, iVe, iVe, iVe);
        linearLayout3.setLayoutParams(layoutParams6);
        linearLayout2.addView(linearLayout3);
        this.x = new Button(this.n);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
        int iVe2 = pf.ve(this.n, 7.0f);
        layoutParams7.leftMargin = iVe2;
        layoutParams7.rightMargin = iVe2;
        layoutParams7.weight = 1.0f;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(pf.ve(this.n, 3.0f));
        gradientDrawable2.setStroke(pf.ve(this.n, 0.5f), Color.parseColor("#E0161823"));
        this.x.setBackground(gradientDrawable2);
        int iVe3 = pf.ve(this.n, 12.0f);
        this.x.setText("上一步");
        this.x.setPadding(0, iVe3, 0, iVe3);
        this.x.setTextColor(Color.parseColor("#A8161823"));
        this.x.setLayoutParams(layoutParams7);
        linearLayout3.addView(this.x);
        this.sp = new Button(this.n);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -2);
        layoutParams8.leftMargin = iVe2;
        layoutParams8.rightMargin = iVe2;
        layoutParams8.weight = 1.0f;
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable3.setCornerRadius(pf.ve(this.n, 3.0f));
        this.sp.setBackground(gradientDrawable3);
        this.sp.setText("立即下载");
        this.sp.setPadding(0, iVe3, 0, iVe3);
        this.sp.setTextColor(-1);
        this.sp.setLayoutParams(layoutParams8);
        linearLayout3.addView(this.sp);
        if (i == 0) {
            return linearLayout;
        }
        View view4 = new View(this.n);
        view4.setLayoutParams(new LinearLayout.LayoutParams(-1, pf.ve(this.n, 34.0f)));
        linearLayout2.addView(view4);
        return linearLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c() {
        if (this.n.getResources().getConfiguration().orientation == 1) {
            setContentView(c(1));
        } else {
            setContentView(c(0));
        }
        this.f29011a.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.ve.set(0);
                if (n.this.i != null) {
                    n.this.i.tt(n.this);
                }
            }
        });
        this.x.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.ve.set(0);
                if (n.this.i != null) {
                    n.this.i.ve(n.this);
                }
            }
        });
        this.sp.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.n.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.ve.set(0);
                if (n.this.i != null) {
                    n.this.i.c(n.this);
                }
            }
        });
        this.uj.setWebViewClient(new com.byazt.jwd.uj(this.n, null, 0 == true ? 1 : 0) { // from class: com.byazt.sgn.n.4
            @Override // com.byazt.jwd.uj
            public boolean c(WebView webView, WebResourceRequest webResourceRequest) {
                this.x = n.ve;
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
                    String lowerCase = scheme.toLowerCase(Locale.ROOT);
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
                this.x = n.ve;
                return super.c(webView, str);
            }
        });
        this.uj.setJavaScriptEnabled(true);
        this.uj.setDisplayZoomControls(false);
        this.uj.setCacheMode(2);
        this.uj.loadUrl(this.c);
    }

    public n c(c cVar) {
        this.i = cVar;
        return this;
    }
}
