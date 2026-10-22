package com.byazt.ds;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 66})
public class t extends ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f28430a;
    public final Context n;

    public t(Context context, x xVar) {
        super(true, false);
        this.n = context;
        this.f28430a = xVar;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException {
        String strTt = com.byazt.yv.c.tt();
        if (TextUtils.isEmpty(strTt)) {
            return true;
        }
        jSONObject.put("mc", strTt);
        return true;
    }
}
