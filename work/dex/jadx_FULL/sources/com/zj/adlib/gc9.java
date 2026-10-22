package com.zj.adlib;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class gc9 implements TransportScheduleCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gc9 f41873a = new gc9();

    public static TransportScheduleCallback b() {
        return f41873a;
    }

    @Override // com.google.android.datatransport.TransportScheduleCallback
    public void a(Exception exc) {
        g.c(exc);
    }
}
