package com.byazt.ds;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 46})
public final class n extends ve {
    public final x n;

    public n(Context context, x xVar) {
        super(true, false);
        this.n = xVar;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException, SecurityException {
        String strC = com.byazt.vm.sp.c(this.n.n());
        if (TextUtils.isEmpty(strC)) {
            return false;
        }
        jSONObject.put("cdid", strC);
        return true;
    }
}
