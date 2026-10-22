package com.byazt.ch;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1054, 13})
public class tt {
    public final Function<SparseArray<Object>, Object> c;

    public tt(Function<SparseArray<Object>, Object> function) {
        this.c = function == null ? com.byazt.rl.c.tt : function;
    }

    public Map<String, Object> a() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266006);
        sparseArray.put(-99999985, Map.class);
        return (Map) this.c.apply(sparseArray);
    }

    public boolean c() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266001);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    public com.byazt.am.tt da() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266101);
        sparseArray.put(-99999985, Object.class);
        Object objApply = this.c.apply(sparseArray);
        if (objApply instanceof Function) {
            return new com.byazt.am.tt((Function) objApply);
        }
        return null;
    }

    public boolean i() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266009);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    public boolean n() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266005);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    public float sl() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266010);
        sparseArray.put(-99999985, Float.TYPE);
        return ((Float) this.c.apply(sparseArray)).floatValue();
    }

    public boolean sp() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266007);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    public float t() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266011);
        sparseArray.put(-99999985, Float.TYPE);
        return ((Float) this.c.apply(sparseArray)).floatValue();
    }

    public boolean tt() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266002);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    public com.byazt.am.ve u() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266102);
        sparseArray.put(-99999985, Object.class);
        return new com.byazt.am.ve(com.byazt.gxc.ve.c(this.c.apply(sparseArray)));
    }

    public float uj() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266004);
        sparseArray.put(-99999985, Float.TYPE);
        return ((Float) this.c.apply(sparseArray)).floatValue();
    }

    public boolean ve() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266003);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    public String x() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266008);
        sparseArray.put(-99999985, String.class);
        return (String) this.c.apply(sparseArray);
    }

    public String yp() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266103);
        sparseArray.put(-99999985, String.class);
        return (String) this.c.apply(sparseArray);
    }

    public int z() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266104);
        sparseArray.put(-99999985, Integer.TYPE);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }
}
