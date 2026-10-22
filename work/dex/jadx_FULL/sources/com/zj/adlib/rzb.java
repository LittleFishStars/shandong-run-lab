package com.zj.adlib;

import android.os.Handler;
import android.os.Looper;
import cn.hzjizhun.admin.base.ad.ErrorCallback;
import cn.hzjizhun.admin.base.ad.RcSdk;
import cn.hzjizhun.admin.base.b0;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class rzb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static rzb f44572a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f19453a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ErrorCallback f19454a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f19456a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList f19457a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19460a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f19462b;
    public int c;
    public int d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LinkedList f19458a = new LinkedList();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final LinkedList f19461b = new LinkedList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Stack f19459a = new Stack();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final owb f19455a = new owb(this, Looper.getMainLooper());

    public static rzb a() {
        if (f44572a == null) {
            synchronized (rzb.class) {
                if (f44572a == null) {
                    f44572a = new rzb();
                }
            }
        }
        return f44572a;
    }

    public static void c(rzb rzbVar, qvb qvbVar) {
        rzbVar.getClass();
        if (qvbVar.b == 1 && !RcSdk.k()) {
            rzbVar.f19455a.sendEmptyMessageDelayed(4, 60000L);
            return;
        }
        rzbVar.f19455a.sendEmptyMessageDelayed(1, 3600000L);
        rzbVar.f19457a = qvbVar.f19186a;
        rzbVar.f19456a = hrb.b(qvbVar.f19185a);
        int i = qvbVar.f44311a;
        try {
            if (!rzbVar.f19462b && i > 0) {
                for (int i2 = 0; i2 < i; i2++) {
                    rzbVar.f19459a.push(new b0(RcSdk.e()));
                }
                rzbVar.f19462b = true;
            }
            if (!rzbVar.f19460a) {
                rzbVar.f19460a = true;
                rzbVar.g();
            }
        } catch (Throwable unused) {
        }
        rzbVar.f19455a.sendEmptyMessage(2);
    }

    public static boolean d(rzb rzbVar) {
        rzbVar.getClass();
        try {
            return (rzbVar.f19458a.isEmpty() && rzbVar.f19461b.isEmpty()) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void b(wtb wtbVar) {
        b0 b0Var;
        try {
            long j = wtbVar.f20542a;
            if (j != 0 && j * 1000 <= System.currentTimeMillis()) {
                return;
            }
            dqb dqbVar = new dqb(wtbVar);
            if (wtbVar.d() && !this.f19459a.isEmpty() && (b0Var = (b0) this.f19459a.pop()) != null) {
                dqbVar.c(b0Var);
            }
            wtb wtbVar2 = dqbVar.f16060a;
            if (wtbVar2.f45689a != 10) {
                dqbVar.g();
                return;
            }
            String str = wtbVar2.f20563h;
            ceb cebVar = new ceb(dqbVar);
            zmb zmbVarA = zmb.a();
            xab xabVar = new xab(str, cebVar);
            zmbVarA.getClass();
            mib mibVarA = mib.a();
            ylb ylbVar = new ylb(zmbVarA, xabVar);
            mibVarA.getClass();
            mib.f18226a.submit(ylbVar);
        } catch (Throwable unused) {
        }
    }

    public final void e() {
        synchronized (this) {
            qxb qxbVar = new qxb(this);
            zmb zmbVarA = zmb.a();
            a6b a6bVar = new a6b(qxbVar);
            zmbVarA.getClass();
            mib mibVarA = mib.a();
            ylb ylbVar = new ylb(zmbVarA, a6bVar);
            mibVarA.getClass();
            mib.f18226a.submit(ylbVar);
        }
    }

    public final void f() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.nzb
            @Override // java.lang.Runnable
            public final void run() {
                this.f43635a.e();
            }
        });
    }

    public final void g() {
        wtb wtbVar;
        wtb wtbVar2;
        try {
            if (this.f19458a.size() > 0 && (wtbVar2 = (wtb) this.f19458a.poll()) != null) {
                b(wtbVar2);
            }
            if (this.f19461b.size() > 0 && this.f19459a.size() > 0 && (wtbVar = (wtb) this.f19461b.poll()) != null) {
                b(wtbVar);
            }
            this.f19455a.sendEmptyMessageDelayed(3, 800L);
        } catch (Throwable unused) {
        }
    }
}
