package com.byazt.whk;

import android.text.TextUtils;
import android.util.SparseArray;
import com.aliyun.svideosdk.common.struct.common.CropKey;
import com.byazt.aas.nb;
import com.byazt.aas.z;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.omf.eo;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.hzchengdun.securityguard.SecExceptionCode;
import com.zj.adlib.c49;
import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_UMID_TIME_OUT, 67})
public class u {
    public static final ConcurrentHashMap<String, JSONObject> c = new ConcurrentHashMap<>();
    public static AtomicInteger tt = new AtomicInteger();
    public JSONObject uj;
    public JSONObject ve;

    private JSONObject tt(com.byazt.jzl.a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            ic icVarC = com.byazt.btt.ve.c(aVar);
            if (icVarC != null) {
                String strC = nb.c(icVarC, "");
                int i = !TextUtils.isEmpty(strC) ? Integer.parseInt(strC) : 0;
                int iSl = nb.sl(icVarC);
                jSONObject.put("video_count", com.byazt.sw.tt.c());
                JSONObject jSONObjectC = c();
                jSONObject.put("device", jSONObjectC);
                JSONObject jSONObjectC2 = c(aVar, i, iSl);
                jSONObject.put("current_video", jSONObjectC2);
                jSONObject.put("predict_use", c(String.valueOf(i)));
                jSONObject.put("csj_plugin", tt());
                jSONObject.put("package", tt("video_cache"));
                jSONObject.put("hour", jSONObjectC.optInt("hour"));
                jSONObject.put("video_size", aVar.getVideoSize());
                jSONObject.put("rit", i);
                jSONObject.put("preload_size", aVar.getPreloadSize());
                jSONObject.put("access", jSONObjectC.optString("access"));
                jSONObject.put("sdk_fg_time", jSONObjectC.optLong("sdk_fg_time"));
                jSONObject.put("ad_slot_type", jSONObjectC2.optInt("ad_slot_type"));
            }
        } catch (Throwable th) {
            m.c(th);
        }
        return jSONObject;
    }

    private static String c(int i, String str) {
        int iIncrementAndGet = tt.incrementAndGet();
        return i + c49.f40900a + z.c() + c49.f40900a + iIncrementAndGet + c49.f40900a + str + c49.f40900a + System.currentTimeMillis();
    }

    private static JSONObject c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.get(str);
    }

    public static void c(int i, long j, ic icVar, com.byazt.jzl.a aVar) {
        com.byazt.dj.tt ttVarIj;
        if (icVar == null || aVar == null || (ttVarIj = icVar.ij()) == null) {
            return;
        }
        try {
            JSONObject jSONObjectC = c(ttVarIj.uj());
            if (jSONObjectC != null) {
                String fileNameKey = aVar.getFileNameKey();
                String strOptString = jSONObjectC.optString("trace_id");
                if (!TextUtils.isEmpty(strOptString) && strOptString.contains(fileNameKey)) {
                    jSONObjectC.put("play_type", i);
                    jSONObjectC.put("cache_size", j);
                }
            }
        } catch (Exception e) {
            m.c(e);
        }
    }

    public static void c(long j, ic icVar, com.byazt.jzl.a aVar) {
        com.byazt.dj.tt ttVarIj;
        if (icVar == null || aVar == null || (ttVarIj = icVar.ij()) == null) {
            return;
        }
        try {
            JSONObject jSONObjectC = c(ttVarIj.uj());
            if (jSONObjectC != null) {
                String strOptString = jSONObjectC.optString("trace_id");
                if (!TextUtils.isEmpty(strOptString) && strOptString.contains(aVar.getFileNameKey())) {
                    jSONObjectC.put("play_duration", j);
                    jSONObjectC.put("pitaya_meet_cache", 1);
                }
            }
        } catch (Exception e) {
            m.c(e);
        }
    }

    private JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("access", rh.sp(gt.getContext()));
            jSONObject.put("hour", Calendar.getInstance().get(11));
            long jCurrentTimeMillis = System.currentTimeMillis() - com.byazt.aas.c.tt;
            if (jCurrentTimeMillis > 0) {
                jSONObject.put("sdk_fg_time", jCurrentTimeMillis);
            }
        } catch (Exception e) {
            m.c(e);
        }
        return jSONObject;
    }

    private JSONObject tt(final String str) {
        ve veVar = (ve) com.byazt.ut.uj.getService("pitaya");
        if (veVar != null) {
            veVar.queryPackage(str, new x() { // from class: com.byazt.whk.u.1
                @Override // com.byazt.whk.x
                public PluginValueSet ve(int i, SparseArray<Object> sparseArray) {
                    if (sparseArray == null) {
                        return null;
                    }
                    com.byazt.yxi.tt ttVar = new com.byazt.yxi.tt(sparseArray);
                    PluginValueSet pluginValueSetUj = ttVar.uj();
                    boolean zC = ttVar.c();
                    if (pluginValueSetUj != null) {
                        if (TextUtils.equals(str, pluginValueSetUj.stringValue(5))) {
                            if (zC) {
                                u.this.ve = da.c(pluginValueSetUj, 3);
                                JSONObject unused = u.this.ve;
                            } else {
                                u.this.uj = da.c(pluginValueSetUj, 4);
                            }
                        }
                    }
                    return super.ve(i, sparseArray);
                }
            });
        } else {
            this.ve = new JSONObject();
        }
        return this.ve;
    }

    private JSONObject tt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("core_api_code", p.uj);
            jSONObject.put("core_plugin_code", 7611);
            jSONObject.put("ext_api_code", p.f28884a);
            jSONObject.put("ext_plugin_code", eo.tt());
        } catch (Exception e) {
            m.c(e);
        }
        return jSONObject;
    }

    private JSONObject c(com.byazt.jzl.a aVar, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("video_size", aVar.getVideoSize());
            jSONObject.put("preload_size", aVar.getPreloadSize());
            jSONObject.put(CropKey.VIDEO_DURATION, aVar.getCurrentVideoInfo().getVideo_duration());
            jSONObject.put("ad_slot_type", i2);
            jSONObject.put("rit", i);
            jSONObject.put("video_url", aVar.getUrl());
            jSONObject.put("preload_all", aVar.isPreloadAll());
            jSONObject.put("trace_id", c(i, aVar.getFileNameKey()));
        } catch (Exception e) {
            m.c(e);
        }
        return jSONObject;
    }

    public static void c(com.byazt.jzl.a aVar, JSONObject jSONObject, int i, int i2) {
        int iOptInt;
        if (aVar == null || jSONObject == null || (iOptInt = jSONObject.optInt("rit", 0)) <= 0) {
            return;
        }
        c.put(String.valueOf(iOptInt), jSONObject);
    }

    public JSONObject c(com.byazt.jzl.a aVar) {
        return tt(aVar);
    }
}
