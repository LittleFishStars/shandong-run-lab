package com.zj.adlib;

import android.os.Looper;
import android.text.TextUtils;
import cn.hzjizhun.admin.base.b0;
import cn.hzjizhun.admin.base.r1;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class dqb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b0 f41258a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final bbb f16059a = new bbb(this, Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final wtb f16060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f16061a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList f16062a;
    public String b;

    public dqb(wtb wtbVar) {
        this.f16061a = "";
        this.f16060a = wtbVar;
        this.f16061a = "TG" + wtbVar.f20561g;
        this.f16062a = wtbVar.f20546a;
    }

    public static String a(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : str.replaceAll("_clickTime10_", Long.toString(System.currentTimeMillis() / 1000)).replaceAll("_clickTime13_", Long.toString(System.currentTimeMillis()));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void e(dqb dqbVar, ArrayList arrayList) {
        dqbVar.getClass();
        if (arrayList != null) {
            try {
                if (arrayList.isEmpty()) {
                    return;
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    String strReplaceAll = (String) arrayList.get(i);
                    if (dqbVar.f16060a.f45689a == 10) {
                        String str = (String) arrayList.get(i);
                        try {
                            strReplaceAll = TextUtils.isEmpty(str) ? "" : str.replaceAll("__CLICK_ID__", dqbVar.b);
                        } catch (Throwable unused) {
                        }
                    }
                    mib.e(strReplaceAll, dqbVar.f16060a, new ngb(new f8b(), strReplaceAll));
                }
            } catch (Throwable unused2) {
            }
        }
    }

    public final void b() {
        try {
            d(new f0b(this), this.f16060a.f20565i);
            ArrayList arrayList = this.f16060a.f20556d;
            if (arrayList == null || arrayList.isEmpty()) {
                d(new f6b(this), this.f16060a.k);
            } else {
                d(new n3b(this), this.f16060a.j);
            }
        } catch (Throwable unused) {
        }
    }

    public final void c(b0 b0Var) {
        try {
            this.f41258a = b0Var;
            b0Var.setTag(this.f16061a);
            this.f41258a.setTaskBean(this.f16060a);
            this.f41258a.setScrollBean(this.f16060a.f20543a);
            this.f41258a.setClickBean(this.f16060a.f20544a);
            this.f41258a.setJs(this.f16060a.f20559f);
            b0 b0Var2 = this.f41258a;
            String strA = a(this.f16060a.f20555d);
            wtb wtbVar = this.f16060a;
            if (wtbVar.f20550b == null) {
                wtbVar.f20550b = "";
            }
            b0Var2.a(strA, wtbVar.f20550b);
        } catch (Throwable unused) {
        }
    }

    public final void d(r1 r1Var, long j) {
        try {
            this.f16059a.postDelayed(r1Var, j);
        } catch (Throwable unused) {
        }
    }

    public final void f() {
        ArrayList arrayList = this.f16062a;
        if (arrayList != null) {
            try {
                if (arrayList.isEmpty()) {
                    return;
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    String str = (String) arrayList.get(i);
                    mib.e(str, this.f16060a, new ngb(new ejb(), str));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void g() {
        try {
            String str = this.f16060a.f20553c;
            if (TextUtils.isEmpty(str)) {
                h();
            } else {
                mib.e(str, this.f16060a, new ogb(this));
            }
        } catch (Throwable unused) {
        }
    }

    public final void h() {
        try {
            this.f16059a.postDelayed(new Runnable() { // from class: com.zj.adlib.bqb
                @Override // java.lang.Runnable
                public final void run() {
                    this.f40817a.f();
                }
            }, this.f16060a.f20549b);
            wtb wtbVar = this.f16060a;
            if (wtbVar.f20548a) {
                this.f16059a.postDelayed(new nib(this), wtbVar.f20549b);
            }
        } catch (Throwable unused) {
        }
    }
}
