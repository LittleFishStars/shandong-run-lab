package com.baidu.mapapi.http.wrapper;

import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AsyncResponse<T> {
    private static final ExecutorService threadPool = ThreadPoolUtils.getThreadPool();
    private Callback<T> callback;
    private T data;
    private Throwable e;
    private volatile boolean finish = false;
    private boolean success = false;
    private boolean hasCallback = false;

    public interface Callback<T> {
        void onFailed(Throwable th);

        void onSuccess(T t);
    }

    public void onFailed(Throwable th) {
        synchronized (this) {
            this.e = th;
            this.finish = true;
        }
        threadPool.submit(new Runnable() { // from class: com.baidu.mapapi.http.wrapper.AsyncResponse.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    if (this.callback != null && !this.hasCallback) {
                        this.callback.onFailed(this.e);
                        this.hasCallback = true;
                    }
                }
            }
        });
    }

    public void onSuccess(T t) {
        synchronized (this) {
            this.data = t;
            this.finish = true;
            this.success = true;
        }
        threadPool.submit(new Runnable() { // from class: com.baidu.mapapi.http.wrapper.AsyncResponse.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    if (this.callback != null && !this.hasCallback) {
                        this.callback.onSuccess(this.data);
                        this.hasCallback = true;
                    }
                }
            }
        });
    }

    public void setCallback(Callback<T> callback) {
        this.callback = callback;
        threadPool.submit(new Runnable() { // from class: com.baidu.mapapi.http.wrapper.AsyncResponse.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    if (this.finish && !this.hasCallback) {
                        if (this.success) {
                            this.callback.onSuccess(this.data);
                        } else {
                            this.callback.onFailed(this.e);
                        }
                        this.hasCallback = true;
                    }
                }
            }
        });
    }
}
