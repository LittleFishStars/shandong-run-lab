package com.beizi.ad.internal.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.beizi.ad.internal.download.BeiZiWebView;
import com.beizi.fusion.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class DownloadAppInfoActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f26865a;
    private TextView b;
    private LinearLayout c;
    private LinearLayout d;
    private LinearLayout e;
    private TextView f;
    private TextView g;
    private TextView h;
    private View i;
    private View j;
    private View k;
    private int l = 0;
    private String m = "";
    private String n = "";
    private String o = "";
    private String p = "";
    private ScrollView q;
    private ScrollView r;
    private ScrollView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private BeiZiWebView w;
    private BeiZiWebView x;
    private BeiZiWebView y;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DownloadAppInfoActivity.this.finish();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DownloadAppInfoActivity.this.a(0);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DownloadAppInfoActivity.this.a(1);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DownloadAppInfoActivity.this.a(2);
        }
    }

    private void a() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.n = extras.getString("privacy_content_key");
        this.p = extras.getString("title_content_key");
        this.m = extras.getString("permission_content_key");
        this.o = extras.getString("intro_content_key");
        this.l = extras.getInt("from_position_key");
    }

    private void b() {
        this.f26865a = (ImageView) findViewById(R.id.beizi_download_appinfo_back);
        this.b = (TextView) findViewById(R.id.beizi_download_appinfo_title);
        this.c = (LinearLayout) findViewById(R.id.beizi_appinfo_permission_layout);
        this.f = (TextView) findViewById(R.id.beizi_appinfo_permission_textview);
        this.i = findViewById(R.id.beizi_appinfo_permission_below_line);
        this.d = (LinearLayout) findViewById(R.id.beizi_appinfo_privacy_layout);
        this.g = (TextView) findViewById(R.id.beizi_appinfo_privacy_textview);
        this.j = findViewById(R.id.beizi_appinfo_privacy_below_line);
        this.e = (LinearLayout) findViewById(R.id.beizi_appinfo_intro_layout);
        this.h = (TextView) findViewById(R.id.beizi_appinfo_intro_textview);
        this.k = findViewById(R.id.beizi_appinfo_intro_below_line);
        this.q = (ScrollView) findViewById(R.id.beizi_download_appinfo_persmission_content_scrollview);
        this.t = (TextView) findViewById(R.id.beizi_download_appinfo_persmission_content_textview);
        this.w = (BeiZiWebView) findViewById(R.id.beizi_download_appinfo_persmission_content_webview);
        this.r = (ScrollView) findViewById(R.id.beizi_download_appinfo_privacy_content_scrollview);
        this.u = (TextView) findViewById(R.id.beizi_download_appinfo_privacy_content_textview);
        this.x = (BeiZiWebView) findViewById(R.id.beizi_download_appinfo_privacy_content_webview);
        this.s = (ScrollView) findViewById(R.id.beizi_download_appinfo_intro_content_scrollview);
        this.v = (TextView) findViewById(R.id.beizi_download_appinfo_intro_content_textview);
        this.y = (BeiZiWebView) findViewById(R.id.beizi_download_appinfo_intro_content_webview);
    }

    private void c() {
        TextView textView = this.h;
        int i = R.color.appinfo_tab_unselected_color;
        textView.setTextColor(ContextCompat.getColor(this, i));
        this.k.setVisibility(4);
        this.f.setTextColor(ContextCompat.getColor(this, i));
        this.i.setVisibility(4);
        this.g.setTextColor(ContextCompat.getColor(this, i));
        this.j.setVisibility(4);
        this.s.setVisibility(8);
        this.y.setVisibility(8);
        this.v.setVisibility(8);
        this.q.setVisibility(8);
        this.t.setVisibility(8);
        this.w.setVisibility(8);
        this.r.setVisibility(8);
        this.u.setVisibility(8);
        this.x.setVisibility(8);
    }

    private void d() {
        if (!TextUtils.isEmpty(this.p)) {
            this.b.setText(this.p);
        }
        this.f26865a.setOnClickListener(new a());
        this.c.setOnClickListener(new b());
        this.d.setOnClickListener(new c());
        this.e.setOnClickListener(new d());
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        setContentView(R.layout.beizi_download_appinfo_activity);
        b();
        a(this.l);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i == 2) {
            c();
            a(this.h, this.k, this.o, this.v, this.s, this.y);
        } else if (i == 1) {
            c();
            a(this.g, this.j, this.n, this.u, this.r, this.x);
        } else {
            c();
            a(this.f, this.i, this.m, this.t, this.q, this.w);
        }
    }

    private void a(TextView textView, View view, String str, TextView textView2, ScrollView scrollView, WebView webView) {
        int i = R.color.appinfo_tab_selected_color;
        textView.setTextColor(ContextCompat.getColor(this, i));
        view.setBackgroundColor(ContextCompat.getColor(this, i));
        view.setVisibility(0);
        if (str.startsWith("http")) {
            textView2.setText("");
            scrollView.setVisibility(8);
            webView.setVisibility(0);
            webView.loadUrl(str);
            return;
        }
        textView2.setText(str);
        textView2.setVisibility(0);
        scrollView.setVisibility(0);
        webView.setVisibility(8);
    }
}
