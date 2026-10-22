package com.alibaba.ariver.commonability.device.jsapi.system.field.group;

import android.content.Context;
import com.alibaba.ariver.app.api.App;
import com.hjq.permissions.Permission;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e extends com.alibaba.ariver.commonability.device.jsapi.system.field.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23994a = "cameraAuthorized";
    private static final String b = "locationAuthorized";
    private static final String c = "microphoneAuthorized";
    private static final String d = "notificationAuthorized";

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.b
    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(f23994a);
        arrayList.add(b);
        arrayList.add(c);
        arrayList.add(d);
        return arrayList;
    }

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.b
    public void a(Context context, App app, Map<String, Object> map) {
        map.put(d, Boolean.valueOf(com.alibaba.ariver.commonability.core.b.b.a(context)));
        map.put(f23994a, Boolean.valueOf(com.alibaba.ariver.commonability.core.b.b.a(context, Permission.CAMERA)));
        map.put(b, Boolean.valueOf(com.alibaba.ariver.commonability.core.b.b.a(context, "android.permission.ACCESS_COARSE_LOCATION") || com.alibaba.ariver.commonability.core.b.b.a(context, "android.permission.ACCESS_FINE_LOCATION")));
        map.put(c, Boolean.valueOf(com.alibaba.ariver.commonability.core.b.b.a(context, Permission.RECORD_AUDIO)));
    }
}
