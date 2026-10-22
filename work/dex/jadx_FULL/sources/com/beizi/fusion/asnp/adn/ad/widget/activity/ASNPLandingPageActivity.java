package com.beizi.fusion.asnp.adn.ad.widget.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import com.ali.auth.third.login.LoginConstants;
import com.beizi.fusion.R;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.BasicWebView;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.LandingPageWebView;
import com.beizi.fusion.fp;
import com.beizi.fusion.sg;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ASNPLandingPageActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LandingPageWebView f27079a;
    private TextView b;
    private LinearLayout c;
    private FrameLayout d;
    private View e;
    private String f = "";
    private sg.e g;

    public class a implements OnBackInvokedCallback {
        public a() {
        }

        @Override // android.window.OnBackInvokedCallback
        public void onBackInvoked() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a();
    }

    private void b() {
        this.c.setBackgroundColor(Color.parseColor(fp.a().a("#FFFFFF")));
        this.e.setBackgroundColor(Color.parseColor(fp.a().a("#FFC1C1C1")));
        this.b.setTextColor(Color.parseColor(fp.a().a("#000000")));
    }

    private void c() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f = intent.getStringExtra("url");
            Bundle bundleExtra = intent.getBundleExtra(LoginConstants.EXT);
            if (bundleExtra != null) {
                this.f27079a.setAllowDeeplinkDirect(bundleExtra.getBoolean("allow", false));
            }
            this.f27079a.setWebViewClientListener(new b());
        }
    }

    private void d() {
        this.d = (FrameLayout) findViewById(R.id.landing_page_root);
        this.c = (LinearLayout) findViewById(R.id.landing_page_container);
        this.e = findViewById(R.id.landing_page_divider);
        this.f27079a = (LandingPageWebView) findViewById(R.id.landing_page_main);
        TextView textView = (TextView) findViewById(R.id.landing_page_close);
        this.b = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.zq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f46317a.a(view);
            }
        });
        try {
            b();
        } catch (Exception unused) {
        }
    }

    private void e() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, new a());
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        e();
        setContentView(R.layout.asnp_landing_page_layout);
        d();
        c();
        a(this.f);
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        sg.e eVar = this.g;
        if (eVar != null) {
            eVar.c();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        sg.e eVar = this.g;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        sg.e eVar = this.g;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        sg.e eVar = this.g;
        if (eVar != null) {
            eVar.e();
        }
    }

    public class b implements BasicWebView.c {
        private b() {
        }

        @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.BasicWebView.c
        public void a(Context context, String str, boolean z) {
            sg.e eVar = ASNPLandingPageActivity.this.g;
            if (eVar != null) {
                eVar.a(context, str, z);
            }
        }

        @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.BasicWebView.c
        public void a() {
            sg.e eVar = ASNPLandingPageActivity.this.g;
            if (eVar != null) {
                eVar.d();
            }
        }
    }

    private void a() {
        finish();
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap map = new HashMap();
        map.put(com.google.common.net.b.c1, "");
        this.f27079a.loadUrl(str, map);
    }

    public void a(sg.e eVar) {
        this.g = eVar;
        if (eVar != null) {
            eVar.a(this.d);
        }
    }
}
