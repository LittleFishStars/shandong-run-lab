package com.byazt.tb;

import android.util.SparseArray;
import com.byazt.nr.m;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1771, 20})
public abstract class c implements tt {
    public SparseArray<Method> c = new SparseArray<>();
    public Object tt;

    public abstract String c();

    @Override // com.byazt.tb.tt
    public void c(int i, Method method) {
        this.c.put(i, method);
    }

    @Override // com.byazt.tb.tt
    public <T> T call(int i, Object... objArr) {
        Object obj;
        Method method = this.c.get(i);
        if (method == null || (obj = this.tt) == null) {
            m.tt(c(), "call method " + i + " failed for null ");
            return null;
        }
        try {
            return obj instanceof Class ? (T) method.invoke(null, objArr) : (T) method.invoke(obj, objArr);
        } catch (Throwable th) {
            m.tt(c(), "call method " + i + " failed: " + th.getMessage());
            return null;
        }
    }

    @Override // com.byazt.tb.tt
    public void c(Object obj) {
        this.tt = obj;
    }
}
