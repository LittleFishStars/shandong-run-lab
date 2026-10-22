package com.kc.dw.platform.ad_adapter;

import android.content.Context;
import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.IAd;
import com.kc.dw.core.loader.InteractionListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface c<T extends InteractionListener> extends IAd<T> {
    AdSlot a();

    AdType getAdType();

    Context getContext();

    int getInteractionType();
}
