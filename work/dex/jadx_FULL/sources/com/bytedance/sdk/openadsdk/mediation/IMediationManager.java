package com.bytedance.sdk.openadsdk.mediation;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface IMediationManager {
    Map<String, Object> getMediationExtraInfo();

    void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback);

    void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback);

    Object mtool(int i, SparseArray<Object> sparseArray);

    void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i, int i2);

    @Deprecated
    void requestPermissionIfNecessary(Context context);

    @Deprecated
    void requestPermissionIfNecessary(Context context, int[] iArr);

    void setPulisherDid(String str);

    @Deprecated
    void setThemeStatus(int i);

    void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment);

    int showOpenOrInstallAppDialog(MediationAppDialogClickListener mediationAppDialogClickListener);

    @Deprecated
    void updateLocalExtra(Map<String, Object> map);

    @Deprecated
    void updatePrivacyConfig(TTCustomController tTCustomController);
}
