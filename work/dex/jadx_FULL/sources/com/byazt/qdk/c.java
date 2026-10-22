package com.byazt.qdk;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.byazt.aas.n;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.ete.ir;
import com.byazt.omf.gt;
import com.byazt.omf.rl;
import com.byazt.pm.a;
import com.byazt.sy.uj;
import com.byazt.sz.m;
import com.byazt.un.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1262, 20})
public class c {
    public static volatile c c;

    private c() {
    }

    private void a(ic icVar, Context context) {
        if (icVar == null || context == null) {
            return;
        }
        n.c(icVar, context, nb.tt(icVar));
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    private void n(ic icVar, Context context) {
        if (icVar == null || context == null) {
            return;
        }
        n.c(context, icVar, nb.tt(icVar));
    }

    private void tt(ic icVar, Context context) {
        if (icVar == null || context == null) {
            return;
        }
        n.c(context, icVar);
    }

    private void uj(ic icVar, Context context) {
        if (icVar == null || context == null) {
            return;
        }
        n.ve(icVar, context, nb.tt(icVar));
    }

    private void ve(ic icVar, Context context) {
        if (icVar == null || context == null) {
            return;
        }
        n.tt(icVar, context, nb.tt(icVar));
    }

    private void tt(com.byazt.xj.ve veVar) {
        uj.c(veVar.i(), "fullscreen_tag");
    }

    private void tt(ve veVar, ic icVar, Context context) {
        HashMap map = new HashMap();
        map.put("material_meta", icVar);
        map.put("context", context);
        map.put("event_tag", nb.tt(icVar));
        com.byazt.ppf.ve.c(icVar, (HashMap<String, Object>) map, veVar);
    }

    public boolean c(m mVar, ic icVar, Context context, com.byazt.xj.ve veVar, JSONObject jSONObject, tt ttVar, Map<String, Object> map) {
        ve veVarC = ve.c(mVar, jSONObject, map);
        if (ttVar == null || !ttVar.c(veVarC.c(), veVar, veVarC)) {
            return c(veVarC, icVar, context, veVar, ttVar);
        }
        return true;
    }

    public boolean c(a.c cVar, ic icVar, Context context, com.byazt.xj.ve veVar, JSONObject jSONObject, tt ttVar, Map<String, Object> map) {
        ve veVarC = ve.c(cVar, jSONObject, map);
        veVarC.c("v3_trigger_name");
        if (ttVar == null || !ttVar.c(veVarC.c(), veVar, veVarC)) {
            return c(veVarC, icVar, context, veVar, ttVar);
        }
        return true;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private boolean c(ve veVar, ic icVar, Context context, com.byazt.xj.ve veVar2, tt ttVar) {
        String strC = veVar != null ? veVar.c() : "";
        strC.hashCode();
        boolean z = false;
        byte b = -1;
        switch (strC.hashCode()) {
            case -1822902106:
                if (strC.equals("openAppPermission")) {
                    b = 0;
                }
                break;
            case -1681588935:
                if (strC.equals("stopHaptic")) {
                    b = 1;
                }
                break;
            case -1657551782:
                if (strC.equals("openCommonUrl")) {
                    b = 2;
                }
                break;
            case -1639156586:
                if (strC.equals("renderScene")) {
                    b = 3;
                }
                break;
            case -1597668912:
                if (strC.equals("openAppRegistration")) {
                    b = 4;
                }
                break;
            case -1298570264:
                if (strC.equals("openNewAdPage")) {
                    b = 5;
                }
                break;
            case -1224502633:
                if (strC.equals("haptic")) {
                    b = 6;
                }
                break;
            case -850733204:
                if (strC.equals("uchain")) {
                    b = 7;
                }
                break;
            case -847712894:
                if (strC.equals("execEffect")) {
                    b = 8;
                }
                break;
            case -800853518:
                if (strC.equals("clickEvent")) {
                    b = 9;
                }
                break;
            case -511324706:
                if (strC.equals("openPrivacy")) {
                    b = 10;
                }
                break;
            case -459025504:
                if (strC.equals("openAppFunctionDesc")) {
                    b = 11;
                }
                break;
            case 257906716:
                if (strC.equals("openPolicy")) {
                    b = 12;
                }
                break;
            case 270575969:
                if (strC.equals("ugen_view_visibility_tracker")) {
                    b = 13;
                }
                break;
            case 293548143:
                if (strC.equals("openAppFunction")) {
                    b = com.google.common.base.a.p;
                }
                break;
            case 421035042:
                if (strC.equals("dismissScene")) {
                    b = com.google.common.base.a.q;
                }
                break;
            case 951590323:
                if (strC.equals("convert")) {
                    b = com.google.common.base.a.r;
                }
                break;
            case 1151744482:
                if (strC.equals("muteVideo")) {
                    b = 17;
                }
                break;
            case 1237425033:
                if (strC.equals("openAppPolicy")) {
                    b = com.google.common.base.a.u;
                }
                break;
            case 1250743019:
                if (strC.equals("playHaptic")) {
                    b = 19;
                }
                break;
            case 1671642405:
                if (strC.equals(com.byazt.dyf.tt.AD_TAG_DISLIKE)) {
                    b = com.google.common.base.a.x;
                }
                break;
            case 1671672458:
                if (strC.equals("dismiss")) {
                    b = com.google.common.base.a.y;
                }
                break;
        }
        switch (b) {
            case 0:
                uj(icVar, context);
                break;
            case 1:
                c(context);
                break;
            case 2:
                c(veVar, context);
                break;
            case 3:
                c(veVar, veVar2, icVar);
                break;
            case 4:
                a(icVar, context);
                break;
            case 5:
                c(veVar, icVar, context);
                break;
            case 6:
            case 19:
                c(veVar, context, icVar);
                break;
            case 7:
                tt(veVar, icVar, context);
                break;
            case 8:
                c(veVar, veVar2);
                break;
            case 9:
            case 16:
                c(veVar2, icVar, context);
                break;
            case 10:
            case 12:
                tt(icVar, context);
                break;
            case 11:
            case 14:
                n(icVar, context);
                break;
            case 13:
                c(veVar, icVar);
                break;
            case 15:
                tt(veVar2);
                break;
            case 17:
                c(icVar);
                break;
            case 18:
                ve(icVar, context);
                break;
            case 20:
                c(icVar, context);
                break;
            case 21:
                c(veVar2);
                break;
            default:
                if (z && ttVar != null) {
                    ttVar.c(strC);
                }
                return z;
        }
        z = true;
        if (z) {
            ttVar.c(strC);
        }
        return z;
    }

    private void c(com.byazt.xj.ve veVar, ic icVar, Context context) {
        com.byazt.oit.c.c(veVar != null ? veVar.i() : null, icVar, context);
    }

    private void c(ic icVar) {
        NativeVideoTsView nativeVideoTsView;
        if (icVar == null || (nativeVideoTsView = (NativeVideoTsView) rl.ve(icVar.lw(), NativeVideoTsView.class)) == null) {
            return;
        }
        boolean z = !nativeVideoTsView.m();
        nativeVideoTsView.tt(z, true);
        nativeVideoTsView.setIsQuiet(z);
    }

    private void c(ic icVar, Context context) {
        if (icVar == null) {
            return;
        }
        Dialog dialog = (Dialog) rl.ve(icVar.lw(), Dialog.class);
        com.byazt.dyf.tt ttVar = (com.byazt.dyf.tt) rl.ve(icVar.lw(), com.byazt.dyf.tt.class);
        if (dialog != null) {
            dialog.show();
        } else if (ttVar != null) {
            ttVar.showDislikeDialog();
        } else {
            TTDelegateActivity.c(context, icVar);
        }
    }

    private void c(com.byazt.xj.ve veVar) {
        if (veVar == null) {
            return;
        }
        uj.uj(veVar.i());
    }

    private void c(ve veVar, Context context) {
        if (veVar == null) {
            return;
        }
        String strC = veVar.c("webUrl");
        String strC2 = veVar.c("webTitle");
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        TTDelegateActivity.uj(context, strC, strC2);
    }

    private void c(ve veVar, Context context, ic icVar) {
        if (veVar == null) {
            return;
        }
        JSONObject jSONObjectTt = veVar.tt("params");
        String strC = veVar.c("id");
        JSONArray jSONArrayVe = veVar.ve("pattern");
        if (jSONObjectTt != null) {
            com.byazt.fx.ve.c(jSONObjectTt, context, icVar);
        } else {
            com.byazt.fx.ve.c(strC, jSONArrayVe, context, icVar);
        }
    }

    private void c(Context context) {
        if (context == null) {
            context = gt.getContext();
        }
        if (context == null) {
            return;
        }
        com.byazt.fx.ve.tt(context);
    }

    private void c(ve veVar, com.byazt.xj.ve veVar2) {
        com.byazt.xj.ve veVarTt;
        if (veVar == null || veVar2 == null) {
            return;
        }
        String strC = veVar.c("id");
        int iC = veVar.c("col", 4);
        int iC2 = veVar.c("row", 3);
        int iC3 = veVar.c("duration", 600);
        if (TextUtils.isEmpty(strC) || (veVarTt = veVar2.tt(veVar2)) == null) {
            return;
        }
        com.byazt.xj.ve veVarUj = veVarTt.uj(strC);
        if (veVarUj instanceof com.byazt.yn.c) {
            ((com.byazt.yn.c) veVarUj).c(iC, iC2, iC3);
        }
    }

    private void c(ve veVar, com.byazt.xj.ve veVar2, ic icVar) {
        View viewI;
        ir irVarC;
        if (veVar == null || veVar2 == null) {
            return;
        }
        String strC = veVar.c("scene");
        String strC2 = veVar.c("ugen_id");
        String strC3 = veVar.c("ugen_md5");
        String strC4 = veVar.c("ugen_url");
        int iC = veVar.c("displayAreaAndroid", 0);
        int iC2 = veVar.c("render_sequence", 2);
        if (!TextUtils.equals("scene1", strC) || !uj.c(iC) || (viewI = veVar2.i()) == null || icVar == null || (irVarC = uj.c(strC2, strC3, strC4, iC, iC2, 5)) == null || !irVarC.t()) {
            return;
        }
        new com.byazt.ma.n(icVar, null, irVarC).c(viewI);
    }

    private void c(ve veVar, ic icVar, Context context) {
        if (veVar == null || icVar == null) {
            return;
        }
        new com.byazt.rob.c(icVar, context).c(veVar.c("second_page_type", 0), icVar.ij());
    }

    private void c(ve veVar, ic icVar) {
        if (veVar == null || icVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : veVar.tt().keySet()) {
                jSONObject.put(str, veVar.c(str));
            }
        } catch (JSONException unused) {
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        map2.put("material_meta", icVar);
        HashMap map3 = new HashMap();
        map3.put("ugen_event_params", jSONObject);
        String strTt = nb.tt(icVar);
        nb.md();
        com.byazt.ppf.ve.c(icVar, map, "ugen_view_visibility_tracker", map2, strTt, map3, -1L);
    }
}
