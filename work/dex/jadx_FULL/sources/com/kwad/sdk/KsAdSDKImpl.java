package com.kwad.sdk;

import android.content.Context;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.IComponentProxy;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@KsAdSdkDynamicImpl(IKsAdSDK.class)
@Keep
public class KsAdSDKImpl implements IKsAdSDK {

    public static class a {
        private static final KsAdSDKImpl aGe = new KsAdSDKImpl();
    }

    @KsAdSdkDynamicImpl(IKsAdSDK.class)
    @Keep
    public static KsAdSDKImpl get() {
        return a.aGe;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void addHp(@NonNull Map<String, String> map) {
        o.Gs();
        o.f(map);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public Object dM(String str, Object... objArr) {
        o.Gs();
        return o.f(str, objArr);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void deleteCache() {
        o.Gs();
        o.deleteCache();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @NonNull
    public KsLoadManager getAdManager() {
        return o.Gs().getAdManager();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getApiVersion() {
        return o.Gs().getApiVersion();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getApiVersionCode() {
        return o.Gs().getApiVersionCode();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppId() {
        o.Gs();
        return o.getAppId();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getAppInfo() {
        o.Gs();
        return o.getAppInfo();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getAppName() {
        o.Gs();
        return o.getAppName();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public Context getContext() {
        o.Gs();
        return o.getContext();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getDeviceInfo() {
        o.Gs();
        return o.getDeviceInfo();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getDid() {
        o.Gs();
        return o.getDid();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    @Keep
    public JSONObject getNetworkInfo() {
        o.Gs();
        return o.getNetworkInfo();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRD(String str) {
        o.Gs();
        return o.cU(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getRM(String str) {
        o.Gs();
        return o.cT(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKType() {
        o.Gs();
        return 1;
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public String getSDKVersion() {
        o.Gs();
        return o.getSDKVersion();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public int getSDKVersionCode() {
        o.Gs();
        return BuildConfig.VERSION_CODE;
    }

    public SdkConfig getSdkConfig() {
        o.Gs();
        return o.getSdkConfig();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public synchronized void init(Context context, SdkConfig sdkConfig) {
        Log.w("jky", "KsAdSDKImpl init call start");
        o oVarGs = o.Gs();
        oVarGs.b(context, sdkConfig);
        if (!oVarGs.Gv()) {
            oVarGs.Gt();
        }
        Log.w("jky", "KsAdSDKImpl init call end");
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public boolean isDebugLogEnable() {
        o.Gs();
        return o.isDebugLogEnable();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T extends IComponentProxy> T newComponentProxy(Class<?> cls, Object obj) {
        return (T) o.Gs().newComponentProxy(cls, obj);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public <T> T newInstance(Class<T> cls) {
        o.Gs();
        return (T) o.newInstance(cls);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void pauseCurrentPlayer() {
        o.Gs();
        o.pauseCurrentPlayer();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void re(Object obj) {
        if (obj instanceof Throwable) {
            o.Gs();
            o.r((Throwable) obj);
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void reportBatchEvent(int i, Map<String, Object> map) {
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void resumeCurrentPlayer() {
        o.Gs();
        o.resumeCurrentPlayer();
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void sR(String str, Map<String, String> map, String str2) {
        o.Gs();
        o.b(str, map, str2);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAdxEnable(boolean z) {
        o.Gs().setAdxEnable(z);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersion(String str) {
        o.Gs().setApiVersion(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setApiVersionCode(int i) {
        o.Gs().setApiVersionCode(i);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setAppTag(String str) {
        o.Gs().setAppTag(str);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setInitStartTime(long j) {
        o.Gs().setInitStartTime(j);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setIsExternal(boolean z) {
        o.Gs().setIsExternal(z);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLaunchTime(long j) {
        o.Gs().setLaunchTime(j);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimation(boolean z, @RawRes int i) {
        o.Gs();
        o.setLoadingLottieAnimation(z, i);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setLoadingLottieAnimationColor(boolean z, @ColorInt int i) {
        o.Gs();
        o.setLoadingLottieAnimationColor(z, i);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setPersonalRecommend(boolean z) {
        o.Gs().setPersonalRecommend(z);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setProgrammaticRecommend(boolean z) {
        o.Gs().setProgrammaticRecommend(z);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void setThemeMode(int i) {
        o.Gs();
        o.setThemeMode(i);
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public synchronized void start() {
        Log.e("jky", "KsAdSDKImpl start call 1");
        o oVarGs = o.Gs();
        Log.e("jky", "KsAdSDKImpl start call 2");
        if (oVarGs.Gv()) {
            Log.e("jky", "KsAdSDKImpl start call 3");
            oVarGs.Gt();
            Log.e("jky", "KsAdSDKImpl start call 4");
        }
    }

    @Override // com.kwad.sdk.api.core.IKsAdSDK
    public void unInit() {
        o.Gs().unInit();
    }

    private KsAdSDKImpl() {
    }
}
