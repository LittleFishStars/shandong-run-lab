package com.alibaba.ariver.commonability.file;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f24014a;
    public volatile boolean b = false;
    public float c;
    public long d;
    public long e;
    public volatile Future<k> f;
    public String g;

    public void a() {
        this.b = true;
        if (this.f != null) {
            this.f.cancel(true);
        }
    }
}
