package com.byazt.ck;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.text.TextUtils;
import com.byazt.eu.n;
import com.byazt.nr.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zj.adlib.bv9;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 603, 54})
public class ve {
    public static volatile ve c;
    public Map<String, com.byazt.nbs.c> ve = new ConcurrentHashMap();
    public com.byazt.it.ve tt = com.byazt.rq.c.uj();

    private ve() {
    }

    private void a() {
        String string = this.tt.getString("adn_init_config", null);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (!string.startsWith("[") && !string.startsWith(bv9.b)) {
            string = com.byazt.vx.c.tt(string, com.byazt.vx.tt.c());
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            tt(new JSONObject(string));
        } catch (Throwable th) {
            m.c(th);
        }
    }

    private Set<String> sp() {
        HashSet hashSet = new HashSet();
        if (this.ve.size() != 0) {
            for (Map.Entry<String, com.byazt.nbs.c> entry : this.ve.entrySet()) {
                com.byazt.nbs.c value = entry.getValue();
                if (value != null && !value.n()) {
                    hashSet.add(entry.getKey());
                }
            }
        }
        return hashSet;
    }

    private void tt(JSONObject jSONObject) {
        this.ve.clear();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
            com.byazt.nbs.c cVarC = com.byazt.nbs.c.c(next, jSONObjectOptJSONObject);
            if (jSONObjectOptJSONObject != null && cVarC != null) {
                this.ve.put(next, cVarC);
            }
        }
    }

    private void ve(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        n.uj(new Runnable() { // from class: com.byazt.ck.ve.2
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.ii.tt.c().c(jSONObject);
            }
        });
    }

    public synchronized void n() {
        Context context = com.byazt.bp.tt.getContext();
        if (context == null) {
            return;
        }
        Set<String> setSp = sp();
        if (setSp.size() == 0) {
            return;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        com.byazt.eu.tt.tt("TTMediationSDK_SDK_Init", "------------------ 聚合 接入信息 start ---------------------");
        com.byazt.eu.tt.c("TTMediationSDK_SDK_Init", "当前接入的聚合 SDK版本是：" + com.byazt.yl.tt.tt());
        List<String> listC = c(context);
        if (listC != null) {
            for (String str : setSp) {
                if (!MediationConstant.ADN_UNITY.equals(str) && !MediationConstant.ADN_MINTEGRAL.equals(str) && !"xiaomi".equals(str)) {
                    if (listC.contains(str)) {
                        com.byazt.eu.tt.tt("TTMediationSDK_SDK_Init", "已按要求接入三方广告sdk【" + str + "】");
                    } else {
                        com.byazt.eu.tt.uj("TTMediationSDK_SDK_Init", "未按要求接入三方广告sdk【" + str + "】，请检查接入配置");
                    }
                }
            }
        }
        com.byazt.eu.tt.tt("TTMediationSDK_SDK_Init", "------------------ GroMore 接入信息 end ---------------------");
        com.byazt.eu.tt.tt("TTMediationSDK_SDK_Init", "------------------ GroMore 版本信息 start ---------------------");
        for (String str2 : setSp) {
            if (!TextUtils.equals(str2, MediationConstant.ADN_PANGLE) && !TextUtils.equals(str2, MediationConstant.ADN_UNITY) && !TextUtils.equals(str2, MediationConstant.ADN_MINTEGRAL)) {
                com.byazt.ly.uj ujVarC = com.byazt.px.tt.c().c(str2);
                if (ujVarC != null) {
                    ujVarC.checkVersion();
                } else {
                    com.byazt.eu.tt.uj("TTMediationSDK_InitChecker", "没有引入" + str2 + "Adapter,请检查相关引入情况");
                }
            }
        }
        com.byazt.eu.tt.tt("TTMediationSDK_SDK_Init", "------------------ GroMore 版本信息 end ---------------------");
    }

    public boolean uj() {
        if (this.ve.size() == 0) {
            a();
        }
        return this.ve.isEmpty();
    }

    public static ve c() {
        if (c == null) {
            synchronized (ve.class) {
                if (c == null) {
                    c = new ve();
                }
            }
        }
        return c;
    }

    public Map<String, com.byazt.nbs.c> ve() {
        if (this.ve.size() == 0) {
            a();
        }
        return new ConcurrentHashMap(this.ve);
    }

    public void c(final JSONObject jSONObject) {
        if (jSONObject != null) {
            tt(jSONObject);
            if (com.byazt.bp.tt.tt().ve()) {
                n.uj(new Runnable() { // from class: com.byazt.ck.ve.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String string = jSONObject.toString();
                        if (TextUtils.isEmpty(string)) {
                            return;
                        }
                        ve.this.tt.put("adn_init_config", string);
                    }
                });
            } else {
                String string = jSONObject.toString();
                if (!TextUtils.isEmpty(string)) {
                    this.tt.put("adn_init_config", string);
                }
            }
        }
        ve(jSONObject);
    }

    public List<com.byazt.nbs.c> tt() {
        if (this.ve.size() == 0) {
            a();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, com.byazt.nbs.c>> it = this.ve.entrySet().iterator();
        while (it.hasNext()) {
            com.byazt.nbs.c value = it.next().getValue();
            if (value != null && value.n()) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    public com.byazt.nbs.c c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.ve.size() == 0) {
            a();
        }
        return this.ve.get(str);
    }

    public boolean tt(String str) {
        com.byazt.nbs.c cVar;
        if (this.ve.size() == 0) {
            a();
        }
        Map<String, com.byazt.nbs.c> map = this.ve;
        return (map == null || (cVar = map.get(str)) == null || !cVar.n()) ? false : true;
    }

    private List<String> c(Context context) {
        List<ProviderInfo> listQueryContentProviders = context.getPackageManager().queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072);
        if (listQueryContentProviders == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        context.getPackageName();
        Iterator<ProviderInfo> it = listQueryContentProviders.iterator();
        while (it.hasNext()) {
            String str = it.next().name;
            str.hashCode();
            switch (str) {
                case "com.baidu.mobads.sdk.api.BdFileProvider":
                    arrayList.add("baidu");
                    break;
                case "com.mbridge.msdk.foundation.tools.MBFileProvider":
                    arrayList.add(MediationConstant.ADN_MINTEGRAL);
                    break;
                case "com.sigmob.sdk.SigmobFileProvider":
                case "com.sigmob.sdk.SigmobFileV4Provider":
                    arrayList.add("sigmob");
                    break;
                case "com.tencent.klevin.utils.FileProvider":
                    arrayList.add(MediationConstant.ADN_KLEVIN);
                    break;
                case "com.bykv.vk.openvk.TTFileProvider":
                case "com.bytedance.sdk.openadsdk.TTFileProvider":
                    arrayList.add(MediationConstant.ADN_PANGLE);
                    break;
                case "com.kwad.sdk.api.proxy.app.AdSdkFileProvider":
                    arrayList.add(MediationConstant.ADN_KS);
                    break;
                case "com.unity":
                    arrayList.add(MediationConstant.ADN_UNITY);
                    break;
                case "com.qq.e.comm.GDTFileProvider":
                    arrayList.add("gdt");
                    break;
            }
        }
        return arrayList;
    }
}
