package com.byazt.bzd;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.byazt.ete.ic;
import com.byazt.t.DownloadInfo;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 724, 13})
public class tt {
    public static boolean c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(NativeCallContext.DOMAIN_APP);
        String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("package_name") : null;
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = jSONObject.optString("package_name");
        }
        return c(strOptString);
    }

    public static boolean c(ic icVar) {
        if (icVar == null) {
            return false;
        }
        com.byazt.ete.n nVarZ = icVar.z();
        String strUj = nVarZ != null ? nVarZ.uj() : null;
        if (TextUtils.isEmpty(strUj)) {
            strUj = icVar.ls();
        }
        return c(strUj);
    }

    private static boolean c(String str) {
        List<DownloadInfo> listTt;
        if (TextUtils.isEmpty(str) || (listTt = com.byazt.zz.ve.zm().tt()) == null) {
            return false;
        }
        for (DownloadInfo downloadInfo : listTt) {
            int status = downloadInfo.getStatus();
            if (str.equals(downloadInfo.getPackageName()) && status == -3) {
                return true;
            }
        }
        return false;
    }
}
