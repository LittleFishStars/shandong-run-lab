package com.acse.ottn.service;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.acse.ottn.h2;
import com.acse.ottn.n1;
import com.acse.ottn.n3;
import com.acse.ottn.util.HelpShopAppUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExcessiveService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f23203a = "DemoService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    String strD = n1.a().d("sessionID");
                    if (TextUtils.isEmpty(strD)) {
                        HelpShopAppUtil.getInstance();
                        HelpShopAppUtil.sessionExID();
                    } else {
                        n3.a().b("sessionID", strD);
                        n1.a().b("sessionID", "");
                    }
                    n3.a().a("open_battery_white", Boolean.valueOf(n1.a().a("open_battery_white")));
                }
            } catch (Exception unused) {
                h2.b(f23203a, "request code fail ");
            }
        }
        stopSelf();
        return super.onStartCommand(intent, i, i2);
    }
}
