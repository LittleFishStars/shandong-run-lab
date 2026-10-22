package com.zj.adlib;

import android.text.TextUtils;
import cn.hzjizhun.admin.base.l0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class ceb extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dqb f40957a;

    public ceb(dqb dqbVar) {
        this.f40957a = dqbVar;
    }

    @Override // cn.hzjizhun.admin.base.l0
    public final void e(String str) {
        try {
            String strOptString = new JSONObject(str).optJSONObject("data").optString("clickid", "");
            this.f40957a.b = strOptString;
            TextUtils.isEmpty(strOptString);
            this.f40957a.g();
        } catch (Throwable unused) {
        }
    }
}
