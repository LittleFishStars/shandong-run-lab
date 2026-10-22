package com.fl.saas;

import android.text.TextUtils;
import androidx.arch.core.util.Function;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.fl.saas.adx.base.activity.h5.QuickAppHelper;
import com.fl.saas.adx.util.CommConstant;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.LogcatUtil;
import com.fl.saas.adx.util.OaidUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kc.aw.lib.constants.PtgRewardConstant;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.c49;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class E0 {
    private static E0 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f30042a = 0;
    private Map b = new HashMap();
    private int c;

    public class a implements T {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String a(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String b(Object obj) {
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }

        @Override // com.fl.saas.T
        public void b(String str) {
        }

        @Override // com.fl.saas.T
        public void onError(Exception exc) {
            LogcatUtil.d("FLSDK", "上报失败:" + exc.toString());
            E0.this.f30042a = -1;
        }

        @Override // com.fl.saas.T
        public void a(String str) {
            E0.this.f30042a = 2;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObjectA = AbstractC1420l0.a(str);
                if (jSONObjectA != null) {
                    LogcatUtil.d("FLSdk:init_response", "");
                    JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("app_list");
                    if (jSONArrayOptJSONArray != null) {
                        DeviceUtil.appList = jSONArrayOptJSONArray;
                    }
                    QuickAppHelper.getInstance().setCollectWebviewWakeup(jSONObjectA.optInt("collect_webview_wakeup", 0));
                    QuickAppHelper.getInstance().setWebviewWakeupLimit(jSONObjectA.optInt("webview_wakeup_limit", 0));
                    QuickAppHelper.getInstance().setQuickAppBlockRatio(jSONObjectA.optDouble("quick_app_block_ratio", 100.0d));
                    QuickAppHelper.getInstance().setQuickAppInterceptionType(jSONObjectA.optInt("quick_app_interception_type", 1));
                    QuickAppHelper.getInstance().setQuickAppFreqDay(jSONObjectA.optInt("quick_app_freq_day", 0));
                    String strOptString = jSONObjectA.optString("whitelist_headers", "");
                    if (!strOptString.isEmpty()) {
                        QuickAppHelper.getInstance().setWhitelistHeaders(Arrays.asList(strOptString.split(",")));
                    }
                    String strOptString2 = jSONObjectA.optString("device_permisson_info");
                    if (!TextUtils.isEmpty(strOptString2) && !c49.f40900a.equals(strOptString2)) {
                        C1432r0 c1432r0 = new C1432r0();
                        JSONObject jSONObject = new JSONObject(strOptString2);
                        int iOptInt = jSONObject.optInt(DeviceIdType.ANDROID_ID, 1);
                        int iOptInt2 = jSONObject.optInt("mac", 1);
                        int iOptInt3 = jSONObject.optInt("iemi", 1);
                        int iOptInt4 = jSONObject.optInt(DeviceIdType.OAID, 1);
                        int iOptInt5 = jSONObject.optInt("bootId", 1);
                        int iOptInt6 = jSONObject.optInt("sensor", 1);
                        c1432r0.a(iOptInt == 1);
                        c1432r0.d(iOptInt2 == 1);
                        c1432r0.c(iOptInt3 == 1);
                        c1432r0.e(iOptInt4 == 1);
                        c1432r0.b(iOptInt5 == 1);
                        c1432r0.f(iOptInt6 == 1);
                        DeviceUtil.controlBean = c1432r0;
                        if (!DeviceUtil.isCanUseSensor && iOptInt6 == 1) {
                            boolean zCheckAccelerometerSensor = DeviceUtil.checkAccelerometerSensor(DeviceUtil.getContext());
                            DeviceUtil.deviceHasAccelerometerSensor = zCheckAccelerometerSensor;
                            if (zCheckAccelerometerSensor) {
                                T0.b().a();
                            }
                        }
                        if (!OaidUtils.isIsCanUseOAID() && iOptInt4 == 1) {
                            OaidUtils.init();
                        }
                    }
                    int iOptInt7 = jSONObjectA.optInt("keyword_ad_sts", 0);
                    E0.this.c = jSONObjectA.optInt("has_bg_wake_up", 0);
                    if (iOptInt7 == 1) {
                        C1404d0 c1404d0 = new C1404d0();
                        c1404d0.c(jSONObjectA.optString("keyword_url", ""));
                        c1404d0.b(jSONObjectA.optString("keyword_regex", ""));
                        c1404d0.a(jSONObjectA.optInt("device_keyword_freq", 0));
                        c1404d0.b(jSONObjectA.optInt("device_keyword_interval", 0));
                        c1404d0.c(jSONObjectA.optInt("keyword_use_time_range", 0));
                        c1404d0.a(jSONObjectA.optString("kcs", ""));
                        C1406e0.a().a(c1404d0);
                    }
                    C1401c.c().a(AbstractC1402c0.a(jSONObjectA.optJSONArray("quickapp_block_domains"), new Function() { // from class: com.fl.saas.h1
                        @Override // androidx.arch.core.util.Function
                        public final Object apply(Object obj) {
                            return E0.a.a(obj);
                        }
                    }));
                    C1401c.c().b(AbstractC1402c0.a(jSONObjectA.optJSONArray("quickapp_whitelist_domains"), new Function() { // from class: com.fl.saas.i1
                        @Override // androidx.arch.core.util.Function
                        public final Object apply(Object obj) {
                            return E0.a.b(obj);
                        }
                    }));
                    DeviceUtil.filling_timing = jSONObjectA.optInt("filling_timing", 0);
                    QuickAppHelper.getInstance().setEnableQuickApp(jSONObjectA.optInt("enable_quick_app", 1));
                    try {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectA.optJSONArray("quick_app_list");
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                                arrayList.add(jSONArrayOptJSONArray2.optString(i));
                            }
                            QuickAppHelper.getInstance().addListQuickKey(arrayList);
                        }
                        JSONArray jSONArrayOptJSONArray3 = jSONObjectA.optJSONArray("quickapp_match_rule_list");
                        if (jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray3.length() <= 0) {
                            return;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray3.length(); i2++) {
                            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray3.optJSONObject(i2);
                            if (jSONObjectOptJSONObject != null) {
                                B0 b0 = new B0();
                                b0.b(jSONObjectOptJSONObject.optString(RequestParameters.PREFIX));
                                b0.a(jSONObjectOptJSONObject.optString("contains_str"));
                                arrayList2.add(b0);
                            }
                        }
                        QuickAppHelper.getInstance().addListQuickMatch(arrayList2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class b implements T {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f30044a;

        public b(e eVar) {
            this.f30044a = eVar;
        }

        @Override // com.fl.saas.T
        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObjectA = AbstractC1420l0.a(str);
                if (jSONObjectA != null) {
                    int iOptInt = jSONObjectA.optInt("code");
                    JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("places");
                    if (iOptInt != 0 || jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        String strOptString = jSONObjectOptJSONObject.optString("place_id");
                        int iOptInt2 = jSONObjectOptJSONObject.optInt("bg_wake_up_time");
                        int iOptInt3 = jSONObjectOptJSONObject.optInt("position");
                        C1438u0 c1438u0 = new C1438u0();
                        c1438u0.a(strOptString);
                        c1438u0.a(iOptInt2);
                        c1438u0.b(iOptInt3);
                        arrayList.add(c1438u0);
                    }
                    e eVar = this.f30044a;
                    if (eVar != null) {
                        eVar.a(arrayList);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.fl.saas.T
        public void b(String str) {
        }

        @Override // com.fl.saas.T
        public void onError(Exception exc) {
            LogcatUtil.e(exc.getMessage());
        }
    }

    public class c implements T {
        public c() {
        }

        @Override // com.fl.saas.T
        public void a(String str) {
        }

        @Override // com.fl.saas.T
        public void b(String str) {
        }

        @Override // com.fl.saas.T
        public void onError(Exception exc) {
            LogcatUtil.d("FLSDk-doRequest", "上报失败:" + exc.toString());
        }
    }

    public class d implements T {
        public d() {
        }

        @Override // com.fl.saas.T
        public void a(String str) {
            LogcatUtil.d("FLSDK-API", "VideoVerify:" + str);
        }

        @Override // com.fl.saas.T
        public void b(String str) {
        }

        @Override // com.fl.saas.T
        public void onError(Exception exc) {
        }
    }

    public interface e {
        void a(List list);
    }

    private String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            String reqID = DeviceUtil.getReqID("");
            jSONObject.putOpt("id", reqID);
            jSONObject.putOpt("track_id", reqID);
            jSONObject.putOpt("version", CommConstant.SdkVersion.SDK_VERSION_CODE);
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt("app_id", DeviceUtil.appId);
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return AbstractC1417k.e(jSONObject.toString());
    }

    public boolean d() {
        return this.c == 1;
    }

    public synchronized void e() {
        int i = this.f30042a;
        if (i != 1 && i != 2) {
            LogcatUtil.d("FLSdk:", "reportSDKInit");
            this.f30042a = 1;
            OaidUtils.init();
            if (DeviceUtil.isCanUseSensor) {
                boolean zCheckAccelerometerSensor = DeviceUtil.checkAccelerometerSensor(DeviceUtil.getContext());
                DeviceUtil.deviceHasAccelerometerSensor = zCheckAccelerometerSensor;
                if (zCheckAccelerometerSensor) {
                    T0.b().a();
                }
            }
            String strB = b();
            LogcatUtil.d("FLSdk:", "startSDKInit");
            C1401c.c().a(strB, new a());
            C1408f0.a().b();
        }
    }

    public static E0 a() {
        if (d == null) {
            synchronized (E0.class) {
                d = new E0();
            }
        }
        return d;
    }

    private String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", DeviceUtil.getReqID(""));
            jSONObject.putOpt("version", CommConstant.SdkVersion.SDK_VERSION_CODE);
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt("is_applist", Boolean.valueOf(DeviceUtil.isAppList()));
            jSONObject.putOpt("device_id_info", DeviceUtil.customConfig);
            if (DeviceUtil.customMap != null) {
                jSONObject.putOpt("user_defined", new JSONObject(DeviceUtil.customMap));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "https://t.funlinkads.com/log/initialization?e=" + AbstractC1417k.e(jSONObject.toString());
    }

    private String a(C1415j c1415j, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", c1415j.g);
            jSONObject.putOpt("version", CommConstant.SdkVersion.SDK_VERSION_CODE);
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt("place_id", c1415j.i);
            jSONObject.putOpt("group_id", c1415j.h);
            jSONObject.putOpt("adv_id", Integer.valueOf(c1415j.f30175a));
            jSONObject.putOpt("tagid", c1415j.f);
            jSONObject.putOpt("price", Integer.valueOf(c1415j.i()));
            jSONObject.putOpt("time", Long.valueOf(c1415j.A));
            jSONObject.putOpt("test_id", c1415j.j);
            jSONObject.putOpt("track_id", c1415j.r);
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(DeviceUtil.getBootTime() - c1415j.l));
            jSONObject.putOpt("js_dpurl", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "https://t.funlinkads.com/log/js_dpurl?e=" + AbstractC1417k.e(jSONObject.toString()) + "&place_id=" + c1415j.i;
    }

    public synchronized void b(C1415j c1415j, String str) {
        if (c1415j != null) {
            if (!TextUtils.isEmpty(str)) {
                a(a(c1415j, str));
            }
        }
    }

    private JSONObject b(String str, String str2, String str3, String str4, String str5, String str6) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(PtgRewardConstant.REWARD_PARAMS.USER_ID, str);
            jSONObject.putOpt("custom_parameters", str2);
            jSONObject.putOpt("app_id", str3);
            jSONObject.putOpt("place_id", str4);
            jSONObject.putOpt(CommonCode.MapKey.TRANSACTION_ID, str5);
            jSONObject.putOpt("reward_ecpm", str6);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void a(e eVar) {
        C1401c.c().a(CommConstant.API.URL_WAKEUP_PLACES, c(), new b(eVar));
    }

    public void a(C1415j c1415j, String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", c1415j.g);
            jSONObject.putOpt("version", CommConstant.SdkVersion.SDK_VERSION_CODE);
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt("place_id", c1415j.i);
            jSONObject.putOpt("adv_id", Integer.valueOf(c1415j.f30175a));
            jSONObject.putOpt("tagid", c1415j.f);
            jSONObject.putOpt("price", Integer.valueOf(c1415j.i()));
            jSONObject.putOpt("time", Long.valueOf(c1415j.A));
            jSONObject.putOpt("test_id", c1415j.j);
            jSONObject.putOpt("track_id", c1415j.r);
            jSONObject.putOpt("creative_id", c1415j.z);
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(DeviceUtil.getBootTime() - c1415j.l));
            jSONObject.putOpt("is_background_switch", str);
            jSONObject.putOpt("background_stay_time", Long.valueOf(j));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a("https://t.funlinkads.com/log/dpEffect?e=" + AbstractC1417k.e(jSONObject.toString()) + "&place_id=" + c1415j.i);
    }

    public void a(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", DeviceUtil.getReqID(""));
            jSONObject.putOpt("version", CommConstant.SdkVersion.SDK_VERSION_CODE);
            jSONObject.putOpt("secure", Integer.valueOf(DeviceUtil.isHttpSupported()));
            jSONObject.putOpt(NativeCallContext.DOMAIN_APP, DeviceUtil.getAppInfo());
            jSONObject.putOpt("device", DeviceUtil.getDeviceInfo());
            jSONObject.putOpt("keyword_url_result", Integer.valueOf(i));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a("https://t.funlinkads.com/log/ka_rep?e=" + AbstractC1417k.e(jSONObject.toString()));
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        C1401c.c().a(CommConstant.API.NEW_VIDEO_SERVER_VERIFY, AbstractC1417k.e(b(str, str2, str3, str4, str5, str6).toString()), new d());
    }

    private synchronized void a(String str) {
        C1401c.c().a(str, new c());
    }
}
