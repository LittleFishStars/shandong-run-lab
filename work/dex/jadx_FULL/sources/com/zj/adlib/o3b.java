package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class o3b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f43659a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Messenger f18548a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g0b f18549a;

    public o3b(Context context) {
        this.f18549a = null;
        this.f43659a = null;
        this.f43659a = context.getApplicationContext();
        this.f18549a = new g0b(this.f43659a);
    }

    public final IBinder a(Intent intent) {
        this.f18549a.w(intent);
        this.f18549a.d(intent);
        Messenger messenger = new Messenger(this.f18549a.s());
        this.f18548a = messenger;
        return messenger.getBinder();
    }

    public final void b() {
        try {
            g0b.C();
            this.f18549a.f16671d = i.b();
            this.f18549a.e = i.a();
            this.f18549a.c();
        } catch (Throwable th) {
            b.a(th, "ApsServiceCore", "onCreate");
        }
    }

    public final void c() {
        try {
            g0b g0bVar = this.f18549a;
            if (g0bVar != null) {
                g0bVar.s().sendEmptyMessage(11);
            }
        } catch (Throwable th) {
            b.a(th, "ApsServiceCore", "onDestroy");
        }
    }
}
