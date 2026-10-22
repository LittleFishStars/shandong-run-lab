package com.alibaba.ariver.kernel.common.network.http;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVHttpResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f24265a;
    private Map<String, List<String>> b;
    private InputStream c;

    public Map<String, List<String>> getHeaders() {
        return this.b;
    }

    public InputStream getResStream() {
        return this.c;
    }

    public int getStatusCode() {
        return this.f24265a;
    }

    public void setHeaders(Map<String, List<String>> map) {
        this.b = map;
    }

    public void setResStream(InputStream inputStream) {
        this.c = inputStream;
    }

    public void setStatusCode(int i) {
        this.f24265a = i;
    }
}
