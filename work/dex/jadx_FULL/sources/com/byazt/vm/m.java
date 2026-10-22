package com.byazt.vm;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 130})
public final class m {
    public static final String c;
    public static String da;
    public static long sl;
    public static boolean t;
    public static final String tt;
    public static final List<com.byazt.gj.n> uj;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f29134a;
    public final nu n;
    public final gt sp;
    public Map<String, String> u;
    public final Context x;
    public Long yp;
    public final ReentrantLock ve = new ReentrantLock();
    public final AtomicBoolean i = new AtomicBoolean(false);

    static {
        String str = m.class.getSimpleName() + "#";
        tt = str;
        c = str;
        uj = new ArrayList();
    }

    public m(Context context) {
        this.x = context.getApplicationContext();
        nu nuVarC = rh.c(context);
        this.n = nuVarC;
        if (nuVarC != null) {
            this.f29134a = nuVarC.tt(context);
        } else {
            this.f29134a = false;
        }
        this.sp = new gt(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj() {
        int iIntValue;
        try {
            this.ve.lock();
            my myVarC = this.sp.c();
            long jLongValue = -1;
            boolean z = false;
            if (myVarC != null) {
                da = myVarC.c;
                Boolean bool = myVarC.ve;
                t = bool != null && bool.booleanValue();
                Long l = myVarC.sp;
                sl = l == null ? -1L : l.longValue();
                this.u = myVarC.c();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Pair<String, Boolean> pairC = c(this.x);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            my myVar = null;
            String string = null;
            if (pairC.first != null) {
                if (myVarC != null) {
                    string = myVarC.tt;
                    iIntValue = myVarC.f29135a.intValue() + 1;
                } else {
                    iIntValue = -1;
                }
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                }
                String str = string;
                if (iIntValue <= 0) {
                    iIntValue = 1;
                }
                my myVar2 = new my((String) pairC.first, str, (Boolean) pairC.second, Long.valueOf(jElapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(iIntValue), this.yp);
                this.sp.c(myVar2);
                myVar = myVar2;
            }
            if (myVar != null) {
                da = myVar.c;
                Boolean bool2 = myVar.ve;
                if (bool2 != null && bool2.booleanValue()) {
                    z = true;
                }
                t = z;
                Long l2 = myVar.sp;
                if (l2 != null) {
                    jLongValue = l2.longValue();
                }
                sl = jLongValue;
                this.u = myVar.c();
            }
        } finally {
            this.ve.unlock();
            c(new com.byazt.gj.n.c(da, t, sl), ve());
        }
    }

    private static Object[] ve() {
        Object[] array;
        List<com.byazt.gj.n> list = uj;
        synchronized (list) {
            array = list.size() > 0 ? list.toArray() : null;
        }
        return array;
    }

    public void tt() {
        if (this.i.compareAndSet(false, true)) {
            c(new Runnable() { // from class: com.byazt.vm.m.1
                @Override // java.lang.Runnable
                public void run() {
                    m.this.uj();
                }
            });
        }
    }

    @Nullable
    @WorkerThread
    public Map<String, String> c(long j) {
        if (!this.f29134a) {
            return null;
        }
        if (!com.byazt.gj.c.tt) {
            my myVarC = this.sp.c();
            if (myVarC != null) {
                return myVarC.c();
            }
            return null;
        }
        tt();
        if (this.u == null) {
            SystemClock.elapsedRealtime();
            try {
                if (this.ve.tryLock(j, TimeUnit.MILLISECONDS)) {
                    this.ve.unlock();
                }
            } catch (InterruptedException e) {
                com.byazt.yv.da.c(e);
                return this.u;
            }
        }
        return this.u;
    }

    @AnyThread
    public static void c(@Nullable com.byazt.gj.n nVar) {
        List<com.byazt.gj.n> list = uj;
        synchronized (list) {
            list.add(nVar);
        }
        String str = da;
        if (str != null) {
            c(new com.byazt.gj.n.c(str, t, sl), new Object[]{nVar});
        }
    }

    public nu c() {
        return this.n;
    }

    private static void c(@Nullable com.byazt.gj.n.c cVar, Object[] objArr) {
        if (cVar == null || objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            ((com.byazt.gj.n) obj).c(cVar);
        }
    }

    public static void c(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            com.byazt.yv.da.c(e);
        }
    }

    public static <K, V> void c(Map<K, V> map, K k, V v) {
        if (k == null || v == null) {
            return;
        }
        map.put(k, v);
    }

    @NonNull
    @WorkerThread
    private Pair<String, Boolean> c(Context context) {
        String str;
        Boolean boolValueOf;
        nu.c cVarVe;
        nu nuVar = this.n;
        if (nuVar == null || (cVarVe = nuVar.ve(context)) == null) {
            str = null;
            boolValueOf = null;
        } else {
            str = cVarVe.tt;
            boolValueOf = Boolean.valueOf(cVarVe.ve);
            if (cVarVe instanceof i.c) {
                this.yp = Long.valueOf(((i.c) cVarVe).c);
            }
        }
        return new Pair<>(str, boolValueOf);
    }

    private static void c(Runnable runnable) {
        x.c(c + "-query", runnable);
    }
}
