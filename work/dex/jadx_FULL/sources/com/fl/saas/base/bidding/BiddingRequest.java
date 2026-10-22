package com.fl.saas.base.bidding;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alipay.sdk.m.n.b;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.custom.MedProConst;
import com.fl.saas.base.rest.ConfigHelper;
import com.fl.saas.base.type.AdType;
import com.fl.saas.base.widget.JsonUtil;
import com.fl.saas.common.listener.SdkBidListener;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class BiddingRequest {
    private final String key;
    private final BiddingLoadEvent mBiddingLoadEvent;
    private final Context mContext;

    public interface BiddingLoadEvent {
        void onFailed(YdError ydError);

        void onStart();

        void onSucc(@NonNull AdSource adSource, Object obj);
    }

    public BiddingRequest(String str, Context context, BiddingLoadEvent biddingLoadEvent) {
        this.key = str;
        this.mContext = context;
        this.mBiddingLoadEvent = biddingLoadEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reqSdkBidAd$0(boolean[] zArr, AdSource adSource, String str, boolean[] zArr2, AdPlace adPlace, Map map, AdSource adSource2) {
        zArr[0] = false;
        adSource.tagid = str;
        if (zArr2[0]) {
            requestSDKBid(adPlace, map);
        }
    }

    public void reqSdkBidAd(AdType adType, final AdPlace adPlace) {
        BiddingRequest biddingRequest = this;
        boolean z = true;
        final boolean[] zArr = new boolean[1];
        char c = 0;
        zArr[0] = false;
        final boolean[] zArr2 = new boolean[1];
        zArr2[0] = false;
        final HashMap map = new HashMap();
        for (final AdSource adSource : adPlace.bid_ad_sources) {
            adSource.isSDKBidAd = z;
            Bidding biddingLoadBiddingHandle = BiddingManager.getInstance().loadBiddingHandle(adType, adSource.adv_id);
            if (biddingLoadBiddingHandle != null) {
                if (biddingLoadBiddingHandle instanceof BiddingHandle) {
                    try {
                        ((BiddingHandle) biddingLoadBiddingHandle).handleBiddingSource(biddingRequest.mContext, adSource);
                        if ((biddingLoadBiddingHandle instanceof AdapterAPI) || (biddingLoadBiddingHandle instanceof MixNativeHandler)) {
                            map.put(Integer.valueOf(adSource.adv_id), biddingLoadBiddingHandle);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    if (biddingLoadBiddingHandle instanceof GLXHBiddingHandle) {
                        zArr2[c] = z;
                        final String str = adSource.tagid;
                        String str2 = adSource.customParameJson;
                        if (str2 != null) {
                            String str3 = (String) JsonUtil.jsonObjectToMap(str2).get(MedProConst.AD_PLACEID);
                            if (!TextUtils.isEmpty(str3)) {
                                adSource.tagid = str3;
                            }
                        }
                        ((GLXHBiddingHandle) biddingLoadBiddingHandle).handleBiddingSource(biddingRequest.mContext, adSource, new GLXHBiddingHandle.Callback() { // from class: com.zj.adlib.fv0
                            @Override // com.fl.saas.base.bidding.GLXHBiddingHandle.Callback
                            public final void onFinish(AdSource adSource2) {
                                this.f41761a.lambda$reqSdkBidAd$0(zArr2, adSource, str, zArr, adPlace, map, adSource2);
                            }
                        });
                        z = true;
                        c = 0;
                    }
                    biddingRequest = this;
                }
            }
        }
        char c2 = c;
        zArr[c2] = z;
        if (zArr2[c2]) {
            return;
        }
        requestSDKBid(adPlace, map);
    }

    public void requestSDKBid(final AdPlace adPlace, final Map<Integer, Object> map) {
        this.mBiddingLoadEvent.onStart();
        ConfigHelper.getInstance().reqSDKBid(adPlace.bid_ad_sources, this.key, adPlace.req_id, adPlace.api_timeout, new SdkBidListener() { // from class: com.fl.saas.base.bidding.BiddingRequest.1
            @Override // com.fl.saas.common.listener.SdkBidListener
            public void onFailed(String str) {
                LogcatUtil.d("YdSDK-Manager", "reqSDKBid onFailed:" + str);
                BiddingRequest.this.mBiddingLoadEvent.onFailed(YdError.create(20410, "sdk bidding error:" + str));
            }

            @Override // com.fl.saas.common.listener.SdkBidListener
            public void onSuccess(JSONObject jSONObject) {
                if (TextUtils.isEmpty(jSONObject.optString("token"))) {
                    LogcatUtil.d("YdSDK-Manager", "reqSDKBid onFailed:token is null");
                    if (!TextUtils.isEmpty(jSONObject.optString("nbr"))) {
                        LogcatUtil.d("YdSDK-Manager", "reqSDKBid onFailed:" + jSONObject.optString("nbr"));
                    }
                    BiddingRequest.this.mBiddingLoadEvent.onFailed(YdError.create(20410, "sdk bidding token is null"));
                    return;
                }
                AdSource adSource = new AdSource();
                adSource.isSDKBidAd = true;
                adSource.adv_id = jSONObject.optInt("adv_id");
                adSource.mAdv_id = jSONObject.optInt("adv_id");
                adSource.app_id = jSONObject.optString("app_id");
                adSource.app_key = jSONObject.optString(b.h);
                adSource.slot_id = jSONObject.optString("slot_id");
                adSource.req_id = jSONObject.optString("id");
                adSource.place_id = adPlace.place_id;
                adSource.bidfloor = jSONObject.optInt("price");
                adSource.price = jSONObject.optInt("price");
                adSource.tagid = jSONObject.optString("tagid");
                adSource.mTagid = jSONObject.optString("tagid");
                adSource.token = jSONObject.optString("token");
                AdPlace adPlace2 = adPlace;
                adSource.group_id = adPlace2.group_id;
                adSource.test_id = adPlace2.test_id;
                adSource.track_id = adPlace2.track_id;
                adSource.nurl = jSONObject.optString("nurl");
                adSource.lurl = jSONObject.optString("lurl");
                for (AdSource adSource2 : adPlace.bid_ad_sources) {
                    if (adSource.equalsAD(adSource2)) {
                        adSource2.copyAdConfig(adSource);
                        break;
                    }
                }
                BiddingRequest.this.mBiddingLoadEvent.onSucc(adSource, map.get(Integer.valueOf(adSource.adv_id)));
            }
        });
    }
}
