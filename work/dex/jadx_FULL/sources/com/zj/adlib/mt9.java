package com.zj.adlib;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class mt9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f43379a = "WakeLockManager";
    public static final String b = "ExoPlayer:WakeLockManager";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public PowerManager.WakeLock f18297a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final PowerManager f18298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18299a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f18300b;

    public mt9(Context context) {
        this.f18298a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    public void a(boolean z) {
        if (z && this.f18297a == null) {
            PowerManager powerManager = this.f18298a;
            if (powerManager == null) {
                Log.n(f43379a, "PowerManager is null, therefore not creating the WakeLock.");
                return;
            } else {
                PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, b);
                this.f18297a = wakeLockNewWakeLock;
                wakeLockNewWakeLock.setReferenceCounted(false);
            }
        }
        this.f18299a = z;
        c();
    }

    public void b(boolean z) {
        this.f18300b = z;
        c();
    }

    @SuppressLint({"WakelockTimeout"})
    public final void c() {
        PowerManager.WakeLock wakeLock = this.f18297a;
        if (wakeLock == null) {
            return;
        }
        if (this.f18299a && this.f18300b) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }
}
