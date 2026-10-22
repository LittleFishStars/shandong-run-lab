package com.alibaba.ariver.kernel.common.bigdata;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BigDataChannelModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24232a = "AriverKernel:BigDataChannelModel";
    private static final int b = 10;
    private final AtomicInteger c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;
    private int i;
    private JSONObject j;
    private boolean k;
    private LinkedBlockingQueue<JSONObject> l;
    private IBigDataConsumerReadyCallback m;

    public BigDataChannelModel() {
        this.c = new AtomicInteger(0);
        this.i = 0;
        this.k = true;
    }

    public void enqueueBuffer(JSONObject jSONObject) {
        if (this.c.get() >= 10) {
            RVLogger.w(f24232a, "buffer size limit : 10");
            return;
        }
        try {
            this.l.put(jSONObject);
            this.c.incrementAndGet();
        } catch (Throwable th) {
            RVLogger.e(f24232a, "enqueueBuffer exception, ", th);
        }
    }

    public int getBizType() {
        return this.g;
    }

    public int getBufferSize() {
        return this.i;
    }

    public JSONObject getBufferedData() {
        LinkedBlockingQueue<JSONObject> linkedBlockingQueue = this.l;
        if (linkedBlockingQueue != null && !linkedBlockingQueue.isEmpty()) {
            try {
                this.c.decrementAndGet();
                return this.l.take();
            } catch (Throwable th) {
                RVLogger.e(f24232a, "getBufferedData exception, ", th);
            }
        }
        return null;
    }

    public IBigDataConsumerReadyCallback getCallback() {
        return this.m;
    }

    public String getChannelId() {
        return this.d;
    }

    public int getPolicy() {
        return this.h;
    }

    public String getViewId() {
        return this.f;
    }

    public String getWorkerId() {
        return this.e;
    }

    public boolean isConsumerReady() {
        return this.k;
    }

    public void releaseBuffer() {
        if (this.l != null) {
            this.j.clear();
        }
        this.l = null;
    }

    public void setBizType(int i) {
        this.g = i;
    }

    public void setBufferSize(int i) {
        this.i = i;
    }

    public void setCallback(IBigDataConsumerReadyCallback iBigDataConsumerReadyCallback) {
        this.m = iBigDataConsumerReadyCallback;
    }

    public void setChannelId(String str) {
        this.d = str;
    }

    public void setConsumerReady(boolean z) {
        this.k = z;
    }

    public void setPolicy(int i) {
        this.h = i;
    }

    public void setViewId(String str) {
        this.f = str;
    }

    public void setWorkerId(String str) {
        this.e = str;
    }

    public BigDataChannelModel(String str, int i, JSONObject jSONObject) {
        this.c = new AtomicInteger(0);
        this.k = true;
        this.d = str;
        this.i = i;
        this.j = jSONObject;
        if (i > 0) {
            this.l = new LinkedBlockingQueue<>();
        }
    }
}
