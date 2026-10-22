package com.byazt.iz;

import android.text.TextUtils;
import com.byazt.nbs.da;
import com.byazt.qv.sp;
import com.byazt.vx.p;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 732, 20})
public class c {
    public List<Integer> sl;
    public AtomicInteger ve = new AtomicInteger(-1);
    public AtomicBoolean uj = new AtomicBoolean();
    public final Map<Integer, Boolean> c = new HashMap();
    public final Map<Integer, Boolean> tt = new HashMap();
    public final Map<Integer, AtomicInteger> n = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f28681a = new AtomicInteger();
    public final AtomicInteger sp = new AtomicInteger();
    public final AtomicInteger x = new AtomicInteger();
    public final List<String> i = new CopyOnWriteArrayList();
    public final AtomicInteger da = new AtomicInteger(-1000);

    public synchronized boolean a() {
        AtomicInteger atomicInteger = this.n.get(-100);
        if (atomicInteger == null) {
            return false;
        }
        return atomicInteger.get() == 0;
    }

    public List<Integer> c() {
        return this.sl;
    }

    public synchronized boolean da() {
        return this.x.get() == 0;
    }

    public synchronized boolean i() {
        return this.sp.get() == 0;
    }

    public synchronized boolean n(int i) {
        Boolean bool = this.tt.get(Integer.valueOf(i));
        return bool != null && bool.booleanValue();
    }

    public synchronized int sl() {
        return this.da.get();
    }

    public synchronized boolean sp() {
        AtomicInteger atomicInteger = this.n.get(0);
        if (atomicInteger == null) {
            return false;
        }
        return atomicInteger.get() == 0;
    }

    public synchronized void t() {
        this.ve.set(-1);
        this.uj.set(false);
        this.c.clear();
        this.tt.clear();
        this.n.clear();
        this.f28681a.set(0);
        this.i.clear();
        this.da.set(-1000);
    }

    public synchronized int tt() {
        return this.ve.get();
    }

    public synchronized void uj(int i) {
        this.tt.put(Integer.valueOf(i), Boolean.TRUE);
    }

    public synchronized boolean ve() {
        return tt() > 0;
    }

    public synchronized boolean x() {
        return this.f28681a.get() == 0;
    }

    public void c(List<Integer> list) {
        this.sl = list;
    }

    public synchronized void i(int i) {
        this.x.set(i);
    }

    public synchronized void tt(int i) {
        if (this.da.get() < i) {
            this.da.set(i);
        }
        this.c.put(Integer.valueOf(i), Boolean.TRUE);
    }

    public synchronized boolean ve(int i) {
        Boolean bool = this.c.get(Integer.valueOf(i));
        return bool != null && bool.booleanValue();
    }

    public synchronized void x(int i) {
        this.sp.set(i);
    }

    public synchronized void c(int i) {
        this.ve.set(i);
    }

    public synchronized void uj() {
        this.uj.set(true);
    }

    public synchronized void c(int i, int i2) {
        this.n.put(Integer.valueOf(i), new AtomicInteger(i2));
    }

    public synchronized boolean n() {
        return this.uj.get();
    }

    public synchronized int a(int i) {
        AtomicInteger atomicInteger = this.n.get(Integer.valueOf(i));
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    public synchronized void sp(int i) {
        this.f28681a.set(i);
    }

    public synchronized void c(int i, String str) {
        AtomicInteger atomicInteger = this.n.get(Integer.valueOf(i));
        if (atomicInteger != null && atomicInteger.get() != 0) {
            atomicInteger.decrementAndGet();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.i.add(str);
        if (i < -100 && this.sp.get() != 0) {
            this.sp.decrementAndGet();
        }
        if (i > 0 && this.x.get() != 0) {
            this.x.decrementAndGet();
        }
        if (this.f28681a.get() != 0) {
            this.f28681a.decrementAndGet();
        } else {
            com.byazt.eu.tt.uj(MediationConstant.TAG, "decrementTotalWaterFall--waterfall数量减少一个 ---不用再减了不然就变成-1了");
        }
    }

    public synchronized void c(List<da> list, List<da> list2, List<da> list3) {
        int size;
        if (list != null) {
            if (list.size() != 0) {
                List<da> listTt = sp.tt(list);
                int i = 0;
                if (!p.c(listTt)) {
                    size = listTt.size();
                    for (da daVar : listTt) {
                        for (String str : this.i) {
                            if (!TextUtils.isEmpty(str) && daVar != null && str.equals(daVar.rh())) {
                                size--;
                                break;
                            }
                        }
                    }
                } else {
                    size = 0;
                }
                if (size < 0) {
                    size = 0;
                }
                this.x.set(size);
                int size2 = list.size();
                if (list2 != null) {
                    size2 += list2.size();
                }
                if (list3 != null) {
                    size2 += list3.size();
                }
                for (da daVar2 : list) {
                    for (String str2 : this.i) {
                        if (!TextUtils.isEmpty(str2) && daVar2 != null && str2.equals(daVar2.rh())) {
                            size2--;
                            break;
                        }
                    }
                }
                if (!p.c(list2)) {
                    for (da daVar3 : list2) {
                        for (String str3 : this.i) {
                            if (!TextUtils.isEmpty(str3) && daVar3 != null && str3.equals(daVar3.rh())) {
                                size2--;
                                break;
                            }
                        }
                    }
                }
                if (!p.c(list3)) {
                    for (da daVar4 : list3) {
                        for (String str4 : this.i) {
                            if (!TextUtils.isEmpty(str4) && daVar4 != null && str4.equals(daVar4.rh())) {
                                size2--;
                                break;
                            }
                        }
                    }
                }
                if (size2 >= 0) {
                    i = size2;
                }
                this.f28681a.set(i);
            }
        }
    }
}
