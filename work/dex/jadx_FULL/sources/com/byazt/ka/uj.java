package com.byazt.ka;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.byazt.nr.m;
import com.byazt.vx.zm;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 874, 15})
public class uj {
    public static uj uj;
    public final Set<String> c = new HashSet(1);
    public final List<n> tt = new ArrayList(1);
    public final List<WeakReference<n>> ve = new ArrayList(1);

    private uj() {
        tt();
    }

    public static uj c() {
        if (uj == null) {
            uj = new uj();
        }
        return uj;
    }

    private void tt() {
        PackageInfo packageInfo;
        String[] strArr;
        Context context = com.byazt.bp.tt.getContext();
        if (context == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, 4096)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                for (int i = 0; i < strArr.length; i++) {
                    if (!TextUtils.isEmpty(strArr[i])) {
                        this.c.add(strArr[i]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @NonNull
    private List<String> ve(@NonNull Activity activity, @NonNull String[] strArr, @Nullable n nVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.c.contains(str)) {
                if (!c(activity, str)) {
                    arrayList.add(str);
                } else if (nVar != null) {
                    nVar.c(str, ve.GRANTED);
                }
            } else if (nVar != null) {
                nVar.c(str, ve.NOT_FOUND);
            }
        }
        return arrayList;
    }

    private synchronized void c(@NonNull String[] strArr, @Nullable n nVar) {
        if (nVar != null) {
            nVar.c(strArr);
            this.tt.add(nVar);
            this.ve.add(new WeakReference<>(nVar));
        }
    }

    private synchronized void c(@Nullable n nVar) {
        Iterator<WeakReference<n>> it = this.ve.iterator();
        while (it.hasNext()) {
            WeakReference<n> next = it.next();
            if (next.get() == nVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<n> it2 = this.tt.iterator();
        while (it2.hasNext()) {
            if (it2.next() == nVar) {
                it2.remove();
            }
        }
    }

    private void tt(@NonNull Activity activity, @NonNull String[] strArr, @Nullable n nVar) {
        boolean zC;
        for (String str : strArr) {
            if (nVar != null) {
                try {
                    if (!this.c.contains(str)) {
                        zC = nVar.c(str, ve.NOT_FOUND);
                    } else if (tt.c(activity, str) != 0) {
                        zC = nVar.c(str, ve.DENIED);
                    } else {
                        zC = nVar.c(str, ve.GRANTED);
                    }
                    if (zC) {
                        break;
                    }
                } catch (Throwable th) {
                    m.c(th);
                }
            }
        }
        c(nVar);
    }

    public synchronized boolean c(@Nullable Context context, @NonNull String str) {
        if (context == null) {
            return false;
        }
        if (zm.n()) {
            return com.byazt.xgx.ve.c(context, str) && (tt.c(context, str) == 0 || !this.c.contains(str));
        }
        return tt.c(context, str) == 0 || !this.c.contains(str);
    }

    public synchronized void c(@Nullable Activity activity, @NonNull String[] strArr, @Nullable n nVar) {
        if (activity != null) {
            try {
                c(strArr, nVar);
                List<String> listVe = ve(activity, strArr, nVar);
                if (listVe.isEmpty()) {
                    c(nVar);
                } else {
                    tt.requestPermissions(activity, (String[]) listVe.toArray(new String[listVe.size()]), 1);
                }
            } catch (Throwable th) {
                m.c(th);
            }
        }
    }

    public synchronized void c(@NonNull Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if ((iArr[i] == -1 || (zm.n() && !com.byazt.xgx.ve.c(activity, str))) && iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            c(strArr, iArr);
        } catch (Throwable th) {
            m.c(th);
        }
    }

    private void c(@NonNull String[] strArr, @NonNull int[] iArr) {
        int i;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<n>> it = this.ve.iterator();
            while (it.hasNext()) {
                n nVar = it.next().get();
                while (i < length) {
                    i = (nVar == null || nVar.c(strArr[i], iArr[i])) ? 0 : i + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<n> it2 = this.tt.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }
}
