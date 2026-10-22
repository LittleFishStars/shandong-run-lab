package com.alibaba.ariver.commonability.device.jsapi.system.field.group;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c extends com.alibaba.ariver.commonability.device.jsapi.system.field.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23992a = "CommonAbility#DeviceFieldGroup";
    private static final String b = "performance";
    private static final String c = "storage";

    private static String c() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return com.alibaba.ariver.commonability.core.util.a.a(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            RVLogger.e(f23992a, "getInternalMemorySize...", th);
            return "";
        }
    }

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.b
    public List<String> a() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(b);
        arrayList.add(c);
        return arrayList;
    }

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.c
    public void b(Context context, App app, Map<String, Object> map) {
        map.put(b, ((RVCommonAbilityProxy) RVProxy.get(RVCommonAbilityProxy.class)).getDevicePerformance());
        map.put(c, c());
    }
}
