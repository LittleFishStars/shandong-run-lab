package com.bytedance.sdk.openadsdk.mediation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface IMediationNativeAdTokenCallback {
    void onAdTokenLoaded(String str, IMediationNativeTokenInfo iMediationNativeTokenInfo);

    void onAdTokenLoadedFail(int i, String str);
}
