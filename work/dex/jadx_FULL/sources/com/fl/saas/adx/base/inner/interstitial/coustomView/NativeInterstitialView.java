package com.fl.saas.adx.base.inner.interstitial.coustomView;

import android.view.View;
import androidx.annotation.NonNull;
import com.fl.saas.EnumC1433s;
import com.fl.saas.adx.base.inner.InnerNativeView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface NativeInterstitialView extends InnerNativeView {
    void addActionView(View view);

    void click();

    void destroy();

    NativeInterstitialView setAnimalStartTime(int i);

    NativeInterstitialView setAnimalTime(int i);

    NativeInterstitialView setAutoClose(boolean z);

    NativeInterstitialView setClickType(int i);

    NativeInterstitialView setClosePos(@NonNull EnumC1433s enumC1433s);

    NativeInterstitialView setCloseViewSize(int i);

    NativeInterstitialView setCountDown(boolean z, int i);

    NativeInterstitialView setShakeType(boolean z);

    NativeInterstitialView setSpeed(int i);

    void setViewType(boolean z, int i);

    NativeInterstitialView startCountdown();
}
