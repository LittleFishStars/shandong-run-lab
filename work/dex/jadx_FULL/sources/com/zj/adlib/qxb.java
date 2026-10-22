package com.zj.adlib;

import cn.hzjizhun.admin.base.l0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class qxb extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rzb f44323a;

    public qxb(rzb rzbVar) {
        this.f44323a = rzbVar;
    }

    @Override // cn.hzjizhun.admin.base.l0
    public final void a(int i, String str) {
        rzb rzbVar = this.f44323a;
        int i2 = rzbVar.c;
        if (i2 < 3) {
            int i3 = i2 + 1;
            rzbVar.c = i3;
            rzbVar.f19455a.sendEmptyMessageDelayed(1, i3 * 500);
        }
    }

    @Override // cn.hzjizhun.admin.base.l0
    public final void d(JSONObject jSONObject) {
        try {
            rzb rzbVar = this.f44323a;
            rzbVar.f19453a++;
            rzbVar.c = 0;
            qvb qvbVar = new qvb();
            qvbVar.b(jSONObject);
            rzb.c(this.f44323a, qvbVar);
        } catch (Throwable unused) {
        }
    }
}
