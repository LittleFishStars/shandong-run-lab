package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.f;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c {
    public static Map<String, String> a(Context context) {
        com.alipay.sdk.m.f0.b bVarA = com.alipay.sdk.m.f0.b.a(APSecuritySdk.getInstance(context));
        HashMap map = new HashMap();
        f fVarA = com.alipay.apmobilesecuritysdk.e.e.a(context);
        String strA = bVarA.a(context);
        String strK = bVarA.k(context);
        if (fVarA != null) {
            if (com.alipay.sdk.m.d0.a.a(strA)) {
                strA = fVarA.b();
            }
            if (com.alipay.sdk.m.d0.a.a(strK)) {
                strK = fVarA.e();
            }
        }
        com.alipay.apmobilesecuritysdk.e.e.a(context, new f("", strA, "", "", strK));
        map.put("AD1", "");
        map.put("AD2", strA);
        map.put("AD3", bVarA.e(context));
        map.put("AD5", bVarA.g(context));
        map.put("AD6", bVarA.h(context));
        map.put("AD7", bVarA.i(context));
        map.put("AD9", bVarA.j(context));
        map.put("AD10", strK);
        map.put("AD11", bVarA.c());
        map.put("AD12", bVarA.d());
        map.put("AD13", bVarA.e());
        map.put("AD14", bVarA.g());
        map.put("AD15", bVarA.h());
        map.put("AD16", bVarA.i());
        map.put("AD17", "");
        map.put("AD19", bVarA.l(context));
        map.put("AD20", bVarA.j());
        map.put("AD22", "");
        map.put("AD24", com.alipay.sdk.m.d0.a.g(bVarA.f(context)));
        map.put("AD26", bVarA.d(context));
        map.put("AD27", bVarA.o());
        map.put("AD28", bVarA.q());
        map.put("AD29", bVarA.s());
        map.put("AD30", bVarA.p());
        map.put("AD31", bVarA.r());
        map.put("AD32", bVarA.m());
        map.put("AD33", bVarA.n());
        map.put("AD34", bVarA.p(context));
        map.put("AD35", bVarA.q(context));
        map.put("AD36", bVarA.m(context));
        map.put("AD37", bVarA.l());
        map.put("AD38", bVarA.k());
        map.put("AD39", bVarA.b(context));
        map.put("AD40", bVarA.c(context));
        map.put("AD41", bVarA.a());
        map.put("AD42", bVarA.b());
        return map;
    }
}
