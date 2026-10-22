package com.byazt.sx;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.byazt.nbs.da;
import com.byazt.ng.a;
import com.byazt.nr.m;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 928, 13})
public class tt {
    public static final Map<String, Boolean> c = new ConcurrentHashMap();

    public static final synchronized void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c.put(str, Boolean.TRUE);
    }

    public static final synchronized boolean tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Boolean bool = c.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static synchronized void c(Context context, List<com.byazt.nbs.c> list) {
        if (list != null) {
            for (com.byazt.nbs.c cVar : list) {
                final com.byazt.ih.tt ttVarUj = cVar.uj();
                try {
                    if (!tt(cVar.a())) {
                        c(context, ttVarUj, new com.byazt.ly.ve() { // from class: com.byazt.sx.tt.1
                            @Override // com.byazt.ly.ve
                            public void c() {
                                com.byazt.px.c.c(ttVarUj.tt(), (Pair<Boolean, String>) new Pair(Boolean.TRUE, ""));
                            }

                            @Override // com.byazt.ly.ve
                            public void c(@NonNull com.byazt.pp.c cVar2) {
                                if (cVar2 != null) {
                                    com.byazt.px.c.c(ttVarUj.tt(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, "errorCode = " + cVar2.c + " errorMessage = " + cVar2.tt));
                                }
                            }
                        });
                        c(cVar.a());
                    }
                } catch (Exception e) {
                    m.c(e);
                    com.byazt.px.c.c(ttVarUj.tt(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, e.toString()));
                    a.c(ttVarUj.tt(), (com.byazt.yl.ve) null, (com.byazt.ll.tt) null, (da) null, new com.byazt.pp.c(49013, e.toString()));
                }
            }
            return;
        }
        a.c("", (com.byazt.yl.ve) null, (com.byazt.ll.tt) null, (da) null, new com.byazt.pp.c(49013, "获取的自定义Adapter总配置为null"));
    }

    private static com.byazt.id.c c(com.byazt.ih.tt ttVar, com.byazt.ly.ve veVar) {
        com.byazt.id.c cVarC = com.byazt.px.c.uj().c(ttVar.tt());
        if (cVarC != null) {
            return cVarC;
        }
        com.byazt.id.c cVar = new com.byazt.id.c();
        com.byazt.px.c.uj().c(ttVar.tt(), cVar);
        return cVar;
    }

    private static void c(Context context, com.byazt.ih.tt ttVar, com.byazt.ly.ve veVar) throws Exception {
        if (ttVar == null || TextUtils.isEmpty(ttVar.ve())) {
            if (ttVar == null) {
                throw new Exception("自定义ADN初始化失败，获取的自定义Adapter单条配置为null");
            }
            throw new Exception("自定义ADN初始化失败，获取的自定义Adapter单条配置初始化类名为空");
        }
        com.byazt.id.c cVarC = c(ttVar, veVar);
        if (cVarC != null) {
            if (!cVarC.isInit()) {
                c(context, ttVar, cVarC);
            }
            veVar.c();
            return;
        }
        throw new Exception("GMCustomAdapterConfiguration is null");
    }

    private static void c(Context context, com.byazt.ih.tt ttVar, com.byazt.id.c cVar) {
        if (context == null) {
            a.c(ttVar.tt(), (com.byazt.yl.ve) null, (com.byazt.ll.tt) null, (da) null, new com.byazt.pp.c(49013, "context为null"));
            return;
        }
        try {
            cVar.initializeInnerADN(context.getApplicationContext(), ttVar, com.byazt.bp.c.t().gr());
        } catch (Exception e) {
            a.c(ttVar.tt(), (com.byazt.yl.ve) null, (com.byazt.ll.tt) null, (da) null, new com.byazt.pp.c(49013, "调用自定义Adapter初始化方法出现异常 " + e.getClass().getName()));
            m.c(e);
        }
    }

    public static synchronized void c(Context context, String str) {
        if (!tt(str)) {
            c(context, com.byazt.ck.ve.c().tt());
        }
    }
}
