package com.byazt.whk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.ukr.yp;
import com.byazt.ut.ATSKeep;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.hzchengdun.securityguard.SecExceptionCode;
import com.zj.adlib.xh9;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_UMID_TIME_OUT, 34})
public class a implements ve, com.byazt.aas.c.tt, Function {
    public static final int INIT_FAIL = -1;
    public static final int INIT_SUCCESS = 0;
    public AtomicBoolean c = new AtomicBoolean(false);
    public AtomicBoolean tt = new AtomicBoolean(false);
    public Function<SparseArray<Object>, Object> ve;

    private void ve() {
        if (this.ve == null) {
            this.ve = new x() { // from class: com.byazt.whk.a.3
                @Override // com.byazt.whk.x, com.byazt.fb.uj
                public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
                    JSONObject jSONObject;
                    try {
                        JSONObject jSONObjectC = da.c(pluginValueSet, 10);
                        if (jSONObjectC == null) {
                            com.byazt.yxi.tt ttVar = new com.byazt.yxi.tt((SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class));
                            if (ttVar.uj() != null) {
                                jSONObjectC = da.c(ttVar.uj(), 10);
                            }
                        }
                        if (jSONObjectC == null) {
                            return (T) com.byazt.yxi.uj.c().c(37, new JSONObject()).tt();
                        }
                        switch (i) {
                            case 1:
                                c.c().c(jSONObjectC.optString("module"), jSONObjectC.optString(CachedContentIndex.a.e), jSONObjectC.optString("value"), com.byazt.vxy.c.uj());
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("success", true);
                                return (T) com.byazt.yxi.uj.c().c(37, jSONObject2).tt();
                            case 2:
                                String strOptString = jSONObjectC.optString("module");
                                String strOptString2 = jSONObjectC.optString(CachedContentIndex.a.e);
                                String strC = c.c().c(strOptString, strOptString2, com.byazt.vxy.c.uj());
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(strOptString2, strC);
                                return (T) com.byazt.yxi.uj.c().c(37, jSONObject3).tt();
                            case 3:
                                c.c().c(jSONObjectC.optString("module"), jSONObjectC.optString(CachedContentIndex.a.e), "-1", com.byazt.vxy.c.uj());
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("success", true);
                                return (T) com.byazt.yxi.uj.c().c(37, jSONObject4).tt();
                            case 4:
                                String strOptString3 = jSONObjectC.optString("module", jSONObjectC.optString("table"));
                                String strOptString4 = jSONObjectC.optString(CachedContentIndex.a.e);
                                String strC2 = c.c().c(strOptString3, strOptString4, com.byazt.vxy.c.uj());
                                JSONObject jSONObject5 = new JSONObject();
                                jSONObject5.put(strOptString4, strC2);
                                return (T) com.byazt.yxi.uj.c().c(37, jSONObject5).tt();
                            case 5:
                                String strOptString5 = jSONObjectC.optString("module", jSONObjectC.optString("table"));
                                String strOptString6 = jSONObjectC.optString(CachedContentIndex.a.e);
                                String strOptString7 = jSONObjectC.optString("value");
                                if (TextUtils.isEmpty(strOptString5) || TextUtils.isEmpty(strOptString6)) {
                                    jSONObject = new JSONObject();
                                    jSONObject.put("success", false);
                                } else {
                                    c.c().c(strOptString5, strOptString6, strOptString7, com.byazt.vxy.c.uj());
                                    jSONObject = new JSONObject();
                                    jSONObject.put("success", true);
                                }
                                return (T) com.byazt.yxi.uj.c().c(37, jSONObject).tt();
                            case 6:
                                c.c().c(jSONObjectC.optString("module", jSONObjectC.optString("table")), jSONObjectC.optString(CachedContentIndex.a.e), "-1", com.byazt.vxy.c.uj());
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("success", true);
                                return (T) com.byazt.yxi.uj.c().c(37, jSONObject6).tt();
                            default:
                                return (T) super.applyFunction(i, pluginValueSet, cls);
                        }
                    } catch (JSONException e) {
                        m.c(e);
                        return (T) com.byazt.yxi.uj.c().c(37, new JSONObject()).tt();
                    }
                }
            };
        }
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                init((Context) sparseArray.get(1), (Function) sparseArray.get(2));
                return null;
            case 2:
                return Boolean.valueOf(isPitayaEnvAvailable());
            case 3:
                return Boolean.valueOf(isPitayaInitSuccess());
            case 4:
                runTask((String) sparseArray.get(1), (JSONObject) sparseArray.get(2), (Function) sparseArray.get(3));
                return null;
            case 5:
                onAppLogEvent((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
                return null;
            case 6:
                queryPackage((String) sparseArray.get(1), (Function) sparseArray.get(2));
                return null;
            default:
                return null;
        }
    }

