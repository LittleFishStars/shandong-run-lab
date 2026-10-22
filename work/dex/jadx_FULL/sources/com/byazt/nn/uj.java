package com.byazt.nn;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.gq.t;
import com.byazt.hu.u;
import com.byazt.nr.m;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1020, 15})
public class uj {
    public static volatile uj c;
    public final LinkedList<c> tt = new LinkedList<>();
    public static final String[] ve = {"com", "android", "ss"};
    public static final int[] uj = {3101, 3102, 3103, 3201, 3202, 3203};

    @com.byazt.zqa.c(c = {0, 1, 1020, 123})
    public static class c {
        public final String c;
        public final long n;
        public final int tt;
        public final String uj;
        public final String ve;

        private c(String str, int i, String str2, String str3, long j) {
            this.c = str;
            this.tt = i;
            this.ve = str2 != null ? str2.toLowerCase() : null;
            this.uj = str3 != null ? str3.toLowerCase() : null;
            this.n = j;
        }
    }

    private uj() {
    }

    public static uj c() {
        if (c == null) {
            synchronized (uj.class) {
                if (c == null) {
                    c = new uj();
                }
            }
        }
        return c;
    }

    private c ve(String str) {
        try {
            PackageManager packageManager = t.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new c(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            m.c(th);
            return null;
        }
    }

    public void tt(String str) {
        tt();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.tt) {
            Iterator<c> it = this.tt.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().c)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public void c(String str) {
        c cVarVe;
        tt();
        if (TextUtils.isEmpty(str) || (cVarVe = ve(str)) == null) {
            return;
        }
        synchronized (this.tt) {
            this.tt.add(cVarVe);
        }
    }

    public Pair<c, Integer> tt(com.byazt.dd.tt ttVar) {
        int i;
        if (ttVar == null) {
            return null;
        }
        try {
            tt();
            if (this.tt.isEmpty()) {
                return null;
            }
            String strAw = ttVar.aw();
            String strN = ttVar.n();
            String strNb = ttVar.nb();
            int iQp = ttVar.qp();
            int length = uj.length;
            c[] cVarArr = new c[length];
            synchronized (this.tt) {
                Iterator<c> it = this.tt.iterator();
                PackageInfo packageInfoC = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c next = it.next();
                    if (next.n >= ttVar.h()) {
                        if (TextUtils.isEmpty(strAw)) {
                            if (packageInfoC == null) {
                                packageInfoC = u.c(ttVar);
                            }
                            if (packageInfoC != null) {
                                try {
                                    strAw = (String) t.getContext().getPackageManager().getApplicationLabel(packageInfoC.applicationInfo);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(strAw) && !TextUtils.isEmpty(next.uj)) {
                            strAw = strAw.toLowerCase();
                            if (strAw.equals(next.uj)) {
                                cVarArr[0] = next;
                                break;
                            }
                            if (strAw.contains(next.uj) || next.uj.contains(strAw)) {
                                cVarArr[1] = next;
                                break;
                            }
                        }
                        if (TextUtils.isEmpty(strN)) {
                            if (packageInfoC == null) {
                                packageInfoC = u.c(ttVar);
                            }
                            if (packageInfoC != null) {
                                strN = packageInfoC.packageName;
                            }
                        }
                        if (!TextUtils.isEmpty(strN) && !TextUtils.isEmpty(next.c)) {
                            strN = strN.toLowerCase();
                            if (!strN.contains(next.c) && !next.c.contains(strN)) {
                                if (cVarArr[3] == null) {
                                    if (c(strN, next.c)) {
                                        cVarArr[3] = next;
                                    }
                                }
                            }
                            cVarArr[2] = next;
                            break;
                        }
                        if (cVarArr[4] == null) {
                            if (TextUtils.isEmpty(strNb)) {
                                if (packageInfoC == null) {
                                    packageInfoC = u.c(ttVar);
                                }
                                if (packageInfoC != null) {
                                    strNb = packageInfoC.versionName;
                                }
                            }
                            if (!TextUtils.isEmpty(strNb) && !TextUtils.isEmpty(next.ve)) {
                                strNb = strNb.toLowerCase();
                                if (strNb.equals(next.ve)) {
                                    cVarArr[4] = next;
                                }
                            }
                            if (cVarArr[5] == null) {
                                if (iQp <= 0) {
                                    if (packageInfoC == null) {
                                        packageInfoC = u.c(ttVar);
                                    }
                                    if (packageInfoC != null) {
                                        iQp = packageInfoC.versionCode;
                                    }
                                }
                                if (iQp == next.tt) {
                                    cVarArr[5] = next;
                                }
                            }
                        }
                    }
                }
            }
            for (i = 0; i < length; i++) {
                if (cVarArr[i] != null) {
                    return new Pair<>(cVarArr[i], Integer.valueOf(uj[i]));
                }
            }
        } catch (Throwable th) {
            m.c(th);
        }
        return null;
    }

    public c c(com.byazt.dd.tt ttVar) {
        if (ttVar == null) {
            return null;
        }
        tt();
        synchronized (this.tt) {
            for (c cVar : this.tt) {
                if (cVar.n > ttVar.h()) {
                    return cVar;
                }
            }
            return null;
        }
    }

    private static boolean c(String str, String str2) {
        boolean z;
        try {
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            if (strArrSplit.length != 0 && strArrSplit2.length != 0) {
                int i = 0;
                int i2 = 0;
                for (String str3 : strArrSplit) {
                    String[] strArr = ve;
                    int length = strArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            z = false;
                            break;
                        }
                        String str4 = strArr[i3];
                        if (str4.equals(str3)) {
                            if (i < strArrSplit2.length && str4.equals(strArrSplit2[i])) {
                                i++;
                            }
                            z = true;
                            break;
                        }
                        i3++;
                    }
                    if (!z) {
                        int i4 = i2;
                        int i5 = i;
                        while (i < strArrSplit2.length) {
                            if (str3.equals(strArrSplit2[i])) {
                                if (i == i5) {
                                    i5++;
                                }
                                i4++;
                                if (i4 >= 2) {
                                    return true;
                                }
                            }
                            i++;
                        }
                        i = i5;
                        i2 = i4;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            m.c(th);
        }
    }

    private void tt() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.tt) {
            Iterator<c> it = this.tt.iterator();
            while (it.hasNext() && jCurrentTimeMillis - it.next().n > 1800000) {
                it.remove();
            }
        }
    }
}
