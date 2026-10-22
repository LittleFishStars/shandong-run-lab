package com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad;

import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ASNPJsonResponseModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.bid.BiddingModel3;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.creative.CreativeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.event.EventModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.notify.NotifyPropModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.ReportModel3;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.reward.RewardPropModel;
import com.beizi.fusion.kg;
import com.beizi.fusion.mg;
import com.beizi.fusion.qh;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdItemModel extends ASNPJsonResponseModel {
    public static final String DEFAULT_EVENT_TAG = "DEFAULT_EVENT";
    private static final String JSON_KEY_EVENT = "event";
    private String adnTraceTag;

    @kg(key = "bid")
    private BiddingModel3 bid;

    @kg(key = "bidId")
    private String bidId;

    @kg(key = "bindId")
    private String bindId;

    @kg(key = "category")
    private String category;

    @kg(key = "childAds")
    private List<AdItemModel> childAds;

    @kg(key = "creative")
    private CreativeModel creativeModel;

    @kg(key = "cur")
    private String cur;

    @kg(key = "dspId")
    private String dspId;

    @kg(key = "event")
    private List<EventModel> eventModels;

    @kg(key = "exp")
    private long exp;

    @kg(key = "native")
    private NativeModel nativeModel;

    @kg(key = "notify")
    private NotifyPropModel notify;

    @kg(key = "orderId")
    private String orderId;

    @kg(key = "parseTime")
    private long parseTime;

    @kg(key = "renderType")
    private int renderType;

    @kg(key = "report")
    private ReportModel3 report;

    @kg(key = "reqId")
    private String reqId;

    @kg(key = "rw")
    private RewardPropModel rewardPropModel;

    public static class AdItemModelWrapper extends AdItemModel {
        public AdItemModelWrapper(JSONObject jSONObject) {
            super(jSONObject);
        }

        public void recoverMonitor(List<EventModel> list) {
            ((AdItemModel) this).eventModels = list;
        }

        public void updateWrapperBasicInfo(String str, String str2) {
            ((AdItemModel) this).bindId = str;
            ((AdItemModel) this).category = str2;
        }

        public void updateWrapperNative(NativeModel nativeModel) {
            ((AdItemModel) this).nativeModel = nativeModel;
        }

        public void updateWrapperNotify(NotifyPropModel notifyPropModel) {
            ((AdItemModel) this).notify = notifyPropModel;
        }
    }

    public AdItemModel(JSONObject jSONObject) {
        super(jSONObject);
        this.parseTime = 0L;
        this.parseTime = System.currentTimeMillis();
    }

    private String generateAdnTraceTag() {
        JSONArray jSONArrayA;
        JSONObject jSONObject = this.mJsonObject;
        return (jSONObject == null || (jSONArrayA = mg.a(jSONObject, "event")) == null) ? qh.a(DEFAULT_EVENT_TAG) : qh.a(jSONArrayA.toString());
    }

    public String getAdnTraceTag() {
        if (TextUtils.isEmpty(this.adnTraceTag)) {
            this.adnTraceTag = generateAdnTraceTag();
        }
        return this.adnTraceTag;
    }

    public String getBidId() {
        return this.bidId;
    }

    public BiddingModel3 getBiddingModel() {
        return this.bid;
    }

    public String getBindId() {
        return this.bindId;
    }

    public String getCategory() {
        return this.category;
    }

    public List<AdItemModel> getChildAds() {
        return this.childAds;
    }

    public CreativeModel getCreativeModel() {
        return this.creativeModel;
    }

    public String getCur() {
        return this.cur;
    }

    public String getDspId() {
        return this.dspId;
    }

    public List<EventModel> getEventModels() {
        return this.eventModels;
    }

    public long getExpired() {
        return this.exp + this.parseTime;
    }

    public NativeModel getNativeModel() {
        return this.nativeModel;
    }

    public NotifyPropModel getNotifyProp() {
        return this.notify;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public int getRenderType() {
        return this.renderType;
    }

    public ReportModel3 getReport() {
        return this.report;
    }

    public String getReqId() {
        return this.reqId;
    }

    public RewardPropModel getRewardPropModel() {
        return this.rewardPropModel;
    }

    public boolean isIndependentAd() {
        NativeModel nativeModel = this.nativeModel;
        return (nativeModel == null || nativeModel.getAsset() == null || this.nativeModel.getAsset().isEmpty()) ? false : true;
    }
}
