package com.byazt.ds;

import android.annotation.SuppressLint;
import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 67})
public class u extends ve {
    public final Context n;

    public u(Context context) {
        super(true, true);
        this.n = context;
    }

    @Override // com.byazt.ds.ve
    @SuppressLint({"MissingPermission"})
    public boolean c(JSONObject jSONObject) throws JSONException {
        i.c(jSONObject, "access", com.byazt.yv.n.c(this.n));
        return true;
    }
}
