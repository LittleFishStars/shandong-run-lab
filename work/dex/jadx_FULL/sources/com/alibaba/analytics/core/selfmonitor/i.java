package com.alibaba.analytics.core.selfmonitor;

import com.alibaba.analytics.a.j;
import com.alibaba.appmonitor.event.EventType;
import com.ut.mini.core.UTLogTransferMain;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static i f23788a = new i();

    public static i a() {
        return f23788a;
    }

    public void init() {
        try {
            com.alibaba.analytics.core.sync.e.a().mMonitor.a(this);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
        try {
            com.alibaba.analytics.core.sync.i.mMonitor.a(this);
        } catch (Throwable th2) {
            j.e(null, th2, new Object[0]);
        }
        try {
            com.alibaba.analytics.core.sync.a.mMonitor.a(this);
        } catch (Throwable th3) {
            j.e(null, th3, new Object[0]);
        }
        try {
            com.alibaba.analytics.core.f.d.mMonitor.a(this);
        } catch (Throwable th4) {
            j.e(null, th4, new Object[0]);
        }
        try {
            UTLogTransferMain.getInstance().mMonitor.a(this);
        } catch (Throwable th5) {
            j.e(null, th5, new Object[0]);
        }
        try {
            a.mMonitor.a(this);
        } catch (Throwable th6) {
            j.e(null, th6, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.core.selfmonitor.h
    public void a(f fVar) {
        EventType eventType = fVar.f23786a;
        if (eventType == EventType.COUNTER) {
            com.alibaba.appmonitor.a.a.b.commit("AppMonitor", fVar.monitorPoint, fVar.aT, fVar.f659a.doubleValue());
        } else if (eventType == EventType.STAT) {
            com.alibaba.appmonitor.a.a.d.commit("AppMonitor", fVar.monitorPoint, fVar.f657a, fVar.f658a);
        }
    }
}
