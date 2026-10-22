package com.alibaba.alibctriver.proxy;

import android.text.TextUtils;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;
import com.alibaba.triver.impl.TriverLogProxyImpl;
import com.alibaba.triver.open.proxy.IMonitorProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcMonitorProxy implements IMonitorProxy {
    @Override // com.alibaba.triver.open.proxy.IMonitorProxy
    public boolean hitSampling(String str, String str2, String str3, String str4) {
        return (TextUtils.equals(str, "Page_TRVMonitor") && TextUtils.equals(str2, TriverLogProxyImpl.TLOG_MODULE) && TextUtils.equals(str3, "Launch")) ? AlibcUserTracker.getInstance().keyPointHit() : AlibcUserTracker.getInstance().normalPointHit();
    }
}
