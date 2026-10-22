package com.byazt.whk;

import android.util.SparseArray;
import com.byazt.omf.eo;
import com.byazt.omf.gt;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_UMID_TIME_OUT, 72})
public class da {
    public static JSONObject c(PluginValueSet pluginValueSet, int i) {
        if (pluginValueSet == null) {
            return null;
        }
        JSONObject jSONObject = (JSONObject) pluginValueSet.objectValue(i, JSONObject.class);
        if (jSONObject != null) {
            return jSONObject;
        }
        String strStringValue = pluginValueSet.stringValue(i, null);
        if (strStringValue != null && strStringValue.length() != 0) {
            try {
                return new JSONObject(strStringValue);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static boolean tt() {
        JSONObject jSONObjectVi = gt.tt().vi();
        return jSONObjectVi != null && jSONObjectVi.optInt("pre_drop", 0) == 1;
    }

    public static boolean c() {
        JSONObject jSONObjectVi = gt.tt().vi();
        return jSONObjectVi != null && jSONObjectVi.optInt("video_cache", 0) == 1;
    }

    public static void c(final Function<SparseArray<Object>, Object> function) {
        ve veVar;
        Function<SparseArray<Object>, Object> functionLt = com.byazt.omf.x.m().lt();
        if (gt.tt().pf()) {
            Object objApply = functionLt.apply(com.byazt.yxi.uj.c().c(6).c(Boolean.class).c(0, "com.byted.csj.ext").tt());
            if (objApply != null ? ((Boolean) objApply).booleanValue() : false) {
                Object objApply2 = functionLt.apply(com.byazt.yxi.uj.c().c(7).c(Boolean.class).c(0, "com.byted.csj.ext").tt());
                if (((objApply2 != null ? ((Boolean) objApply2).booleanValue() : false) || eo.c().c(functionLt, false)) && (veVar = (ve) com.byazt.ut.uj.getService("pitaya")) != null) {
                    veVar.init(gt.getContext(), new com.byazt.fb.uj() { // from class: com.byazt.whk.da.1
                        @Override // com.byazt.fb.uj
                        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
                            if (function == null) {
                                return null;
                            }
                            function.apply(com.byazt.yxi.uj.c().c(i).c(Void.class).c(-99999979, (SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class)).tt());
                            return null;
                        }
                    });
                }
            }
        }
    }
}
