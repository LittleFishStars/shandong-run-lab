package com.zj.adlib;

import android.content.Context;
import android.net.wifi.WifiManager;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class kw9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f42933a = "WifiLockManager";
    public static final String b = "ExoPlayer:WifiLockManager";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public WifiManager.WifiLock f17813a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final WifiManager f17814a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17815a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f17816b;

    public kw9(Context context) {
        this.f17814a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    public void a(boolean z) {
        if (z && this.f17813a == null) {
            WifiManager wifiManager = this.f17814a;
            if (wifiManager == null) {
                Log.n(f42933a, "WifiManager is null, therefore not creating the WifiLock.");
                return;
            } else {
                WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(3, b);
                this.f17813a = wifiLockCreateWifiLock;
                wifiLockCreateWifiLock.setReferenceCounted(false);
            }
        }
        this.f17815a = z;
        c();
    }

    public void b(boolean z) {
        this.f17816b = z;
        c();
    }

    public final void c() {
        WifiManager.WifiLock wifiLock = this.f17813a;
        if (wifiLock == null) {
            return;
        }
        if (this.f17815a && this.f17816b) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }
}
