package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.bkc;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f31387a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final zzgy f5815a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Class f5816a;
    public static final zzgy b;

    static {
        Class<?> cls;
        Class<?> cls2;
        zzgy zzgyVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f5816a = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzgyVar = (zzgy) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        f5815a = zzgyVar;
        b = new p0();
    }

    public static int A(List list) {
        int iW;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof t) {
            t tVar = (t) list;
            iW = 0;
            while (i < size) {
                iW += zzdj.w(tVar.a(i));
                i++;
            }
        } else {
            iW = 0;
            while (i < size) {
                iW += zzdj.w(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iW;
    }

    public static int B(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzdj.A(i << 3) + 4);
    }

    public static int C(List list) {
        return list.size() * 4;
    }

    public static int D(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzdj.A(i << 3) + 8);
    }

    public static int E(List list) {
        return list.size() * 8;
    }

    public static int F(int i, List list, zzgh zzghVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iV = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iV += zzdj.v(i, (zzfo) list.get(i2), zzghVar);
        }
        return iV;
    }

    public static int G(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return H(list) + (size * zzdj.A(i << 3));
    }

    public static int H(List list) {
        int iW;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof t) {
            t tVar = (t) list;
            iW = 0;
            while (i < size) {
                iW += zzdj.w(tVar.a(i));
                i++;
            }
        } else {
            iW = 0;
            while (i < size) {
                iW += zzdj.w(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iW;
    }

    public static int I(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return J(list) + (list.size() * zzdj.A(i << 3));
    }

    public static int J(List list) {
        int iB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            iB = 0;
            while (i < size) {
                iB += zzdj.B(zVar.a(i));
                i++;
            }
        } else {
            iB = 0;
            while (i < size) {
                iB += zzdj.B(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iB;
    }

    public static int K(int i, Object obj, zzgh zzghVar) {
        if (!(obj instanceof u)) {
            return zzdj.A(i << 3) + zzdj.y((zzfo) obj, zzghVar);
        }
        int i2 = zzdj.f31401a;
        int iA = ((u) obj).a();
        return zzdj.A(i << 3) + zzdj.A(iA) + iA;
    }

    public static int L(int i, List list, zzgh zzghVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iA = zzdj.A(i << 3) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof u) {
                int iA2 = ((u) obj).a();
                iA += zzdj.A(iA2) + iA2;
            } else {
                iA += zzdj.y((zzfo) obj, zzghVar);
            }
        }
        return iA;
    }

    public static int M(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return N(list) + (size * zzdj.A(i << 3));
    }

    public static int N(List list) {
        int iA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof t) {
            t tVar = (t) list;
            iA = 0;
            while (i < size) {
                int iA2 = tVar.a(i);
                iA += zzdj.A((iA2 >> 31) ^ (iA2 + iA2));
                i++;
            }
        } else {
            iA = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iA += zzdj.A((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iA;
    }

    public static int O(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return P(list) + (size * zzdj.A(i << 3));
    }

    public static int P(List list) {
        int iB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            iB = 0;
            while (i < size) {
                long jA = zVar.a(i);
                iB += zzdj.B((jA >> 63) ^ (jA + jA));
                i++;
            }
        } else {
            iB = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iB += zzdj.B((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
        }
        return iB;
    }

    public static int Q(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        boolean z = list instanceof zzew;
        int iA = zzdj.A(i << 3) * size;
        if (z) {
            zzew zzewVar = (zzew) list;
            while (i2 < size) {
                Object objK = zzewVar.k(i2);
                if (objK instanceof zzdb) {
                    int iZzd = ((zzdb) objK).zzd();
                    iA += zzdj.A(iZzd) + iZzd;
                } else {
                    iA += zzdj.z((String) objK);
                }
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzdb) {
                    int iZzd2 = ((zzdb) obj).zzd();
                    iA += zzdj.A(iZzd2) + iZzd2;
                } else {
                    iA += zzdj.z((String) obj);
                }
                i2++;
            }
        }
        return iA;
    }

    public static int R(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return S(list) + (size * zzdj.A(i << 3));
    }

    public static int S(List list) {
        int iA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof t) {
            t tVar = (t) list;
            iA = 0;
            while (i < size) {
                iA += zzdj.A(tVar.a(i));
                i++;
            }
        } else {
            iA = 0;
            while (i < size) {
                iA += zzdj.A(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iA;
    }

    public static int T(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return U(list) + (size * zzdj.A(i << 3));
    }

    public static int U(List list) {
        int iB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            iB = 0;
            while (i < size) {
                iB += zzdj.B(zVar.a(i));
                i++;
            }
        } else {
            iB = 0;
            while (i < size) {
                iB += zzdj.B(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iB;
    }

    public static zzgy V() {
        return f5815a;
    }

    public static zzgy W() {
        return b;
    }

    public static Object a(Object obj, int i, int i2, Object obj2, zzgy zzgyVar) {
        if (obj2 == null) {
            obj2 = zzgyVar.c(obj);
        }
        zzgyVar.f(obj2, i, i2);
        return obj2;
    }

    public static void b(zzdp zzdpVar, Object obj, Object obj2) {
        bkc bkcVarB = zzdpVar.b(obj2);
        if (bkcVarB.f15553a.isEmpty()) {
            return;
        }
        zzdpVar.c(obj).h(bkcVarB);
    }

    public static void c(zzgy zzgyVar, Object obj, Object obj2) {
        zzgyVar.h(obj, zzgyVar.e(zzgyVar.d(obj), zzgyVar.d(obj2)));
    }

    public static void d(Class cls) {
        Class cls2;
        if (!zzed.class.isAssignableFrom(cls) && (cls2 = f5816a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void e(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.D(i, list, z);
    }

    public static void f(int i, List list, zzhq zzhqVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.l(i, list);
    }

    public static void g(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.y(i, list, z);
    }

    public static void h(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.B(i, list, z);
    }

    public static void i(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.o(i, list, z);
    }

    public static void j(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.p(i, list, z);
    }

    public static void k(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.j(i, list, z);
    }

    public static void l(int i, List list, zzhq zzhqVar, zzgh zzghVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((l) zzhqVar).C(i, list.get(i2), zzghVar);
        }
    }

    public static void m(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.s(i, list, z);
    }

    public static void n(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.t(i, list, z);
    }

    public static void o(int i, List list, zzhq zzhqVar, zzgh zzghVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((l) zzhqVar).z(i, list.get(i2), zzghVar);
        }
    }

    public static void p(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.q(i, list, z);
    }

    public static void q(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.f(i, list, z);
    }

    public static void r(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.h(i, list, z);
    }

    public static void s(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.d(i, list, z);
    }

    public static void t(int i, List list, zzhq zzhqVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.K(i, list);
    }

    public static void u(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.I(i, list, z);
    }

    public static void v(int i, List list, zzhq zzhqVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhqVar.J(i, list, z);
    }

    public static boolean w(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int x(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzdj.A(i << 3) + 1);
    }

    public static int y(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iA = size * zzdj.A(i << 3);
        for (int i2 = 0; i2 < list.size(); i2++) {
            int iZzd = ((zzdb) list.get(i2)).zzd();
            iA += zzdj.A(iZzd) + iZzd;
        }
        return iA;
    }

    public static int z(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return A(list) + (size * zzdj.A(i << 3));
    }
}
