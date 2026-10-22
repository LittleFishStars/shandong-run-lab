package com.byazt.ds;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 20})
public class c extends ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f28425a;
    public final Context n;

    public c(Context context, x xVar) {
        super(true, false);
        this.n = context;
        this.f28425a = xVar;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException, SecurityException {
        if (!TextUtils.isEmpty(this.f28425a.cu())) {
            jSONObject.put("ab_client", this.f28425a.cu());
        }
        if (!TextUtils.isEmpty(this.f28425a.my())) {
            if (com.byazt.yv.da.tt) {
                com.byazt.yv.da.c("init config has abversion:" + this.f28425a.my(), null);
            }
            jSONObject.put("ab_version", this.f28425a.my());
        }
        if (!TextUtils.isEmpty(this.f28425a.qp())) {
            jSONObject.put("ab_group", this.f28425a.qp());
        }
        if (TextUtils.isEmpty(this.f28425a.nb())) {
            return true;
        }
        jSONObject.put("ab_feature", this.f28425a.nb());
        return true;
    }
}
