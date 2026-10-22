package com.byazt.yj;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.io.File;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1197, 54})
public class ve implements tt, Function {
    public volatile Function c;
    public volatile tt tt;

    public ve(tt ttVar) {
        this.tt = ttVar;
    }

    public ve(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Long.valueOf(this.tt.getFileCacheSize());
            case 2:
                return Integer.valueOf(this.tt.getMemoryCacheSize());
            case 3:
                return Boolean.valueOf(this.tt.isMemoryCache());
            case 4:
                return Boolean.valueOf(this.tt.isDiskCache());
            case 5:
                return this.tt.getCacheDir();
            case 6:
                return Boolean.valueOf(this.tt.isQueryAll());
            case 7:
                return Integer.valueOf(this.tt.getRawMemoryCacheSize());
            case 8:
                return Boolean.valueOf(this.tt.isRawMemoryCache());
            default:
                return null;
        }
    }

    @Override // com.byazt.yj.tt
    public File getCacheDir() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (File) this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.tt
    public long getFileCacheSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Long) this.c.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.yj.tt
    public int getMemoryCacheSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.yj.tt
    public int getRawMemoryCacheSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.yj.tt
    public boolean isDiskCache() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.yj.tt
    public boolean isMemoryCache() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.yj.tt
    public boolean isQueryAll() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.yj.tt
    public boolean isRawMemoryCache() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }
}
