package com.beizi.fusion.asnp.common.analyse2.base.model.biz;

import com.baidu.mapapi.SDKInitializer;
import com.beizi.fusion.asnp.common.analyse2.base.model.AnalyseBasicReceiveLog;
import com.beizi.fusion.gb;
import com.beizi.fusion.j2;
import com.beizi.fusion.kg;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AnalyseSimpleLog extends AnalyseBasicReceiveLog {

    @kg(key = SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE)
    private String error_code;

    @kg(key = "error_info")
    private String error_info;

    @kg(key = "beta_hits")
    private List<String> mBetaHits;

    @kg(key = HiAnalyticsConstant.BI_KEY_COST_TIME)
    private String mCostTime;

    @kg(key = "event_code")
    private String mEventCode;

    @kg(key = "event_id")
    private String mEventID;

    @kg(key = "event_time")
    private String mEventTime;

    @kg(key = "sample")
    private String mSample;

    public static class AnalyseSimpleLogWrapper extends gb implements j2.c {

        @kg(key = SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE)
        private String error_code;

        @kg(key = "error_info")
        private String error_info;

        @kg(key = "beta_hits")
        private List<String> mBetaHits;

        @kg(key = HiAnalyticsConstant.BI_KEY_COST_TIME)
        private String mCostTime;

        @kg(key = "event_code")
        private String mEventCode;

        @kg(key = "event_id")
        private String mEventID;

        @kg(key = "event_time")
        private String mEventTime;

        @kg(key = "sample")
        private String mSample;

        public AnalyseSimpleLogWrapper(AnalyseSimpleLog analyseSimpleLog) {
            this.mEventID = analyseSimpleLog.mEventID;
            this.mEventCode = analyseSimpleLog.mEventCode;
            this.mEventTime = analyseSimpleLog.mEventTime;
            this.mCostTime = analyseSimpleLog.mCostTime;
            this.error_code = analyseSimpleLog.error_code;
            this.error_info = analyseSimpleLog.error_info;
            this.mSample = analyseSimpleLog.mSample;
            this.mBetaHits = analyseSimpleLog.mBetaHits;
        }
    }

    public AnalyseSimpleLog(JSONObject jSONObject) {
        super(jSONObject);
    }

    public void a(String str) {
        this.mSample = str;
    }

    public String getEventCode() {
        return this.mEventCode;
    }

    public j2.c a() {
        return new AnalyseSimpleLogWrapper(this);
    }
}
