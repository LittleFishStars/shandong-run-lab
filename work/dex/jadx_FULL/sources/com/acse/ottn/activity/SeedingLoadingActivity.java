package com.acse.ottn.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.acse.ottn.R;
import com.acse.ottn.a0;
import com.acse.ottn.e4;
import com.acse.ottn.h2;
import com.acse.ottn.n4;
import com.acse.ottn.o;
import com.acse.ottn.util.HelpShopAppUtil;
import com.byazt.hv.TTDownloadField;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SeedingLoadingActivity extends a0 {
    public int e;
    public boolean f;

    public class a implements e4.h {

        /* JADX INFO: renamed from: com.acse.ottn.activity.SeedingLoadingActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0092a implements Runnable {
            public RunnableC0092a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SeedingLoadingActivity.this.finish();
            }
        }

        public a() {
        }

        @Override // com.acse.ottn.e4.h
        public void a(String str, String str2) {
            if (SeedingLoadingActivity.this.f) {
                SeedingLoadingActivity.this.finish();
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                h2.a("SeedingLoadingActivity", "write code = " + str);
                o.c().a(SeedingLoadingActivity.this, str);
            }
            try {
                if (!TextUtils.isEmpty(str2)) {
                    n4.c().a(SeedingLoadingActivity.this, str2, "", "");
                }
            } catch (Throwable unused) {
            }
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0092a(), SeedingLoadingActivity.this.e);
        }
    }

    @Override // com.acse.ottn.a0, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        this.f = true;
        e4.a().c();
    }

    @Override // com.acse.ottn.a0, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(Color.argb(0, 0, 0, 0));
        try {
            if (HelpShopAppUtil.getContext() == null) {
                new AcseHelpManager.InitSdk().setContext(getApplication()).build();
            }
            String strA = a(getApplication());
            if (Build.VERSION.SDK_INT >= 28) {
                WebView.setDataDirectorySuffix(strA);
            }
        } catch (Throwable unused) {
            h2.a("SeedingLoadingActivity", "WebView already initialized  ");
        }
        setContentView(R.layout.seeding_activity_loading);
        a(false);
        this.f = false;
        this.e = getIntent().getIntExtra("dissmiss_time", 1500);
        e4.a().a(this, new a());
    }

    @Override // com.acse.ottn.a0, androidx.fragment.app.FragmentActivity, android.app.Activity
    @RequiresApi(api = 21)
    public void onPause() {
        super.onPause();
        this.f = true;
        finish();
    }

    public final String a(Context context) {
        if (context == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }
}
