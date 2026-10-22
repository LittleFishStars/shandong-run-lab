package com.zj.adlib;

import com.amap.api.col.p0003l.ju;
import com.amap.api.col.p0003l.ka;
import com.amap.api.col.p0003l.kb;
import com.amap.api.col.p0003l.kc;
import com.amap.api.col.p0003l.kd;
import com.amap.api.col.p0003l.ke;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class mfb {

    public static class a implements ju {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f43292a;
        public int b;
        public int c;

        public a(int i, int i2, int i3) {
            this.f43292a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // com.amap.api.col.p0003l.ju
        public final long a() {
            return mfb.a(this.f43292a, this.b);
        }

        @Override // com.amap.api.col.p0003l.ju
        public final int b() {
            return this.c;
        }
    }

    public static class b implements ju {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f43293a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f18189a;

        public b(long j, int i) {
            this.f18189a = j;
            this.f43293a = i;
        }

        @Override // com.amap.api.col.p0003l.ju
        public final long a() {
            return this.f18189a;
        }

        @Override // com.amap.api.col.p0003l.ju
        public final int b() {
            return this.f43293a;
        }
    }

    public static long a(int i, int i2) {
        return (((long) i2) & 4294967295L) | ((((long) i) & 4294967295L) << 32);
    }

    public static synchronized short b(long j) {
        return lfb.a().b(j);
    }

    public static synchronized void c(List<ka> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                ArrayList arrayList = new ArrayList(list.size());
                for (ka kaVar : list) {
                    if (kaVar instanceof kc) {
                        kc kcVar = (kc) kaVar;
                        arrayList.add(new a(kcVar.j, kcVar.k, kcVar.c));
                    } else if (kaVar instanceof kd) {
                        kd kdVar = (kd) kaVar;
                        arrayList.add(new a(kdVar.j, kdVar.k, kdVar.c));
                    } else if (kaVar instanceof ke) {
                        ke keVar = (ke) kaVar;
                        arrayList.add(new a(keVar.j, keVar.k, keVar.c));
                    } else if (kaVar instanceof kb) {
                        kb kbVar = (kb) kaVar;
                        arrayList.add(new a(kbVar.k, kbVar.l, kbVar.c));
                    }
                }
                lfb.a().d(arrayList);
            }
        }
    }

    public static synchronized short d(long j) {
        return lfb.a().g(j);
    }

    public static synchronized void e(List<mhb> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                ArrayList arrayList = new ArrayList(list.size());
                for (mhb mhbVar : list) {
                    arrayList.add(new b(mhbVar.f18215a, mhbVar.f43306a));
                }
                lfb.a().h(arrayList);
            }
        }
    }
}
