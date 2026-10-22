package com.byazt.ch;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1054, 20})
public class c extends com.byazt.dj.tt {
    public final PluginValueSet tt;

    public c(SparseArray<Object> sparseArray, String str) {
        super(sparseArray, str);
        this.tt = com.byazt.rl.c.c(sparseArray).tt();
    }

    private static Function<SparseArray<Object>, Object> c(PluginValueSet pluginValueSet) {
        Object objObjectValue;
        if (pluginValueSet != null) {
            objObjectValue = pluginValueSet.objectValue(8260028, Object.class);
            if (objObjectValue == null) {
                try {
                    objObjectValue = pluginValueSet.objectValue(260026, Function.class);
                } catch (Throwable unused) {
                }
            }
        } else {
            objObjectValue = null;
        }
        return com.byazt.gxc.ve.c(objObjectValue);
    }

    public Map d() {
        PluginValueSet pluginValueSet = this.tt;
        if (pluginValueSet == null) {
            return null;
        }
        return (Map) pluginValueSet.objectValue(8260032, Map.class);
    }

    public PluginValueSet eo() {
        return this.tt;
    }

    public String h() {
        PluginValueSet pluginValueSet = this.tt;
        if (pluginValueSet == null) {
            return null;
        }
        return (String) pluginValueSet.objectValue(8260029, String.class);
    }

    public tt md() {
        Function<SparseArray<Object>, Object> functionC = c(this.tt);
        if (functionC != null) {
            return new tt(functionC);
        }
        return null;
    }

    public boolean p() {
        PluginValueSet pluginValueSet = this.tt;
        if (pluginValueSet == null) {
            return false;
        }
        return pluginValueSet.booleanValue(8260030);
    }

    public static final PluginValueSet c(com.byazt.dj.tt ttVar) {
        return c(ttVar, null, false);
    }

    public static final PluginValueSet c(com.byazt.dj.tt ttVar, String str, boolean z) {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c();
        if (ttVar == null) {
            return cVarC.tt();
        }
        cVarC.c(260001, ttVar.c());
        cVarC.c(260002, ttVar.tt());
        cVarC.c(260003, ttVar.ve());
        cVarC.c(260004, ttVar.uj());
        cVarC.c(260005, ttVar.n());
        cVarC.c(260006, ttVar.a());
        cVarC.c(260007, ttVar.sp());
        cVarC.c(7, ttVar.a());
        cVarC.c(8, ttVar.sp());
        cVarC.c(260008, ttVar.x());
        cVarC.c(260009, ttVar.i());
        cVarC.c(10, ttVar.x());
        cVarC.c(9, ttVar.i());
        cVarC.c(260010, ttVar.da());
        cVarC.c(260011, ttVar.sl());
        cVarC.c(2600012, ttVar.t());
        cVarC.c(260013, ttVar.u());
        cVarC.c(260014, ttVar.yp());
        cVarC.c(260015, ttVar.z());
        cVarC.c(260016, ttVar.m());
        cVarC.c(260017, ttVar.nu());
        cVarC.c(260018, ttVar.rh());
        cVarC.c(260019, ttVar.my());
        cVarC.c(260020, ttVar.gt());
        cVarC.c(260021, ttVar.rl());
        cVarC.c(260022, ttVar.qy());
        cVarC.c(260023, ttVar.gu());
        cVarC.c(8260032, ttVar.zb());
        PluginValueSet pluginValueSet = null;
        try {
            for (Field field : ttVar.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.get(ttVar) instanceof PluginValueSet) {
                    pluginValueSet = (PluginValueSet) field.get(ttVar);
                }
                field.setAccessible(false);
            }
        } catch (Exception unused) {
        }
        if (pluginValueSet != null) {
            cVarC.c(8260028, c(pluginValueSet));
            if (com.byazt.mta.c.c().tt() < 7400) {
                cVarC.c(260027, pluginValueSet.objectValue(260027, IMediationAdSlot.class));
            }
        }
        cVarC.c(260024, ttVar.gr());
        cVarC.c(260025, ttVar.zm());
        cVarC.c(260008, ttVar.x());
        if (!TextUtils.isEmpty(str)) {
            cVarC.c(8260029, str);
            cVarC.c(8260030, z);
        }
        return cVarC.tt();
    }

    public static PluginValueSet c(PluginValueSet pluginValueSet, String str) {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c(pluginValueSet);
        cVarC.c(260022, str);
        return cVarC.tt();
    }
}
