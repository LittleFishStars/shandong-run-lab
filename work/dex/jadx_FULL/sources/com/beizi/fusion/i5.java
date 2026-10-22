package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.TaskBean;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class i5 {
    private static i5 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f27399a = "ClipUtil";
    private Context b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f27400a;
        final /* synthetic */ TaskBean.BackTaskArrayBean b;

        public a(List list, TaskBean.BackTaskArrayBean backTaskArrayBean) {
            this.f27400a = list;
            this.b = backTaskArrayBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < this.f27400a.size(); i++) {
                if (!TextUtils.isEmpty((CharSequence) this.f27400a.get(i))) {
                    if (m9.a(oo.a(i5.this.b, (String) this.f27400a.get(i), null), this.b.getUserAgent()) != null) {
                        EventCar.getInstance(i5.this.b).goRoadWithoutThread(new EventBean(q1.u, "", "520.200", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    } else {
                        EventCar.getInstance(i5.this.b).goRoadWithoutThread(new EventBean(q1.u, "", "520.500", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    }
                    try {
                        Thread.sleep(this.b.getSleepTime());
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    private i5(Context context) {
        this.b = context.getApplicationContext();
    }

    public static i5 a(Context context) {
        if (c == null) {
            synchronized (i5.class) {
                if (c == null) {
                    c = new i5(context);
                }
            }
        }
        return c;
    }

    public void a(TaskBean.BackTaskArrayBean backTaskArrayBean) {
        if (backTaskArrayBean != null && !TextUtils.isEmpty(backTaskArrayBean.getContentUrl())) {
            EventCar.getInstance(this.b).goRoad(new EventBean(q1.u, "", "510.200", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            List<String> report = backTaskArrayBean.getReport();
            if (report == null || report.size() <= 0) {
                return;
            }
            v3.b().f().execute(new a(report, backTaskArrayBean));
            return;
        }
        EventCar.getInstance(this.b).goRoad(new EventBean(q1.u, "", "510.500", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
    }
}
