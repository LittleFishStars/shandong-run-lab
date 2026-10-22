package com.alibaba.ariver.kernel.common.rpc;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVRpcResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f24268a;
    private Object b;
    private String c;

    public RVRpcResponse(Map<String, String> map, Object obj) {
        this.f24268a = map;
        this.b = obj;
    }

    public Map<String, String> getHeaders() {
        return this.f24268a;
    }

    public Object getResponse() {
        return this.b;
    }

    public String getTimeCost() {
        return this.c;
    }

    public RVRpcResponse(Map<String, String> map, Object obj, String str) {
        this.f24268a = map;
        this.b = obj;
        this.c = str;
    }
}
