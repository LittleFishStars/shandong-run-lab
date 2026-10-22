package com.byazt.za;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.gj.a;
import com.byazt.lu.uj;
import com.byazt.tv.i;
import com.byazt.yv.da;
import com.zj.adlib.u15;
import java.util.HashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 76, 20})
public class c implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f29230a = null;
    public static int c = 0;
    public static final HashSet<Integer> i = new HashSet<>(8);
    public static long n = 0;
    public static int sp = -1;
    public static i tt;
    public static String uj;
    public static long ve;
    public final a x;

    public c(a aVar) {
        this.x = aVar;
    }

    public static i c(String str, String str2, long j, String str3) {
        i iVar = new i();
        if (TextUtils.isEmpty(str2)) {
            iVar.yp = str;
        } else {
            iVar.yp = str + u15.f19942b + str2;
        }
        iVar.tt = j;
        iVar.t = -1L;
        if (str3 == null) {
            str3 = "";
        }
        iVar.u = str3;
        uj.c(iVar);
        return iVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        i.add(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        i.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        i iVar = tt;
        if (iVar != null) {
            uj = iVar.yp;
            long jCurrentTimeMillis = System.currentTimeMillis();
            ve = jCurrentTimeMillis;
            c(tt, jCurrentTimeMillis);
            tt = null;
            if (activity.isChild()) {
                return;
            }
            sp = -1;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        i iVarC = c(activity.getClass().getName(), "", System.currentTimeMillis(), uj);
        tt = iVarC;
        iVarC.my = !i.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (activity.isChild()) {
            return;
        }
        try {
            sp = activity.getWindow().getDecorView().hashCode();
        } catch (Exception e) {
            da.tt(e);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        c++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (uj != null) {
            int i2 = c - 1;
            c = i2;
            if (i2 <= 0) {
                uj = null;
                f29230a = null;
                n = 0L;
                ve = 0L;
            }
        }
    }

    public static i c(i iVar, long j) {
        i iVar2 = (i) iVar.clone();
        iVar2.tt = j;
        long j2 = j - iVar.tt;
        if (j2 >= 0) {
            iVar2.t = j2;
        } else {
            da.tt((Throwable) null);
        }
        uj.c(iVar2);
        return iVar2;
    }
}
