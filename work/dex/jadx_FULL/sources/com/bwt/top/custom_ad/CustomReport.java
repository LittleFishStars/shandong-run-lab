package com.bwt.top.custom_ad;

import com.bwt.top.ad.report.BaseReport;
import com.bwt.top.custom_ad.http.CustomAdPosResult;
import com.bwt.top.util.ALog;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CustomReport extends BaseReport {
    CustomAdPosResult channelAdPos;

    public CustomReport(CustomAdPosResult customAdPosResult) {
        this.channelAdPos = customAdPosResult;
    }

    @Override // com.bwt.top.ad.report.BaseReport
    public void clickReport() {
        ALog.i(this.TAG, "click report");
        CustomAdPosResult customAdPosResult = this.channelAdPos;
        if (customAdPosResult == null || customAdPosResult.getClickReport() == null || this.channelAdPos.getClickReport().size() <= 0) {
            return;
        }
        for (String str : this.channelAdPos.getClickReport()) {
            ALog.v(this.TAG, "doReportOnly click url:" + str);
            doReportOnly(str);
        }
    }

    @Override // com.bwt.top.ad.report.BaseReport
    public void deepLinkFailReport() {
        ALog.i(this.TAG, "deeplink fail report");
        CustomAdPosResult customAdPosResult = this.channelAdPos;
        if (customAdPosResult == null || customAdPosResult.getDpf() == null || this.channelAdPos.getDpf().size() <= 0) {
            return;
        }
        for (String str : this.channelAdPos.getDpf()) {
            ALog.v(this.TAG, "doReportOnly dpf url:" + str);
            doReportOnly(str);
        }
    }

    @Override // com.bwt.top.ad.report.BaseReport
    public void deepLinkReport() {
        ALog.i(this.TAG, "deeplink report");
        CustomAdPosResult customAdPosResult = this.channelAdPos;
        if (customAdPosResult == null || customAdPosResult.getDpt() == null || this.channelAdPos.getDpt().size() <= 0) {
            return;
        }
        for (String str : this.channelAdPos.getDpt()) {
            ALog.v(this.TAG, "doReportOnly dpt url:" + str);
            doReportOnly(str);
        }
    }

    @Override // com.bwt.top.ad.report.BaseReport
    public void deepLinkSuccessReport() {
        ALog.i(this.TAG, "deeplink success report");
        CustomAdPosResult customAdPosResult = this.channelAdPos;
        if (customAdPosResult == null || customAdPosResult.getDps() == null || this.channelAdPos.getDps().size() <= 0) {
            return;
        }
        for (String str : this.channelAdPos.getDps()) {
            ALog.v(this.TAG, "doReportOnly dps url:" + str);
            doReportOnly(str);
        }
    }

    @Override // com.bwt.top.ad.report.BaseReport
    public void displayReport() {
        ALog.i(this.TAG, "display report");
        CustomAdPosResult customAdPosResult = this.channelAdPos;
        if (customAdPosResult == null || customAdPosResult.getDisplayReport() == null || this.channelAdPos.getDisplayReport().size() <= 0) {
            return;
        }
        for (String str : this.channelAdPos.getDisplayReport()) {
            ALog.v(this.TAG, "doReportOnly display url:" + str);
            doReportOnly(str);
        }
    }

    @Override // com.bwt.top.ad.report.BaseReport
    public List<String> getReportUrl() {
        return null;
    }
}
