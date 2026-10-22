package com.acse.ottn.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.webkit.WebView;
import com.acse.ottn.R;
import com.acse.ottn.a0;
import com.acse.ottn.b1;
import com.acse.ottn.h2;
import com.acse.ottn.util.HelpShopAppUtil;
import com.byazt.hv.TTDownloadField;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExcessActivity extends a0 {
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
        setContentView(R.layout.activity_excess);
        a(false);
        b1.a().a(this);
    }
}
