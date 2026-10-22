package com.byazt.omf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 115})
public class rh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Handler f28885a = null;
    public static volatile boolean c = false;
    public static AtomicBoolean tt = new AtomicBoolean(false);
    public static AtomicBoolean ve = new AtomicBoolean(false);
    public static AtomicBoolean uj = new AtomicBoolean(false);
    public static final long n = SystemClock.elapsedRealtime();

    @com.byazt.zqa.c(c = {0, 1, 31, 739})
    public static final class c implements com.byazt.yj.qy {
        private c() {
        }

        @Override // com.byazt.yj.qy
        public void clearAllCache() {
            com.byazt.xky.tt.tt().clearAllCache();
        }

        @Override // com.byazt.yj.qy
        public void clearCache(double d) {
            com.byazt.xky.tt.tt().clearCache(d);
        }

        @Override // com.byazt.yj.qy
        public void clearDiskCache(double d) {
            com.byazt.xky.tt.tt().clearDiskCache(d);
        }

        @Override // com.byazt.yj.qy
        public void clearMemoryCache(double d) {
            com.byazt.xky.tt.tt().clearMemoryCache(d);
        }

        @Override // com.byazt.yj.qy
        public com.byazt.yj.yp from(String str) {
            return com.byazt.xky.tt.tt().from(str);
        }

        @Override // com.byazt.yj.qy
        public InputStream getCacheStream(String str, String str2) {
            return com.byazt.xky.tt.tt().getCacheStream(str, str2);
        }

        @Override // com.byazt.yj.qy
        public InputStream getDiskCacheStream(String str, String str2, String str3) {
            return com.byazt.xky.tt.tt().getDiskCacheStream(str, str2, str3);
        }

        @Override // com.byazt.yj.qy
        public boolean hasDiskCache(String str, String str2, String str3) {
            return com.byazt.xky.tt.tt().hasDiskCache(str, str2, str3);
        }
    }

    public static Handler a() {
        if (f28885a == null) {
            synchronized (rh.class) {
                if (f28885a == null) {
                    f28885a = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f28885a;
    }

    public static void c() {
        Context context;
        if (uj.get() || !gt.tt().tk() || (context = gt.getContext()) == null) {
            return;
        }
        try {
            com.byazt.hy.n.c().tt().c(context, true, (com.byazt.hw.tt) new com.byazt.hy.uj(context));
        } catch (Exception unused) {
        }
        uj.set(true);
    }

    public static void n() {
        com.byazt.mf.c.c().c(new com.byazt.mf.tt() { // from class: com.byazt.omf.rh.4
            @Override // com.byazt.mf.tt
            public int delete(String str, String str2, String[] strArr) {
                return com.byazt.pe.c.delete(gt.getContext(), str, str2, strArr);
            }

            @Override // com.byazt.mf.tt
            public void insert(String str, ContentValues contentValues) {
                com.byazt.pe.c.insert(gt.getContext(), str, contentValues);
            }

            @Override // com.byazt.mf.tt
            public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
                return com.byazt.pe.c.query(gt.getContext(), str, strArr, str2, strArr2, str3, str4, str5);
            }

            @Override // com.byazt.mf.tt
            public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
                return com.byazt.pe.c.update(gt.getContext(), str, contentValues, str2, strArr);
            }
        });
        com.byazt.mf.c.c().c(new com.byazt.mf.uj() { // from class: com.byazt.omf.rh.5
            @Override // com.byazt.mf.uj
            public void c(final int i) {
                com.byazt.ukr.yp.c().n(new com.byazt.ee.c() { // from class: com.byazt.omf.rh.5.1
                    @Override // com.byazt.ee.c
                    public com.byazt.qal.c c() throws Exception {
                        return com.byazt.qal.tt.tt().tt(i).sp(sp.c(i));
                    }
                });
            }
        });
        com.byazt.mf.c.c().c(new c());
        com.byazt.mf.c.c().c(new com.byazt.mf.n() { // from class: com.byazt.omf.rh.6
            @Override // com.byazt.mf.n
            public void delete(String str, String str2) {
                com.byazt.by.tt.c().c(str, str2);
            }

            @Override // com.byazt.mf.n
            public void update(String str, com.byazt.ku.ve veVar) {
                com.byazt.by.tt.c().c(str, veVar);
            }
        });
    }

    private static void sp() {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            Method declaredMethod = cls.getDeclaredMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(objInvoke, true);
        } catch (Throwable unused) {
        }
    }

    public static void tt() {
        gt.tt().c(1);
        if (!uj.get()) {
            c();
        }
        Context context = gt.getContext();
        if (context == null) {
            return;
        }
        try {
            com.byazt.hy.n.c().tt().c(context, com.byazt.ue.tt.c());
        } catch (Exception unused) {
        }
    }

    public static void uj() {
        com.byazt.mf.c.c().c(new com.byazt.mf.ve() { // from class: com.byazt.omf.rh.2
            @Override // com.byazt.mf.ve
            public String a() {
                return x.m().rl();
            }

            @Override // com.byazt.mf.ve
            public int c() {
                if (gt.tt() == null) {
                    return 0;
                }
                return gt.tt().ab();
            }

            @Override // com.byazt.mf.ve
            public int da() {
                return x.m().pu();
            }

            @Override // com.byazt.mf.ve
            public Context getContext() {
                return gt.getContext();
            }

            @Override // com.byazt.mf.ve
            public int i() {
                return gt.tt().op();
            }

            @Override // com.byazt.mf.ve
            public com.byazt.va.ve n() {
                return com.byazt.hy.n.c().tt().ve();
            }

            @Override // com.byazt.mf.ve
            public int sl() {
                return gt.tt().fv();
            }

            @Override // com.byazt.mf.ve
            public int sp() {
                return 0;
            }

            @Override // com.byazt.mf.ve
            public boolean t() {
                return com.byazt.ue.tt.c();
            }

            @Override // com.byazt.mf.ve
            public Handler tt() {
                return rh.a();
            }

            @Override // com.byazt.mf.ve
            public ExecutorService u() {
                return null;
            }

            @Override // com.byazt.mf.ve
            public com.byazt.va.tt uj() {
                return com.byazt.hy.n.c().tt().uj();
            }

            @Override // com.byazt.mf.ve
            public com.byazt.ku.c ve() {
                return gt.c().c(1);
            }

            @Override // com.byazt.mf.ve
            public int x() {
                return gt.tt().ru();
            }

            @Override // com.byazt.mf.ve
            public ExecutorService yp() {
                return null;
            }

            @Override // com.byazt.mf.ve
            public int z() {
                return pf.uj(gt.getContext());
            }
        });
        com.byazt.nr.z.c(new com.byazt.nr.z.c() { // from class: com.byazt.omf.rh.3
            @Override // com.byazt.nr.z.c
            public String c() {
                return com.byazt.fh.ve.c("");
            }

            @Override // com.byazt.nr.z.c
            public String tt() {
                return com.byazt.fh.n.c().uj();
            }
        });
    }

    public static void ve() {
        com.byazt.it.ve veVarC = tt.c();
        long jCurrentTimeMillis = veVarC.get("sdk_first_init_timestamp", 0L);
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
            veVarC.put("sdk_first_init_timestamp", jCurrentTimeMillis);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        String strTt = nb.tt(jCurrentTimeMillis, jCurrentTimeMillis2);
        long j = veVarC.get("sdk_init_timestamp", 0L);
        StringBuilder sb = new StringBuilder();
        sb.append(j != 0 ? (jCurrentTimeMillis2 - j) / 1000 : 0L);
        com.byazt.ukr.yp.c().c(strTt, sb.toString());
        veVarC.put("sdk_init_timestamp", System.currentTimeMillis());
    }

    private static void x() {
        com.byazt.by.uj.c().tt(UUID.randomUUID().toString());
    }

    public static void c(Context context) {
        tt.set(true);
        ve.set(true);
        sp();
        pf.c(context);
        x();
        String strC = com.byazt.aas.z.c();
        com.byazt.nr.m.c("appLogID", strC);
        if (!TextUtils.isEmpty(strC)) {
            com.byazt.ukr.tt.c(strC);
        }
        if (com.byazt.lkt.c.c() != null) {
            com.byazt.lkt.c.c().c(strC);
        }
        com.byazt.six.tt.c();
        new com.byazt.xo.tt(256).c(new Runnable() { // from class: com.byazt.omf.rh.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.hef.tt.tt();
            }
        });
    }
}
