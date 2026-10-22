package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.alipay.sdk.app.H5PayActivity;
import com.alipay.sdk.m.c0.c;
import com.alipay.sdk.m.l.d;
import com.alipay.sdk.m.w.a;
import com.alipay.sdk.m.y.b;
import com.alipay.sdk.m.y.g;
import com.alipay.sdk.m.y.q;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class H5PayActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f25368a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public String g;
    public String h = null;
    public WeakReference<a> i;

    public final void a(final View view) {
        Context context = view.getContext();
        if (context != null && b.d(context)) {
            try {
                ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.zj.adlib.yw3
                    @Override // androidx.core.view.OnApplyWindowInsetsListener
                    public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                        return H5PayActivity.a(view, view2, windowInsetsCompat);
                    }
                });
            } catch (Throwable unused) {
                view.setPadding(0, b.b(context), 0, b.a(context));
            }
        }
    }

    public final void b() {
        try {
            super.requestWindowFeature(1);
            getWindow().addFlags(8192);
        } catch (Throwable th) {
            g.a(th);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        a();
        super.finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1010) {
            d.a((a) q.a(this.i), i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        c cVar = this.f25368a;
        if (cVar == null) {
            finish();
            return;
        }
        if (cVar.a()) {
            cVar.b();
            return;
        }
        if (!cVar.b()) {
            super.onBackPressed();
        }
        com.alipay.sdk.m.l.b.a(com.alipay.sdk.m.l.b.a());
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        b();
        super.onCreate(bundle);
        try {
            a aVarA = a.C0210a.a(getIntent());
            if (aVarA == null) {
                finish();
                return;
            }
            this.i = new WeakReference<>(aVarA);
            if (com.alipay.sdk.m.o.b.i().C()) {
                setRequestedOrientation(3);
            } else {
                setRequestedOrientation(1);
            }
            try {
                Bundle extras = getIntent().getExtras();
                String string = extras.getString("url", null);
                this.b = string;
                if (!q.f(string)) {
                    finish();
                    return;
                }
                this.d = extras.getString("cookie", null);
                this.c = extras.getString("method", null);
                this.e = extras.getString("title", null);
                this.g = extras.getString("version", c.c);
                this.f = extras.getBoolean("backisexit", false);
                this.h = extras.getString("cashierBizData", "");
                try {
                    com.alipay.sdk.m.c0.d dVar = new com.alipay.sdk.m.c0.d(this, aVarA, this.g);
                    setContentView(dVar);
                    a(dVar);
                    dVar.a(this.e, this.c, this.f);
                    dVar.setCashierBizData(this.h);
                    dVar.a(this.b, this.d);
                    dVar.a(this.b);
                    this.f25368a = dVar;
                } catch (Throwable th) {
                    com.alipay.sdk.m.m.a.a(aVarA, com.alipay.sdk.m.m.b.l, "GetInstalledAppEx", th);
                    finish();
                }
            } catch (Exception unused) {
                finish();
            }
        } catch (Exception unused2) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.f25368a;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        try {
            super.setRequestedOrientation(i);
        } catch (Throwable th) {
            try {
                com.alipay.sdk.m.m.a.a((a) q.a(this.i), com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.B, th);
            } catch (Throwable unused) {
            }
        }
    }

    public static /* synthetic */ WindowInsetsCompat a(View view, View view2, WindowInsetsCompat windowInsetsCompat) {
        view.setPadding(0, windowInsetsCompat.getSystemWindowInsetTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
        return windowInsetsCompat;
    }

    public void a() {
        Object obj = PayTask.j;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
    }
}
