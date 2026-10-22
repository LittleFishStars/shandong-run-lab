package com.kc.cw.ad.c.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c {
    private static String b = "OpenDeviceId library";
    private static boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.kc.cw.ad.c.d.a f38737a;
    private ServiceConnection d;
    private Context e = null;
    private a f = null;

    @Keep
    public interface a<T> {
        void a(T t, c cVar);
    }

    public int a(Context context, a<String> aVar) {
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.e = context;
        this.f = aVar;
        this.d = new ServiceConnection(this) { // from class: com.kc.cw.ad.c.d.c.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final c f38738a;

            {
                this.f38738a = this;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (this) {
                    this.f38738a.f38737a = com.kc.cw.ad.c.d.a.AbstractBinderC0976a.a(iBinder);
                    if (this.f38738a.f != null) {
                        this.f38738a.f.a("Deviceid Service Connected", this.f38738a);
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                this.f38738a.f38737a = null;
            }
        };
        Intent intent = new Intent();
        intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
        return this.e.bindService(intent, this.d, 1) ? 1 : -1;
    }

    public String a() {
        if (this.e == null) {
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            com.kc.cw.ad.c.d.a aVar = this.f38737a;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean b() {
        try {
            com.kc.cw.ad.c.d.a aVar = this.f38737a;
            if (aVar != null) {
                return aVar.c();
            }
            return false;
        } catch (RemoteException unused) {
            return false;
        }
    }
}
