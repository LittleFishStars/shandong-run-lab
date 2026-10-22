package com.ltmb.ltadsdk.adx.ad.interstitial;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import com.ltmb.ltadsdk.pkg.d9;
import com.ltmb.ltadsdk.pkg.n7;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ltmb/ltadsdk/adx/ad/interstitial/AdxInterstitialLandscapeActivity;", "Lcom/ltmb/ltadsdk/adx/ad/interstitial/AdxInterstitialActivity;", "<init>", "()V", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public final class AdxInterstitialLandscapeActivity extends AdxInterstitialActivity {
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(@Nullable Context context) {
        super.attachBaseContext(context);
    }

    @Override // com.ltmb.ltadsdk.adx.ad.interstitial.AdxInterstitialActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @NotNull
    public Resources getResources() {
        Resources resources = super.getResources();
        if (resources != null) {
            resources.getDisplayMetrics().density = n7.a;
            resources.getDisplayMetrics().scaledDensity = n7.a;
        }
        Intrinsics.checkNotNullExpressionValue(resources, "newResources");
        return resources;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        Configuration configuration = getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "resources.configuration");
        getResources().getDisplayMetrics().density = n7.a;
        getResources().getDisplayMetrics().scaledDensity = n7.a;
        d9.d.a("onContentChanged fontScale=" + configuration.fontScale + ", densityDpi = " + configuration.densityDpi + ", scaledDensity=" + getResources().getDisplayMetrics().scaledDensity + ", density=" + getResources().getDisplayMetrics().density);
        configuration.fontScale = 1.0f;
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }

    @Override // com.ltmb.ltadsdk.adx.ad.interstitial.AdxInterstitialActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }
}
