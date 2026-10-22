package com.byazt.utw;

import android.annotation.SuppressLint;
import android.content.Context;
import com.byazt.nr.m;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 450, 15})
public final class uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f29113a = false;
    public static volatile com.byazt.byh.tt c = null;
    public static volatile com.byazt.emg.ve da = null;

    @SuppressLint({"StaticFieldLeak"})
    public static volatile Context sl = null;
    public static volatile com.byazt.byh.ve tt = null;
    public static volatile Integer uj = null;
    public static volatile int ve = 3;
    public static volatile boolean x;
    public static final boolean n = m.ve();
    public static volatile boolean sp = true;
    public static volatile int i = 0;

    public static void c(boolean z) {
        x = z;
    }

    public static Context getContext() {
        return sl;
    }

    public static com.byazt.byh.tt tt() {
        return c;
    }

    public static void c(int i2) {
        i = i2;
    }

    public static void c(com.byazt.byh.ve veVar, Context context) {
        if (veVar != null && context != null) {
            sl = context.getApplicationContext();
            if (tt != null) {
                return;
            }
            com.byazt.byh.tt ttVar = c;
            if (ttVar != null && ttVar.c.getAbsolutePath().equals(veVar.c.getAbsolutePath())) {
                throw new IllegalArgumentException("DiskLruCache and DiskCache can't use the same dir");
            }
            tt = veVar;
            da = com.byazt.emg.ve.c(context);
            tt.c(new com.byazt.byh.ve.c() { // from class: com.byazt.utw.uj.1
                @Override // com.byazt.byh.ve.c
                public void c(String str) {
                    if (uj.n) {
                        m.c("TAG_PROXY_DiskLruCache", "new cache created: ".concat(String.valueOf(str)));
                    }
                }

                @Override // com.byazt.byh.ve.c
                public void c(Set<String> set) {
                    uj.da.c(set, 0);
                    if (uj.n) {
                        m.c("TAG_PROXY_DiskLruCache", "cache file removed, ".concat(String.valueOf(set)));
                    }
                }
            });
            ve veVarC = ve.c();
            veVarC.c(veVar);
            veVarC.c(da);
            return;
        }
        throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
    }

    public static com.byazt.byh.ve c() {
        return tt;
    }
}
