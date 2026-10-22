package com.zj.adlib;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import java.util.HashMap;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class bpd extends GmsClientSupervisor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f40810a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f15615a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile Handler f15616a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final kt1 f15617a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ond f15618a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("connectionStatus")
    public final HashMap f15619a = new HashMap();
    public final long b;

    public bpd(Context context, Looper looper) {
        ond ondVar = new ond(this, null);
        this.f15618a = ondVar;
        this.f15615a = context.getApplicationContext();
        this.f15616a = new ozc(looper, ondVar);
        this.f15617a = kt1.a();
        this.f40810a = 5000L;
        this.b = 300000L;
    }

    public final void k(Looper looper) {
        synchronized (this.f15619a) {
            this.f15616a = new ozc(looper, this.f15618a);
        }
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final void zza(chd chdVar, ServiceConnection serviceConnection, String str) {
        yw6.m(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f15619a) {
            kjd kjdVar = (kjd) this.f15619a.get(chdVar);
            if (kjdVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + chdVar.toString());
            }
            if (!kjdVar.h(serviceConnection)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + chdVar.toString());
            }
            kjdVar.f(serviceConnection, str);
            if (kjdVar.i()) {
                this.f15616a.sendMessageDelayed(this.f15616a.obtainMessage(0, chdVar), this.f40810a);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    public final boolean zzc(chd chdVar, ServiceConnection serviceConnection, String str, @Nullable Executor executor) {
        boolean zJ;
        yw6.m(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f15619a) {
            kjd kjdVar = (kjd) this.f15619a.get(chdVar);
            if (kjdVar == null) {
                kjdVar = new kjd(this, chdVar);
                kjdVar.d(serviceConnection, serviceConnection, str);
                kjdVar.e(str, executor);
                this.f15619a.put(chdVar, kjdVar);
            } else {
                this.f15616a.removeMessages(0, chdVar);
                if (kjdVar.h(serviceConnection)) {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + chdVar.toString());
                }
                kjdVar.d(serviceConnection, serviceConnection, str);
                int iA = kjdVar.a();
                if (iA == 1) {
                    serviceConnection.onServiceConnected(kjdVar.b(), kjdVar.c());
                } else if (iA == 2) {
                    kjdVar.e(str, executor);
                }
            }
            zJ = kjdVar.j();
        }
        return zJ;
    }
}
