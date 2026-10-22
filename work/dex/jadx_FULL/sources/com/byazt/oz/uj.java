package com.byazt.oz;

import com.byazt.yj.m;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 213, 15})
public class uj<T> implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28929a;
    public String c;
    public com.byazt.yj.x da;
    public boolean i;
    public int n;
    public int sl;
    public Map<String, String> sp;
    public String tt;
    public T uj;
    public T ve;
    public boolean x;

    public uj c(ve veVar, T t) {
        this.ve = t;
        this.c = veVar.getMemoryCacheKey();
        this.tt = veVar.getUrl();
        this.n = veVar.getWidth();
        this.f28929a = veVar.getHeight();
        this.i = veVar.x();
        this.da = veVar.da();
        this.sl = veVar.sl();
        return this;
    }

    @Override // com.byazt.yj.m
    public String getCacheKey() {
        return this.c;
    }

    @Override // com.byazt.yj.m
    public int getFileSize() {
        return this.sl;
    }

    @Override // com.byazt.yj.m
    public Map<String, String> getHeaders() {
        return this.sp;
    }

    @Override // com.byazt.yj.m
    public int getHeight() {
        return this.f28929a;
    }

    @Override // com.byazt.yj.m
    public com.byazt.yj.x getHttpTime() {
        return this.da;
    }

    @Override // com.byazt.yj.m
    public T getOriginResult() {
        return this.uj;
    }

    @Override // com.byazt.yj.m
    public T getResult() {
        return this.ve;
    }

    @Override // com.byazt.yj.m
    public String getUrl() {
        return this.tt;
    }

    @Override // com.byazt.yj.m
    public int getWidth() {
        return this.n;
    }

    @Override // com.byazt.yj.m
    public boolean isGif() {
        return this.x;
    }

    @Override // com.byazt.yj.m
    public boolean isLocal() {
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.byazt.yj.m
    public void setResult(Object obj) {
        this.uj = this.ve;
        this.ve = obj;
    }

    public uj c(ve veVar, T t, Map<String, String> map, boolean z) {
        this.sp = map;
        this.x = z;
        return c(veVar, t);
    }
}
