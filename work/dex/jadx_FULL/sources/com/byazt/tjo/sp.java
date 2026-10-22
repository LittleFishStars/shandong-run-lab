package com.byazt.tjo;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.nr.m;
import com.byazt.omf.h;
import com.byazt.omf.rh;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 516, 91})
public class sp implements Function<SparseArray<Object>, Object> {
    public Function<SparseArray<Object>, Object> c;
    public Context tt;

    public sp(Context context, Function<SparseArray<Object>, Object> function) {
        this.c = function;
        this.tt = context;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        c(sparseArray);
        return null;
    }

    private PluginValueSet c(PluginValueSet pluginValueSet) {
        JSONArray jSONArray;
        if (pluginValueSet == null) {
            return null;
        }
        String strQy = new com.byazt.dj.tt(pluginValueSet.sparseArray(), com.byazt.vxy.c.tt()).qy();
        try {
            if (TextUtils.isEmpty(strQy)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(strQy);
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && TextUtils.equals("personal_ads_type", jSONObjectOptJSONObject.optString("name"))) {
                    return pluginValueSet;
                }
            }
            JSONObject jSONObject = new JSONObject();
            com.byazt.xf.ve veVarTt = com.byazt.bp.c.t().tt();
            if (veVarTt != null) {
                String str = veVarTt.sp() ? "0" : "1";
                jSONObject.put("name", "personal_ads_type");
                jSONObject.put("value", str);
                jSONArray.put(jSONObject);
                return com.byazt.ch.c.c(pluginValueSet, jSONArray.toString());
            }
        } catch (Throwable th) {
            m.c(th);
        }
        return pluginValueSet;
    }

    private void c(final SparseArray<Object> sparseArray) {
        final PluginValueSet pluginValueSetTt = com.byazt.rl.c.c(sparseArray).tt();
        final int iIntValue = pluginValueSetTt.intValue(-99999982);
        final String strStringValue = pluginValueSetTt.stringValue(260004);
        final Function<SparseArray<Object>, Object> function = (Function) pluginValueSetTt.objectValue(1, Function.class);
        if (!com.byazt.vq.c.c().ve()) {
            if (this.c instanceof h) {
                com.byazt.eu.tt.tt("TMe", "load csj 代码位未开启聚合开关");
                ((h) this.c).loadAdByType(iIntValue, pluginValueSetTt, function);
                return;
            }
            return;
        }
        c.c().c(new com.byazt.zh.uj() { // from class: com.byazt.tjo.sp.1
            @Override // com.byazt.zh.uj
            public void c(boolean z, Map<String, Object> map) {
                sp.this.c(iIntValue, sparseArray, pluginValueSetTt, function, map, z);
            }

            @Override // com.byazt.zh.uj
            public String tt() {
                return strStringValue;
            }

            @Override // com.byazt.zh.uj
            public int c() {
                return iIntValue;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:161:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:163:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:165:0x040b  */
    /* JADX WARN: Code duplicated, block: B:167:0x0420  */
    /* JADX WARN: Code duplicated, block: B:16:0x008a  */
    /* JADX WARN: Instruction removed from duplicated block: B:167:0x0420, please report this as an issue */
    public void c(int i, SparseArray<Object> sparseArray, PluginValueSet pluginValueSet, Function<SparseArray<Object>, Object> function, Map<String, Object> map, boolean z) {
        boolean z2;
        PluginValueSet pluginValueSetC;
        boolean z3;
        final com.byazt.bc.tt ttVar;
        com.byazt.eu.tt.tt(MediationConstant.TAG, "CSJM_loadAD Type:".concat(String.valueOf(i)));
        final com.byazt.nx.c cVar = new com.byazt.nx.c(sparseArray);
        com.byazt.dj.tt.c cVar2 = new com.byazt.dj.tt.c(new com.byazt.dj.tt(sparseArray, com.byazt.vxy.c.tt()));
        if (map != null && !map.isEmpty()) {
            cVar2.c(map);
        }
        com.byazt.vq.c.c().c(cVar.x());
        com.byazt.dj.tt.c cVar3 = new com.byazt.dj.tt.c(new com.byazt.dj.tt(sparseArray, com.byazt.vxy.c.tt()));
        c(cVar, cVar3);
        float fVe = cVar.ve();
        float fUj = cVar.uj();
        if (cVar.c() == 0 || !(fVe == 0.0f || cVar.c() == fVe)) {
            z2 = false;
        } else {
            cVar2.c(com.byazt.pp.n.tt(this.tt, cVar.c()));
            if (cVar.c() == fVe) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (cVar.tt() != 0 && ((fVe == 0.0f && fUj == 0.0f) || fUj == cVar.tt())) {
            cVar2.tt(com.byazt.pp.n.tt(this.tt, cVar.tt()));
        }
        if (cVar.c() == 0 && fVe != 0.0f) {
            cVar2.c(com.byazt.pp.n.c(this.tt, fVe));
        }
        if (cVar.tt() == 0 && fUj != 0.0f) {
            cVar2.tt(com.byazt.pp.n.c(this.tt, fUj));
        }
        if (com.byazt.omf.x.m().zb()) {
            pluginValueSetC = com.byazt.qv.uj.c(cVar.n(), cVar2, i);
        } else {
            pluginValueSetC = com.byazt.ch.c.c(cVar2.c());
        }
        final com.byazt.ch.c cVar4 = new com.byazt.ch.c(pluginValueSetC != null ? pluginValueSetC.sparseArray() : new SparseArray<>(), com.byazt.vxy.c.tt());
        PluginValueSet pluginValueSetC2 = c(pluginValueSet, cVar3.c());
        boolean z4 = !TextUtils.isEmpty(cVar4.h());
        if (i == 1) {
            if (com.byazt.vq.c.c().c(cVar4.uj(), 1, z4)) {
                com.byazt.xw.c cVar5 = new com.byazt.xw.c(function);
                if (!rh.c) {
                    m.uj("TMe", h.NOT_INIT_TIPS_MSG);
                    cVar5.c(10000, h.NOT_INIT_TIPS_MSG);
                    return;
                } else {
                    if (z) {
                        cVar5.c(10089, h.GET_CONFIG_TIME_OUT_MSG);
                        return;
                    }
                    com.byazt.eu.tt.tt("TMe", "load m banner 广告位 = " + cVar.n() + ",ritId:" + cVar4.uj());
                    com.byazt.qv.tt.c(this.tt, cVar4, cVar5, z2);
                    return;
                }
            }
            com.byazt.eu.tt.tt("TMe", "load csj banner 代码位 = " + cVar.n());
            c(i, pluginValueSetC2);
            return;
        }
        if (i == 3) {
            if (com.byazt.vq.c.c().c(cVar4.uj(), 3, z4)) {
                com.byazt.eu.tt.tt("TMe", "load m splash 广告位 = " + cVar.n() + ",ritId:" + cVar4.uj());
            } else {
                if (!com.byazt.ck.uj.c().ve() || cVar.sp() == null || TextUtils.isEmpty(cVar.sp().c()) || TextUtils.isEmpty(cVar.sp().ve()) || TextUtils.isEmpty(cVar.sp().tt())) {
                    z3 = false;
                } else {
                    com.byazt.eu.tt.tt("TMe", "load m splash 开屏兜底代码位 = " + cVar.sp().tt());
                }
                if (z3) {
                    ttVar = new com.byazt.bc.tt(function);
                    if (!rh.c) {
                        m.uj("TMe", h.NOT_INIT_TIPS_MSG);
                        ttVar.c(new com.byazt.oh.c(10000, h.NOT_INIT_TIPS_MSG));
                        return;
                    } else {
                        final boolean z5 = z2;
                        com.byazt.yf.da.c(new com.byazt.ko.c() { // from class: com.byazt.tjo.sp.2
                            @Override // com.byazt.ko.c
                            public void c() {
                                com.byazt.qv.tt.c(sp.this.tt, cVar4, cVar, ttVar, z5);
                            }
                        });
                        return;
                    }
                }
                com.byazt.eu.tt.tt("TMe", "load csj splash 代码位 = " + cVar.n());
                c(i, pluginValueSetC2);
                return;
            }
            z3 = true;
            if (z3) {
                ttVar = new com.byazt.bc.tt(function);
                if (!rh.c) {
                    m.uj("TMe", h.NOT_INIT_TIPS_MSG);
                    ttVar.c(new com.byazt.oh.c(10000, h.NOT_INIT_TIPS_MSG));
                    return;
                } else {
                    final boolean z6 = z2;
                    com.byazt.yf.da.c(new com.byazt.ko.c() { // from class: com.byazt.tjo.sp.2
                        @Override // com.byazt.ko.c
                        public void c() {
                            com.byazt.qv.tt.c(sp.this.tt, cVar4, cVar, ttVar, z6);
                        }
                    });
                    return;
                }
            }
            com.byazt.eu.tt.tt("TMe", "load csj splash 代码位 = " + cVar.n());
            c(i, pluginValueSetC2);
            return;
        }
        if (i == 5) {
            boolean zBooleanValue = pluginValueSetC2.booleanValue(2);
            if (com.byazt.vq.c.c().c(cVar4.uj(), 5, z4)) {
                com.byazt.eu.tt.tt("TMe", "load m feed 广告位 = " + cVar.n() + ",ritId:" + cVar4.uj() + ", isExpress: " + zBooleanValue);
                if (zBooleanValue) {
                    com.byazt.cv.sl slVar = new com.byazt.cv.sl(function);
                    if (!rh.c) {
                        m.uj("TMe", h.NOT_INIT_TIPS_MSG);
                        slVar.c(10000, h.NOT_INIT_TIPS_MSG);
                        return;
                    } else {
                        if (z) {
                            slVar.c(10089, h.GET_CONFIG_TIME_OUT_MSG);
                            return;
                        }
                        Context context = this.tt;
                        if (context != null) {
                            com.byazt.qv.tt.c(context, cVar4, slVar, z2);
                            return;
                        } else {
                            slVar.c(81005, "context is null");
                            return;
                        }
                    }
                }
                com.byazt.cv.t tVar = new com.byazt.cv.t(function);
                if (!rh.c) {
                    m.uj("TMe", h.NOT_INIT_TIPS_MSG);
                    tVar.c(10000, h.NOT_INIT_TIPS_MSG);
                    return;
                } else {
                    if (z) {
                        tVar.c(10089, h.GET_CONFIG_TIME_OUT_MSG);
                        return;
                    }
                    Context context2 = this.tt;
                    if (context2 != null) {
                        com.byazt.qv.tt.c(context2, cVar4, tVar, z2);
                        return;
                    } else {
                        tVar.c(81005, "context is null");
                        return;
                    }
                }
            }
            com.byazt.eu.tt.tt("TMe", "load csj feed 代码位 = " + cVar.n() + ", isExpress: " + zBooleanValue);
            c(i, pluginValueSetC2);
            return;
        }
        if (i == 7) {
            if (com.byazt.vq.c.c().c(cVar4.uj(), 7, z4)) {
                com.byazt.bz.tt ttVar2 = new com.byazt.bz.tt(function);
                if (!rh.c) {
                    m.uj("TMe", h.NOT_INIT_TIPS_MSG);
                    ttVar2.c(10000, h.NOT_INIT_TIPS_MSG);
                    return;
                } else {
                    if (z) {
                        ttVar2.c(10089, h.GET_CONFIG_TIME_OUT_MSG);
                        return;
                    }
                    com.byazt.eu.tt.tt("TMe", "load m reward video 广告位 = " + cVar.n() + ",ritId:" + cVar4.uj());
                    com.byazt.qv.tt.c(this.tt, cVar4, ttVar2);
                    return;
                }
            }
            c(i, pluginValueSetC2);
            return;
        }
        if (i != 8) {
            if (i != 9) {
                com.byazt.eu.tt.uj(MediationConstant.TAG, "CSJM_loadAD load default mCSJLoader = " + this.c);
                c(i, pluginValueSetC2);
                return;
            }
            if (com.byazt.vq.c.c().c(cVar4.uj(), 9, z4)) {
                com.byazt.eu.tt.tt("TMe", "load m draw 广告位 = " + cVar.n() + ",ritId:" + cVar4.uj());
                com.byazt.yla.ve veVar = new com.byazt.yla.ve(function);
                if (!rh.c) {
                    m.uj("TMe", h.NOT_INIT_TIPS_MSG);
                    veVar.c(10000, h.NOT_INIT_TIPS_MSG);
                    return;
                } else {
                    if (z) {
                        veVar.c(10089, h.GET_CONFIG_TIME_OUT_MSG);
                        return;
                    }
                    Context context3 = this.tt;
                    if (context3 != null) {
                        com.byazt.qv.tt.c(context3, cVar4, veVar);
                        return;
                    } else {
                        veVar.c(81005, "context is null");
                        return;
                    }
                }
            }
            com.byazt.eu.tt.tt("TMe", "load csj draw 代码位 = " + cVar.n());
            c(i, pluginValueSetC2);
            return;
        }
        if (!com.byazt.vq.c.c().c(cVar4.uj(), 8, z4) && !com.byazt.vq.c.c().c(cVar4.uj(), 10, z4)) {
            com.byazt.eu.tt.tt("TMe", "load csj full");
            c(i, pluginValueSetC2);
            return;
        }
        com.byazt.ov.c cVar6 = new com.byazt.ov.c(function);
        if (!rh.c) {
            m.uj("TMe", h.NOT_INIT_TIPS_MSG);
            cVar6.c(10000, h.NOT_INIT_TIPS_MSG);
            return;
        }
        if (z) {
            cVar6.c(10089, h.GET_CONFIG_TIME_OUT_MSG);
            return;
        }
        com.byazt.nbs.tt ttVarC = com.byazt.bp.tt.tt().c(cVar4.uj(), 8, 101);
        if (ttVarC == null) {
            ttVarC = com.byazt.bp.tt.tt().c(cVar4.uj(), 10, 101);
        }
        if (ttVarC != null && ttVarC.pf() == 8) {
            com.byazt.eu.tt.tt("TMe", "load m full 广告位 = " + cVar.n() + ",ritId:" + cVar4.uj());
            com.byazt.qv.tt.c(this.tt, cVar4, cVar6);
            return;
        }
        com.byazt.eu.tt.tt("TMe", "load m interstitial full 广告位 = " + cVar.n() + ",ritId:" + cVar4.uj());
        com.byazt.qv.tt.tt(this.tt, cVar4, cVar6);
    }

    private void c(int i, PluginValueSet pluginValueSet) {
        if (this.c instanceof h) {
            Object objObjectValue = c(pluginValueSet).objectValue(1, Object.class);
            if (objObjectValue == null) {
                m.ve("apply->load with null callback");
            } else {
                ((h) this.c).loadAdByType(i, pluginValueSet, com.byazt.gxc.ve.c(objObjectValue));
            }
        }
    }

    private void c(com.byazt.nx.c cVar, com.byazt.dj.tt.c cVar2) {
        cVar2.uj(cVar.n());
        cVar2.c(cVar.ve());
        cVar2.tt(cVar.uj());
        cVar2.tt(cVar.tt());
        cVar2.c(cVar.c());
    }

    private PluginValueSet c(PluginValueSet pluginValueSet, com.byazt.dj.tt ttVar) {
        com.byazt.rl.c cVarC = com.byazt.rl.c.c(pluginValueSet);
        cVarC.c(260009, ttVar.i());
        cVarC.c(260008, ttVar.x());
        cVarC.c(260007, ttVar.sp());
        cVarC.c(260006, ttVar.a());
        cVarC.c(260004, ttVar.uj());
        return cVarC.tt();
    }
}
