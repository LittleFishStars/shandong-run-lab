package com.alibaba.analytics;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AnalyticsService extends Service {
    IAnalytics b = null;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.b == null) {
            this.b = new AnalyticsImp(getApplication());
        }
        return (IBinder) this.b;
    }

    @Override // android.app.Service
    public void onDestroy() {
        IAnalytics iAnalytics = this.b;
        if (iAnalytics != null) {
            try {
                iAnalytics.triggerUpload();
            } catch (RemoteException unused) {
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        IAnalytics iAnalytics = this.b;
        if (iAnalytics != null) {
            try {
                iAnalytics.triggerUpload();
            } catch (RemoteException unused) {
            }
        }
        super.onLowMemory();
    }
}
