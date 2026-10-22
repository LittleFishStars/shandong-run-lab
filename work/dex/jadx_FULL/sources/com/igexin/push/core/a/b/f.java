package com.igexin.push.core.a.b;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.log.PageLog;
import com.baidu.mapapi.SDKInitializer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37931a = com.igexin.push.config.c.f37909a + "_QueryTagResultAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(Object obj, JSONObject jSONObject) {
        com.igexin.c.a.c.a.a(f37931a + "|query tag result resp data = " + jSONObject, new Object[0]);
        try {
            if (!jSONObject.has("action") || !jSONObject.getString("action").equals("query_tag_result")) {
                return true;
            }
            String string = jSONObject.getString(PageLog.PAGE_LOG_TAGS);
            com.igexin.push.core.l.a().a(jSONObject.getString("sn"), jSONObject.getString(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE), jSONObject.getString(PageLog.PAGE_LOG_TAGS));
            if (TextUtils.isEmpty(string)) {
                string = "none";
            }
            com.igexin.push.core.e.f.a().e(string);
            return true;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return true;
        }
    }
}
