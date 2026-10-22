package com.beizi.fusion.asnp.adn.ad.widget.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.window.OnBackInvokedCallback;
import com.beizi.fusion.fh;
import com.beizi.fusion.om;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ASNPAdActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27068a;
    private String b;
    private String c;
    private RelativeLayout d;

    public class a implements OnBackInvokedCallback {
        public a() {
        }

        @Override // android.window.OnBackInvokedCallback
        public void onBackInvoked() {
        }
    }

    public class b implements ViewGroup.OnHierarchyChangeListener {
        public b() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (!(view instanceof ViewGroup) || ((ViewGroup) view).getChildCount() > 0) {
                return;
            }
            ASNPAdActivity.this.a(false, "");
        }
    }

    private void a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    private void b() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, new a());
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        b();
        if (intent == null) {
            a(true, "Intent为空...");
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("AdBundle");
        if (bundleExtra != null) {
            this.f27068a = bundleExtra.getString("SpaceId");
            this.b = bundleExtra.getString("AdType");
            this.c = bundleExtra.getString("consumeId");
        }
        if (!a(this.f27068a, this.b, this.c)) {
            a(true, "无效的广告信息...");
            return;
        }
        View viewA = ((com.beizi.fusion.a) com.beizi.fusion.b.a().b(getApplicationContext())).a(this.c);
        a(viewA);
        if (viewA == null) {
            a(true, "无效的渲染View...");
            return;
        }
        a();
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null) {
            relativeLayout.addView(viewA, new ViewGroup.LayoutParams(-2, -2));
        } else {
            a(true, "无效的contentView...");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.d = null;
    }

    public void a() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.d = relativeLayout;
        addContentView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        this.d.setOnHierarchyChangeListener(new b());
    }

    private boolean a(String str, String str2, String str3) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str) {
        om.b("ASNPAdActivity", "广告Activity异常..." + str);
        if (z) {
            a(str);
        }
        finish();
    }

    private void a(String str) {
        Intent intent = new Intent();
        intent.putExtra("Result", str);
        intent.setAction("com.asnp.ad.ACTION_ACTIVITY_RESULT");
        fh.a(getApplicationContext()).a(intent);
    }
}
