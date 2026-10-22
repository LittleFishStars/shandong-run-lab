package com.alibaba.alibclinkpartner.smartlink.manager;

import com.alibaba.alibclinkpartner.smartlink.constants.ALPUserTrackConstant;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.util.e;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f23577a = true;
    private static boolean b = false;

    public static void a(final com.alibaba.alibclinkpartner.smartlink.b.a.a aVar) {
        com.alibaba.alibclinkpartner.smartlink.a.a(new Runnable() { // from class: com.alibaba.alibclinkpartner.smartlink.manager.b.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                if (b.b()) {
                    b.d(aVar);
                } else {
                    b.e(aVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized boolean b() {
        if (f23577a) {
            try {
                Class.forName(ALPUserTrackConstant.CLASS_UTANALYTICS);
                b = true;
            } catch (Exception e) {
                ALSLLogUtil.e("ALSLUserTraceManager", "isUTExsist", "ut do not exist , errmsg =" + e.toString());
                b = false;
            }
            f23577a = false;
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(com.alibaba.alibclinkpartner.smartlink.b.a.a aVar) {
        Object objA = e.a(ALPUserTrackConstant.CLASS_UTCUSTOMHITBUILDER, new String[]{"java.lang.String"}, new Object[]{aVar.a()});
        e.a(ALPUserTrackConstant.CLASS_UTCUSTOMHITBUILDER, ALPUserTrackConstant.METHOD_PROPERITIES, new String[]{"java.util.Map"}, objA, new Object[]{aVar.b()});
        e.a(ALPUserTrackConstant.CLASS_TRACKER, "send", new String[]{"java.util.Map"}, e.a(ALPUserTrackConstant.CLASS_UTANALYTICS, ALPUserTrackConstant.METHOD_GET_TRACKER, new String[]{"java.lang.String"}, e.a(ALPUserTrackConstant.CLASS_UTANALYTICS, "getInstance", null, null, null), new String[]{ALPUserTrackConstant.TRACKER_ID}), new Object[]{(Map) e.a(ALPUserTrackConstant.CLASS_UTCUSTOMHITBUILDER, ALPUserTrackConstant.METHOD_BUILD, null, objA, null)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(com.alibaba.alibclinkpartner.smartlink.b.a.a aVar) throws Throwable {
        com.alibaba.alibclinkpartner.smartlink.b.a aVarA = com.alibaba.alibclinkpartner.smartlink.b.a.a();
        aVarA.a(aVar.a());
        aVarA.a(aVar.b());
        aVarA.b();
    }
}
