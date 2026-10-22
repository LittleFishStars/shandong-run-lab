package com.byazt.om;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.bytedance.pangle.wrapper.PluginActivityWrapper;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 554, 67})
public class u implements c {
    @Override // com.byazt.om.c
    public void c(c.InterfaceC0486c interfaceC0486c) {
        com.byazt.iz.tt ttVarC = interfaceC0486c.c();
        com.byazt.ll.tt ttVarGu = ttVarC.gu();
        String strC = com.byazt.ni.c.c(ttVarGu.zb());
        if (!TextUtils.isEmpty(strC)) {
            ttVarGu.uj(2);
            com.byazt.nbs.tt ttVarC2 = com.byazt.ni.c.c(ttVarC.m(), strC);
            if (ttVarC2 == null) {
                com.byazt.ng.a.c(ttVarC.gu(), (String) null, !ttVarC.yv(), ttVarC.pf().c, 81012, (Map<String, Object>) null);
                ttVarC.c(new com.byazt.bnd.c(81012, com.byazt.pp.c.c(81012)));
                return;
            }
            ttVarC.c(ttVarC2);
            com.byazt.eu.tt.uj(MediationConstant.TAG, com.byazt.eu.uj.c(ttVarC2) + "测试工具加载广告........rit_id:" + ttVarGu.gt() + " ,slot_id:" + strC);
        } else if (com.byazt.zlb.ve.c() && com.byazt.omf.x.m().tx()) {
            try {
                SharedPreferences sharedPreferencesC = c(com.byazt.bp.tt.getContext());
                if (sharedPreferencesC == null) {
                    interfaceC0486c.c(interfaceC0486c.c());
                    return;
                }
                String string = sharedPreferencesC.getString(ttVarGu.gt(), "");
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    String strOptString = jSONObject.optString("sub_rit_id");
                    if (System.currentTimeMillis() - jSONObject.optLong("save_time") > 3600000) {
                        sharedPreferencesC.edit().remove(ttVarGu.gt()).apply();
                        interfaceC0486c.c(interfaceC0486c.c());
                        return;
                    } else {
                        com.byazt.nbs.tt ttVarC3 = com.byazt.ni.c.c(ttVarC.m(), strOptString);
                        if (ttVarC3 != null) {
                            ttVarC.c(ttVarC3);
                        }
                    }
                }
            } catch (Exception e) {
                m.c(e);
            }
        }
        interfaceC0486c.c(interfaceC0486c.c());
    }

    @Override // com.byazt.om.c
    public void tt(c.InterfaceC0486c interfaceC0486c) {
        interfaceC0486c.c((String) null);
    }

    private SharedPreferences c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context.getClass() == PluginActivityWrapper.class && ((PluginActivityWrapper) context).mOriginActivity != null) {
                return com.byazt.nys.tt.tt(((PluginActivityWrapper) context).mOriginActivity, "tools_pre_view_name", 0);
            }
            if (context.getClass() == PluginApplicationWrapper.class && ((PluginApplicationWrapper) context).mOriginApplication != null) {
                return com.byazt.nys.tt.tt(((PluginApplicationWrapper) context).mOriginApplication, "tools_pre_view_name", 0);
            }
            return com.byazt.nys.tt.tt(context, "tools_pre_view_name", 0);
        } catch (Throwable th) {
            m.c(th);
            return null;
        }
    }
}
