package com.fl.saas.s2s.topon;

import android.content.Context;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.ATBiddingNotice;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.fl.saas.api.AdParams;
import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.api.mixNative.NativeLoadListener;
import com.fl.saas.base.custom.MedProConst;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.api.YdSDK;
import com.igexin.assist.sdk.AssistPushConsts;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLTopOnNativeAdapter extends CustomNativeAdapter implements ATBiddingNotice {
    private static final String TAG = CommConstant.getClassTag("FL", FLTopOnNativeAdapter.class);
    private Context mContext;
    private NativeAd nativeAd;
    private String slotId;

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoad(final ATBiddingListener aTBiddingListener, Map<String, Object> map, int i) {
        int i2;
        int i3;
        LogcatUtil.d(TAG, "startLoad");
        if (map != null) {
            Object obj = map.containsKey(MedProConst.AD_WIDTH) ? map.get(MedProConst.AD_WIDTH) : null;
            Object obj2 = map.containsKey(MedProConst.AD_HEIGHT) ? map.get(MedProConst.AD_HEIGHT) : null;
            if (i == 1) {
                i3 = 690;
                i2 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT;
            } else if (i == 2) {
                i3 = 228;
                i2 = 150;
            } else {
                i2 = 0;
                try {
                    i3 = ((obj instanceof Integer) || (obj instanceof String)) ? Integer.parseInt(obj.toString()) : 0;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    if ((obj2 instanceof Integer) || (obj2 instanceof String)) {
                        i2 = Integer.parseInt(obj2.toString());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            int iPx2dip = DeviceUtil.px2dip(i3);
            int iPx2dip2 = DeviceUtil.px2dip(i2);
            if (iPx2dip <= 0 || iPx2dip2 <= 0) {
                iPx2dip = DeviceUtil.px2dip(DeviceUtil.getMobileWidth());
                iPx2dip2 = 80;
            }
            YdSDK.loadMixNative(this.mContext, new AdParams.Builder(this.slotId).setExpressHeight(iPx2dip2).setExpressWidth(iPx2dip).build(), new NativeLoadListener() { // from class: com.fl.saas.s2s.topon.FLTopOnNativeAdapter.2
                @Override // com.fl.saas.base.interfaces.AdViewListener
                public void onAdFailed(YdError ydError) {
                    if (FLTopOnNativeAdapter.this.mLoadListener != null) {
                        FLTopOnNativeAdapter.this.mLoadListener.onAdLoadError("", ydError.toString());
                    }
                    ATBiddingListener aTBiddingListener2 = aTBiddingListener;
                    if (aTBiddingListener2 != null) {
                        aTBiddingListener2.onC2SBiddingResultWithCache(ATBiddingResult.fail(ydError.toString()), (BaseAd) null);
                    }
                }

                @Override // com.fl.saas.api.mixNative.NativeLoadListener
                public void onNativeAdLoaded(NativeAd nativeAd) {
                    BaseAd fLTopOnMixNativeAd = new FLTopOnMixNativeAd(FLTopOnNativeAdapter.this.mContext, nativeAd);
                    if (FLTopOnNativeAdapter.this.mLoadListener != null) {
                        FLTopOnNativeAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[]{fLTopOnMixNativeAd});
                    }
                    if (aTBiddingListener != null) {
                        String str = System.currentTimeMillis() + "";
                        FLTopOnInitManager.getInstance().putBidAdObject(str, nativeAd);
                        aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.success(nativeAd.getECPM() == 0 ? AudioStats.AUDIO_AMPLITUDE_NONE : ((double) nativeAd.getECPM()) / 100.0d, str, (ATBiddingNotice) null, ATAdConst.CURRENCY.RMB), fLTopOnMixNativeAd);
                    }
                }
            });
        }
    }

    public void destory() {
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            nativeAd.destroy();
            this.nativeAd = null;
        }
    }

    public String getNetworkName() {
        return FLTopOnInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.slotId;
    }

    public String getNetworkSDKVersion() {
        return FLTopOnInitManager.getInstance().getNetworkVersion();
    }

    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB;
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, final Map<String, Object> map2) {
        final int i;
        ATCustomLoadListener aTCustomLoadListener;
        String str;
        LogcatUtil.d(TAG, "loadCustomNetworkAd");
        this.mContext = context;
        this.slotId = (String) map.get("slot_id");
        try {
            i = map.containsKey("media_size") ? Integer.parseInt(map.get("media_size").toString()) : 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(this.slotId)) {
            if (this.mLoadListener == null) {
                return;
            }
            aTCustomLoadListener = this.mLoadListener;
            str = "slot_id is empty!";
        } else {
            if (!map.containsKey(AssistPushConsts.MSG_TYPE_PAYLOAD)) {
                FLTopOnInitManager.getInstance().initSDK(context, map, new FLTopOnInitManager.InitCallback() { // from class: com.fl.saas.s2s.topon.FLTopOnNativeAdapter.3
                    @Override // com.fl.saas.s2s.topon.FLTopOnInitManager.InitCallback
                    public void onFinish() {
                        FLTopOnNativeAdapter.this.startLoad(null, map2, i);
                    }
                });
                return;
            }
            String str2 = (String) map.get(AssistPushConsts.MSG_TYPE_PAYLOAD);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            Object objPopBidAdObject = FLTopOnInitManager.getInstance().popBidAdObject(str2);
            if (objPopBidAdObject instanceof NativeAd) {
                if (this.nativeAd == null) {
                    this.nativeAd = (NativeAd) objPopBidAdObject;
                }
                if (this.mLoadListener != null) {
                    this.mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    return;
                }
                return;
            }
            if (this.mLoadListener == null) {
                return;
            }
            aTCustomLoadListener = this.mLoadListener;
            str = "FL: Bidding Cache is empty.";
        }
        aTCustomLoadListener.onAdLoadError("", str);
    }

    public void notifyBidDisplay(boolean z, double d) {
    }

    public void notifyBidLoss(String str, double d, Map<String, Object> map) {
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            nativeAd.biddingResultUpload(false, (int) (d * 100.0d), 0);
        }
    }

    public void notifyBidWin(double d, double d2, Map<String, Object> map) {
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            nativeAd.biddingResultUpload(true, (int) (d * 100.0d), (int) (d2 * 100.0d));
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, final Map<String, Object> map2, final ATBiddingListener aTBiddingListener) {
        final int i;
        LogcatUtil.d(TAG, "startBiddingRequest");
        this.mContext = context;
        this.slotId = (String) map.get("slot_id");
        try {
            i = map.containsKey("media_size") ? Integer.parseInt(map.get("media_size").toString()) : 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.slotId)) {
            FLTopOnInitManager.getInstance().initSDK(context, map, new FLTopOnInitManager.InitCallback() { // from class: com.fl.saas.s2s.topon.FLTopOnNativeAdapter.1
                @Override // com.fl.saas.s2s.topon.FLTopOnInitManager.InitCallback
                public void onFinish() {
                    FLTopOnNativeAdapter.this.startLoad(aTBiddingListener, map2, i);
                }
            });
            return true;
        }
        LogcatUtil.d(TAG, "slot_id is empty!");
        if (this.mLoadListener != null) {
            this.mLoadListener.onAdLoadError("", "slot_id is empty!");
        }
        if (aTBiddingListener == null) {
            return true;
        }
        aTBiddingListener.onC2SBiddingResultWithCache(ATBiddingResult.fail("slot_id is empty!"), (BaseAd) null);
        return true;
    }
}
