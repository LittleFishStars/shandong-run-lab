package cn.hzjizhun.admin.ad.report;

import cn.hzjizhun.admin.JZAdSdk;
import cn.hzjizhun.admin.api.ApiManager;
import cn.hzjizhun.admin.api.FunctionConfig;
import cn.hzjizhun.admin.api.bean.PosInfoBean;
import cn.hzjizhun.admin.api.bean.ReportInfoBean;
import cn.hzjizhun.admin.bean.ExtendChannel;
import cn.hzjizhun.admin.util.ALog;
import com.kc.aw.lib.constants.PtgRewardConstant;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class OtherChannelReport extends BaseReport {
    private ExtendChannel extendChannel;
    private boolean isClickReport;
    private boolean isDisplayReport;
    private boolean isRequest;
    private boolean isRequestSuccess;
    private String platformType;
    private PosInfoBean posInfo;
    private String price = "";
    private List<ReportInfoBean> reportInfoList;
    private String sceneUserId;

    public OtherChannelReport(PosInfoBean posInfoBean) {
        this.platformType = "";
        try {
            this.platformType = getPlatformType();
            this.posInfo = posInfoBean;
            this.reportInfoList = FunctionConfig.instance().getReportInfo(this.platformType);
            List<ExtendChannel> extendChannelList = JZAdSdk.getInstance().getExtendChannelList();
            if (extendChannelList == null || extendChannelList.size() <= 0) {
                return;
            }
            for (ExtendChannel extendChannel : extendChannelList) {
                if (this.platformType.equals(extendChannel.getType())) {
                    if (extendChannel.getUserid() == null || extendChannel.getUserid().length() <= 0) {
                        return;
                    }
                    this.extendChannel = extendChannel;
                    return;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private String getMPrice(String str) {
        try {
            return String.valueOf((int) (((double) Integer.valueOf(str).intValue()) / this.posInfo.getBiddingRatio()));
        } catch (Throwable unused) {
            return str;
        }
    }

    @Override // cn.hzjizhun.admin.ad.report.BaseReport
    public void clickReport(String str) {
        if (this.isClickReport) {
            return;
        }
        this.isClickReport = true;
        ALog.d(this.TAG, this.platformType + " click report");
        ApiManager.reportAdClick(str);
        doReport("click");
    }

    @Override // cn.hzjizhun.admin.ad.report.BaseReport
    @Deprecated
    public void displayReport() {
    }

    public void displayReport(String str) {
        this.price = str;
        if (this.isDisplayReport) {
            return;
        }
        this.isDisplayReport = true;
        ALog.d(this.TAG, this.platformType + " display report");
        doReport("display");
    }

    public abstract String getPlatformType();

    @Override // cn.hzjizhun.admin.ad.report.BaseReport
    public List<String> getReportUrl() {
        List<ReportInfoBean> list = this.reportInfoList;
        if (list == null || list.size() <= 0) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (ReportInfoBean reportInfoBean : this.reportInfoList) {
            if (reportInfoBean != null) {
                String strReplace = reportInfoBean.getReportUrl().replace("{os}", "android").replace("{channel}", this.platformType).replace("{appid}", this.posInfo.getAppid()).replace("{posid}", this.posInfo.getPosId()).replace("{bid}", this.posInfo.getReqId()).replace("{price}", this.price).replace("{mprice}", getMPrice(this.price)).replace("{thirdappid}", this.posInfo.getThirdAppId()).replace("{thirdposid}", this.posInfo.getThirdPosId());
                if (strReplace.contains("{userid}")) {
                    ExtendChannel extendChannel = this.extendChannel;
                    if (extendChannel != null) {
                        strReplace = strReplace.replace("{userid}", extendChannel.getUserid());
                    } else {
                        String str = this.sceneUserId;
                        strReplace = (str == null || str.length() <= 0) ? strReplace.replace("{userid}", "") : strReplace.replace("{userid}", this.sceneUserId);
                    }
                }
                linkedList.add(strReplace);
            }
        }
        return linkedList;
    }

    public void requestReport() {
        if (this.isRequest) {
            return;
        }
        this.isRequest = true;
        ALog.d(this.TAG, this.platformType + " request report");
        doReport("request");
    }

    public void requestSuccessReport() {
        if (this.isRequestSuccess) {
            return;
        }
        this.isRequestSuccess = true;
        ALog.d(this.TAG, this.platformType + " request success report");
        doReport("request-success");
    }

    public void setScenesParams(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        if (map.containsKey("userid")) {
            this.sceneUserId = map.get("userid");
            return;
        }
        if (map.containsKey("userId")) {
            this.sceneUserId = map.get("userId");
        } else if (map.containsKey("UserId")) {
            this.sceneUserId = map.get("UserId");
        } else if (map.containsKey(PtgRewardConstant.REWARD_PARAMS.USER_ID)) {
            this.sceneUserId = map.get(PtgRewardConstant.REWARD_PARAMS.USER_ID);
        }
    }
}
