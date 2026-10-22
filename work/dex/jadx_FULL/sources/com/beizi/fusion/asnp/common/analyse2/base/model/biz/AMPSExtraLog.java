package com.beizi.fusion.asnp.common.analyse2.base.model.biz;

import com.beizi.fusion.j2;
import com.beizi.fusion.kg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AMPSExtraLog extends AnalyseAdEventLog {

    @kg(key = "ad_info")
    private List<AMPSExtraAdInfoLog> adInfoList;

    @kg(key = "ad_view_request_id")
    private String adViewRequestID;

    @kg(key = "browse_time")
    private String browseTime;

    @kg(key = "s_custom_data")
    private String customData;

    @kg(key = "ecpm")
    private String ecpm;

    @kg(key = "entry_price")
    private String entryPrice;

    @kg(key = "floor_price")
    private String floorPrice;

    @kg(key = "first_order_price")
    private String fop;

    @kg(key = "is_peak")
    private String isPeak;

    @kg(key = "bid_seat_id")
    private String mBidSeatID;

    @kg(key = "bid_space_id")
    private String mBidSpaceID;

    @kg(key = "bid_type")
    private String mBidType;

    @kg(key = "s_app_id")
    private String mChannelAppID;

    @kg(key = "s_space_id")
    private String mChannelSpaceID;

    @kg(key = "is_hit_auction")
    private String mHitAuction;

    @kg(key = "is_last_look")
    private String mLastLook;

    @kg(key = "load_type")
    private String mLoadType;

    @kg(key = "loss_reason")
    private String mLossReason;

    @kg(key = "minor")
    private String mMinor;

    @kg(key = "notice_price")
    private String mNoticePrice;

    @kg(key = "real_price")
    private String mRealPrice;

    @kg(key = "seat_id")
    private String mSeatID;

    @kg(key = "s_time_out")
    private String mTimeout;

    @kg(key = "peak_space_id")
    private String peakSpaceID;

    @kg(key = "request_uuid")
    private String requestUUID;

    @kg(key = "second_order_price")
    private String sop;

    public static class AMPSAnalyseAdEventLogWrapper extends AnalyseSimpleLog.AnalyseSimpleLogWrapper implements j2.a {

        @kg(key = "ad_info")
        private List<AMPSExtraAdInfoLog.AMPSExtraAdInfoLogWrapper> adInfoList;

        @kg(key = "ad_view_request_id")
        private String adViewRequestID;

        @kg(key = "browse_time")
        private String browseTime;

        @kg(key = "s_custom_data")
        private String customData;

        @kg(key = "ecpm")
        private String ecpm;

        @kg(key = "entry_price")
        private String entryPrice;

        @kg(key = "floor_price")
        private String floorPrice;

        @kg(key = "first_order_price")
        private String fop;

        @kg(key = "is_peak")
        private String isPeak;

        @kg(key = "bid_seat_id")
        private String mBidSeatID;

        @kg(key = "bid_space_id")
        private String mBidSpaceID;

        @kg(key = "bid_type")
        private String mBidType;

        @kg(key = "s_app_id")
        private String mChannelAppID;

        @kg(key = "s_space_id")
        private String mChannelSpaceID;

        @kg(key = "is_hit_auction")
        private String mHitAuction;

        @kg(key = "is_last_look")
        private String mLastLook;

        @kg(key = "load_type")
        private String mLoadType;

        @kg(key = "loss_reason")
        private String mLossReason;

        @kg(key = "minor")
        private String mMinor;

        @kg(key = "notice_price")
        private String mNoticePrice;

        @kg(key = "real_price")
        private String mRealPrice;

        @kg(key = "seat_id")
        private String mSeatID;

        @kg(key = "s_time_out")
        private String mTimeout;

        @kg(key = "peak_space_id")
        private String peakSpaceID;

        @kg(key = "request_uuid")
        private String requestUUID;

        @kg(key = "second_order_price")
        private String sop;

        public AMPSAnalyseAdEventLogWrapper(AMPSExtraLog aMPSExtraLog) {
            super(aMPSExtraLog);
            this.mChannelAppID = aMPSExtraLog.mChannelAppID;
            this.mChannelSpaceID = aMPSExtraLog.mChannelSpaceID;
            this.mSeatID = aMPSExtraLog.mSeatID;
            this.mTimeout = aMPSExtraLog.mTimeout;
            this.mBidType = aMPSExtraLog.mBidType;
            this.mLoadType = aMPSExtraLog.mLoadType;
            this.mHitAuction = aMPSExtraLog.mHitAuction;
            this.mLastLook = aMPSExtraLog.mLastLook;
            this.mNoticePrice = aMPSExtraLog.mNoticePrice;
            this.mLossReason = aMPSExtraLog.mLossReason;
            this.mRealPrice = aMPSExtraLog.mRealPrice;
            this.mBidSeatID = aMPSExtraLog.mBidSeatID;
            this.mBidSpaceID = aMPSExtraLog.mBidSpaceID;
            this.mMinor = aMPSExtraLog.mMinor;
            this.ecpm = aMPSExtraLog.ecpm;
            this.fop = aMPSExtraLog.fop;
            this.sop = aMPSExtraLog.sop;
            this.floorPrice = aMPSExtraLog.floorPrice;
            this.customData = aMPSExtraLog.customData;
            this.isPeak = aMPSExtraLog.isPeak;
            this.peakSpaceID = aMPSExtraLog.peakSpaceID;
            this.browseTime = aMPSExtraLog.browseTime;
            this.entryPrice = aMPSExtraLog.entryPrice;
            this.requestUUID = aMPSExtraLog.requestUUID;
            this.adViewRequestID = aMPSExtraLog.adViewRequestID;
            if (aMPSExtraLog.adInfoList != null) {
                ArrayList arrayList = new ArrayList();
                Iterator it = aMPSExtraLog.adInfoList.iterator();
                while (it.hasNext()) {
                    arrayList.add(((AMPSExtraAdInfoLog) it.next()).a());
                }
                this.adInfoList = arrayList;
            }
        }
    }

    public AMPSExtraLog(JSONObject jSONObject) {
        super(jSONObject);
    }

    @Override // com.beizi.fusion.asnp.common.analyse2.base.model.biz.AnalyseAdEventLog
    public j2.a c() {
        return new AMPSAnalyseAdEventLogWrapper(this);
    }
}
