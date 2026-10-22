package com.alibaba.triver.kit.api.monitor;

import android.content.Context;
import com.alibaba.ariver.kernel.common.Proxiable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IPerformanceAndErrorTracker extends Proxiable {
    void sendErr(Context context, ErrReportBean errReportBean);

    void sendPerf(String str, String str2);

    void sendPerfStageLog(String str, String str2);

    void sendPerfV2(String str);
}
