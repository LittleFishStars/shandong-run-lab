package com.byazt.yih;

import com.alibaba.triver.appinfo.core.AppInfoCenterInternal;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 730, 54})
public class ve {
    public JSONObject c;

    public ve(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public int a() {
        JSONObject jSONObject = this.c;
        if (jSONObject == null) {
            return 1;
        }
        return jSONObject.optInt("max_notification", 1);
    }

    public boolean c() {
        JSONObject jSONObject = this.c;
        return jSONObject == null || jSONObject.optInt("enable_install_notification", 1) == 1;
    }

    public long n() {
        JSONObject jSONObject = this.c;
        return jSONObject == null ? AppInfoCenterInternal.c : jSONObject.optLong("notification_internal", AppInfoCenterInternal.c);
    }

    public int sp() {
        JSONObject jSONObject = this.c;
        if (jSONObject == null) {
            return 1;
        }
        return jSONObject.optInt("max_interface", 1);
    }

    public boolean tt() {
        JSONObject jSONObject = this.c;
        return jSONObject == null || jSONObject.optInt("enable_active_notification", 1) == 1;
    }

    public long uj() {
        JSONObject jSONObject = this.c;
        if (jSONObject == null) {
            return 300L;
        }
        return jSONObject.optLong("uninstall_delay", 300L);
    }

    public boolean ve() {
        JSONObject jSONObject = this.c;
        return jSONObject != null && jSONObject.optInt("enable_install_interface", 0) == 1;
    }
}
