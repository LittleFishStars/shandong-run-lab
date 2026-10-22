package com.kc.dw.platform;

import android.content.Context;
import android.text.TextUtils;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.domain.SdkAdInfo;
import com.kc.dw.core.loader.a;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.ReflectUtil;
import com.kc.dw.platform.custom.CustomInitLoader;
import com.kc.dw.platform.custom.banner.MsCustomBannerAdapter;
import com.kc.dw.platform.custom.draw.MsCustomDrawAdapter;
import com.kc.dw.platform.custom.fullscreen.MsCustomFullScreenAdapter;
import com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter;
import com.kc.dw.platform.custom.paster.MsCustomPasterAdapter;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter;
import com.kc.dw.platform.custom.reward.MsCustomRewardAdapter;
import com.kc.dw.platform.custom.splash.MsCustomSplashAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ADPlatformHelper {
    private static final String TAG = "ADPlatformHelper";

    private static boolean checkPlatformPermission(Context context, String str) {
        throw null;
    }

    public static boolean checkTypeSupport(a aVar, String str) {
        throw null;
    }

    public static SdkAdInfo[] filterValidSdk(Context context, SdkAdInfo[] sdkAdInfoArr, a aVar) {
        if (sdkAdInfoArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(sdkAdInfoArr.length);
        int i = 0;
        while (i < sdkAdInfoArr.length) {
            if (isSdkValid(context, sdkAdInfoArr[i], aVar) && ((com.kc.dw.base.a.adConfig() != null && com.kc.dw.base.a.adConfig().isUseMediation()) || !TextUtils.isEmpty(sdkAdInfoArr[i].getCls()))) {
                SdkAdInfo sdkAdInfo = sdkAdInfoArr[i];
                arrayList.add(sdkAdInfo);
            }
            i++;
        }
        return (SdkAdInfo[]) arrayList.toArray(new SdkAdInfo[0]);
    }

    private static boolean isSdkValid(Context context, SdkAdInfo sdkAdInfo, a aVar) {
        String sdk;
        try {
            sdk = sdkAdInfo.getSdk();
            try {
                if (TextUtils.isEmpty(sdk)) {
                    LogUtil.e(TAG, "sdk invalid, platform is empty");
                    return false;
                }
                if ("ADMOB".equals(sdkAdInfo.getSdk())) {
                    if (AdSdk.getAdmobVersionName() != null) {
                        return true;
                    }
                    LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                    return false;
                }
                if ("PANGLE".equals(sdkAdInfo.getSdk())) {
                    if (AdSdk.getPangleVersionName() != null) {
                        return true;
                    }
                    LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                    return false;
                }
                if ("DM".equals(sdkAdInfo.getSdk())) {
                    if (AdSdk.getDuoMengVersionName() != null) {
                        return true;
                    }
                    LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                    return false;
                }
                if ("SGM".equals(sdkAdInfo.getSdk())) {
                    if (AdSdk.getSGMVersionName() != null) {
                        return true;
                    }
                    LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                    return false;
                }
                if ("CSJ".equals(sdkAdInfo.getSdk())) {
                    if (AdSdk.getCSJVersionName() != null) {
                        return true;
                    }
                    LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                    return false;
                }
                if ("GDT".equals(sdkAdInfo.getSdk())) {
                    if (AdSdk.getGDTVersionName() != null) {
                        return true;
                    }
                    LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                    return false;
                }
                if ("BAIDU".equals(sdkAdInfo.getSdk())) {
                    if (AdSdk.getBDVersionName() != null) {
                        return true;
                    }
                    LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                    return false;
                }
                if ("KS".equals(sdkAdInfo.getSdk())) {
                    if (AdSdk.getKSVersionName() != null) {
                        return true;
                    }
                    LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                    return false;
                }
                if ("JD".equals(sdkAdInfo.getSdk())) {
                    if (AdSdk.getJDVersionName() != null) {
                        return true;
                    }
                    LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                    return false;
                }
                if ("HW".equals(sdkAdInfo.getSdk())) {
                    if (AdSdk.getHWVersionName() != null) {
                        return true;
                    }
                    LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                    return false;
                }
                if ("MIMO".equals(sdkAdInfo.getSdk())) {
                    if (AdSdk.getMimoVersionName() != null) {
                        return true;
                    }
                    LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                    return false;
                }
                if ("OPPO".equals(sdkAdInfo.getSdk())) {
                    if (AdSdk.getOPPOVersionName() != null) {
                        return true;
                    }
                    LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                    return false;
                }
                if ("CUSTOM".equals(sdkAdInfo.getSdk())) {
                    if (isValidCustom(sdkAdInfo)) {
                        return true;
                    }
                    LogUtil.e(TAG, "custom sdk adapter invalid (" + sdkAdInfo.getCls() + ")");
                    return false;
                }
                LogUtil.e(TAG, "sdk invalid (" + sdk + "), check lib import");
                return false;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
            }
        } catch (Exception e2) {
            e = e2;
            sdk = null;
        }
    }

    private static boolean isValidCustom(SdkAdInfo sdkAdInfo) {
        try {
            if (TextUtils.isEmpty(sdkAdInfo.getCls()) || TextUtils.isEmpty(sdkAdInfo.getInitCls())) {
                return false;
            }
            Class<?> cls = ReflectUtil.getClass(sdkAdInfo.getCls());
            Class<?> cls2 = ReflectUtil.getClass(sdkAdInfo.getInitCls());
            if (cls == null || cls2 == null || !CustomInitLoader.class.isAssignableFrom(cls2)) {
                return false;
            }
            return MsCustomBannerAdapter.class.isAssignableFrom(cls) || MsCustomDrawAdapter.class.isAssignableFrom(cls) || MsCustomFullScreenAdapter.class.isAssignableFrom(cls) || MsCustomInterstitialAdapter.class.isAssignableFrom(cls) || MsCustomPasterAdapter.class.isAssignableFrom(cls) || MsCustomRecyclerAdapter.class.isAssignableFrom(cls) || MsCustomRewardAdapter.class.isAssignableFrom(cls) || MsCustomSplashAdapter.class.isAssignableFrom(cls);
        } catch (Exception unused) {
            return false;
        }
    }
}
