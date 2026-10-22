package com.zj.adlib;

import com.facebook.common.time.Clock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class uy8 implements Clock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uy8 f45252a = new uy8();

    public static uy8 a() {
        return f45252a;
    }

    @Override // com.facebook.common.time.Clock
    public long now() {
        return System.currentTimeMillis();
    }
}
