package com.fl.saas.base.bidding;

import android.content.Context;
import com.fl.saas.common.saas.bean.AdSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface GLXHBiddingHandle extends Bidding {

    public interface Callback {
        void onFinish(AdSource adSource);
    }

    void handleBiddingSource(Context context, AdSource adSource, Callback callback);
}
