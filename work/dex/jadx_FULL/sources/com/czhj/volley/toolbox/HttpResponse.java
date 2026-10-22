package com.czhj.volley.toolbox;

import com.czhj.volley.Header;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class HttpResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29485a;
    private final List<Header> b;
    private final int c;
    private final InputStream d;

    public HttpResponse(int i, List<Header> list) {
        this(i, list, -1, null);
    }

    public HttpResponse(int i, List<Header> list, int i2, InputStream inputStream) {
        this.f29485a = i;
        this.b = list;
        this.c = i2;
        this.d = inputStream;
    }

    public final InputStream getContent() {
        return this.d;
    }

    public final int getContentLength() {
        return this.c;
    }

    public final List<Header> getHeaders() {
        return Collections.unmodifiableList(this.b);
    }

    public final int getStatusCode() {
        return this.f29485a;
    }
}
