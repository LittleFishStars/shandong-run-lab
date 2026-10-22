package com.igexin.push.core.a.b;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37927a = com.igexin.push.config.c.f37909a + "_BindAliasResultAction";

    @Override // com.igexin.push.core.a.b.a
    public final boolean a(Object obj, JSONObject jSONObject) {
        com.igexin.c.a.c.a.b(f37927a, "bind alias result resp data = ".concat(String.valueOf(jSONObject)));
        try {
            if (!jSONObject.has("action") || !jSONObject.getString("action").equals("response_bind")) {
                return true;
            }
            com.igexin.push.core.l.a().b(jSONObject.getString("sn"), jSONObject.getString("result"));
            return true;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            return true;
        }
    }
}
