package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.TaskBean;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class vo implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TaskBean.BackTaskArrayBean f27876a;
    private Context b;

    public vo(Context context, TaskBean.BackTaskArrayBean backTaskArrayBean) {
        this.b = context;
        this.f27876a = backTaskArrayBean;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f27876a != null) {
            for (int i = 0; i < this.f27876a.getRepeatCount(); i++) {
                if (this.f27876a.getMethod().equals("GET") && !TextUtils.isEmpty(this.f27876a.getContentUrl())) {
                    try {
                        EventBean eventBean = null;
                        m9.a(oo.a(this.b, this.f27876a.getContentUrl(), null), this.f27876a.getUserAgent());
                        Thread.sleep(this.f27876a.getSleepTime());
                        List<String> report = this.f27876a.getReport();
                        if (report != null && report.size() > 0) {
                            int i2 = 0;
                            while (i2 < report.size()) {
                                if (!TextUtils.isEmpty(report.get(i2))) {
                                    if (m9.a(oo.a(this.b, report.get(i2), eventBean), this.f27876a.getUserAgent()) != null) {
                                        EventCar.getInstance(this.b).goRoadWithoutThread(new EventBean(q1.u, "", "520.200", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                    } else {
                                        EventCar.getInstance(this.b).goRoadWithoutThread(new EventBean(q1.u, "", "520.500", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                                    }
                                    Thread.sleep(this.f27876a.getSleepTime());
                                }
                                i2++;
                                eventBean = null;
                            }
                        }
                    } catch (Exception unused) {
                        EventCar.getInstance(this.b).goRoadWithoutThread(new EventBean(q1.u, "", "510.500", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    }
                }
            }
            EventCar.getInstance(this.b).goRoadWithoutThread(new EventBean(q1.u, "", "510.200", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
    }
}
