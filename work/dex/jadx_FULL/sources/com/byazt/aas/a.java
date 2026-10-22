package com.byazt.aas;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 34})
public class a {
    public static final Map<String, c> c = Collections.synchronizedMap(new HashMap());
    public static com.byazt.omf.yp tt;

    public interface c {
        void c();

        void c(String str);
    }

    private static c tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.remove(str);
    }

    public static void c(String str, String[] strArr, c cVar) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        c(str, cVar);
        TTDelegateActivity.c(str, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.omf.yp tt() {
        if (tt == null) {
            tt = com.byazt.omf.yp.c.c(com.byazt.wzi.c.c(com.byazt.omf.gt.getContext()).c(4));
        }
        return tt;
    }

    public static void c(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.byazt.ue.tt.c()) {
            com.byazt.bwm.n.ve().execute(new com.byazt.bwm.sp("handleYes", 5) { // from class: com.byazt.aas.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.tt().c(str, (String) null);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        c cVarTt = tt(str);
        if (cVarTt == null) {
            return;
        }
        cVarTt.c();
    }

    public static void c(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.byazt.ue.tt.c()) {
            com.byazt.bwm.n.ve().execute(new com.byazt.bwm.sp("handleNo", 5) { // from class: com.byazt.aas.a.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.tt().c(str, str2);
                    } catch (Throwable unused) {
                    }
                }
            });
            return;
        }
        c cVarTt = tt(str);
        if (cVarTt == null) {
            return;
        }
        cVarTt.c(str2);
    }

    private static void c(final String str, final c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        if (com.byazt.ue.tt.c()) {
            com.byazt.bwm.n.tt(new com.byazt.bwm.sp("addListener") { // from class: com.byazt.aas.a.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.byazt.nr.m.uj("MultiProcess", "getListenerManager().registerPermissionListener...");
                        a.tt().c(str, new com.byazt.ymw.tt(cVar));
                    } catch (Throwable th) {
                        com.byazt.nr.m.c(th);
                        com.byazt.nr.m.uj("MultiProcess", th.toString());
                    }
                }
            }, 5);
        } else {
            c.put(str, cVar);
        }
    }
}
