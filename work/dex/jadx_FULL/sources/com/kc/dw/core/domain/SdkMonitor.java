package com.kc.dw.core.domain;

import androidx.core.app.NotificationCompat;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kc.openset.sdk.dsp.util.QdActivityType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SdkMonitor {
    private String clk;
    private String err;
    private String imp;
    private String req;
    private String rsp;

    public static SdkMonitor fromJson(String str) {
        SdkMonitor sdkMonitor = new SdkMonitor();
        try {
            JSONObject jSONObject = new JSONObject(str);
            sdkMonitor.setReq(jSONObject.optString(HiAnalyticsConstant.Direction.REQUEST));
            sdkMonitor.setRsp(jSONObject.optString(HiAnalyticsConstant.Direction.RESPONSE));
            sdkMonitor.setImp(jSONObject.optString(QdActivityType.IMP));
            sdkMonitor.setClk(jSONObject.optString("clk"));
            sdkMonitor.setErr(jSONObject.optString(NotificationCompat.CATEGORY_ERROR));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sdkMonitor;
    }

    public String getClk() {
        return this.clk;
    }

    public String getErr() {
        return this.err;
    }

    public String getImp() {
        return this.imp;
    }

    public String getReq() {
        return this.req;
    }

    public String getRsp() {
        return this.rsp;
    }

    public void setClk(String str) {
        this.clk = str;
    }

    public void setErr(String str) {
        this.err = str;
    }

    public void setImp(String str) {
        this.imp = str;
    }

    public void setReq(String str) {
        this.req = str;
    }

    public void setRsp(String str) {
        this.rsp = str;
    }
}
