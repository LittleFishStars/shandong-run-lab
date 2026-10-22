package com.zj.adlib;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.triver.kit.api.TinyApp;
import com.huachenjie.ad.impl.JzAdLoader;
import com.huachenjie.ad.impl.LinkPageAdLoader;
import com.huachenjie.ad.impl.MhtAdLoader;
import com.huachenjie.ad.impl.SigmobAdLoader;
import com.huachenjie.ad.impl.ZJAdLoader;
import com.huachenjie.ad.interfaces.BannerAdListener;
import com.huachenjie.ad.interfaces.NativeAdListener;
import com.huachenjie.ad.interfaces.SplashAdListener;
import com.huachenjie.ad.util.OAIDUtil;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.ltmb.ltsdk.check.LTAdDeviceManager;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ew {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41535a = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final MutableLiveData<String> f16408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static JzAdLoader f16409a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static LinkPageAdLoader f16410a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static MhtAdLoader f16411a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static SigmobAdLoader f16412a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ZJAdLoader f16413a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static d88 f16414a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Map<String, String> f16415a;
    public static final int b = 3;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final MutableLiveData<String> f16416b;
    public static final int c = 4;
    public static final int d = 5;
    public static final int e = 6;
    public static final int f = 7;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f16415a = linkedHashMap;
        f16408a = new MutableLiveData<>("");
        f16416b = new MutableLiveData<>("");
        linkedHashMap.put("", "0");
        linkedHashMap.put("9", "6");
        linkedHashMap.put("19", "3");
        linkedHashMap.put("27", "5");
        linkedHashMap.put(TinyApp.SUB_TYPE_BRAND_ZONE, "2");
        linkedHashMap.put("13", "1");
        linkedHashMap.put("21", "4");
        linkedHashMap.put("20", PrepareException.ERROR_AUTH_FAIL);
        linkedHashMap.put("22", "9");
        linkedHashMap.put("35", "ms");
        linkedHashMap.put("10681", "ly");
        linkedHashMap.put("10881", "ux");
        linkedHashMap.put("11025", "qd");
        linkedHashMap.put("11178", "fl");
        linkedHashMap.put("11055", "zj");
        linkedHashMap.put("41", "zy");
        linkedHashMap.put("11478", "litemob");
    }

    public static void a(int i) {
        MutableLiveData<String> mutableLiveData = f16416b;
        String value = mutableLiveData.getValue();
        if (value == null) {
            value = "";
        }
        mutableLiveData.postValue(value + i);
    }

    public static void b(int i) {
        MutableLiveData<String> mutableLiveData = f16408a;
        String value = mutableLiveData.getValue();
        if (value == null) {
            value = "";
        }
        mutableLiveData.postValue(value + i);
    }

    public static void c(String str, Map<String, String> map, StringBuilder sb) {
        if (str == null) {
            sb.append("-0");
            return;
        }
        String str2 = map.get(str);
        if (TextUtils.isEmpty(str2)) {
            sb.append("--1");
        } else {
            sb.append(c49.f40900a);
            sb.append(str2);
        }
    }

    public static String d(int i, String str) {
        StringBuilder sb = new StringBuilder();
        if (i == 5) {
            sb.append("C");
            c(str, f16415a, sb);
        } else if (i == 6) {
            sb.append("D");
            c(str, f16415a, sb);
        }
        return sb.toString();
    }

    public static MutableLiveData<String> e() {
        return f16416b;
    }

    public static JzAdLoader f() {
        return f16409a;
    }

    public static LinkPageAdLoader g() {
        return f16410a;
    }

    public static MhtAdLoader h() {
        return f16411a;
    }

    public static d88 i() {
        return f16414a;
    }

    public static SigmobAdLoader j() {
        return f16412a;
    }

    public static MutableLiveData<String> k() {
        return f16408a;
    }

    public static ZJAdLoader l() {
        return f16413a;
    }

    public static void m(Application application, boolean z, String str) {
        SigmobAdLoader sigmobAdLoader = new SigmobAdLoader();
        f16412a = sigmobAdLoader;
        sigmobAdLoader.e(application, z);
        ZJAdLoader zJAdLoader = new ZJAdLoader();
        f16413a = zJAdLoader;
        zJAdLoader.c(application, z);
        LinkPageAdLoader linkPageAdLoader = new LinkPageAdLoader();
        f16410a = linkPageAdLoader;
        linkPageAdLoader.c(application, z);
        if (!TextUtils.isEmpty(OAIDUtil.com.kc.openset.constant.DeviceIdType.OAID java.lang.String)) {
            f16410a.f(application, OAIDUtil.com.kc.openset.constant.DeviceIdType.OAID java.lang.String);
            LTAdDeviceManager.setUserOAID(application, OAIDUtil.com.kc.openset.constant.DeviceIdType.OAID java.lang.String);
        }
        JzAdLoader jzAdLoader = new JzAdLoader();
        f16409a = jzAdLoader;
        jzAdLoader.d(application, z);
        MhtAdLoader mhtAdLoader = new MhtAdLoader();
        f16411a = mhtAdLoader;
        mhtAdLoader.c(application);
        f16414a = new d88();
    }

    public static void n(FragmentActivity fragmentActivity, String str, String str2, Lifecycle lifecycle, ViewGroup viewGroup, int i, int i2, @Nullable BannerAdListener bannerAdListener) {
        kl0.a(fragmentActivity, str, str2, lifecycle, viewGroup, i, i2, bannerAdListener);
    }

    public static void o(Activity activity, Lifecycle lifecycle) {
        nd4.a(activity, lifecycle);
    }

    public static void p(Activity activity, AdPlatformSwitch adPlatformSwitch, Lifecycle lifecycle, ViewGroup viewGroup, int i, int i2, @Nullable NativeAdListener nativeAdListener) {
        fx5.a(activity, adPlatformSwitch, lifecycle, viewGroup, i, i2, nativeAdListener);
    }

    public static void q(boolean z, AdPlatformSwitch adPlatformSwitch, FragmentActivity fragmentActivity, Lifecycle lifecycle, ViewGroup viewGroup, int i, int i2, SplashAdListener splashAdListener) {
        zm8.a(z, adPlatformSwitch, fragmentActivity, lifecycle, viewGroup, i, i2, splashAdListener);
    }
}
