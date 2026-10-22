package com.fl.saas.base.inner.spread.coustomView;

import android.content.Context;
import android.view.View;
import com.fl.saas.base.inner.InnerNativeView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface NativeSpreadView extends InnerNativeView {
    void cancelCountdown();

    void setClickAreaVisibility(boolean z, View view);

    void setContext(Context context);

    void setRainView(boolean z);

    void setViewType(boolean z, boolean z2, int i);

    void show();

    void startCountdown();
}
