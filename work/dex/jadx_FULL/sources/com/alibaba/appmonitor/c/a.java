package com.alibaba.appmonitor.c;

import com.alibaba.analytics.a.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends com.alibaba.analytics.core.b.b implements Cloneable {

    @com.alibaba.analytics.core.b.a.a(com.alipay.sdk.m.m.b.m)
    private int Q;

    @com.alibaba.analytics.core.b.a.a("offline")
    protected String bo;

    @com.alibaba.analytics.core.b.a.b
    private HashMap<String, a> g;

    @com.alibaba.analytics.core.b.a.a("module")
    protected String module;

    @com.alibaba.analytics.core.b.a.a("mp")
    protected String monitorPoint;

    private boolean z() {
        return "1".equalsIgnoreCase(this.bo);
    }

    public boolean a(int i, String str, String str2, Map<String, String> map) {
        ArrayList<String> arrayList = new ArrayList<>(2);
        arrayList.add(str);
        arrayList.add(str2);
        return a(i, arrayList);
    }

    public synchronized a b(String str) {
        if (this.g == null) {
            this.g = new HashMap<>();
        }
        return this.g.get(str);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean d(int i) {
        j.d("sampling", "module", this.module, "monitorPoint", this.monitorPoint, "samplingSeed", Integer.valueOf(i), "sampling", Integer.valueOf(this.Q));
        return i < this.Q;
    }

    public boolean f(String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>(2);
        arrayList.add(str);
        arrayList.add(str2);
        return a(arrayList);
    }

    public synchronized boolean h(String str) {
        HashMap<String, a> map = this.g;
        if (map == null) {
            return false;
        }
        return map.containsKey(str);
    }

    public void setSampling(int i) {
        this.Q = i;
    }

    private boolean a(int i, ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            String strRemove = arrayList.remove(0);
            if (h(strRemove)) {
                return this.g.get(strRemove).a(i, arrayList);
            }
            return d(i);
        }
        return d(i);
    }

    public synchronized void a(String str, a aVar) {
        HashMap<String, a> map;
        HashMap<String, a> map2;
        if (this.g == null) {
            this.g = new HashMap<>();
        }
        if (h(str)) {
            a aVar2 = this.g.get(str);
            if (aVar2 != null && (map = aVar2.g) != null && (map2 = aVar.g) != null) {
                map2.putAll(map);
            }
            j.w("config object order errror", "config:", aVar + "");
        }
        this.g.put(str, aVar);
    }

    public synchronized a a(String str) {
        a aVarB;
        a aVar;
        CloneNotSupportedException e;
        aVarB = b(str);
        if (aVarB == null) {
            try {
                aVar = (a) clone();
                try {
                    aVar.module = str;
                } catch (CloneNotSupportedException e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (CloneNotSupportedException e3) {
                aVar = aVarB;
                e = e3;
            }
            aVarB = aVar;
        }
        this.g.put(str, aVarB);
        return aVarB;
    }

    private boolean a(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            String strRemove = arrayList.remove(0);
            if (h(strRemove)) {
                return this.g.get(strRemove).a(arrayList);
            }
            return z();
        }
        return z();
    }
}
