package com.kc.dw.core.ad;

import android.view.View;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.s2s.ISBidding;
import com.kc.dw.core.utils.ResultBean;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IAd<T extends InteractionListener> extends ISBidding {
    View getAdView();

    ResultBean getData();

    T getInteractionListener();

    TouchData getTouchData();

    boolean isAdValid();

    void setAdView(View view);

    void setInteractionListener(T t);
}
