package com.kc.cw.ad;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.Menu;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import com.kc.cw.ad.internal.c.f;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AdActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f38642a = false;
    static Class<AdActivity> b = AdActivity.class;
    private a c;

    @Keep
    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    public static Class<AdActivity> a() {
        return b;
    }

    public static void a(Activity activity, int i) {
        b(activity, i);
    }

    private static void b(Activity activity, int i) {
        String str = com.kc.cw.ad.internal.c.a.a().k;
        Locale locale = Locale.US;
        String upperCase = str.toUpperCase(locale);
        boolean z = com.kc.cw.ad.internal.c.a.a().j.toUpperCase(locale).equals("AMAZON") && (upperCase.equals("KFTT") || upperCase.equals("KFJWI") || upperCase.equals("KFJWA"));
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        if (i == 1) {
            int rotation = defaultDisplay.getRotation();
            if (rotation == 1 || rotation == 2) {
                activity.setRequestedOrientation(9);
                return;
            } else {
                activity.setRequestedOrientation(1);
                return;
            }
        }
        if (i == 2) {
            int rotation2 = defaultDisplay.getRotation();
            if (z ? rotation2 == 0 || rotation2 == 1 : !(rotation2 == 0 || rotation2 == 1)) {
                activity.setRequestedOrientation(8);
            } else {
                activity.setRequestedOrientation(0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("ACTIVITY_TYPE");
        if (TextUtils.isEmpty(stringExtra)) {
            f.e(f.f38946a, f.a(R.string.adactivity_no_type));
            finish();
        } else if ("INTERSTITIAL".equals(stringExtra)) {
            e eVar = new e(this);
            this.c = eVar;
            eVar.a();
        }
        CookieSyncManager.createInstance(this);
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.startSync();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.d();
            this.c = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.c();
        }
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.stopSync();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onResume() {
        a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.startSync();
        }
        super.onResume();
    }
}
