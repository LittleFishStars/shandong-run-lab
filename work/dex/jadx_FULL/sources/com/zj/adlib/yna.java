package com.zj.adlib;

import android.content.Context;
import com.alipay.sdk.m.y.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class yna {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static i7b f46080a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile yna f20912a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f20913a;

    public yna(Context context) {
        this.f20913a = context;
        f46080a = i(context);
    }

    public static yna b(Context context) {
        if (f20912a == null) {
            synchronized (yna.class) {
                if (f20912a == null) {
                    f20912a = new yna(context);
                }
            }
        }
        return f20912a;
    }

    public static List<String> d(List<vna> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0) {
            Iterator<vna> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().a());
            }
        }
        return arrayList;
    }

    public static void h(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return;
        }
        String strB = vna.b(str);
        if (f46080a.p(strB, vna.class).size() > 0) {
            f46080a.j(strB, vna.class);
        }
        String[] strArrSplit = str2.split(l.b);
        ArrayList arrayList = new ArrayList();
        for (String str3 : strArrSplit) {
            arrayList.add(new vna(str, str3));
        }
        f46080a.l(arrayList);
    }

    public static i7b i(Context context) {
        try {
            return new i7b(context, xna.a());
        } catch (Throwable th) {
            a7b.m(th, "OfflineDB", "getDB");
            th.printStackTrace();
            return null;
        }
    }

    public final synchronized tna a(String str) {
        if (!l()) {
            return null;
        }
        List listP = f46080a.p(wna.f(str), tna.class);
        if (listP.size() <= 0) {
            return null;
        }
        return (tna) listP.get(0);
    }

    public final ArrayList<tna> c() {
        ArrayList<tna> arrayList = new ArrayList<>();
        if (!l()) {
            return arrayList;
        }
        Iterator it = f46080a.p("", tna.class).iterator();
        while (it.hasNext()) {
            arrayList.add((tna) it.next());
        }
        return arrayList;
    }

    public final synchronized void e(tna tnaVar) {
        if (l()) {
            f46080a.h(tnaVar, wna.h(tnaVar.j()));
            h(tnaVar.e(), tnaVar.k());
        }
    }

    public final void f(String str, int i, long j, long j2, long j3) {
        if (l()) {
            g(str, i, j, new long[]{j2, 0, 0, 0, 0}, new long[]{j3, 0, 0, 0, 0});
        }
    }

    public final synchronized void g(String str, int i, long j, long[] jArr, long[] jArr2) {
        if (l()) {
            f46080a.h(new una(str, j, i, jArr[0], jArr2[0]), una.a(str));
        }
    }

    public final synchronized List<String> j(String str) {
        ArrayList arrayList = new ArrayList();
        if (!l()) {
            return arrayList;
        }
        arrayList.addAll(d(f46080a.p(vna.b(str), vna.class)));
        return arrayList;
    }

    public final synchronized void k(tna tnaVar) {
        if (l()) {
            f46080a.j(wna.h(tnaVar.j()), wna.class);
            f46080a.j(vna.b(tnaVar.e()), vna.class);
            f46080a.j(una.a(tnaVar.e()), una.class);
        }
    }

    public final boolean l() {
        if (f46080a == null) {
            f46080a = i(this.f20913a);
        }
        return f46080a != null;
    }

    public final synchronized void m(String str) {
        if (l()) {
            f46080a.j(wna.f(str), wna.class);
            f46080a.j(vna.b(str), vna.class);
            f46080a.j(una.a(str), una.class);
        }
    }

    public final synchronized String n(String str) {
        if (!l()) {
            return null;
        }
        List listP = f46080a.p(wna.h(str), wna.class);
        return listP.size() > 0 ? ((wna) listP.get(0)).c() : null;
    }
}
