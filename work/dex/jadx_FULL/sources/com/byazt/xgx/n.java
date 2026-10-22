package com.byazt.xgx;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.byazt.aas.zm;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1109, 46})
public class n {
    public static final String c = "n";
    public static volatile n n;
    public final CopyOnWriteArraySet<String> tt = new CopyOnWriteArraySet<>();
    public final List<WeakReference<a>> ve = new ArrayList(1);
    public final List<a> uj = new ArrayList(1);

    private n() {
        tt();
    }

    public static n c() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    private void tt() {
        ve();
    }

    private void ve() {
        PackageInfo packageInfo;
        String[] strArr;
        Context context = gt.getContext();
        if (context == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(packageName, 4096)) != null && (strArr = packageInfo.requestedPermissions) != null && strArr.length != 0) {
                for (int i = 0; i < strArr.length; i++) {
                    if (!TextUtils.isEmpty(strArr[i])) {
                        this.tt.add(strArr[i]);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean tt(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (zm.gt()) {
            return ve.c(context, str) && tt.c(context, str) == 0;
        }
        return tt.c(context, str) == 0;
    }

    private void tt(Activity activity, String[] strArr, a aVar) {
        boolean zC;
        for (String str : strArr) {
            if (aVar != null) {
                try {
                    if (!this.tt.contains(str)) {
                        zC = aVar.c(str, uj.NOT_FOUND);
                    } else if (tt.c(activity, str) != 0) {
                        zC = aVar.c(str, uj.DENIED);
                    } else {
                        zC = aVar.c(str, uj.GRANTED);
                    }
                    if (zC) {
                        break;
                    }
                } catch (Throwable th) {
                    m.c(th);
                }
            }
        }
        c(aVar);
    }

    private synchronized void c(String[] strArr, a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.c(strArr);
        this.uj.add(aVar);
        this.ve.add(new WeakReference<>(aVar));
    }

    private List<String> ve(Activity activity, String[] strArr, a aVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.tt.contains(str)) {
                if (!c(activity, str)) {
                    arrayList.add(str);
                } else if (aVar != null) {
                    aVar.c(str, uj.GRANTED);
                }
            } else if (aVar != null) {
                aVar.c(str, uj.NOT_FOUND);
            }
        }
        return arrayList;
    }

    private synchronized void c(a aVar) {
        Iterator<WeakReference<a>> it = this.ve.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next.get() == aVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<a> it2 = this.uj.iterator();
        while (it2.hasNext()) {
            if (it2.next() == aVar) {
                it2.remove();
            }
        }
    }

    public boolean c(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (zm.gt()) {
            return ve.c(context, str) && tt.c(context, str) == 0;
        }
        return tt.c(context, str) == 0;
    }

    public synchronized void c(Activity activity, String[] strArr, a aVar) {
        if (activity == null) {
            return;
        }
        try {
            c(strArr, aVar);
            List<String> listVe = ve(activity, strArr, aVar);
            if (listVe.isEmpty()) {
                c(aVar);
            } else {
                tt.requestPermissions(activity, (String[]) listVe.toArray(new String[listVe.size()]), 1);
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public synchronized void c(Activity activity, String[] strArr, int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                String str = strArr[i];
                if ((iArr[i] == -1 || (zm.gt() && !ve.c(activity, str))) && iArr[i] != -1) {
                    iArr[i] = -1;
                }
            }
            c(strArr, iArr, (String[]) null);
        } catch (Throwable th) {
            m.c(th);
        }
    }

    private void c(String[] strArr, int[] iArr, String[] strArr2) {
        int i;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<a>> it = this.ve.iterator();
            while (it.hasNext()) {
                a aVar = it.next().get();
                while (i < length) {
                    i = (aVar == null || aVar.c(strArr[i], iArr[i])) ? 0 : i + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<a> it2 = this.uj.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }
}
