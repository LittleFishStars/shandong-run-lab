package com.alibaba.appmonitor.a;

import android.annotation.TargetApi;
import android.app.Application;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.x;
import com.alibaba.appmonitor.event.EventType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements Runnable {
    private static boolean Y = false;
    private static ScheduledFuture g;
    private static List<a> i = Collections.synchronizedList(new ArrayList());
    private boolean Z = true;
    private Application b;

    public interface a {
        void B();

        void C();
    }

    public b(Application application) {
        this.b = application;
    }

    public static void a(a aVar) {
        i.add(aVar);
    }

    @TargetApi(14)
    public static void init(Application application) {
        if (Y) {
            return;
        }
        j.d("init BackgroundTrigger", new Object[0]);
        g = x.a().a(g, new b(application), 60000L);
        Y = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zB = com.alibaba.analytics.a.a.b(this.b.getApplicationContext());
        if (this.Z != zB) {
            this.Z = zB;
            if (zB) {
                com.alibaba.appmonitor.c.b.a().ad();
                for (EventType eventType : EventType.values()) {
                    com.alibaba.appmonitor.a.a.setStatisticsInterval(eventType, eventType.getForegroundStatisticsInterval());
                }
            } else {
                for (EventType eventType2 : EventType.values()) {
                    com.alibaba.appmonitor.a.a.setStatisticsInterval(eventType2, eventType2.getBackgroundStatisticsInterval());
                }
                com.alibaba.appmonitor.a.a.triggerUpload();
            }
            for (int i2 = 0; i2 < i.size(); i2++) {
                if (zB) {
                    i.get(i2).C();
                } else {
                    i.get(i2).B();
                }
            }
        }
    }
}
