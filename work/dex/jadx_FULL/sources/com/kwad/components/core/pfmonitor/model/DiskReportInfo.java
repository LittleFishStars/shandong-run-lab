package com.kwad.components.core.pfmonitor.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.ac;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class DiskReportInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    public static final int STATUS_ERROR = 1;
    public static final int STATUS_NORMAL = 2;
    private static final long serialVersionUID = 7321357294899828707L;
    public String pathList;
    public int status;

    public static DiskReportInfo createCommonPathListInfo(List<f> list) {
        DiskReportInfo diskReportInfo = new DiskReportInfo();
        diskReportInfo.status = 2;
        diskReportInfo.pathList = ac.Y(list).toString();
        return diskReportInfo;
    }

    public static DiskReportInfo createErrorInfo(List<f> list) {
        DiskReportInfo diskReportInfo = new DiskReportInfo();
        diskReportInfo.status = 1;
        diskReportInfo.pathList = ac.Y(list).toString();
        return diskReportInfo;
    }
}
