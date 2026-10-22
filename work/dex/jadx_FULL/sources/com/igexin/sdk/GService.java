package com.igexin.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.getui.gtc.base.GtcProvider;
import com.igexin.push.core.ServiceManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class GService extends Service {
    public static final String TAG = "com.igexin.sdk.GService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            GtcProvider.setContext(getApplicationContext());
            ServiceManager.getInstance().a(getApplicationContext(), intent);
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            GtcProvider.setContext(getApplicationContext());
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            GtcProvider.setContext(getApplicationContext());
            ServiceManager.getInstance().a(getApplicationContext(), intent);
            return 2;
        } catch (Throwable unused) {
            return 2;
        }
    }
}
