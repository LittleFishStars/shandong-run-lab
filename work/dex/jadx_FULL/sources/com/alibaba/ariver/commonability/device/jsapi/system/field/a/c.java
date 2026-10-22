package com.alibaba.ariver.commonability.device.jsapi.system.field.a;

import android.content.Context;
import com.alibaba.ariver.app.api.App;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile JSONObject f23987a;

    private static JSONObject c() {
        return new JSONObject();
    }

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.b
    public void a(Context context) {
        this.f23987a = c();
    }

    public void b() {
        this.f23987a.clear();
    }

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.b
    public void b(Context context) {
    }

    public abstract void b(Context context, App app, Map<String, Object> map);

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.b
    public void a(Context context, App app, Map<String, Object> map) {
        if (this.f23987a.isEmpty()) {
            b(context, app, this.f23987a);
        }
        map.putAll(this.f23987a);
    }
}
