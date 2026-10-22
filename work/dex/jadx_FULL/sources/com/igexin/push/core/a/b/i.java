package com.igexin.push.core.a.b;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class i extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37934a = "ResponseDeviceidAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(Object obj, JSONObject jSONObject) {
        try {
            if (!jSONObject.has("action") || !jSONObject.getString("action").equals("response_deviceid")) {
                return true;
            }
            com.igexin.push.core.e.f.a().a(jSONObject.getString("deviceid"));
            if (com.igexin.push.core.e.H != null) {
                com.igexin.push.core.a.b.d().i();
            }
            String str = com.igexin.push.core.e.H;
            return true;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return true;
        }
    }
}
