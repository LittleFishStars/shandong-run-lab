package com.byazt.ga;

import android.content.Context;
import android.os.Trace;
import com.alibaba.android.arouter.utils.Consts;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 256, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long[] f28559a = null;
    public static boolean c = false;
    public static com.byazt.xy.n da = null;
    public static com.byazt.xy.a i = null;
    public static String[] n = null;
    public static volatile com.byazt.xy.x sl = null;
    public static int sp = 0;
    public static volatile com.byazt.xy.sp t = null;
    public static boolean tt = false;
    public static boolean uj = true;
    public static boolean ve = true;
    public static int x;

    public static void c(String str) {
        if (tt) {
            int i2 = sp;
            if (i2 == 20) {
                x++;
                return;
            }
            n[i2] = str;
            f28559a[i2] = System.nanoTime();
            Trace.beginSection(str);
            sp++;
        }
    }

    public static float tt(String str) {
        int i2 = x;
        if (i2 > 0) {
            x = i2 - 1;
            return 0.0f;
        }
        if (!tt) {
            return 0.0f;
        }
        int i3 = sp - 1;
        sp = i3;
        if (i3 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(n[i3])) {
            Trace.endSection();
            return (System.nanoTime() - f28559a[sp]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + n[sp] + Consts.DOT);
    }

    public static com.byazt.xy.x c(Context context) {
        com.byazt.xy.x xVar = sl;
        if (xVar == null) {
            synchronized (com.byazt.xy.x.class) {
                xVar = sl;
                if (xVar == null) {
                    com.byazt.xy.sp spVarTt = tt(context);
                    com.byazt.xy.a ttVar = i;
                    if (ttVar == null) {
                        ttVar = new com.byazt.xy.tt();
                    }
                    xVar = new com.byazt.xy.x(spVarTt, ttVar);
                    sl = xVar;
                }
            }
        }
        return xVar;
    }

    public static com.byazt.xy.sp tt(Context context) {
        if (!ve) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        com.byazt.xy.sp spVar = t;
        if (spVar == null) {
            synchronized (com.byazt.xy.sp.class) {
                spVar = t;
                if (spVar == null) {
                    com.byazt.xy.n nVar = da;
                    if (nVar == null) {
                        nVar = new com.byazt.xy.n() { // from class: com.byazt.ga.n.1
                            @Override // com.byazt.xy.n
                            public File c() {
                                return new File(com.byazt.nys.tt.tt(applicationContext), "lottie_network_cache");
                            }
                        };
                    }
                    spVar = new com.byazt.xy.sp(nVar);
                    t = spVar;
                }
            }
        }
        return spVar;
    }

    public static boolean c() {
        return uj;
    }
}
