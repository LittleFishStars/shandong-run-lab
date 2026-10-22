package com.alibaba.alibclinkpartner.smartlink.b.a;

import com.alibaba.alibclinkpartner.smartlink.constants.ALSLAplusConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f23570a = new ArrayList();

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public String a() {
        return ALSLAplusConstant.ALSL_MATRIX_APP_INSTALL;
    }

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public Map<String, String> b() {
        Map<String, String> mapB = super.b();
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = this.f23570a.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            stringBuffer.append("^");
        }
        mapB.put("installedMatrixAppList", stringBuffer.toString());
        return mapB;
    }
}
