package com.baichuan.nb_trade.impl;

import android.app.Activity;
import android.content.Context;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.base.CommonListener;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.baichuan.nb_trade.AlibcTrade;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AlibcCommonListenerImpl implements CommonListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f26232a = "AlibcCommonListenerImpl";

    @Override // com.alibaba.alibcprotocol.base.CommonListener
    public void openUrl(String str, String str2) {
        if ("pushWindow".equals(str)) {
            AlibcTradeContext alibcTradeContext = AlibcTradeContext.getInstance();
            alibcTradeContext.showParams.setNewWindow(true);
            AlibcLogger.i(f26232a, "execute push window: url=" + str2);
            Context context = alibcTradeContext.context;
            if (context != null) {
                AlibcTrade.openByUrl(context, str2, alibcTradeContext.showParams, alibcTradeContext.taokeParams, alibcTradeContext.trackParams, null);
                return;
            }
            WeakReference<Activity> weakReference = alibcTradeContext.mActivity;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            AlibcTrade.openByUrl(alibcTradeContext.mActivity.get(), str2, alibcTradeContext.showParams, alibcTradeContext.taokeParams, alibcTradeContext.trackParams, null);
        }
    }
}
