package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.TaskBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class r2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TaskBean.BackTaskArrayBean f27708a;
    private Context b;

    public r2(Context context, TaskBean.BackTaskArrayBean backTaskArrayBean) {
        this.b = context;
        this.f27708a = backTaskArrayBean;
    }

    private void a() {
        int i;
        try {
            ArrayList arrayList = new ArrayList();
            List<TaskBean.BackTaskArrayBean.AppLinkBean> apps = this.f27708a.getApps();
            if (apps == null || apps.size() <= 0) {
                return;
            }
            Iterator<TaskBean.BackTaskArrayBean.AppLinkBean> it = apps.iterator();
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    break;
                }
                TaskBean.BackTaskArrayBean.AppLinkBean next = it.next();
                String strValueOf = so.a(this.b, next.getTestLink()) ? String.valueOf(1) : String.valueOf(0);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appLinkId", next.getAppLinkId());
                jSONObject.put("isLink", strValueOf);
                arrayList.add(jSONObject.toString());
            }
            List<String> report = this.f27708a.getReport();
            if (report == null || report.size() <= 0) {
                return;
            }
            while (i < report.size()) {
                if (!TextUtils.isEmpty(report.get(i))) {
                    EventCar.getInstance(this.b).goRoadWithoutThread(new EventBean(q1.u, "", "590.200", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), "", arrayList.toString(), report.get(i), false));
                }
                i++;
                arrayList = arrayList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f27708a != null) {
            try {
                if (System.currentTimeMillis() - so.a(this.b).longValue() < 86400000) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int i = 0; i < this.f27708a.getRepeatCount(); i++) {
                if (this.f27708a.getMethod().equalsIgnoreCase("GET")) {
                    try {
                        a();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        EventCar.getInstance(this.b).goRoadWithoutThread(new EventBean(q1.u, "", "510.500", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    }
                }
            }
            EventCar.getInstance(this.b).goRoadWithoutThread(new EventBean(q1.u, "", "510.200", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
    }
}
