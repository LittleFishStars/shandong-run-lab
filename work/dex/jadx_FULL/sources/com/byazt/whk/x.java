package com.byazt.whk;

import android.util.SparseArray;
import com.byazt.aas.nb;
import com.byazt.aas.z;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.UUID;
import java.util.function.LongSupplier;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_UMID_TIME_OUT, 71})
public abstract class x extends com.byazt.fb.uj implements LongSupplier {
    private SparseArray<Object> c(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        Object obj = sparseArray.get(-99999979);
        return obj instanceof SparseArray ? (SparseArray) obj : sparseArray;
    }

    @Override // com.byazt.fb.uj
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        PluginValueSet pluginValueSetOnEvent = onEvent(i, pluginValueSet.sparseArray());
        if (pluginValueSetOnEvent == null) {
            return null;
        }
        T t = (T) pluginValueSetOnEvent.sparseArray();
        if (cls == null || cls.isInstance(t)) {
            return t;
        }
        return null;
    }

    public PluginValueSet c(int i, SparseArray<Object> sparseArray) {
        return null;
    }

    public PluginValueSet c(int i, i iVar) {
        return null;
    }

    public PluginValueSet c(int i, n nVar) {
        return null;
    }

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    public PluginValueSet onEvent(int i, SparseArray<Object> sparseArray) {
        SparseArray<Object> sparseArrayC = c(sparseArray);
        switch (i) {
            case 1:
                return provideDid();
            case 2:
                return c(i, sparseArrayC);
            case 3:
                return onSettingsCallback();
            case 4:
                return provideUid();
            case 5:
                return onFilterCallback();
            case 6:
                return c(i, new n(sparseArrayC, i));
            case 7:
            default:
                return null;
            case 8:
                return c(i, new i(sparseArrayC, i));
            case 9:
                return ve(i, sparseArrayC);
            case 10:
                tt(sparseArrayC);
                return null;
            case 11:
                return tt(i, sparseArrayC);
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004a  */
    public PluginValueSet onFilterCallback() {
        JSONObject jSONObjectNt = gt.tt().nt();
        JSONObject jSONObject = null;
        if (jSONObjectNt != null) {
            JSONObject jSONObjectOptJSONObject = jSONObjectNt.optJSONObject("filter");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = jSONObjectNt.optJSONObject("pitaya_filter");
            }
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = jSONObjectNt.optJSONObject("init_filter");
            }
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = jSONObjectNt.optJSONObject("filter_config");
            }
            if (jSONObjectOptJSONObject != null) {
                jSONObject = jSONObjectOptJSONObject;
            } else {
                String strOptString = jSONObjectNt.optString("filter", null);
                if (strOptString == null || strOptString.length() == 0) {
                    strOptString = jSONObjectNt.optString("pitaya_filter", null);
                }
                if (strOptString == null || strOptString.length() == 0) {
                    jSONObject = jSONObjectOptJSONObject;
                } else {
                    try {
                        jSONObject = new JSONObject(strOptString);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return com.byazt.rl.c.c().c(34, jSONObject).tt();
    }

    public PluginValueSet onSettingsCallback() {
        JSONObject jSONObjectNt = gt.tt().nt();
        if (jSONObjectNt != null) {
            return com.byazt.rl.c.c().c(33, jSONObjectNt).tt();
        }
        return null;
    }

    public PluginValueSet provideDid() {
        String strC = z.c();
        if (strC == null) {
            strC = "";
        }
        return com.byazt.rl.c.c().c(31, strC).tt();
    }

    public PluginValueSet provideUid() {
        return com.byazt.rl.c.c().c(32, String.valueOf(nb.n())).tt();
    }

    public PluginValueSet tt(int i, SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        pluginValueSetTt.intValue(9, 0);
        if (pluginValueSetTt.containsKey(8)) {
            pluginValueSetTt.longValue(8);
        }
        return null;
    }

    public PluginValueSet ve(int i, SparseArray<Object> sparseArray) {
        return null;
    }

    private void tt(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            try {
                PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
                SparseArray sparseArray2 = (SparseArray) pluginValueSetTt.objectValue(-999902, SparseArray.class);
                if (sparseArray2 != null) {
                    pluginValueSetTt = com.byazt.rl.c.c((SparseArray<Object>) sparseArray2).tt();
                }
                String strStringValue = pluginValueSetTt.stringValue(6);
                JSONObject jSONObjectC = da.c(pluginValueSetTt, 7);
                if (jSONObjectC == null) {
                    jSONObjectC = new JSONObject();
                }
                if (strStringValue != null) {
                    jSONObjectC.put("label", strStringValue);
                }
                com.byazt.fo.c cVar = new com.byazt.fo.c(UUID.randomUUID().toString(), jSONObjectC);
                cVar.c((byte) 0);
                cVar.tt((byte) 2);
                com.byazt.lj.ve.reportEvent(cVar);
                com.byazt.epi.c.c(cVar, "csj");
            } catch (Exception e) {
                m.c(e);
            }
        }
    }
}
