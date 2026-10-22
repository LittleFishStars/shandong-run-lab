package com.alibaba.alibclinkpartner.smartlink.b.a;

import com.alibaba.alibclinkpartner.smartlink.config.ALSLUri;
import com.alibaba.alibclinkpartner.smartlink.constants.ALSLAplusConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f23576a;
    public String b;
    public ALSLUri.ALSLdegradeType c;
    public List<String> d = new ArrayList();

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public String a() {
        return ALSLAplusConstant.ALSL_SMART_LINK_MATCH;
    }

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public Map<String, String> b() {
        Map<String, String> mapB = super.b();
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = this.d.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            stringBuffer.append("^");
        }
        mapB.put("url", this.f23576a);
        mapB.put("target", this.b);
        mapB.put("degradeType", this.c.toString());
        mapB.put("matrixAppList", stringBuffer.toString());
        return mapB;
    }
}
