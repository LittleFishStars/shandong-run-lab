package com.zj.adlib;

import android.text.TextUtils;
import cn.hzjizhun.admin.base.l0;
import cn.hzjizhun.admin.base.t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class hyb extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f42230a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ rzb f17091a;

    public hyb(rzb rzbVar, int i) {
        this.f17091a = rzbVar;
        this.f42230a = i;
    }

    @Override // cn.hzjizhun.admin.base.l0
    public final void a(int i, String str) {
        try {
            rzb rzbVar = this.f17091a;
            int i2 = rzbVar.d;
            if (i2 < 3) {
                int i3 = i2 + 1;
                rzbVar.d = i3;
                rzbVar.f19455a.sendEmptyMessageDelayed(2, i3 * 800);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // cn.hzjizhun.admin.base.l0
    public final void c(JSONArray jSONArray) {
        try {
            rzb rzbVar = this.f17091a;
            rzbVar.d = 0;
            ArrayList arrayList = rzbVar.f19457a;
            if (arrayList != null && rzbVar.b < arrayList.size()) {
                rzb rzbVar2 = this.f17091a;
                this.f17091a.f19455a.sendEmptyMessageDelayed(2, ((Integer) rzbVar2.f19457a.get(rzbVar2.b)).intValue() * 1000);
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    wtb wtbVar = new wtb(this.f42230a + c49.f40900a + this.f17091a.b + c49.f40900a + i);
                    wtbVar.e(jSONObjectOptJSONObject);
                    if (wtbVar.d()) {
                        String str = this.f17091a.f19456a;
                        if (!TextUtils.isEmpty(str)) {
                            String str2 = (String) t.f22705a.f20929a.get(str);
                            if (TextUtils.isEmpty(str2)) {
                                wtbVar.f20559f = "";
                            } else {
                                wtbVar.f20559f = str2.replaceAll("_ChannelName_", wtbVar.f20545a);
                            }
                        }
                        this.f17091a.f19461b.offer(wtbVar);
                    } else {
                        this.f17091a.f19458a.offer(wtbVar);
                    }
                }
            }
            this.f17091a.b++;
        } catch (Throwable unused) {
        }
    }
}
