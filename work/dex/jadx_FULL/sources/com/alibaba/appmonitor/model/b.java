package com.alibaba.appmonitor.model;

import com.alibaba.appmonitor.b.d;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f23806a;
    public List<a> k;

    private b(int i) {
        this.k = new ArrayList(i);
    }

    public static b a() {
        if (f23806a == null) {
            f23806a = new b(3);
        }
        return f23806a;
    }

    public void a(a aVar) {
        if (this.k.contains(aVar)) {
            this.k.remove(aVar);
        }
        this.k.add(aVar);
    }

    public a a(String str, String str2) {
        List<a> list;
        if (str == null || str2 == null || (list = this.k) == null) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.k.get(i);
            if (aVar != null && aVar.getModule().equals(str) && aVar.H().equals(str2)) {
                return aVar;
            }
        }
        a aVarA = d.a().a(str, str2);
        if (aVarA != null) {
            this.k.add(aVarA);
        }
        return aVarA;
    }
}
