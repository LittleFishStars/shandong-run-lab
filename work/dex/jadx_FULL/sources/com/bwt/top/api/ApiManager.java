package com.bwt.top.api;

import android.content.Context;
import android.text.TextUtils;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.bwt.top.AdPlatforms;
import com.bwt.top.AdSdk;
import com.bwt.top.api.bean.ChannelUrlBean;
import com.bwt.top.api.bean.InitConfigBean;
import com.bwt.top.api.bean.PriceNoticeBean;
import com.bwt.top.exception.AdError;
import com.bwt.top.http.HttpManager;
import com.bwt.top.http.RequestCallback;
import com.bwt.top.util.ALog;
import com.bwt.top.util.DeviceUtil;
import com.bwt.top.util.OAIDUtil;
import com.rc.base.NativeHelper;
import com.rc.base.RcSdk;
import com.zj.adlib.kva;
import com.zj.adlib.zgb;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ApiManager {
    private static String TAG = "ApiManager";
    private static HashMap<String, String> mChannelUrlMap = null;
    private static boolean mRequestInitConfig = false;
    private static boolean mRequestInitConfigResult = false;

    public class a implements RequestCallback {
        @Override // com.bwt.top.http.RequestCallback
        public void onFail(Throwable th) {
            if (th != null) {
                ALog.d(ApiManager.TAG, "竞价反馈失败 " + th.getMessage());
            }
        }

        @Override // com.bwt.top.http.RequestCallback
        public void onSuccess(String str) {
            ALog.d(ApiManager.TAG, "竞价反馈结果 " + str);
        }
    }

    public class b extends dkkd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdSdk.InitCallback f28246a;

        public b(AdSdk.InitCallback initCallback) {
            this.f28246a = initCallback;
        }

        @Override // com.bwt.top.api.dkkd
        public void a(InitConfigBean initConfigBean) {
            FunctionConfig.instance().saveInitConfig(initConfigBean);
            ApiManager.parseChannelUrlList(initConfigBean.getChannelUrlList());
            ApiManager.initBase(AdSdk.getInstance().getContext());
            ALog.d(ApiManager.TAG, " requestInitConfigData onSucceed" + initConfigBean);
            kva.a().b();
            boolean unused = ApiManager.mRequestInitConfigResult = true;
            AdSdk.InitCallback initCallback = this.f28246a;
            if (initCallback != null) {
                initCallback.onInitResult(true);
            }
        }

        @Override // com.bwt.top.api.dkkd
        public void b(AdError adError) {
            String str;
            String str2;
            ApiManager.initBase(AdSdk.getInstance().getContext());
            adError.log();
            boolean unused = ApiManager.mRequestInitConfigResult = false;
            AdSdk.InitCallback initCallback = this.f28246a;
            if (initCallback != null) {
                initCallback.onInitResult(false);
            }
            if (AdSdk.getInstance().isNoAd()) {
                str = ApiManager.TAG;
                str2 = "广告已经停用";
            } else {
                str = ApiManager.TAG;
                str2 = " requestInitConfigData onFailed";
            }
            ALog.d(str, str2);
        }
    }

    public static boolean checkAdSdkInitStatus() {
        String str;
        String str2;
        if (!mRequestInitConfig) {
            str = TAG;
            str2 = "AdSdk Init: no init";
        } else {
            if (mRequestInitConfigResult) {
                return true;
            }
            str = TAG;
            str2 = "AdSdk Init: init config data is empty)";
        }
        ALog.i(str, str2);
        return false;
    }

    public static String getChannelUrl(String str) {
        HashMap<String, String> map;
        if (TextUtils.isEmpty(str) || (map = mChannelUrlMap) == null || TextUtils.isEmpty(map.get(str))) {
            return (TextUtils.isEmpty(str) || !str.equals(AdPlatforms.inner.name())) ? "http://ad.lovefree.cc" : "http://inner.lovefree.cc";
        }
        return mChannelUrlMap.get(str);
    }

    public static void initBase(Context context) {
        try {
            ALog.i("updateMark", NativeHelper.getSysUpdateMark());
            String oaid = AdSdk.getInstance().getOAID();
            if (TextUtils.isEmpty(oaid)) {
                oaid = OAIDUtil.getOaid(context);
            }
            String androidId = DeviceUtil.getAndroidId(context);
            String imsi = DeviceUtil.getImsi(context);
            String imei = DeviceUtil.getImei(context);
            String macAddress = DeviceUtil.getMacAddress(context);
            RcSdk.setAndroidId(androidId);
            RcSdk.setImei(imei);
            RcSdk.setImsi(imsi);
            RcSdk.setMacAddress(macAddress);
            RcSdk.setOaid(oaid);
            RcSdk.setUrl(getChannelUrl(AdPlatforms.inner.name()));
            RcSdk.init(context);
        } catch (Throwable unused) {
        }
    }

    public static void noticeBinPrice(PriceNoticeBean priceNoticeBean) {
        if (priceNoticeBean == null) {
            return;
        }
        HttpManager.instance().get(String.format("%s/%s/%s/%s", zgb.a(), priceNoticeBean.getPosid(), priceNoticeBean.getWinOrLoss(), priceNoticeBean.getPrice()), null, null, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void parseChannelUrlList(List<ChannelUrlBean> list) {
        if (list == null || list.size() <= 0) {
            ALog.e(TAG, "parseChannelUrlList list is empty");
            return;
        }
        mChannelUrlMap = new HashMap<>();
        for (ChannelUrlBean channelUrlBean : list) {
            String name = channelUrlBean.getName();
            String baseUrl = channelUrlBean.getBaseUrl();
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(baseUrl)) {
                ALog.e(TAG, "parseChannelUrlList name or url is empty,name" + name + "--url: " + baseUrl);
                return;
            }
            mChannelUrlMap.put(name, baseUrl);
        }
    }

    public static void requestInitConfigData(AdSdk.InitCallback initCallback) {
        ALog.d(TAG, "requestInitConfigData:" + zgb.b());
        if (TextUtils.isEmpty(zgb.b())) {
            ALog.e(TAG, "需要调用 AdSdk.getInstance().setBaseHttp()");
            return;
        }
        mRequestInitConfig = true;
        HashMap<String, String> map = new HashMap<>();
        map.put("os", "android");
        map.put("version", "1.0.1");
        if (AdSdk.getInstance().isNoAd()) {
            map.put("adRequest", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        }
        HttpManager.instance().get(zgb.b(), null, map, new b(initCallback));
        Context context = AdSdk.getInstance().getContext();
        OAIDUtil.getOaid(context);
        DeviceUtil.getDefaultUAString(context);
    }
}
