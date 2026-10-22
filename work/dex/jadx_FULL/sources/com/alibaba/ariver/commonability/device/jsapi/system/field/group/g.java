package com.alibaba.ariver.commonability.device.jsapi.system.field.group;

import android.content.Context;
import android.os.Build;
import com.alibaba.ariver.app.api.App;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g extends com.alibaba.ariver.commonability.device.jsapi.system.field.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23996a = "apiLevel";
    private static final String b = "brand";
    private static final String c = "system";
    private static final String d = "platform";
    private static final String e = "model";

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.b
    public List<String> a() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(f23996a);
        arrayList.add(b);
        arrayList.add("system");
        arrayList.add("platform");
        arrayList.add("model");
        return arrayList;
    }

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.c
    public void b(Context context, App app, Map<String, Object> map) {
        map.put(f23996a, Integer.valueOf(Build.VERSION.SDK_INT));
        map.put(b, Build.BRAND);
        map.put("system", Build.VERSION.RELEASE);
        map.put("model", Build.MANUFACTURER + " " + Build.MODEL);
        map.put("platform", "Android");
    }
}
