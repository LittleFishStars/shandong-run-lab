package com.zj.adlib;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class wh2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransportScheduleCallback f45596a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EventInternal f20442a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TransportContext f20443a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zh2 f20444a;

    public wh2(zh2 zh2Var, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        this.f20444a = zh2Var;
        this.f20443a = transportContext;
        this.f45596a = transportScheduleCallback;
        this.f20442a = eventInternal;
    }

    public static Runnable a(zh2 zh2Var, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        return new wh2(zh2Var, transportContext, transportScheduleCallback, eventInternal);
    }

    @Override // java.lang.Runnable
    public void run() {
        zh2.c(this.f20444a, this.f20443a, this.f45596a, this.f20442a);
    }
}
