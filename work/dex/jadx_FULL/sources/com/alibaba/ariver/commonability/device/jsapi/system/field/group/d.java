package com.alibaba.ariver.commonability.device.jsapi.system.field.group;

import android.content.Context;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d extends com.alibaba.ariver.commonability.device.jsapi.system.field.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23993a = "app";
    private static final String b = "language";
    private static final String c = "version";
    private static final String d = "fontSizeSetting";
    private static final float e = 16.0f;

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.b
    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("app");
        arrayList.add("language");
        arrayList.add("version");
        arrayList.add(d);
        return arrayList;
    }

    @Override // com.alibaba.ariver.commonability.device.jsapi.system.field.a.c
    public void b(Context context, App app, Map<String, Object> map) {
        RVCommonAbilityProxy rVCommonAbilityProxy = (RVCommonAbilityProxy) RVProxy.get(RVCommonAbilityProxy.class);
        map.put("app", rVCommonAbilityProxy.getAppAlias());
        map.put("language", rVCommonAbilityProxy.getLocalLanguage());
        map.put(d, Float.valueOf(rVCommonAbilityProxy.getFontSizeSetting() == 0.0f ? 16.0f : rVCommonAbilityProxy.getFontSizeSetting()));
        map.put("version", ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getProductVersion());
    }
}
