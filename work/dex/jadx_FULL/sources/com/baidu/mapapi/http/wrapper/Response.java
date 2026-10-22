package com.baidu.mapapi.http.wrapper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class Response<T> {
    private T data;
    private Throwable e;

    public Response() {
    }

    public T getData() {
        return this.data;
    }

    public Throwable getE() {
        return this.e;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setE(Throwable th) {
        this.e = th;
    }

    public Response(T t, Throwable th) {
        this.data = t;
        this.e = th;
    }
}
