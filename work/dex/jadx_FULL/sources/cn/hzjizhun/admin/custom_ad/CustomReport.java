package cn.hzjizhun.admin.custom_ad;

import android.text.TextUtils;
import cn.hzjizhun.admin.ad.report.BaseReport;
import cn.hzjizhun.admin.custom_ad.http.CustomAdPosResult;
import cn.hzjizhun.admin.util.ALog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CustomReport extends BaseReport {
    private static final String PAGE_ACTION = "__PAGE_ACTION__";
    private static final String TS = "__TS__";
    private static final String TS_END = "__TS_END__";
    CustomAdPosResult channelAdPos;
    private boolean isDeeplink;
    private boolean isDeeplinkFail;
    private boolean isDeeplinkSuccess;
    private boolean mIsPlay25;
    private boolean mIsPlay50;
    private boolean mIsPlay75;
    private boolean mIsReward;
    private HashMap<Integer, List<String>> mTrackMap;
    private final AtomicBoolean isDisplayReport = new AtomicBoolean(false);
    private final AtomicBoolean isClickReport = new AtomicBoolean(false);

    public CustomReport(CustomAdPosResult customAdPosResult) {
        this.mTrackMap = null;
        this.channelAdPos = customAdPosResult;
        if (customAdPosResult != null) {
            try {
                List<CustomAdPosResult.TrackerBean> list = customAdPosResult.trackers;
                if (list == null || list.isEmpty()) {
                    return;
                }
                this.mTrackMap = new HashMap<>();
                for (CustomAdPosResult.TrackerBean trackerBean : customAdPosResult.trackers) {
                    this.mTrackMap.put(Integer.valueOf(trackerBean.type), trackerBean.urls);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void reportTrackUrls(int i) {
        reportTrackUrls(i, null);
    }

    @Override // cn.hzjizhun.admin.ad.report.BaseReport
    public void clickReport(String str) {
        try {
            if (this.isClickReport.compareAndSet(false, true)) {
                displayReport();
                ALog.i(this.TAG, "click report");
                CustomAdPosResult customAdPosResult = this.channelAdPos;
                if (customAdPosResult == null || customAdPosResult.getClickReport() == null || this.channelAdPos.getClickReport().isEmpty()) {
                    return;
                }
                for (String str2 : this.channelAdPos.getClickReport()) {
                    ALog.v(this.TAG, "doReportOnly click url:" + str2);
                    doReportOnly(str2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // cn.hzjizhun.admin.ad.report.BaseReport
    public void deepLinkFailReport() {
        if (this.isDeeplinkFail) {
            return;
        }
        this.isDeeplinkFail = true;
        ALog.i(this.TAG, "deeplink fail report");
        CustomAdPosResult customAdPosResult = this.channelAdPos;
        if (customAdPosResult == null || customAdPosResult.getDpf() == null || this.channelAdPos.getDpf().isEmpty()) {
            return;
        }
        for (String str : this.channelAdPos.getDpf()) {
            ALog.v(this.TAG, "doReportOnly dpf url:" + str);
            doReportOnly(str);
        }
    }

    @Override // cn.hzjizhun.admin.ad.report.BaseReport
    public void deepLinkReport() {
        if (this.isDeeplink) {
            return;
        }
        this.isDeeplink = true;
        ALog.i(this.TAG, "deeplink report");
        CustomAdPosResult customAdPosResult = this.channelAdPos;
        if (customAdPosResult == null || customAdPosResult.getDpt() == null || this.channelAdPos.getDpt().isEmpty()) {
            return;
        }
        for (String str : this.channelAdPos.getDpt()) {
            ALog.v(this.TAG, "doReportOnly dpt url:" + str);
            doReportOnly(str);
        }
    }

    @Override // cn.hzjizhun.admin.ad.report.BaseReport
    public void deepLinkSuccessReport() {
        if (this.isDeeplinkSuccess) {
            return;
        }
        this.isDeeplinkSuccess = true;
        ALog.i(this.TAG, "deeplink success report");
        CustomAdPosResult customAdPosResult = this.channelAdPos;
        if (customAdPosResult == null || customAdPosResult.getDps() == null || this.channelAdPos.getDps().isEmpty()) {
            return;
        }
        for (String str : this.channelAdPos.getDps()) {
            ALog.v(this.TAG, "doReportOnly dps url:" + str);
            doReportOnly(str);
        }
    }

    @Override // cn.hzjizhun.admin.ad.report.BaseReport
    public void displayReport() {
        try {
            if (this.isDisplayReport.compareAndSet(false, true)) {
                ALog.i(this.TAG, "display report 曝光上报");
                CustomAdPosResult customAdPosResult = this.channelAdPos;
                if (customAdPosResult == null || customAdPosResult.getDisplayReport() == null || this.channelAdPos.getDisplayReport().isEmpty()) {
                    return;
                }
                for (String str : this.channelAdPos.getDisplayReport()) {
                    ALog.v(this.TAG, "doReportOnly display url:" + str);
                    doReportOnly(str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // cn.hzjizhun.admin.ad.report.BaseReport
    public HashMap<String, String> getReportHeader() {
        CustomAdPosResult.HeadersBean headersBean;
        try {
            CustomAdPosResult customAdPosResult = this.channelAdPos;
            if (customAdPosResult != null && (headersBean = customAdPosResult.mHeadersBean) != null && !TextUtils.isEmpty(headersBean.headName) && !TextUtils.isEmpty(headersBean.headVaule)) {
                HashMap<String, String> map = new HashMap<>();
                map.put(headersBean.headName, headersBean.headVaule);
                return map;
            }
        } catch (Throwable unused) {
        }
        return super.getReportHeader();
    }

    @Override // cn.hzjizhun.admin.ad.report.BaseReport
    public List<String> getReportUrl() {
        return null;
    }

    public void h5ActionReport(int i) {
        ALog.innerD(this.TAG, "h5ActionReport...." + i);
        HashMap<String, String> map = new HashMap<>();
        map.put(TS, System.currentTimeMillis() + "");
        map.put(PAGE_ACTION, i + "");
        reportTrackUrls(42, map);
    }

    public void h5CloseReport() {
        ALog.innerD(this.TAG, "h5CloseReport....");
        HashMap<String, String> map = new HashMap<>();
        map.put(TS_END, System.currentTimeMillis() + "");
        reportTrackUrls(41, map);
    }

    public void h5loadCompleteReport() {
        ALog.innerD(this.TAG, "h5loadCompleteReport....");
        HashMap<String, String> map = new HashMap<>();
        map.put(TS, System.currentTimeMillis() + "");
        reportTrackUrls(40, map);
    }

    public void play25Report() {
        if (this.mIsPlay25) {
            return;
        }
        this.mIsPlay25 = true;
        ALog.innerD(this.TAG, "play25Report");
        reportTrackUrls(22);
    }

    public void play50Report() {
        if (this.mIsPlay50) {
            return;
        }
        this.mIsPlay50 = true;
        ALog.innerD(this.TAG, "play50Report");
        reportTrackUrls(23);
    }

    public void play75Report() {
        if (this.mIsPlay75) {
            return;
        }
        this.mIsPlay75 = true;
        ALog.innerD(this.TAG, "play75Report");
        reportTrackUrls(24);
    }

    public void playCloseReport() {
        ALog.innerD(this.TAG, "playCloseReport");
        reportTrackUrls(29);
    }

    public void playEndReport() {
        ALog.innerD(this.TAG, "playEndReport");
        reportTrackUrls(25);
    }

    public void playMuteReport() {
        ALog.innerD(this.TAG, "playMuteReport");
        reportTrackUrls(30);
    }

    public void playPauseReport() {
        ALog.innerD(this.TAG, "playPauseReport");
        reportTrackUrls(26);
    }

    public void playResumeReport() {
        ALog.innerD(this.TAG, "playResumeReport");
        reportTrackUrls(27);
    }

    public void playSkipReport() {
        ALog.innerD(this.TAG, "playSkipReport");
        reportTrackUrls(28);
    }

    public void rewardReport() {
        if (this.mIsReward) {
            return;
        }
        this.mIsReward = true;
        ALog.innerD(this.TAG, "rewardReport ....");
        reportTrackUrls(20);
    }

    public void startPlayReport() {
        ALog.innerD(this.TAG, "startPlayReport");
        reportTrackUrls(21);
    }

    private void reportTrackUrls(int i, HashMap<String, String> map) {
        try {
            List<String> list = this.mTrackMap.get(Integer.valueOf(i));
            if (list == null || list.isEmpty()) {
                return;
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                doReportOnly(it.next(), map);
            }
        } catch (Throwable unused) {
        }
    }
}
