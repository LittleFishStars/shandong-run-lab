package com.byazt.yj;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.io.InputStream;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1197, 17})
public class gu implements qy, Function {
    public volatile Function c;
    public volatile qy tt;

    public gu(qy qyVar) {
        this.tt = qyVar;
    }

    public gu(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        Function function;
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -5) {
            return this.tt != null ? this.tt : this.c;
        }
        if (iIntValue == -4 && (function = (Function) sparseArray.get(1)) != null) {
            this.tt = null;
            this.c = function;
        }
        return null;
    }

    @Override // com.byazt.yj.qy
    public void clearAllCache() {
        if (this.tt != null) {
            this.tt.clearAllCache();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.qy
    public void clearCache(double d) {
        if (this.tt != null) {
            this.tt.clearCache(d);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Double.valueOf(d));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.qy
    public void clearDiskCache(double d) {
        if (this.tt != null) {
            this.tt.clearDiskCache(d);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Double.valueOf(d));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.qy
    public void clearMemoryCache(double d) {
        if (this.tt != null) {
            this.tt.clearMemoryCache(d);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Double.valueOf(d));
        this.c.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    @Override // com.byazt.yj.qy
    public yp from(String str) {
        ?? zVar;
        if (this.tt != null) {
            return this.tt.from(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        ?? Apply = this.c.apply(sparseArray);
        if (Apply != 0) {
            zVar = Apply;
            zVar = new z((Function) Apply);
        }
        zVar = Apply;
        return (yp) zVar;
    }

    @Override // com.byazt.yj.qy
    public InputStream getCacheStream(String str, String str2) {
        if (this.tt != null) {
            return this.tt.getCacheStream(str, str2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (InputStream) this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.qy
    public InputStream getDiskCacheStream(String str, String str2, String str3) {
        if (this.tt != null) {
            return this.tt.getDiskCacheStream(str, str2, str3);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, str3);
        return (InputStream) this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.qy
    public boolean hasDiskCache(String str, String str2, String str3) {
        if (this.tt != null) {
            return this.tt.hasDiskCache(str, str2, str3);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, str3);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }
}
