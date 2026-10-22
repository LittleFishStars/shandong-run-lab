package com.kc.cw.ad.c.h;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f38751a;

    public d(a aVar) {
        this.f38751a = aVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f38751a.f38746a = c.a.a(iBinder);
        synchronized (this.f38751a.d) {
            this.f38751a.d.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f38751a.f38746a = null;
    }
}
