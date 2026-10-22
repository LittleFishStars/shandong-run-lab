package com.kc.dw.core.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.kc.dw.core.oaid.OAIDException;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class m implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f39290a;
    public final com.kc.dw.core.oaid.a b;
    public final a c;

    @Keep
    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder) throws OAIDException, RemoteException;
    }

    public m(Context context, com.kc.dw.core.oaid.a aVar, a aVar2) {
        this.f39290a = context instanceof Application ? context : context.getApplicationContext();
        this.b = aVar;
        this.c = aVar2;
    }

    public static void a(Context context, Intent intent, com.kc.dw.core.oaid.a aVar, a aVar2) {
        m mVar = new m(context, aVar, aVar2);
        try {
            if (!mVar.f39290a.bindService(intent, mVar, 1)) {
                throw new OAIDException("Service binding failed");
            }
            Objects.toString(intent);
        } catch (Exception e) {
            ((com.kc.dw.core.utils.n) mVar.b).a(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            try {
                String strA = this.c.a(iBinder);
                if (strA == null || strA.length() == 0) {
                    throw new OAIDException("OAID acquire failed");
                }
                ((com.kc.dw.core.utils.n) this.b).a(strA);
                try {
                    this.f39290a.unbindService(this);
                    componentName.getClassName();
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                try {
                    this.f39290a.unbindService(this);
                    componentName.getClassName();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (Exception e) {
            ((com.kc.dw.core.utils.n) this.b).a(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        componentName.getClassName();
    }
}
