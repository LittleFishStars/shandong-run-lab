package cn.hzjizhun.admin.api;

import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import cn.hzjizhun.admin.JZAdSdk;
import cn.hzjizhun.admin.ad.bean.AdPlatforms;
import cn.hzjizhun.admin.addsdaskk;
import cn.hzjizhun.admin.api.bean.InitConfigBean;
import cn.hzjizhun.admin.api.bean.PriceNoticeBean;
import cn.hzjizhun.admin.api.bean.ResponseBaseBean;
import cn.hzjizhun.admin.base.ad.ErrorCallback;
import cn.hzjizhun.admin.base.ad.RcSdk;
import cn.hzjizhun.admin.custom_ad.http.AESUtil;
import cn.hzjizhun.admin.dsda;
import cn.hzjizhun.admin.exception.JZAdError;
import cn.hzjizhun.admin.h5.AdSdkH5Activity;
import cn.hzjizhun.admin.http.HttpManager;
import cn.hzjizhun.admin.http.RequestCallback;
import cn.hzjizhun.admin.kadas;
import cn.hzjizhun.admin.util.ALog;
import cn.hzjizhun.admin.util.BaseUtil;
import cn.hzjizhun.admin.util.DeviceUtil;
import cn.hzjizhun.admin.util.DisplayUtil;
import cn.hzjizhun.admin.util.FileInfoUtils;
import cn.hzjizhun.admin.util.LocationUtils;
import cn.hzjizhun.admin.util.OAIDUtil;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.zj.adlib.eva;
import com.zj.adlib.u15;
import com.zj.adlib.ugb;
import com.zj.adlib.vgb;
import com.zj.adlib.vwa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ApiManager {
    private static String TAG = "ApiManager";
    private static final String default_file_key = "8S0WGZJgo_h7BpWJ";
    private static int mDialogTouchKeen;
    private static HashMap<String, JZAdSdk.JZInitCallback> mCallbackMap = new HashMap<>();
    private static volatile int mInitResult = 0;

    public class a implements RequestCallback {
        @Override // cn.hzjizhun.admin.http.RequestCallback
        public void onFail(Throwable th) {
        }

        @Override // cn.hzjizhun.admin.http.RequestCallback
        public void onSuccess(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                ResponseBaseBean bean = ResponseBaseBean.toBean(str);
                bean.getResult();
                if (bean.isOk()) {
                    bean.objectToBean().getClass();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public class b implements RequestCallback {
        @Override // cn.hzjizhun.admin.http.RequestCallback
        public void onFail(Throwable th) {
            if (th != null) {
                ALog.d(ApiManager.TAG, "竞价反馈失败 " + th.getMessage());
            }
        }

        @Override // cn.hzjizhun.admin.http.RequestCallback
        public void onSuccess(String str) {
            ALog.d(ApiManager.TAG, "竞价反馈结果 " + str);
        }
    }

    public class c implements RequestCallback {
        @Override // cn.hzjizhun.admin.http.RequestCallback
        public void onFail(Throwable th) {
        }

        @Override // cn.hzjizhun.admin.http.RequestCallback
        public void onSuccess(String str) {
            try {
                int iIntValue = Integer.valueOf(str).intValue();
                if (iIntValue > 0) {
                    ApiManager.setDialogTouchKeen(iIntValue);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public class d implements RequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22687a;

        public d(String str) {
            this.f22687a = str;
        }

        @Override // cn.hzjizhun.admin.http.RequestCallback
        public void onFail(Throwable th) {
        }

        @Override // cn.hzjizhun.admin.http.RequestCallback
        public void onSuccess(String str) {
            try {
                JSONArray jSONArray = new JSONArray(AESUtil.decrypt(str, ApiManager.default_file_key));
                HashMap map = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            String strOptString = jSONObjectOptJSONObject.optString("type");
                            ugb ugbVar = new ugb(strOptString, jSONObjectOptJSONObject.optString("uri"), jSONObjectOptJSONObject.optString("id"));
                            List arrayList = (List) map.get(strOptString);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                map.put(strOptString, arrayList);
                            }
                            arrayList.add(ugbVar);
                        }
                    }
                }
                FileInfoUtils.readShellText(this.f22687a, map);
            } catch (Throwable unused) {
            }
        }
    }

    public class e implements RequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22688a;

        public e(String str) {
            this.f22688a = str;
        }

        @Override // cn.hzjizhun.admin.http.RequestCallback
        public void onFail(Throwable th) {
        }

        @Override // cn.hzjizhun.admin.http.RequestCallback
        public void onSuccess(String str) {
            boolean z;
            try {
                JSONArray jSONArray = new JSONArray(AESUtil.decrypt(str, ApiManager.default_file_key));
                if (jSONArray.length() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String strOptString = jSONArray.optString(i);
                        if (!TextUtils.isEmpty(strOptString)) {
                            try {
                                z = JZAdSdk.getInstance().getContext().getPackageManager().getPackageInfo(strOptString, 0) != null;
                            } catch (Throwable unused) {
                            }
                            jSONObject.put(strOptString, z);
                        }
                    }
                    ApiManager.reportGInfo(this.f22688a, jSONObject);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class f implements ErrorCallback {
        @Override // cn.hzjizhun.admin.base.ad.ErrorCallback
        public void errorReport(String str) {
            ApiManager.reportErrorAndMsg("30001", str, "");
        }
    }

    public class g implements RequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JZAdSdk.akdsd f22689a;

        public g(JZAdSdk.akdsd akdsdVar) {
            this.f22689a = akdsdVar;
        }

        @Override // cn.hzjizhun.admin.http.RequestCallback
        public void onFail(Throwable th) {
            this.f22689a.a("");
        }

        @Override // cn.hzjizhun.admin.http.RequestCallback
        public void onSuccess(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f22689a.a("");
                return;
            }
            try {
                ResponseBaseBean bean = ResponseBaseBean.toBean(str);
                if (!bean.isOk()) {
                    this.f22689a.a("");
                    return;
                }
                ALog.d(ApiManager.TAG, "onSuccess: " + bean.getResult());
                this.f22689a.a(bean.objectToString());
            } catch (Throwable th) {
                if (ALog.isLog) {
                    th.printStackTrace();
                }
                this.f22689a.a("");
            }
        }
    }

    public class h extends kadas {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JZAdSdk.JZInitCallback f22690a;

        public h(JZAdSdk.JZInitCallback jZInitCallback) {
            this.f22690a = jZInitCallback;
        }

        @Override // cn.hzjizhun.admin.kadas
        public void a(InitConfigBean initConfigBean, String str) {
            JZAdSdk.JZInitCallback jZInitCallback;
            try {
                FunctionConfig.instance().saveInitConfig(str);
                if (!FunctionConfig.instance().hasInitData()) {
                    int unused = ApiManager.mInitResult = 1;
                    FunctionConfig.instance().getLocalInitConfig();
                    ApiManager.runInit(this.f22690a);
                }
                if (initConfigBean.getPosInfoList() == null || initConfigBean.getPosInfoList().isEmpty()) {
                    ApiManager.reportError("10001", "");
                }
            } catch (Throwable unused2) {
                if (FunctionConfig.instance().hasInitData() || (jZInitCallback = this.f22690a) == null) {
                    return;
                }
                jZInitCallback.onInitResult(false);
            }
        }

        @Override // cn.hzjizhun.admin.kadas
        public void b(JZAdError jZAdError) {
            JZAdSdk.JZInitCallback jZInitCallback;
            try {
                if (FunctionConfig.instance().hasInitData()) {
                    return;
                }
                ApiManager.initBase(JZAdSdk.getInstance().getContext());
                jZAdError.log();
                int unused = ApiManager.mInitResult = 2;
                JZAdSdk.JZInitCallback jZInitCallback2 = this.f22690a;
                if (jZInitCallback2 != null) {
                    jZInitCallback2.onInitResult(false);
                }
                if (JZAdSdk.getInstance().isNoAd()) {
                    ALog.d(ApiManager.TAG, "广告已经停用");
                } else {
                    ALog.d(ApiManager.TAG, " requestInitConfigData onFailed");
                }
                ApiManager.reportError("10001", "");
            } catch (Throwable unused2) {
                if (FunctionConfig.instance().hasInitData() || (jZInitCallback = this.f22690a) == null) {
                    return;
                }
                jZInitCallback.onInitResult(false);
            }
        }
    }

    public static boolean checkAdSdkInitStatus() {
        return FunctionConfig.instance().hasInitData();
    }

    public static void clickCoordinatesReport(String str, String str2, String str3, String str4) {
        try {
            String appId = JZAdSdk.getInstance().getAppId();
            if (!TextUtils.isEmpty(appId) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                HttpManager.instance().get(dsda.c() + "/coordinate/android/" + appId + WVNativeCallbackUtil.SEPERATER + str + WVNativeCallbackUtil.SEPERATER + (DisplayUtil.screenWidth(JZAdSdk.getInstance().getContext()) + "," + DisplayUtil.screenHeight(JZAdSdk.getInstance().getContext())) + WVNativeCallbackUtil.SEPERATER + str2 + WVNativeCallbackUtil.SEPERATER + str3 + WVNativeCallbackUtil.SEPERATER + str4, null, null, null);
            }
        } catch (Throwable unused) {
        }
    }

    public static int dialogTouchKeenValue() {
        return mDialogTouchKeen;
    }

    public static void getFInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("appid", str);
        map.put("os", "android");
        map.put("mcid", DeviceUtil.getMcid(JZAdSdk.getInstance().getContext()));
        map.put("version", "2.5.0");
        HttpManager.instance().get(dsda.c() + "/gInfo/" + str, null, map, new e(str));
    }

    public static Collection<JZAdSdk.JZInitCallback> getInnerCallback() {
        try {
            return mCallbackMap.values();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void initBase(Context context) {
        try {
            String oaid = OAIDUtil.getOaid(context);
            ALog.innerD("base.....", oaid);
            RcSdk.setAndroidId(DeviceUtil.getAndroidId(context));
            RcSdk.setImei("");
            RcSdk.setImsi("");
            RcSdk.setOaid(oaid);
            initBaseTouchParams();
            RcSdk.setUrl(FunctionConfig.instance().getChannelUrl(AdPlatforms.inner.name()));
            if (!LocationUtils.getInstance().isLoadLocation()) {
                RcSdk.setLocation(LocationUtils.getInstance().getLongitude(), LocationUtils.getInstance().getLatitude());
            }
            RcSdk.init(context);
            RcSdk.setErrorCallback(new f());
            BaseUtil.crashReportInit(context);
        } catch (Throwable unused) {
        }
    }

    private static void initBaseTouchParams() {
        try {
            float fD = eva.e().d(AdSdkH5Activity.TOUCH_MINOR);
            float fD2 = eva.e().d(AdSdkH5Activity.TOUCH_MAJOR);
            if (fD2 != 0.0f) {
                RcSdk.setTouchMajor(fD2);
            }
            if (fD != 0.0f) {
                RcSdk.setTouchMinor(fD);
            }
        } catch (Throwable unused) {
        }
    }

    private static void initMob() {
        addsdaskk.a();
    }

    public static boolean isUninitialized() {
        return mInitResult == 0 && JZAdSdk.getInstance().isCallInit();
    }

    public static void noticeBinPrice(PriceNoticeBean priceNoticeBean) {
        if (priceNoticeBean == null) {
            return;
        }
        HttpManager.instance().get(String.format("%s/%s/%s/%s", dsda.f(), priceNoticeBean.getPosid(), priceNoticeBean.getWinOrLoss(), priceNoticeBean.getPrice()), null, null, new b());
    }

    public static void putInnerCallback(String str, JZAdSdk.JZInitCallback jZInitCallback) {
        try {
            if (TextUtils.isEmpty(str) || jZInitCallback == null) {
                return;
            }
            mCallbackMap.put(str, jZInitCallback);
        } catch (Throwable unused) {
        }
    }

    public static void removeInnerCallback(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            mCallbackMap.remove(str);
        } catch (Throwable unused) {
        }
    }

    public static void reportAdClick(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = dsda.c() + "/mark/" + DeviceUtil.getMcid(JZAdSdk.getInstance().getContext()) + WVNativeCallbackUtil.SEPERATER + str;
        HashMap<String, String> map = new HashMap<>();
        map.put("os", "android");
        map.put("version", "2.5.0");
        HttpManager.instance().get(str2, null, map, new a());
    }

    public static void reportError(String str, String str2) {
        try {
            reportErrorAndMsg(str, (String) dsda.d().get(str), str2);
        } catch (Throwable unused) {
        }
    }

    public static void reportErrorAndMsg(String str, String str2, String str3) {
        try {
            String appId = JZAdSdk.getInstance().getAppId();
            if (TextUtils.isEmpty(appId)) {
                appId = "0";
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            HashMap<String, String> map = new HashMap<>();
            map.put("os", "android");
            map.put("mcid", DeviceUtil.getMcid(JZAdSdk.getInstance().getContext()));
            map.put("version", "2.5.0");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", str);
            jSONObject.put("message", str2);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("posid", str3);
            }
            HashMap<String, String> map2 = new HashMap<>();
            map2.put("json", jSONObject.toString());
            HttpManager.instance().post(dsda.c() + "/errorReport/" + appId, map2, map, null);
            if (str != "10004") {
                ALog.e("", str + u15.f19942b + str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void reportFileTime(String str, List<vwa> list) {
        if (list != null) {
            try {
                if (list.isEmpty()) {
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < list.size(); i++) {
                    vwa vwaVar = list.get(i);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", vwaVar.b());
                    jSONObject.put("time", vwaVar.a());
                    jSONArray.put(jSONObject);
                }
                String strEncrypt = AESUtil.encrypt(jSONArray.toString(), default_file_key);
                HttpManager.instance().postString(dsda.c() + "/setInfo/" + str, strEncrypt, null, null);
            } catch (Throwable unused) {
            }
        }
    }

    public static void reportGInfo(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            String strEncrypt = AESUtil.encrypt(jSONObject.toString(), default_file_key);
            HttpManager.instance().postString(dsda.c() + "/setGInfo/" + str, strEncrypt, null, null);
        } catch (Throwable unused) {
        }
    }

    public static void requestBaseDomain(String str, JZAdSdk.akdsd akdsdVar) {
        if (TextUtils.isEmpty(str)) {
            ALog.e(TAG, "appId 不能为空");
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("os", "android");
        map.put("version", "2.5.0");
        HttpManager.instance().get("https://ad.shunchangzhixing.com/base/" + str, null, map, new g(akdsdVar));
    }

    public static void requestFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("appid", str);
        map.put("os", "android");
        map.put("mcid", DeviceUtil.getMcid(JZAdSdk.getInstance().getContext()));
        map.put("version", "2.5.0");
        HttpManager.instance().get(dsda.c() + "/fInfo/" + str, null, map, new d(str));
    }

    public static void requestInitConfigData(JZAdSdk.JZInitCallback jZInitCallback) {
        ALog.d(TAG, "requestInitConfigData:" + dsda.b());
        if (TextUtils.isEmpty(dsda.b())) {
            ALog.e(TAG, "需要调用 JZAdSdk.getInstance().setBaseHttp()");
            jZInitCallback.onInitResult(false);
            return;
        }
        mInitResult = 0;
        HashMap<String, String> map = new HashMap<>();
        map.put("os", "android");
        map.put("version", "2.5.0");
        if (JZAdSdk.getInstance().isNoAd()) {
            map.put("adRequest", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        }
        HttpManager.instance().get(dsda.b(), null, map, new h(jZInitCallback));
    }

    public static void requestNativeKeen(String str) {
        mDialogTouchKeen = 0;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("os", "android");
        map.put("mcid", DeviceUtil.getMcid(JZAdSdk.getInstance().getContext()));
        map.put("version", "2.5.0");
        HttpManager.instance().get(dsda.a() + WVNativeCallbackUtil.SEPERATER + str, null, map, new c());
    }

    public static void runInit(JZAdSdk.JZInitCallback jZInitCallback) {
        try {
            initBase(JZAdSdk.getInstance().getContext());
            vgb.a().c();
            if (jZInitCallback != null) {
                jZInitCallback.onInitResult(true);
            }
            initMob();
        } catch (Throwable unused) {
            if (jZInitCallback != null) {
                jZInitCallback.onInitResult(false);
            }
        }
    }

    public static void setDialogTouchKeen(int i) {
        mDialogTouchKeen = i;
    }
}
