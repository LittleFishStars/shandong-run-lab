package com.fl.saas.base.inner.interstitial.coustomView;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.fl.saas.base.inner.InnerNativeView;
import com.fl.saas.common.saas.bean.CloseButtonPosition;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface NativeInterstitialView extends InnerNativeView {
    void addActionView(View view);

    void click();

    void closeDialog();

    void destroy();

    NativeInterstitialView setAdType(boolean z);

    NativeInterstitialView setAnimalStartTime(int i);

    NativeInterstitialView setAnimalTime(int i);

    NativeInterstitialView setAutoClose(boolean z);

    NativeInterstitialView setClickType(int i);

    NativeInterstitialView setClosePos(@NonNull CloseButtonPosition closeButtonPosition);

    NativeInterstitialView setCloseViewSize(int i);

    void setContext(Context context);

    NativeInterstitialView setCountDown(boolean z, int i);

    NativeInterstitialView setRainView(boolean z);

    NativeInterstitialView setShakeType(boolean z);

    NativeInterstitialView setSpeed(int i);

    void setViewType(boolean z, int i);

    boolean showDialog(Activity activity);

    NativeInterstitialView startCountdown();
}
