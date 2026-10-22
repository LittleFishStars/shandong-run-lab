package com.zj.adlib;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.zzs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class kjd implements ServiceConnection, zzs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ComponentName f42834a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public IBinder f17712a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ bpd f17713a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final chd f17714a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17716a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map f17715a = new HashMap();
    public int K = 2;

    public kjd(bpd bpdVar, chd chdVar) {
        this.f17713a = bpdVar;
        this.f17714a = chdVar;
    }

    public final int a() {
        return this.K;
    }

    public final ComponentName b() {
        return this.f42834a;
    }

    @Nullable
    public final IBinder c() {
        return this.f17712a;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f17715a.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, @Nullable Executor executor) {
        this.K = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (is6.r()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            bpd bpdVar = this.f17713a;
            boolean zC = bpdVar.f15617a.c(bpdVar.f15615a, str, this.f17714a.c(bpdVar.f15615a), this, this.f17714a.a(), executor);
            this.f17716a = zC;
            if (zC) {
                this.f17713a.f15616a.sendMessageDelayed(this.f17713a.f15616a.obtainMessage(1, this.f17714a), this.f17713a.b);
            } else {
                this.K = 2;
                try {
                    bpd bpdVar2 = this.f17713a;
                    bpdVar2.f15617a.unbindService(bpdVar2.f15615a, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f17715a.remove(serviceConnection);
    }

    public final void g(String str) {
        this.f17713a.f15616a.removeMessages(1, this.f17714a);
        bpd bpdVar = this.f17713a;
        bpdVar.f15617a.unbindService(bpdVar.f15615a, this);
        this.f17716a = false;
        this.K = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f17715a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f17715a.isEmpty();
    }

    public final boolean j() {
        return this.f17716a;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f17713a.f15619a) {
            this.f17713a.f15616a.removeMessages(1, this.f17714a);
            this.f17712a = iBinder;
            this.f42834a = componentName;
            Iterator it = this.f17715a.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
            }
            this.K = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f17713a.f15619a) {
            this.f17713a.f15616a.removeMessages(1, this.f17714a);
            this.f17712a = null;
            this.f42834a = componentName;
            Iterator it = this.f17715a.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
            }
            this.K = 2;
        }
    }
}
