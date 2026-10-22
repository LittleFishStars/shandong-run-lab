package com.beizi.ad;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.beizi.fusion.kq;
import com.beizi.fusion.y4;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdActivity extends Activity {
    public static boolean b = false;
    static Class c = AdActivity.class;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f26852a;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            while (i != 3) {
                i++;
                if (AdActivity.b) {
                    AdActivity.b = false;
                    AdActivity.this.finish();
                    i = 3;
                }
                SystemClock.sleep(500L);
            }
        }
    }

    public interface b {
        WebView a();

        void b();

        void c();

        void destroy();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        b bVar = this.f26852a;
        if (bVar != null) {
            bVar.c();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            String stringExtra = getIntent().getStringExtra("ACTIVITY_TYPE");
            boolean booleanExtra = getIntent().getBooleanExtra("ACTIVITY_CAN_JUMP", false);
            boolean booleanExtra2 = getIntent().getBooleanExtra("ACTIVITY_CAN_DOWNLOAD", false);
            String stringExtra2 = getIntent().getStringExtra("deeplinkUrl");
            int intExtra = getIntent().getIntExtra("webDeepLink", 0);
            if (TextUtils.isEmpty(stringExtra)) {
                finish();
            } else if ("BROWSER".equals(stringExtra)) {
                y4 y4Var = new y4(this, booleanExtra, booleanExtra2, stringExtra2, intExtra);
                this.f26852a = y4Var;
                y4Var.b();
            } else if ("DOWNLOADBROWSER".equals(stringExtra)) {
                y4 y4Var2 = new y4(this, booleanExtra, booleanExtra2, stringExtra2, intExtra);
                this.f26852a = y4Var2;
                y4Var2.b();
                new Thread(new a()).start();
            }
            CookieSyncManager.createInstance(this);
            CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
            if (cookieSyncManager != null) {
                cookieSyncManager.startSync();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        b bVar = this.f26852a;
        if (bVar != null) {
            bVar.destroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        b bVar = this.f26852a;
        if (bVar != null) {
            kq.a(bVar.a());
        }
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.stopSync();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        b bVar = this.f26852a;
        if (bVar != null) {
            kq.b(bVar.a());
        }
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.startSync();
        }
        super.onResume();
    }
}
