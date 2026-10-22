package com.fl.saas.adx.base.inner.spread.coustomView;

import android.view.View;
import com.fl.saas.adx.base.inner.InnerNativeView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface NativeSpreadView extends InnerNativeView {
    void cancelCountdown();

    void setClickAreaVisibility(View view);

    void setViewType(boolean z, boolean z2, int i);

    void show();

    void startCountdown();
}
