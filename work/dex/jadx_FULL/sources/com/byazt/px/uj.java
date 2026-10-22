package com.byazt.px;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alipay.sdk.m.n.b;
import com.byazt.nr.m;
import com.byazt.ukr.yp;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 690, 15})
public class uj extends com.byazt.fb.uj implements com.byazt.ly.uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.yf.ve f28962a;
    public ve c;
    public Function<SparseArray<Object>, Object> n;
    public Function<SparseArray<Object>, Object> tt;
    public String ve;
    public List<com.byazt.ly.ve> uj = new CopyOnWriteArrayList();
    public long sp = 0;
    public int x = 0;

    public uj() {
        ve veVarC = ve.c(com.byazt.bp.c.t().cu());
        this.c = veVarC;
        this.tt = veVarC.c();
    }

    private void c(String str, String str2) {
        if (str != null) {
            str.equals("gdt");
        }
    }

    public static String getAdaperManagerName(String str) {
        str.hashCode();
        switch (str) {
            case "sigmob":
                return "a.b.c.d.e.f.sob.SobFunction";
            case "xiaomi":
                return "a.b.c.d.e.f.xmi.XmiFunction";
            case "ks":
                return "a.b.c.d.e.f.kou.KouFunction";
            case "gdt":
                return "a.b.c.d.e.f.gng.GngFunction";
            case "baidu":
                return "a.b.c.d.e.f.bdu.BduFunction";
            case "unity":
                return "a.b.c.d.e.f.uty.UtyFunction";
            case "mintegral":
                return "a.b.c.d.e.f.mal.MalFunction";
            default:
                return null;
        }
    }

    public static JSONObject getAdnAdapterVersion() {
        com.byazt.it.ve veVarN = com.byazt.rq.c.n();
        if (veVarN != null) {
            String string = veVarN.getString("gm_adapter_version_list", null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    return new JSONObject(string);
                } catch (JSONException e) {
                    m.c(e);
                }
            }
        }
        return null;
    }

    public static String getClassName(String str) {
        str.hashCode();
        switch (str) {
            case "klevin":
                return MediationConstant.KLEVIN_ADN_CLASS_NAME;
            case "sigmob":
                return MediationConstant.SIGMOB_ADN_CLASS_NAME;
            case "xiaomi":
                return MediationConstant.XIAOMI_ADN_CLASS_NAME;
            case "ks":
                return MediationConstant.KS_ADN_CLASS_NAME;
            case "gdt":
                return MediationConstant.GDT_ADN_CLASS_NAME;
            case "baidu":
                return MediationConstant.BAIDU_ADN_CLASS_NAME;
            case "unity":
                return MediationConstant.UNITY_ADN_CLASS_NAME;
            case "mintegral":
                return MediationConstant.MINTEGRAL_ADN_CLASS_NAME;
            default:
                return null;
        }
    }

    private void n() {
        com.byazt.eu.n.uj(new Runnable() { // from class: com.byazt.px.uj.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.it.ve veVarN;
                JSONObject jSONObjectTt = com.byazt.qe.tt.tt();
                if (jSONObjectTt == null || (veVarN = com.byazt.rq.c.n()) == null) {
                    return;
                }
                veVarN.put("gm_adapter_version_list", jSONObjectTt.toString());
            }
        });
    }

    private void tt() {
        com.byazt.eu.tt.tt("TTMediationSDK_SDK_Init", getAdNetworkName() + "版本号：" + getNetworkSdkVersion() + " , 聚合版本号：" + com.byazt.tjo.tt.ve());
    }

    private void uj() {
        Iterator<com.byazt.ly.ve> it = this.uj.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
        this.uj.clear();
    }

    private void ve() {
        String strVe = com.byazt.tjo.tt.ve();
        if (TextUtils.isEmpty(getAdapterVersion())) {
            com.byazt.eu.tt.uj("TTMediationSDK_SDK_Init", getAdNetworkName() + "版本号：" + getNetworkSdkVersion() + " , ***" + getAdNetworkName() + "Adapter未接入，请检查***, 聚合版本号：" + strVe);
            return;
        }
        com.byazt.eu.tt.tt("TTMediationSDK_SDK_Init", getAdNetworkName() + "版本号：" + getNetworkSdkVersion() + " , " + getAdNetworkName() + "Adapter版本号：" + getAdapterVersion() + " , 聚合版本号：" + strVe);
    }

    @Override // com.byazt.fb.uj
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8122) {
            this.n = (Function) pluginValueSet.objectValue(AVMDLDataLoader.KeyIsLiveContainerString, Function.class);
            uj();
        } else if (i == 8123) {
            SparseArray sparseArray = (SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class);
            if (sparseArray == null) {
                sparseArray = (SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class);
            }
            if (sparseArray == null) {
                sparseArray = (SparseArray) pluginValueSet.objectValue(8022, SparseArray.class);
            }
            if (sparseArray != null) {
                PluginValueSet pluginValueSetTt = com.byazt.rl.c.c((SparseArray<Object>) sparseArray).tt();
                c(new com.byazt.pp.c(pluginValueSetTt.intValue(-999900), pluginValueSetTt.stringValue(-999901)));
                return null;
            }
        } else if (i == 8212) {
            if (this.f28962a != null) {
                this.f28962a.c(pluginValueSet.intValue(8095));
            }
        } else if (i == 8266) {
            this.n = (Function) pluginValueSet.objectValue(AVMDLDataLoader.KeyIsLiveContainerString, Function.class);
            n();
        } else if (i == 8270) {
            this.x = pluginValueSet.intValue(8557);
            this.sp = pluginValueSet.longValue(8556) - pluginValueSet.longValue(8555);
        }
        return null;
    }

    @Override // com.byazt.ly.uj
    public void checkVersion() {
        try {
            if (com.byazt.dc.n.ve(getAdNetworkName()) != null) {
                tt();
            } else {
                ve();
            }
        } catch (Exception e) {
            m.c(e);
        }
    }

    @Override // com.byazt.ly.uj
    public void clearInitStatus() {
        this.x = 0;
        this.sp = 0L;
    }

    public String getAdNetworkName() {
        return this.ve;
    }

    @Override // com.byazt.ly.uj
    public String getAdapterVersion() {
        Function<SparseArray<Object>, Object> function = this.n;
        if (function != null) {
            Object objApply = function.apply(com.byazt.yxi.uj.c().c(AVMDLDataLoader.KeyIsLiveLoaderP2pEnable).c(String.class).tt());
            if (objApply instanceof String) {
                return (String) objApply;
            }
        }
        return "";
    }

    @Override // com.byazt.ly.uj
    public String getBiddingToken(Context context, Map<String, Object> map) {
        if (this.n != null) {
            Object objApply = this.n.apply(com.byazt.yxi.uj.c().c(8102).c(String.class).c(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).c(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).tt());
            if (objApply instanceof String) {
                return (String) objApply;
            }
        }
        return null;
    }

    @Override // com.byazt.ly.uj
    public Map<String, Object> getBiddingTokenMap(Context context, Map<String, Object> map) {
        if (this.n != null) {
            Object objApply = this.n.apply(com.byazt.yxi.uj.c().c(AVMDLDataLoader.KeyIsLiveGetLoaderType).c(String.class).c(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).c(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).tt());
            if (objApply instanceof Map) {
                return (Map) objApply;
            }
        }
        return null;
    }

    public String getGroMoreSdkVersion() {
        Function<SparseArray<Object>, Object> function = this.n;
        if (function != null) {
            Object objApply = function.apply(com.byazt.yxi.uj.c().c(8105).c(String.class).tt());
            if (objApply instanceof String) {
                return (String) objApply;
            }
        }
        return "";
    }

    public Map<String, String> getMsdkRequestOptions() {
        return null;
    }

    @Override // com.byazt.ly.uj
    public String getNetworkSdkPluginVersion() {
        return null;
    }

    @Override // com.byazt.ly.uj
    public String getNetworkSdkVersion() {
        try {
            Function<SparseArray<Object>, Object> function = this.n;
            if (function != null) {
                Object objApply = function.apply(com.byazt.yxi.uj.c().c(8104).c(String.class).tt());
                return objApply instanceof String ? (String) objApply : "";
            }
        } catch (Throwable th) {
            m.c(th);
        }
        return "";
    }

    @Override // com.byazt.ly.tt
    public void initAdn(@NonNull Context context, @NonNull Map<String, Object> map, @NonNull com.byazt.ly.ve veVar) {
        int i;
        long jCurrentTimeMillis;
        if (!this.uj.contains(veVar)) {
            this.uj.add(veVar);
        }
        com.byazt.yxi.uj ujVarC = com.byazt.yxi.uj.c();
        n.c(ujVarC);
        ujVarC.c(3, map.get("app_id"));
        ujVarC.c(8550, Boolean.valueOf(com.byazt.omf.x.m().lr()));
        ujVarC.c(8, com.byazt.bp.c.t().my());
        ujVarC.c(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold, map.get(b.h));
        String str = (String) map.get(MediationConstant.EXTRA_ADN_NAME);
        this.ve = str;
        ujVarC.c(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, getClassName(str));
        ujVarC.c(8560, getAdaperManagerName(this.ve));
        ujVarC.c(8003, map.get(MediationConstant.EXTRA_ADN_NAME));
        ujVarC.c(8410, "5.3.20.1.0");
        ujVarC.c(8411, com.byazt.yl.tt.ve());
        ujVarC.c(8413, "9.4503.0");
        ujVarC.c(8414, "4.680.1550.0");
        ujVarC.c(8417, "4.25.14.0");
        ujVarC.c(8558, "5.3.3.8");
        ujVarC.c(7, Integer.valueOf(c()));
        ujVarC.c(8425, map);
        ujVarC.c(JosStatusCodes.RNT_CODE_NETWORK_ERROR, this);
        c(this.ve, "initAdn name: " + this.ve);
        int i2 = 0;
        try {
            if (com.byazt.xiv.n.c(this.ve) && com.byazt.xiv.n.n() == 2 && com.byazt.dc.n.ve(this.ve) == null) {
                jCurrentTimeMillis = System.currentTimeMillis();
                com.byazt.dc.n.uj(this.ve);
            } else {
                jCurrentTimeMillis = -1;
            }
            Function<SparseArray<Object>, Object> functionVe = com.byazt.dc.n.ve(this.ve);
            c(this.ve, "initAdn: dexBridge: ".concat(String.valueOf(functionVe)));
            if (com.byazt.dc.n.c(this.ve)) {
                com.byazt.xiv.n.c(this.ve, "dex_status", functionVe == null ? 10000 : 20000);
                if (com.byazt.xiv.n.n() == 2 && jCurrentTimeMillis != -1) {
                    yp.c().c(0L, System.currentTimeMillis() - jCurrentTimeMillis, 1, 2);
                }
            }
            i = 1;
            if (functionVe != null) {
                c(this.ve, "initAdn: 走dexpl的ADN初始化");
                ujVarC.c(8563, com.byazt.dc.n.c(this.ve, "adn_init"));
                try {
                    this.n = functionVe;
                    functionVe.apply(com.byazt.yxi.uj.c().c(8240).c(Void.class).c(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).c(8424, ujVarC.tt()).tt());
                    com.byazt.xiv.n.c(this.ve, "dex_status", 30000);
                } catch (Throwable th) {
                    th = th;
                    i2 = 1;
                    m.c(th);
                    i = i2;
                }
            } else {
                c(this.ve, "initAdn: 走Adapter aar的ADN初始化");
                ujVarC.c(8100).c(Boolean.class);
                Boolean bool = (Boolean) this.tt.apply(ujVarC.tt());
                if (bool != null && bool.booleanValue()) {
                    i2 = 1;
                }
                i = i2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        com.byazt.xiv.n.c(this.ve, "adn_init", i);
    }

    @Override // com.byazt.ly.uj
    public long initDuration() {
        return this.sp;
    }

    @Override // com.byazt.ly.uj
    public int initStatus() {
        return this.x;
    }

    public void initializeNetwork(@NonNull Context context, @Nullable Map<String, Object> map, @NonNull com.byazt.ly.n nVar) {
    }

    public boolean isNewInitFunction() {
        return false;
    }

    public void setMsdkRequestOptions(Map<String, String> map) {
    }

    @Override // com.byazt.ly.uj
    public void setPrivacyConfig(com.byazt.yf.yp ypVar, SparseArray<Object> sparseArray) {
        Function<SparseArray<Object>, Object> function = this.n;
        if (function == null || ypVar == null) {
            return;
        }
        function.apply(com.byazt.yxi.uj.c().c(8124).c(Void.class).c(8517, sparseArray).tt());
    }

    @Override // com.byazt.ly.uj
    public void setThemeStatus(Map<String, Object> map) {
        Function<SparseArray<Object>, Object> function = this.n;
        if (function != null) {
            function.apply(com.byazt.yxi.uj.c().c(8242).c(Void.class).c(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).tt());
        }
    }

    @Override // com.byazt.ly.uj
    public int showOpenOrInstallAppDialog(com.byazt.yf.ve veVar) {
        Function<SparseArray<Object>, Object> function = this.n;
        if (function != null) {
            this.f28962a = veVar;
            Object objApply = function.apply(com.byazt.yxi.uj.c().c(8126).c(Integer.class).tt());
            if (objApply != null) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    private int c() {
        com.byazt.xf.ve veVarTt = com.byazt.bp.c.t().tt();
        if (veVarTt != null) {
            return veVarTt.md();
        }
        return 0;
    }

    private void c(com.byazt.pp.c cVar) {
        Iterator<com.byazt.ly.ve> it = this.uj.iterator();
        while (it.hasNext()) {
            it.next().c(cVar);
        }
        this.uj.clear();
    }
}
