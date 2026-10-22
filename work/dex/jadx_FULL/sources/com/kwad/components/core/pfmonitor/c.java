package com.kwad.components.core.pfmonitor;

import com.kwad.components.core.pfmonitor.model.DiskReportInfo;
import com.kwad.components.core.pfmonitor.model.f;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c {
    public static void r(List<f> list) {
        try {
            DiskReportInfo diskReportInfoCreateCommonPathListInfo = DiskReportInfo.createCommonPathListInfo(list);
            com.kwad.sdk.core.d.c.d("DiskPerformanceReporter", "reportPathList info: " + diskReportInfoCreateCommonPathListInfo.pathList);
            com.kwad.sdk.commercial.c.e((com.kwad.sdk.commercial.c.a) diskReportInfoCreateCommonPathListInfo, false);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public static void s(List<f> list) {
        try {
            DiskReportInfo diskReportInfoCreateErrorInfo = DiskReportInfo.createErrorInfo(list);
            com.kwad.sdk.core.d.c.d("DiskPerformanceReporter", "reportPathError info: " + diskReportInfoCreateErrorInfo.pathList);
            com.kwad.sdk.commercial.c.e((com.kwad.sdk.commercial.c.a) diskReportInfoCreateErrorInfo, true);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }
}
