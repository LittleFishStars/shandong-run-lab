package com.alibaba.ariver.commonability.device.jsapi.system.field.group;

import android.content.Context;
import com.alibaba.ariver.app.api.App;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f extends com.alibaba.ariver.commonability.device.jsapi.system.field.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23995a = "CommonAbility#SettingFieldGroup";
    private static final String b = "bluetoothEnabled";
    private static final String c = "locationEnabled";
    private static final String d = "wifiEnabled";

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.b
    public List<String> a() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(b);
        arrayList.add(c);
        arrayList.add(d);
        return arrayList;
    }

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.b
    public void a(Context context, App app, Map<String, Object> map) {
        map.put(b, Boolean.valueOf(com.alibaba.ariver.commonability.core.b.b.a()));
        map.put(c, Boolean.valueOf(com.alibaba.ariver.commonability.core.b.b.b(context)));
        map.put(d, Boolean.valueOf(com.alibaba.ariver.commonability.core.b.b.c(context)));
    }
}
