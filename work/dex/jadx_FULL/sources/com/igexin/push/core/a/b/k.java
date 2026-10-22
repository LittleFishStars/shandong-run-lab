package com.igexin.push.core.a.b;

import com.baidu.mapapi.SDKInitializer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class k extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37935a = com.igexin.push.config.c.f37909a + "_SetTagResultAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(Object obj, JSONObject jSONObject) {
        com.igexin.c.a.c.a.a(f37935a + "|set tag result resp data = " + jSONObject, new Object[0]);
        try {
            if (jSONObject.has("action") && jSONObject.getString("action").equals("settag_result")) {
                com.igexin.push.core.l.a().a(jSONObject.getString("sn"), jSONObject.getString(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE));
            }
            if (!jSONObject.getString(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE).equals("0") || com.igexin.push.core.e.e == null) {
                return true;
            }
            com.igexin.push.core.e.f.a().e(com.igexin.push.core.e.e);
            com.igexin.push.core.e.e = null;
            return true;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a(f37935a + "|" + e.toString(), new Object[0]);
            return true;
        }
    }
}
