package com.byazt.yj;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1197, 137})
public class nu implements m, Function {
    public volatile Function c;
    public volatile m tt;

    public nu(m mVar) {
        this.tt = mVar;
    }

    public nu(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.tt.getCacheKey();
            case 2:
                return this.tt.getUrl();
            case 3:
                return this.tt.getResult();
            case 4:
                return this.tt.getOriginResult();
            case 5:
                this.tt.setResult(sparseArray.get(1));
                return null;
            case 6:
                return Integer.valueOf(this.tt.getWidth());
            case 7:
                return Integer.valueOf(this.tt.getHeight());
            case 8:
                return this.tt.getHeaders();
            case 9:
                return Boolean.valueOf(this.tt.isGif());
            case 10:
                return Boolean.valueOf(this.tt.isLocal());
            case 11:
                x httpTime = this.tt.getHttpTime();
                return httpTime != null ? new i(httpTime) : httpTime;
            case 12:
                return Integer.valueOf(this.tt.getFileSize());
            default:
                return null;
        }
    }

    @Override // com.byazt.yj.m
    public String getCacheKey() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.m
    public int getFileSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.yj.m
    public Map getHeaders() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (Map) this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.m
    public int getHeight() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.yj.m
    public x getHttpTime() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        ?? Apply = this.c.apply(sparseArray);
        ?? iVar = Apply;
        if (Apply != 0) {
            iVar = new i((Function) Apply);
        }
        return (x) iVar;
    }

    @Override // com.byazt.yj.m
    public Object getOriginResult() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.m
    public Object getResult() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.m
    public String getUrl() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.yj.m
    public int getWidth() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.yj.m
    public boolean isGif() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.yj.m
    public boolean isLocal() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.yj.m
    public void setResult(Object obj) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, obj);
        this.c.apply(sparseArray);
    }
}
