package com.zj.adlib;

import com.amap.api.col.p0003l.i;
import com.amap.api.col.p0003l.it;
import com.amap.api.col.p0003l.z;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ywa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ywa f46133a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public z f20944a;

    public ywa() {
        this.f20944a = null;
        this.f20944a = i.b("AMapThreadUtil");
    }

    public static ywa a() {
        if (f46133a == null) {
            synchronized (ywa.class) {
                if (f46133a == null) {
                    f46133a = new ywa();
                }
            }
        }
        return f46133a;
    }

    public static void c() {
        if (f46133a != null) {
            try {
                if (f46133a.f20944a != null) {
                    f46133a.f20944a.f();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            f46133a.f20944a = null;
            f46133a = null;
        }
    }

    public static void d(it itVar) {
        if (itVar != null) {
            try {
                itVar.cancelTask();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void b(it itVar) {
        try {
            this.f20944a.b(itVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