    @Override // com.byazt.whk.ve
    public void init(Context context, final Function<SparseArray<Object>, Object> function) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        Function<SparseArray<Object>, Object> functionC = gt.c(10003);
        if (functionC == null) {
            if (function != null) {
                function.apply(com.byazt.yxi.uj.c().c(-1).c(Void.class).tt());
                return;
            }
            return;
        }
        if (isPitayaInitSuccess()) {
            if (function != null) {
                function.apply(com.byazt.yxi.uj.c().c(0).c(Void.class).tt());
                return;
            }
            return;
        }
        try {
            if (this.c.compareAndSet(false, true)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("aid", "1371");
                jSONObject.put(xh9.WEBSITE_PARAMS_CHANNEL, p.x);
                jSONObject.put("core_api_version", p.n);
                jSONObject.put("core_plugin_version", "7.6.1.1");
                jSONObject.put(AliyunLogCommon.LogLevel.DEBUG, false);
                jSONObject.put("update", true);
                jSONObject.put("download_concurrency", 2);
                jSONObject.put("py_concurrency", 2);
                jSONObject.put("provide_applog", true);
                jSONObject.put("sdk_session_id", com.byazt.ukr.tt.c);
                ve();
                functionC.apply(com.byazt.yxi.uj.c(com.byazt.rl.c.c().c(21, jSONObject).c(22, context).c(38, this.ve).c(1, new x() { // from class: com.byazt.whk.a.2
                    @Override // com.byazt.whk.x
                    public PluginValueSet c(int i, n nVar) {
                        a.this.tt.set(nVar.c());
                        if (nVar.c()) {
                            Function function2 = function;
                            if (function2 != null) {
                                function2.apply(com.byazt.yxi.uj.c().c(0).c(Void.class).tt());
                            }
                            a.this.c();
                        } else {
                            if (nVar.tt() != null) {
                                m.uj("pitaya_ext_plugin", "pit error:" + nVar.tt().toString());
                            }
                            Function function3 = function;
                            if (function3 != null) {
                                function3.apply(com.byazt.yxi.uj.c().c(-1).c(Void.class).tt());
                            }
                        }
                        a.this.c(System.currentTimeMillis() - jCurrentTimeMillis, nVar);
                        return super.c(i, nVar);
                    }
                }).c(13, com.byazt.bwm.n.c()).tt().sparseArray()).c(1001).c(Void.class).tt());
            }
        } catch (Throwable th) {
            m.uj("pitaya_ext_plugin", "pit#initPit:" + th.getMessage());
            if (function != null) {
                function.apply(com.byazt.yxi.uj.c().c(-1).c(Void.class).tt());
            }
        }
    }

    public boolean isColorOS() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    @Override // com.byazt.whk.ve
    public boolean isPitayaEnvAvailable() {
        int i;
        if (!p.c() || (i = Build.VERSION.SDK_INT) < 28) {
            return false;
        }
        if (isColorOS() && i == 29) {
            return false;
        }
        return com.byazt.vgp.tt.tt(gt.tt().l());
    }

    @Override // com.byazt.whk.ve
    public boolean isPitayaInitSuccess() {
        return this.tt.get();
    }

    @Override // com.byazt.aas.c.tt
    public void onAppBackground() {
        Function<SparseArray<Object>, Object> functionTt;
        try {
            if (com.byazt.omf.x.m().d() || (functionTt = tt()) == null) {
                return;
            }
            functionTt.apply(com.byazt.yxi.uj.c().c(1008).c(Void.class).c(36, 1).tt());
        } catch (Throwable th) {
            m.c(th);
        }
    }

    @Override // com.byazt.aas.c.tt
    public void onAppExit() {
    }

    @Override // com.byazt.aas.c.tt
    public void onAppForeground() {
        Function<SparseArray<Object>, Object> functionTt;
        try {
            if (com.byazt.omf.x.m().d() || (functionTt = tt()) == null) {
                return;
            }
            functionTt.apply(com.byazt.yxi.uj.c().c(1008).c(Void.class).c(36, 0).tt());
        } catch (Throwable th) {
            m.c(th);
        }
    }

    @Override // com.byazt.whk.ve
    public void onAppLogEvent(final String str, final JSONObject jSONObject) {
        final Function<SparseArray<Object>, Object> functionTt;
        if (jSONObject != null && c(str) && (functionTt = tt()) != null && isPitayaInitSuccess()) {
            com.byazt.bzd.x.c(new com.byazt.bwm.sp("csj-pita-log") { // from class: com.byazt.whk.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        functionTt.apply(com.byazt.yxi.uj.c().c(1002).c(Void.class).c(23, str).c(24, jSONObject.toString()).tt());
                    } catch (Exception e) {
                        m.c(e);
                    }
                }
            });
        }
    }

    @Override // com.byazt.aas.c.tt
    public void onAppStart() {
    }

    @Override // com.byazt.whk.ve
    public void queryPackage(String str, Function<SparseArray<Object>, Object> function) {
        Function<SparseArray<Object>, Object> functionC = gt.c(10003);
        if (functionC != null) {
            com.byazt.rl.c cVarC = com.byazt.rl.c.c();
            cVarC.c(1, function);
            cVarC.c(25, str);
            functionC.apply(com.byazt.yxi.uj.c(cVarC.tt().sparseArray()).c(1004).c(Void.class).tt());
        }
    }

    @Override // com.byazt.whk.ve
    public void runTask(String str, JSONObject jSONObject, Function<SparseArray<Object>, Object> function) {
        Function<SparseArray<Object>, Object> functionC = gt.c(10003);
        if (functionC == null) {
            if (function != null) {
                function.apply(com.byazt.yxi.uj.c().c(8).c(Void.class).c(-99999979, com.byazt.yxi.n.c().c(-6).c(false).c("predict bridge is null").c(com.byazt.yxi.uj.c().c(5, str).tt()).tt()).tt());
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("run_package_start", System.currentTimeMillis());
        } catch (JSONException e) {
            m.c(e);
        }
        functionC.apply(com.byazt.yxi.uj.c().c(1003).c(Void.class).c(25, str).c(26, jSONObject).c(1, function).c(37, jSONObject2).tt());
    }

    private Function<SparseArray<Object>, Object> tt() {
        Function<SparseArray<Object>, Object> functionC = gt.c(10003);
        if (functionC != null && isPitayaInitSuccess()) {
            return functionC;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j, n nVar) {
        yp.c().c(j, nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.byazt.aas.c cVarVe = com.byazt.omf.x.m().ve();
        if (cVarVe != null) {
            cVarVe.c(this);
        }
    }

    private boolean c(String str) {
        JSONArray jSONArrayMq;
        if (!TextUtils.isEmpty(str) && (jSONArrayMq = gt.tt().mq()) != null && jSONArrayMq.length() != 0) {
            for (int i = 0; i < jSONArrayMq.length(); i++) {
                String strOptString = jSONArrayMq.optString(i);
                if (!TextUtils.isEmpty(strOptString) && strOptString.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
