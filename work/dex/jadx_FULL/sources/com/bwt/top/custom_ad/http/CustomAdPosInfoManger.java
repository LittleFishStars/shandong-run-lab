package com.bwt.top.custom_ad.http;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bwt.top.AdSdk;
import com.bwt.top.api.bean.PosInfoBean;
import com.bwt.top.http.HttpManager;
import com.bwt.top.util.ALog;
import com.bwt.top.util.DeviceUtil;
import com.bwt.top.util.DisplayUtil;
import com.bwt.top.util.OAIDUtil;
import com.bwt.top.util.PackageUtil;
import com.igexin.push.core.b;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.ze1;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CustomAdPosInfoManger {
    private static String TAG = "";
    public static final int TYPE_BANNER = 3;
    public static final int TYPE_INTERSTITIAL = 4;
    public static final int TYPE_NATIVE = 2;
    public static final int TYPE_SPLASH = 1;
    private static CustomAdPosInfoManger instance;

    private CustomAdPosInfoManger() {
        TAG = CustomAdPosInfoManger.class.getSimpleName();
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
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(TAG + " channel sign error, error key", e);
        }
    }

    public void requestAdPosInfo(PosInfoBean posInfoBean, int i, Map<String, String> map, CustomRequestCallback customRequestCallback) {
        String url = CustomApiConstant.getUrl(posInfoBean.getPosPlatform());
        ALog.i(TAG, "请求广告 url: ===" + url);
        try {
            Context context = AdSdk.getInstance().getContext();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", posInfoBean.getThirdAppId());
            jSONObject.put("adid", posInfoBean.getThirdPosId());
            jSONObject.put("ad_type", i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", PackageUtil.getAppName(context));
            jSONObject2.put(b.aC, PackageUtil.getPackageName(context));
            jSONObject2.put("version", PackageUtil.getAppVersion(context));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("os_type", 1);
            jSONObject3.put("os_version", Build.VERSION.RELEASE);
            jSONObject3.put("os_sdk", Build.VERSION.SDK_INT);
            int iScreenWidth = DisplayUtil.screenWidth(context);
            int iScreenHeight = DisplayUtil.screenHeight(context);
            jSONObject3.put("screen_width", iScreenWidth + "");
            jSONObject3.put("screen_height", iScreenHeight + "");
            jSONObject3.put(ze1.k, Build.MODEL);
            jSONObject3.put(ze1.n, Build.BRAND);
            jSONObject3.put("ua", DeviceUtil.getDefaultUAString(context));
            jSONObject3.put("androidid", DeviceUtil.getAndroidId(context));
            jSONObject3.put("screenSize", DisplayUtil.screenSize(context));
            String oaid = AdSdk.getInstance().getOAID();
            if (TextUtils.isEmpty(oaid)) {
                oaid = OAIDUtil.getOaid(context);
            }
            jSONObject3.put(DeviceIdType.OAID, oaid);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("ssid", "");
            jSONObject4.put("connect_type", 0);
            jSONObject4.put("operator", 0);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("lng", "");
            jSONObject5.put("lat", "");
            jSONObject5.put("timestamp", System.currentTimeMillis());
            jSONObject5.put("laccu", 0);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("adslot", jSONObject);
            jSONObject6.put(NativeCallContext.DOMAIN_APP, jSONObject2);
            jSONObject6.put("device", jSONObject3);
            jSONObject6.put("network", jSONObject4);
            jSONObject6.put(RequestParameters.SUBRESOURCE_LOCATION, jSONObject5);
            if (map != null && map.size() > 0) {
                JSONObject jSONObject7 = new JSONObject();
                for (String str : map.keySet()) {
                    jSONObject7.put(str, map.get(str));
                }
                jSONObject6.put("scenes", jSONObject7);
            }
            HttpManager.instance().postString(url, sign(jSONObject6.toString()), null, customRequestCallback);
        } catch (Exception e) {
            e.printStackTrace();
            if (customRequestCallback != null) {
                customRequestCallback.onFail(e);
            }
        }
    }
}
