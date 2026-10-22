package com.bytedance.sdk.openadsdk.mediation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface IMediationDrawAdTokenCallback {
    void onAdTokenLoaded(String str, IMediationDrawTokenInfo iMediationDrawTokenInfo);

    void onAdTokenLoadedFail(int i, String str);
}
