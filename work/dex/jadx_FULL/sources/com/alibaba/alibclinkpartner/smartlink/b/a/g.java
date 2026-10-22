package com.alibaba.alibclinkpartner.smartlink.b.a;

import com.alibaba.alibclinkpartner.smartlink.config.ALSLUri;
import com.alibaba.alibclinkpartner.smartlink.constants.ALSLAplusConstant;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f23573a;
    public String b;
    public ALSLUri.ALSLdegradeType c;
    public String d;

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public String a() {
        return ALSLAplusConstant.ALSL_MATRIX_APP_OPEN;
    }

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public Map<String, String> b() {
        Map<String, String> mapB = super.b();
        mapB.put("target", this.f23573a);
        mapB.put("url", this.b);
        mapB.put("matrixApp", this.d);
        mapB.put("degradeType", this.c.toString());
        return mapB;
    }
}
