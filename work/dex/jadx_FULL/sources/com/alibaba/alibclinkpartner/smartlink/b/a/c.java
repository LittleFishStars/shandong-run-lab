package com.alibaba.alibclinkpartner.smartlink.b.a;

import com.alibaba.alibclinkpartner.smartlink.config.ALSLUri;
import com.alibaba.alibclinkpartner.smartlink.constants.ALSLAplusConstant;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f23571a;
    public String b;
    public ALSLUri.ALSLdegradeType c;

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public String a() {
        return ALSLAplusConstant.ALSL_CALL_SDK_OPRNURL;
    }

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public Map<String, String> b() {
        Map<String, String> mapB = super.b();
        mapB.put("target", this.f23571a);
        mapB.put("url", this.b);
        mapB.put("degradeType", this.c.toString());
        return mapB;
    }
}
