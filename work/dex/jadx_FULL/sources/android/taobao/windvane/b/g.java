package android.taobao.windvane.b;

import android.taobao.windvane.util.TaoLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f21197a = 1;
    public static int b = 0;
    public static int c = -1;
    private static volatile g d;
    private List<e> e = new ArrayList();
    private List<e> f = new ArrayList();
    private List<e> g = new ArrayList();
    private h h;

    public static g a() {
        if (d == null) {
            synchronized (g.class) {
                if (d == null) {
                    d = new g();
                }
            }
        }
        return d;
    }

    public synchronized void b(h hVar) {
        try {
            if (hVar == null) {
                TaoLog.e("WVEventService", "event can not be null");
                return;
            }
            h hVar2 = this.h;
            if (hVar2 == null) {
                TaoLog.e("WVEventService", "event already be null");
            } else if (hVar2 != hVar) {
                TaoLog.e("WVEventService", "remove failed");
            } else {
                this.h = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(e eVar, int i) {
        if (eVar != null) {
            if (i == f21197a) {
                this.e.add(eVar);
            } else if (i == b) {
                this.f.add(eVar);
            } else if (i == c) {
                this.g.add(eVar);
            }
        }
    }

    public synchronized void b(e eVar) {
        if (eVar != null) {
            int iIndexOf = this.f.indexOf(eVar);
            if (-1 != iIndexOf) {
                this.f.remove(iIndexOf);
            }
            int iIndexOf2 = this.e.indexOf(eVar);
            if (-1 != iIndexOf2) {
                this.e.remove(iIndexOf2);
            }
            int iIndexOf3 = this.g.indexOf(eVar);
            if (-1 != this.g.indexOf(eVar)) {
                this.g.remove(iIndexOf3);
            }
        }
    }

    public synchronized void a(e eVar) {
        a(eVar, b);
    }

    public synchronized void a(h hVar) {
        try {
            if (hVar == null) {
                TaoLog.e("WVEventService", "event can not be null");
            } else if (this.h != null) {
                TaoLog.e("WVEventService", "an instance has already been set, please wait it end");
            } else {
                this.h = hVar;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public f b(int i, Object... objArr) {
        c cVar = new c(null, null);
        h hVar = this.h;
        if (hVar != null) {
            return hVar.a(i, cVar, objArr);
        }
        return null;
    }

    public synchronized f a(int i, android.taobao.windvane.d.b bVar, String str, Object... objArr) {
        f fVarA;
        f fVarA2;
        f fVarA3;
        c cVar = new c(bVar, str);
        int i2 = 0;
        while (true) {
            List<e> list = this.e;
            if (list == null || i2 >= list.size()) {
                break;
            }
            if (this.e.get(i2) != null && (fVarA3 = this.e.get(i2).a(i, cVar, objArr)) != null && fVarA3.f21196a) {
                return fVarA3;
            }
            i2++;
        }
        int i3 = 0;
        while (true) {
            List<e> list2 = this.f;
            if (list2 == null || i3 >= list2.size()) {
                break;
            }
            if (this.f.get(i3) != null && (fVarA2 = this.f.get(i3).a(i, cVar, objArr)) != null && fVarA2.f21196a) {
                return fVarA2;
            }
            i3++;
        }
        int i4 = 0;
        while (true) {
            List<e> list3 = this.g;
            if (list3 == null || i4 >= list3.size()) {
                break;
            }
            if (this.g.get(i4) != null && (fVarA = this.g.get(i4).a(i, cVar, objArr)) != null && fVarA.f21196a) {
                return fVarA;
            }
            i4++;
        }
        return new f(false);
    }

    public f a(int i) {
        return a(i, null, null, new Object[0]);
    }

    public f a(int i, Object... objArr) {
        return a(i, null, null, objArr);
    }
}
