package com.alibaba.alibclinkpartner.smartlink.b.a;

import com.alibaba.alibclinkpartner.smartlink.config.ALSLUri;
import com.alibaba.alibclinkpartner.smartlink.constants.ALSLAplusConstant;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f23574a;
    public String b;
    public String c;
    public ALSLUri.ALSLdegradeType d;
    public boolean e;

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public String a() {
        return ALSLAplusConstant.ALSL_SDK_DEGRADE;
    }

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public Map<String, String> b() {
        Map<String, String> mapB = super.b();
        mapB.put("target", this.f23574a);
        mapB.put("degradeUrl", this.b);
        mapB.put("url", this.c);
        mapB.put("degradeType", this.d.toString());
        mapB.put("isSmart", this.e ? "1" : "0");
        return mapB;
    }
}
