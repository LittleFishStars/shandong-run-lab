package com.byazt.ds;

import android.content.Context;
import com.kc.openset.constant.DeviceIdType;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 215})
public final class yp extends ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f28433a;
    public final Context n;

    public yp(Context context, x xVar) {
        super(true, false);
        this.n = context;
        this.f28433a = xVar;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException, SecurityException {
        Map<String, String> mapC = com.byazt.vm.sp.c(this.n, this.f28433a.n());
        if (mapC == null) {
            return !com.byazt.gj.c.tt;
        }
        jSONObject.put(DeviceIdType.OAID, new JSONObject(mapC));
        return true;
    }
}
