package com.alibaba.ariver.v8worker;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.jsi.standard.js.w;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f {
    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b() {
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService != null) {
            return "yes".equalsIgnoreCase(rVConfigService.getConfigWithProcessCache("ta_jsConsoleCallback", "yes"));
        }
        return false;
    }

    public static String a(com.alibaba.jsi.standard.js.a aVar) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aVar.a(); i++) {
            String strA_ = aVar.a(i).a_(aVar.b());
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(strA_);
        }
        return sb.toString();
    }

    public static void a(com.alibaba.jsi.standard.b bVar, final JSConsoleCallback jSConsoleCallback) {
        if (bVar == null || bVar.b()) {
            return;
        }
        com.alibaba.jsi.standard.js.o oVarG = bVar.g();
        com.alibaba.jsi.standard.js.j jVar = new com.alibaba.jsi.standard.js.j(bVar, new com.alibaba.jsi.standard.js.h() { // from class: com.alibaba.ariver.v8worker.f.1
            @Override // com.alibaba.jsi.standard.js.h
            public w a(com.alibaba.jsi.standard.js.a aVar) {
                try {
                    String strA = f.a(aVar);
                    RVLogger.d("JSConsole", strA);
                    if (jSConsoleCallback != null && f.b()) {
                        jSConsoleCallback.onConsoleMessage(strA);
                    }
                    return null;
                } catch (Throwable th) {
                    RVLogger.e("JSConsole __nativeLog__ onCallFunction error: " + th);
                    return null;
                }
            }
        }, "__nativeLog__");
        oVarG.a(bVar, "__nativeLog__", jVar);
        jVar.a();
        oVarG.a();
    }
}
