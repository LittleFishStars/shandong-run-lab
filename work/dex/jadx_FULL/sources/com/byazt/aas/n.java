package com.byazt.aas;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.byazt.bv.BaseConstants;
import com.byazt.ete.ic;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 46})
public class n {
    public static final Map<String, c> c = Collections.synchronizedMap(new HashMap());
    public static com.byazt.omf.yp tt;

    public interface c {
        void c();

        void tt();

        void ve();
    }

    public static c n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.remove(str);
    }

    public static void uj(ic icVar, Context context, String str) {
        int iZ = com.byazt.ete.gt.z(icVar);
        if (icVar == null || context == null) {
            return;
        }
        if (icVar.i() == 4 || iZ != 0) {
            com.byazt.wz.c cVarC = com.byazt.yih.x.c(context, icVar, str);
            if (cVarC instanceof com.byazt.wz.c) {
                cVarC.x().c(false);
            }
            cVarC.c(icVar, false);
        }
    }

    public static void ve(final ic icVar, String str, final Context context, final String str2) {
        if (icVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = icVar.fv();
        }
        c(context, icVar.uj(), str, new c() { // from class: com.byazt.aas.n.5
            @Override // com.byazt.aas.n.c
            public void c() {
                n.uj(icVar, context, str2);
            }

            @Override // com.byazt.aas.n.c
            public void tt() {
            }

            @Override // com.byazt.aas.n.c
            public void ve() {
            }
        });
    }

    public static void c(Context context, String str, String str2, String str3, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        c(str, cVar);
        TTDelegateActivity.c(context, str, str2, str3);
    }

    public static void tt(final ic icVar, String str, final Context context, final String str2) {
        if (icVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = icVar.fv();
        }
        c(context, icVar.uj(), new c() { // from class: com.byazt.aas.n.4
            @Override // com.byazt.aas.n.c
            public void c() {
                n.uj(icVar, context, str2);
            }

            @Override // com.byazt.aas.n.c
            public void tt() {
            }

            @Override // com.byazt.aas.n.c
            public void ve() {
            }
        }, str);
    }

    public static void c(final Context context, final String str, final String str2, final String str3, final c cVar, final com.byazt.ux.sp spVar, final ic icVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.aas.n.1
            @Override // java.lang.Runnable
            public void run() {
                boolean zC = com.byazt.omf.x.m().c(true);
                if (!com.byazt.ue.tt.c()) {
                    if (n.c.containsKey(str)) {
                        return;
                    }
                    if (!nb.uj() && !zC) {
                        return;
                    }
                }
                n.c(str, cVar);
                TTDelegateActivity.c(context, str, str2, str3, spVar, icVar);
            }
        });
    }

    public static void ve(ic icVar, Context context, String str) {
        ve(icVar, null, context, str);
    }

    public static void tt(ic icVar, Context context, String str) {
        tt(icVar, (String) null, context, str);
    }

    public static void ve(String str) {
        c(str, 2);
    }

    public static void tt(Context context, String str, String str2, c cVar) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        c(str2, cVar);
        TTDelegateActivity.ve(context, str2, str);
    }

    public static void uj(String str) {
        c(str, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.omf.yp ve() {
        if (tt == null) {
            tt = com.byazt.omf.yp.c.c(com.byazt.wzi.c.c(com.byazt.omf.gt.getContext()).c(2));
        }
        return tt;
    }

    public static void c(final Context context, final String str, final String str2, final String str3, final c cVar, final ic icVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.aas.n.2
            @Override // java.lang.Runnable
            public void run() {
                boolean zC = com.byazt.omf.x.m().c(true);
                if (!com.byazt.ue.tt.c()) {
                    if (n.c.containsKey(str)) {
                        return;
                    }
                    if (!nb.uj() && !zC) {
                        return;
                    }
                }
                n.c(str, cVar);
                TTDelegateActivity.c(context, str, str2, str3, icVar);
            }
        });
    }

    public static void tt(String str) {
        c(str, 1);
    }

    public static void c(String str) {
        Map<String, c> map = c;
        if (map != null) {
            map.remove(str);
        }
    }

    private static void c(Context context, String str, c cVar, String str2, ic icVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        c(str, cVar);
        TTDelegateActivity.c(context, str, str2, icVar);
    }

    public static void c(final ic icVar, String str, final Context context, final String str2) {
        if (icVar == null || context == null || TextUtils.isEmpty(str2)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = icVar.fv();
        }
        c(context, icVar.uj(), new c() { // from class: com.byazt.aas.n.3
            @Override // com.byazt.aas.n.c
            public void c() {
                n.uj(icVar, context, str2);
            }

            @Override // com.byazt.aas.n.c
            public void tt() {
            }

            @Override // com.byazt.aas.n.c
            public void ve() {
            }
        }, str, icVar);
    }

    public static void c(ic icVar, Context context, String str) {
        c(icVar, (String) null, context, str);
    }

    public static void c(Context context, String str, c cVar, String str2) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        c(str, cVar);
        TTDelegateActivity.tt(context, str, str2);
    }

    public static void c(Context context, String str, String str2, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        c(str, cVar);
        TTDelegateActivity.c(context, str, str2);
    }

    public static void c(Context context, ic icVar, String str) {
        c(context, (String) null, icVar, str);
    }

    public static void c(final Context context, String str, final ic icVar, final String str2) {
        if (icVar == null) {
            return;
        }
        String strUj = icVar.uj();
        if (TextUtils.isEmpty(strUj)) {
            return;
        }
        c(strUj, new c() { // from class: com.byazt.aas.n.6
            @Override // com.byazt.aas.n.c
            public void c() {
                n.uj(icVar, context, str2);
            }

            @Override // com.byazt.aas.n.c
            public void tt() {
            }

            @Override // com.byazt.aas.n.c
            public void ve() {
            }
        });
        com.byazt.ete.a aVarRh = icVar.rh();
        if (aVarRh == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = aVarRh.i();
        }
        TTDelegateActivity.ve(context, strUj, str);
    }

    public static void c(Context context, String str) {
        TTDelegateActivity.c(context, str);
        com.byazt.ukr.yp.c().c(str);
    }

    public static void c(Context context, String str, String str2, String str3, String str4, String str5, c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        c(str, cVar);
        TTDelegateActivity.c(context, str, str2, str3, str4, str5);
    }

    public static void c(Context context, String str, boolean z, c cVar) {
        if (z) {
            TTDelegateActivity.c(context, str, z);
        } else {
            if (TextUtils.isEmpty(str) || cVar == null) {
                return;
            }
            c(str, cVar);
            TTDelegateActivity.c(context, str, z);
        }
    }

    public static void c(final String str, final c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return;
        }
        if (com.byazt.ue.tt.c()) {
            com.byazt.bwm.n.tt(new com.byazt.bwm.sp("addDialogListener") { // from class: com.byazt.aas.n.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        n.ve().c(str, new com.byazt.ymw.c(cVar));
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
        } else {
            c.put(str, cVar);
        }
    }

    private static void c(final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.byazt.ue.tt.c()) {
            com.byazt.bwm.n.tt(new com.byazt.bwm.sp("doHandler") { // from class: com.byazt.aas.n.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        n.ve().c(str, i);
                    } catch (Throwable unused) {
                    }
                }
            }, 5);
            return;
        }
        c cVarN = n(str);
        if (cVarN == null) {
            return;
        }
        if (i == 1) {
            cVarN.c();
            return;
        }
        if (i == 2) {
            cVarN.tt();
        } else if (i != 3) {
            cVarN.ve();
        } else {
            cVarN.ve();
        }
    }

    public static void c(Context context, String str, ic icVar) {
        TTDelegateActivity.c(context, str, icVar);
    }

    public static void c(Context context, final ic icVar) {
        if (icVar == null) {
            return;
        }
        new com.byazt.ddx.c.C0382c().n(icVar.uj()).c("pangle_logo").tt("open_policy").uj(icVar.w_()).c(new com.byazt.ya.c() { // from class: com.byazt.aas.n.9
            @Override // com.byazt.ya.c
            public void onSend(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ad_info", icVar.mk());
                jSONObject2.put("ad_slot_type", nb.sl(icVar));
                jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
            }
        });
        TTDelegateActivity.tt(context, icVar.mk());
    }

    public static boolean c(ic icVar) {
        if (icVar == null || icVar.x_() || icVar.u_() == null || com.byazt.ete.gt.u(icVar) == 1 || icVar.i() != 4 || com.byazt.ete.gt.t(icVar) == 0) {
            return false;
        }
        int iPu = icVar.pu();
        return iPu == 4 || iPu == 5;
    }
}
