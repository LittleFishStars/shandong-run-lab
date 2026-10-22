package com.kwad.sdk.api.proxy;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@KsAdSdkDynamicApi
@Keep
public abstract class IFragmentActivityProxy extends IActivityProxy {
    private BaseProxyFragmentActivity mProxyFragmentActivity;

    @KsAdSdkDynamicApi
    @Keep
    public ApplicationInfo getApplicationInfo() {
        return this.mProxyFragmentActivity.getApplicationInfo();
    }

    @KsAdSdkDynamicApi
    @Keep
    public BaseProxyFragmentActivity getProxyFragmentActivity() {
        return this.mProxyFragmentActivity;
    }

    @KsAdSdkDynamicApi
    @Keep
    public int getRequestedOrientation() {
        return this.mProxyFragmentActivity.getRequestedOrientation();
    }

    @KsAdSdkDynamicApi
    @Keep
    public Resources getResources() {
        return this.mProxyFragmentActivity.getResources();
    }

    @KsAdSdkDynamicApi
    @Keep
    public final KsFragmentManager getSupportFragmentManager() {
        return this.mProxyFragmentActivity.getSupportFragmentManager2();
    }

    @KsAdSdkDynamicApi
    @Keep
    public Resources.Theme getTheme() {
        return this.mProxyFragmentActivity.getTheme();
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean isFinishing() {
        return this.mProxyFragmentActivity.isFinishing();
    }

    @KsAdSdkDynamicApi
    @Keep
    public TypedArray obtainStyledAttributes(int[] iArr) {
        return this.mProxyFragmentActivity.obtainStyledAttributes(iArr);
    }

    public void onAttachFragment(KsFragment ksFragment) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void runOnUiThread(Runnable runnable) {
        this.mProxyFragmentActivity.runOnUiThread(runnable);
    }

    public void setProxyFragmentActivity(BaseProxyFragmentActivity baseProxyFragmentActivity) {
        this.mProxyFragmentActivity = baseProxyFragmentActivity;
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setResult(int i, Intent intent) {
        this.mProxyFragmentActivity.setResult(i, intent);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void startActivity(Intent intent) {
        this.mProxyFragmentActivity.startActivity(intent);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void startActivityForResult(Intent intent, int i) {
        this.mProxyFragmentActivity.startActivityForResult(intent, i);
    }
}
