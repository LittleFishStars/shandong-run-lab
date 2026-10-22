package cn.hzjizhun.admin.api.bean;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ReportInfoBean implements Serializable {
    private String appId;
    private String id;
    private String platformType;
    private String reportUrl;

    public static ReportInfoBean toBean(String str) {
        ReportInfoBean reportInfoBean = new ReportInfoBean();
        try {
            JSONObject jSONObject = new JSONObject(str);
            reportInfoBean.reportUrl = jSONObject.optString("url");
            reportInfoBean.platformType = jSONObject.optString("type");
            reportInfoBean.appId = jSONObject.optString("appid");
            reportInfoBean.id = jSONObject.optString("id");
        } catch (Throwable unused) {
        }
        return reportInfoBean;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getId() {
        return this.id;
    }

    public String getPlatformType() {
        return this.platformType;
    }

    public String getReportUrl() {
        return this.reportUrl;
    }

    public String toString() {
        return "ReportInfoBean{reportUrl='" + this.reportUrl + "', platformType='" + this.platformType + "', appId='" + this.appId + "', id='" + this.id + "'}";
    }
}
