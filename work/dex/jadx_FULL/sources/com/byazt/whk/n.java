package com.byazt.whk;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.hzchengdun.securityguard.SecExceptionCode;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_UMID_TIME_OUT, 46})
public class n extends i {
    public n(SparseArray<Object> sparseArray, int i) {
        super(sparseArray, i);
    }

    public boolean c() {
        if (ve() != null) {
            return ve().c();
        }
        return false;
    }

    public sp tt() {
        JSONObject jSONObjectC;
        if (ve() != null) {
            PluginValueSet pluginValueSetUj = ve().uj();
            if (pluginValueSetUj != null && (jSONObjectC = da.c(pluginValueSetUj, 4)) != null) {
                return new sp(jSONObjectC);
            }
            if (!ve().c()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", ve().tt());
                    String strVe = ve().ve();
                    if (strVe != null) {
                        jSONObject.put("message", strVe);
                    }
                    return new sp(jSONObject);
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }
}
