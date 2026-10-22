package com.huawei.hms.framework.network.grs.g.i;

import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.g.j.d;
import com.huawei.hms.framework.network.grs.h.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37531a = "a";
    private static d b;
    private static final Object c = new Object();

    public static synchronized d a(Context context) {
        synchronized (c) {
            d dVar = b;
            if (dVar != null) {
                return dVar;
            }
            String strA = c.a(GrsApp.getInstance().getBrand(WVNativeCallbackUtil.SEPERATER) + "grs_sdk_server_config.json", context);
            ArrayList arrayList = null;
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(strA).getJSONObject("grs_server");
                JSONArray jSONArray = jSONObject.getJSONArray("grs_base_url");
                if (jSONArray != null && jSONArray.length() > 0) {
                    arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.get(i).toString());
                    }
                }
                d dVar2 = new d();
                b = dVar2;
                dVar2.a(arrayList);
                b.a(jSONObject.getString("grs_query_endpoint_2.0"));
                b.a(jSONObject.getInt("grs_query_timeout"));
            } catch (JSONException e) {
                Logger.w(f37531a, "getGrsServerBean catch JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
            }
            return b;
        }
    }
}
