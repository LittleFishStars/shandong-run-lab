package com.zj.adlib;

import android.os.SystemClock;
import com.amap.api.col.p0003l.ka;
import com.amap.api.col.p0003l.kb;
import com.amap.api.col.p0003l.kc;
import com.amap.api.col.p0003l.kd;
import com.amap.api.col.p0003l.ke;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class peb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ka f43965a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public lhb f18828a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f18829a = new a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<ka> f18830a = new ArrayList(3);
    public ka b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte f43966a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ka f18831a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f18832a;
        public ka b;
        public ka c;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public List<ka> f18833a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public List<ka> f18834b = new ArrayList();

        public static boolean c(ka kaVar, ka kaVar2) {
            if (kaVar == null || kaVar2 == null) {
                return (kaVar == null) == (kaVar2 == null);
            }
            if ((kaVar instanceof kc) && (kaVar2 instanceof kc)) {
                kc kcVar = (kc) kaVar;
                kc kcVar2 = (kc) kaVar2;
                return kcVar.j == kcVar2.j && kcVar.k == kcVar2.k;
            }
            if ((kaVar instanceof kb) && (kaVar2 instanceof kb)) {
                kb kbVar = (kb) kaVar;
                kb kbVar2 = (kb) kaVar2;
                return kbVar.l == kbVar2.l && kbVar.k == kbVar2.k && kbVar.j == kbVar2.j;
            }
            if ((kaVar instanceof kd) && (kaVar2 instanceof kd)) {
                kd kdVar = (kd) kaVar;
                kd kdVar2 = (kd) kaVar2;
                return kdVar.j == kdVar2.j && kdVar.k == kdVar2.k;
            }
            if ((kaVar instanceof ke) && (kaVar2 instanceof ke)) {
                ke keVar = (ke) kaVar;
                ke keVar2 = (ke) kaVar2;
                if (keVar.j == keVar2.j && keVar.k == keVar2.k) {
                    return true;
                }
            }
            return false;
        }

        public final void a() {
            this.f43966a = (byte) 0;
            this.f18832a = "";
            this.f18831a = null;
            this.b = null;
            this.c = null;
            this.f18833a.clear();
            this.f18834b.clear();
        }

        public final void b(byte b, String str, List<ka> list) {
            a();
            this.f43966a = b;
            this.f18832a = str;
            if (list != null) {
                this.f18833a.addAll(list);
                for (ka kaVar : this.f18833a) {
                    boolean z = kaVar.i;
                    if (!z && kaVar.h) {
                        this.b = kaVar;
                    } else if (z && kaVar.h) {
                        this.c = kaVar;
                    }
                }
            }
            ka kaVar2 = this.b;
            if (kaVar2 == null) {
                kaVar2 = this.c;
            }
            this.f18831a = kaVar2;
        }

        public final String toString() {
            return "CellInfo{radio=" + ((int) this.f43966a) + ", operator='" + this.f18832a + "', mainCell=" + this.f18831a + ", mainOldInterCell=" + this.b + ", mainNewInterCell=" + this.c + ", cells=" + this.f18833a + ", historyMainCellList=" + this.f18834b + '}';
        }
    }

    public final a a(lhb lhbVar, boolean z, byte b, String str, List<ka> list) {
        if (z) {
            this.f18829a.a();
            return null;
        }
        this.f18829a.b(b, str, list);
        if (this.f18829a.f18831a == null) {
            return null;
        }
        if (!(this.f18828a == null || d(lhbVar) || !a.c(this.f18829a.b, this.f43965a) || !a.c(this.f18829a.c, this.b))) {
            return null;
        }
        a aVar = this.f18829a;
        this.f43965a = aVar.b;
        this.b = aVar.c;
        this.f18828a = lhbVar;
        mfb.c(aVar.f18833a);
        c(this.f18829a);
        return this.f18829a;
    }

    public final void b(ka kaVar) {
        if (kaVar == null) {
            return;
        }
        int size = this.f18830a.size();
        if (size == 0) {
            this.f18830a.add(kaVar);
            return;
        }
        int i = -1;
        long jMin = Long.MAX_VALUE;
        int i2 = 0;
        int i3 = -1;
        while (true) {
            if (i2 >= size) {
                i = i3;
                break;
            }
            ka kaVar2 = this.f18830a.get(i2);
            if (kaVar.equals(kaVar2)) {
                int i4 = kaVar.c;
                if (i4 == kaVar2.c) {
                    break;
                }
                kaVar2.e = i4;
                kaVar2.c = i4;
                break;
            }
            jMin = Math.min(jMin, kaVar2.e);
            if (jMin == kaVar2.e) {
                i3 = i2;
            }
            i2++;
        }
        if (i >= 0) {
            if (size < 3) {
                this.f18830a.add(kaVar);
            } else {
                if (kaVar.e <= jMin || i >= size) {
                    return;
                }
                this.f18830a.remove(i);
                this.f18830a.add(kaVar);
            }
        }
    }

    public final void c(a aVar) {
        synchronized (this.f18830a) {
            for (ka kaVar : aVar.f18833a) {
                if (kaVar != null && kaVar.h) {
                    ka kaVarClone = kaVar.clone();
                    kaVarClone.e = SystemClock.elapsedRealtime();
                    b(kaVarClone);
                }
            }
            this.f18829a.f18834b.clear();
            this.f18829a.f18834b.addAll(this.f18830a);
        }
    }

    public final boolean d(lhb lhbVar) {
        float f;
        float f2 = ((khb) lhbVar).f17701a;
        if (f2 > 10.0f) {
            f = 2000.0f;
        } else {
            f = f2 > 2.0f ? 500.0f : 100.0f;
        }
        return lhbVar.a(this.f18828a) > ((double) f);
    }
}
