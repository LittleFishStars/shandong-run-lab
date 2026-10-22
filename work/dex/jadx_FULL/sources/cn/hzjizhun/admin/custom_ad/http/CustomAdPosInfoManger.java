package cn.hzjizhun.admin.custom_ad.http;

import android.content.Context;
import android.os.Build;
import cn.hzjizhun.admin.JZAdSdk;
import cn.hzjizhun.admin.api.bean.PosInfoBean;
import cn.hzjizhun.admin.http.HttpManager;
import cn.hzjizhun.admin.util.ALog;
import cn.hzjizhun.admin.util.AppStoreInfoUtils;
import cn.hzjizhun.admin.util.DeviceUtil;
import cn.hzjizhun.admin.util.DisplayUtil;
import cn.hzjizhun.admin.util.LocationUtils;
import cn.hzjizhun.admin.util.NetworkTypeUtils;
import cn.hzjizhun.admin.util.OAIDUtil;
import cn.hzjizhun.admin.util.PackageUtil;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.igexin.push.core.b;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.ze1;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CustomAdPosInfoManger {
    private static String TAG = "";
    public static final int TYPE_BANNER = 3;
    public static final int TYPE_INTERSTITIAL = 4;
    public static final int TYPE_NATIVE = 2;
    public static final int TYPE_SPLASH = 1;
    private static CustomAdPosInfoManger instance;

    private CustomAdPosInfoManger() {
        TAG = getClass().getSimpleName();
    }

    private JSONObject buildDeviceJson(Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("os_type", 1);
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_sdk", Build.VERSION.SDK_INT);
        int iScreenWidth = DisplayUtil.screenWidth(context);
        int iScreenHeight = DisplayUtil.screenHeight(context);
        jSONObject.put("screen_width", iScreenWidth + "");
        jSONObject.put("screen_height", iScreenHeight + "");
        jSONObject.put(ze1.k, Build.MODEL);
        jSONObject.put(ze1.n, Build.BRAND);
        jSONObject.put("ua", DeviceUtil.getDefaultUAString(context));
        jSONObject.put("androidid", DeviceUtil.getAndroidId(context));
        jSONObject.put("screenSize", DisplayUtil.screenSize(context));
        jSONObject.put("update_mark", DeviceUtil.getUpdateMark());
        jSONObject.put("boot_mark", DeviceUtil.getSysBootMark());
        jSONObject.put("boot_time", DeviceUtil.getBootTime());
        jSONObject.put("os_update_time", DeviceUtil.getOsUpdateTime());
        jSONObject.put("density", JZAdSdk.getInstance().getDensity());
        jSONObject.put("ppi", JZAdSdk.getInstance().getDensityDpi());
        jSONObject.put("vendor", Build.MANUFACTURER);
        jSONObject.put("storeVer", AppStoreInfoUtils.getStoreVersion());
        jSONObject.put("storeVerCode", AppStoreInfoUtils.getStoreVersionCode());
        jSONObject.put("hmsCoreVerCode", AppStoreInfoUtils.getHmCoreVersionCode());
        jSONObject.put("hmsCoreVer", AppStoreInfoUtils.getHmCoreVersion());
        jSONObject.put(DeviceIdType.OAID, OAIDUtil.getOaid(context));
        ALog.d(TAG, "device params:" + jSONObject);
        return jSONObject;
    }

    private JSONObject buildRequestJson(Context context, PosInfoBean posInfoBean, int i, Map<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appid", posInfoBean.getThirdAppId());
        jSONObject.put("adid", posInfoBean.getThirdPosId());
        jSONObject.put("ad_type", i);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("name", PackageUtil.getAppName(context));
        jSONObject2.put(b.aC, PackageUtil.getPackageName(context));
        jSONObject2.put("version", PackageUtil.getAppVersion(context));
        JSONObject jSONObjectBuildDeviceJson = buildDeviceJson(context);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("ssid", DeviceUtil.getSsid());
        jSONObject3.put("connect_type", NetworkTypeUtils.getNetworkType());
        jSONObject3.put("operator", DeviceUtil.getOperator());
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("lng", LocationUtils.getInstance().getLongitude());
        jSONObject4.put("lat", LocationUtils.getInstance().getLatitude());
        jSONObject4.put("timestamp", System.currentTimeMillis());
        jSONObject4.put("laccu", 0);
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("adslot", jSONObject);
        jSONObject5.put(NativeCallContext.DOMAIN_APP, jSONObject2);
        jSONObject5.put("device", jSONObjectBuildDeviceJson);
        jSONObject5.put("network", jSONObject3);
        jSONObject5.put(RequestParameters.SUBRESOURCE_LOCATION, jSONObject4);
        jSONObject5.put("reqId", posInfoBean.getReqId());
        if (map != null && !map.isEmpty()) {
            JSONObject jSONObject6 = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject6.put(entry.getKey(), entry.getValue());
            }
            jSONObject5.put("scenes", jSONObject6);
        }
        return jSONObject5;
    }

    private void executeRequest(String str, PosInfoBean posInfoBean, int i, Map<String, String> map, CustomRequestCallback customRequestCallback) {
        new Throwable().printStackTrace();
        ALog.i(TAG, "请求广告 url: ===" + str);
        try {
            String string = buildRequestJson(JZAdSdk.getInstance().getContext(), posInfoBean, i, map).toString();
            ALog.innerD(TAG, "jsonStr:" + string);
            String strSign = sign(string);
            ALog.d(TAG, "--:" + strSign);
            HttpManager.instance().postString(str, strSign, null, customRequestCallback);
        } catch (Throwable th) {
            if (customRequestCallback != null) {
                customRequestCallback.onFail(th);
            }
        }
    }

    public static CustomAdPosInfoManger instance() {
        if (instance == null) {
            synchronized (CustomAdPosInfoManger.class) {
                if (instance == null) {
                    instance = new CustomAdPosInfoManger();
                }
            }
        }
        return instance;
    }

    private String sign(String str) {
        try {
            return AESUtil.encrypt(str, CustomApiConstant.getKey());
        } catch (Throwable th) {
            th.printStackTrace();
            throw new IllegalArgumentException(TAG + " channel sign error, error key", th);
        }
    }

    public void requestAdPosInfo(PosInfoBean posInfoBean, int i, Map<String, String> map, CustomRequestCallback customRequestCallback) {
        executeRequest(CustomApiConstant.getUrl(posInfoBean.getPosPlatform()), posInfoBean, i, map, customRequestCallback);
    }

    public void requestInFunctionAdPosInfo(String str, CustomRequestCallback customRequestCallback) {
        try {
            HttpManager.instance().get(CustomApiConstant.getOutFunctionInsertScreenUrl(str), null, null, customRequestCallback);
        } catch (Throwable unused) {
        }
    }

    public void requestOutFunctionAdPosInfo(PosInfoBean posInfoBean, Map<String, String> map, CustomRequestCallback customRequestCallback) {
        executeRequest(CustomApiConstant.getOutFunctionUrl(posInfoBean.getPosPlatform()), posInfoBean, 3, map, customRequestCallback);
    }
}
