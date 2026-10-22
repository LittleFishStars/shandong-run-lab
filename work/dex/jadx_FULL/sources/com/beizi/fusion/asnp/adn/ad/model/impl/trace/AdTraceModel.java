package com.beizi.fusion.asnp.adn.ad.model.impl.trace;

import android.net.Uri;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.bid.BiddingModel3;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.creative.CreativeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule.CSensorModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.report.rule.TSensorModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;
import com.beizi.fusion.ba;
import com.beizi.fusion.d;
import com.beizi.fusion.f3;
import com.beizi.fusion.hf;
import com.beizi.fusion.n1;
import com.beizi.fusion.nn;
import com.beizi.fusion.s;
import com.beizi.fusion.tb;
import com.beizi.fusion.v;
import com.beizi.fusion.we;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdTraceModel implements tb {
    private boolean byCacheAd;
    private CSensorModel cSensorModel;
    private boolean callbackExposure;
    private boolean callbackShown;
    private String dspID;
    private final d mAdType;
    private String mBidResult;
    private String mCacheSession;
    private int mClickMonitorDelay;
    private String mComplain;
    private String mCreateID;
    private String mCurrency;
    private n1 mError;
    private String mInteractiveID;
    private int mInteractiveType;
    private String mMaterialID;
    private final long mMaxTimeout;
    private String mOrderID;
    private long mRecordExposureTime;
    private long mRecordShownTime;
    private final int mRequestCount;
    private long mRequestStartTs;
    private String mRequestTracSerialID;
    private String mSchemeID;
    private final String mSpaceID;
    private String mStrategyMD5;
    private String mWinPrice;
    private double price;
    private hf recorder;
    private List<we> sensorRecorderList;
    private Map<String, Object> switch4VInfo;
    private TSensorModel tSensorModel;
    private long videoDuration;
    private String videoExtCustomData;
    private String videoExtUserID;

    public AdTraceModel(ba baVar) {
        this.mRequestStartTs = -1L;
        this.mRecordShownTime = 0L;
        this.mRecordExposureTime = 0L;
        this.callbackExposure = false;
        this.callbackShown = false;
        this.mInteractiveType = -1;
        this.sensorRecorderList = new ArrayList();
        this.switch4VInfo = new HashMap();
        this.mAdType = baVar.b();
        this.mSpaceID = baVar.g();
        this.mRequestCount = baVar.a();
        this.mMaxTimeout = baVar.h();
        this.mRequestTracSerialID = nn.a();
        Map mapC = baVar.c();
        if (mapC != null) {
            this.videoExtUserID = s.a(mapC, "rwUserId");
            this.videoExtCustomData = Uri.encode(f3.c(s.a(mapC, "rwCustomData")));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$getSensorRecord$0(we weVar, we weVar2) {
        long jB = weVar.b();
        long jB2 = weVar2.b();
        if (jB == 0 && jB2 == 0) {
            return 0;
        }
        if (jB == 0) {
            return 1;
        }
        if (jB2 == 0) {
            return -1;
        }
        return Long.compare(jB, jB2);
    }

    private void parseBidInfo(AdItemModel adItemModel) {
        if (adItemModel != null) {
            BiddingModel3 biddingModel = adItemModel.getBiddingModel();
            if (biddingModel != null) {
                this.price = biddingModel.getPrice();
            }
            this.dspID = adItemModel.getDspId();
            this.mCacheSession = adItemModel.getReqId();
            this.mOrderID = adItemModel.getOrderId();
            CreativeModel creativeModel = adItemModel.getCreativeModel();
            if (creativeModel != null) {
                this.mCreateID = creativeModel.getCreativeId();
                this.mMaterialID = creativeModel.getMaterialID();
            }
            NativeModel nativeModel = adItemModel.getNativeModel();
            if (nativeModel != null) {
                this.mSchemeID = nativeModel.getRenderId();
                this.mInteractiveID = nativeModel.getInteractionId();
            }
        }
    }

    public synchronized void addSensorRecorder(we weVar) {
        this.sensorRecorderList.add(weVar);
    }

    public void bindBidModelInfo(AdItemModel adItemModel) {
        parseBidInfo(adItemModel);
    }

    public void bindInitConfigInfo(v vVar) {
        String string;
        List<String> listI = vVar.i();
        if (listI != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (String str : listI) {
                sb.append("\"");
                sb.append(str);
                sb.append("\"");
                sb.append(",");
            }
            sb.replace(sb.length() - 1, sb.length(), "]");
            string = sb.toString();
        } else {
            string = "[\"CNY\"]";
        }
        this.mCurrency = string;
    }

    public d getAdType() {
        return this.mAdType;
    }

    public String getBidResult() {
        return this.mBidResult;
    }

    public int getByCacheAd() {
        return this.byCacheAd ? 1 : 0;
    }

    public CSensorModel getCSensorModel() {
        return this.cSensorModel;
    }

    public String getCacheRequestTraceSessionID() {
        return this.mCacheSession;
    }

    public int getClickMonitorDelay() {
        return this.mClickMonitorDelay;
    }

    public String getComplain() {
        return this.mComplain;
    }

    public String getCreateID() {
        return this.mCreateID;
    }

    public String getCurrency() {
        return this.mCurrency;
    }

    public long getCurrentTripTime() {
        if (this.mRequestStartTs != -1) {
            return System.currentTimeMillis() - this.mRequestStartTs;
        }
        return -1L;
    }

    public String getDspID() {
        return this.dspID;
    }

    public int getErrorCode() {
        n1 n1Var = this.mError;
        if (n1Var != null) {
            return n1Var.b();
        }
        return -1;
    }

    public String getErrorMessage() {
        n1 n1Var = this.mError;
        return n1Var != null ? n1Var.c() : "";
    }

    public long getExposureTimestamp() {
        return this.mRecordExposureTime;
    }

    public String getInteractionID() {
        return this.mInteractiveID;
    }

    public int getInteractiveType() {
        return this.mInteractiveType;
    }

    public String getMaterialID() {
        return this.mMaterialID;
    }

    public long getMaxTimeout() {
        return this.mMaxTimeout;
    }

    public String getOrderID() {
        return this.mOrderID;
    }

    public double getPrice() {
        return this.price;
    }

    public int getRequestCount() {
        return this.mRequestCount;
    }

    public String getRequestTracSessionID() {
        return this.mRequestTracSerialID;
    }

    public String getSchemeID() {
        return this.mSchemeID;
    }

    public synchronized we.c getSensorRecord() {
        List<we> list = this.sensorRecorderList;
        if (list != null && !list.isEmpty()) {
            Collections.sort(this.sensorRecorderList, new Comparator() { // from class: com.zj.adlib.cw
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return AdTraceModel.lambda$getSensorRecord$0((we) obj, (we) obj2);
                }
            });
            we weVar = this.sensorRecorderList.get(0);
            if (weVar != null) {
                return weVar.a();
            }
        }
        return null;
    }

    public long getShownTimestamp() {
        return this.mRecordShownTime;
    }

    public String getSpaceID() {
        return this.mSpaceID;
    }

    public String getStrategyMD5() {
        return this.mStrategyMD5;
    }

    public Map<String, Object> getSwitch4VInfo() {
        return this.switch4VInfo;
    }

    public TSensorModel getTSensorModel() {
        return this.tSensorModel;
    }

    public long getVideoDuration() {
        return this.videoDuration;
    }

    public String getVideoExtCustomData() {
        return this.videoExtCustomData;
    }

    public String getVideoExtUserID() {
        return this.videoExtUserID;
    }

    public hf.b getViewRecorder() {
        hf hfVar = this.recorder;
        if (hfVar != null) {
            return hfVar.a();
        }
        return null;
    }

    public String getWinPrice() {
        return this.mWinPrice;
    }

    public boolean isCallbackExposure() {
        return this.callbackExposure;
    }

    public boolean isCallbackShown() {
        return this.callbackShown;
    }

    public void recordExposureTimestamp() {
        if (this.mRecordExposureTime == 0) {
            this.mRecordExposureTime = System.currentTimeMillis();
        }
    }

    public void recordShownTimestamp() {
        if (this.mRecordShownTime == 0) {
            this.mRecordShownTime = System.currentTimeMillis();
        }
    }

    public void setBidResult(String str) {
        this.mBidResult = str;
    }

    public void setByCacheAd(boolean z) {
        this.byCacheAd = z;
    }

    public void setCSensorModel(CSensorModel cSensorModel) {
        this.cSensorModel = cSensorModel;
    }

    public void setCallbackExposure() {
        this.callbackExposure = true;
    }

    public void setCallbackShown() {
        this.callbackShown = true;
    }

    public void setClickDelay(int i) {
        this.mClickMonitorDelay = i;
    }

    public void setComplain(String str) {
        this.mComplain = str;
    }

    public void setInteractiveType(int i) {
        this.mInteractiveType = i;
    }

    public void setRecorder(hf hfVar) {
        this.recorder = hfVar;
    }

    public void setRequestFailInfo(n1 n1Var) {
        this.mError = n1Var;
    }

    public void setRequestStartTs(long j) {
        this.mRequestStartTs = j;
    }

    public void setStrategyMD5(String str) {
        this.mStrategyMD5 = str;
    }

    public void setSwitch4VInfo(int i) {
        this.switch4VInfo.put("rollback4v", Integer.valueOf(i));
    }

    public void setTSensorModel(TSensorModel tSensorModel) {
        this.tSensorModel = tSensorModel;
    }

    public void setVideoDuration(long j) {
        this.videoDuration = j;
    }

    public void setWinPrice(String str) {
        this.mWinPrice = str;
    }

    public void updateS2SRequestSerialID(String str) {
        this.mRequestTracSerialID = str;
    }

    /* JADX INFO: renamed from: deepCopy, reason: merged with bridge method [inline-methods] */
    public AdTraceModel m165deepCopy() {
        return new AdTraceModel(this);
    }

    private AdTraceModel(AdTraceModel adTraceModel) {
        this.mRequestStartTs = -1L;
        this.mRecordShownTime = 0L;
        this.mRecordExposureTime = 0L;
        this.callbackExposure = false;
        this.callbackShown = false;
        this.mInteractiveType = -1;
        this.sensorRecorderList = new ArrayList();
        this.switch4VInfo = new HashMap();
        this.mAdType = adTraceModel.mAdType;
        this.mMaxTimeout = adTraceModel.mMaxTimeout;
        this.mRequestCount = adTraceModel.mRequestCount;
        this.mSpaceID = adTraceModel.mSpaceID;
        this.mRequestStartTs = adTraceModel.mRequestStartTs;
        this.mRequestTracSerialID = adTraceModel.mRequestTracSerialID;
        this.mRecordShownTime = adTraceModel.mRecordShownTime;
        this.mRecordExposureTime = adTraceModel.mRecordExposureTime;
        this.callbackExposure = adTraceModel.callbackExposure;
        this.callbackShown = adTraceModel.callbackShown;
        this.mMaterialID = adTraceModel.mMaterialID;
        this.mCurrency = adTraceModel.mCurrency;
        this.mComplain = adTraceModel.mComplain;
        this.mCreateID = adTraceModel.mCreateID;
        this.mOrderID = adTraceModel.mOrderID;
        this.mError = adTraceModel.mError;
        this.price = adTraceModel.price;
        this.dspID = adTraceModel.dspID;
        this.mInteractiveType = adTraceModel.mInteractiveType;
        this.mSchemeID = adTraceModel.mSchemeID;
        this.mWinPrice = adTraceModel.mWinPrice;
        this.mBidResult = adTraceModel.mBidResult;
        this.recorder = adTraceModel.recorder;
        this.sensorRecorderList = adTraceModel.sensorRecorderList;
        this.mClickMonitorDelay = adTraceModel.mClickMonitorDelay;
        this.mCacheSession = adTraceModel.mCacheSession;
        this.mStrategyMD5 = adTraceModel.mStrategyMD5;
        this.mInteractiveID = adTraceModel.mInteractiveID;
        this.tSensorModel = adTraceModel.tSensorModel;
        this.cSensorModel = adTraceModel.cSensorModel;
        this.videoExtCustomData = adTraceModel.videoExtCustomData;
        this.videoExtUserID = adTraceModel.videoExtUserID;
        this.byCacheAd = adTraceModel.byCacheAd;
        this.videoDuration = adTraceModel.videoDuration;
        this.switch4VInfo = adTraceModel.switch4VInfo;
    }
}
