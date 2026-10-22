package com.alibaba.ariver.commonability.device.jsapi.system.field.group;

import android.content.Context;
import com.alibaba.ariver.app.api.App;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends com.alibaba.ariver.commonability.device.jsapi.system.field.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23989a = "platformType";

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.b
    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(f23989a);
        return arrayList;
    }

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.c
    public void b(Context context, App app, Map<String, Object> map) {
        if (app == null) {
            return;
        }
        map.put(f23989a, app.getInstanceType().getValue());
    }
}
