package com.getui.gtc.base.http;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class RealCall implements Call {
    private volatile boolean canceled;
    private GtHttpClient client;
    private boolean executed;
    private Request request;

    public final class AsyncCall implements Runnable {
        private final Call.Callback callback;

        public AsyncCall(Call.Callback callback) {
            this.callback = callback;
        }

        public final RealCall get() {
            return RealCall.this;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Response responseWithInterceptorChain = RealCall.this.getResponseWithInterceptorChain();
                if (RealCall.this.isCanceled()) {
                    throw new IOException("Canceled");
                }
                this.callback.onResponse(get(), responseWithInterceptorChain);
            } catch (Throwable th) {
                try {
                    this.callback.onFailure(get(), new Exception(th.getMessage(), th.getCause()));
                } finally {
                    RealCall.this.client.getDispatcher().finished(this);
                }
            }
        }
    }

    private RealCall(GtHttpClient gtHttpClient, Request request) {
        this.client = gtHttpClient;
        this.request = request;
    }

    public static RealCall newCall(GtHttpClient gtHttpClient, Request request) {
        return new RealCall(gtHttpClient, request);
    }

    @Override // com.getui.gtc.base.http.Call
    public void cancel() {
        this.canceled = true;
    }

    @Override // com.getui.gtc.base.http.Call
    public void enqueue(Call.Callback callback) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.client.getDispatcher().enqueue(new AsyncCall(callback));
    }

    @Override // com.getui.gtc.base.http.Call
    public Response execute() throws Exception {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        try {
            this.client.getDispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain();
            if (responseWithInterceptorChain == null) {
                throw new IOException("Canceled");
            }
            this.client.getDispatcher().finished(this);
            return responseWithInterceptorChain;
        } catch (Throwable th) {
            this.client.getDispatcher().finished(this);
            throw th;
        }
    }

    public Response getResponseWithInterceptorChain() throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.client.interceptors);
        if (this.request.cryptInterceptor() != null) {
            arrayList.add(this.request.cryptInterceptor());
        }
        arrayList.add(new BridgeInterceptor());
        arrayList.add(new ConnectInterceptor(this.client));
        arrayList.add(new CallServerInterceptor());
        return new RealInterceptorChain(arrayList, null, 0, this.request).proceed(this.request);
    }

    @Override // com.getui.gtc.base.http.Call
    public boolean isCanceled() {
        return this.canceled;
    }

    @Override // com.getui.gtc.base.http.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    @Override // com.getui.gtc.base.http.Call
    public Request request() {
        return this.request;
    }
}
