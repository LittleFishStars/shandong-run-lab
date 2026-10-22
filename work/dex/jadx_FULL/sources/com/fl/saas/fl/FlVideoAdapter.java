package com.fl.saas.fl;

import android.app.Activity;
import com.fl.saas.adx.api.FLVideo;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.interfaces.AdViewVideoListener;
import com.fl.saas.base.adapter.AdViewVideoAdapter;
import com.fl.saas.base.annotation.Advertiser;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.bidding.BiddingResult;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.fl.config.FlAdManagerHolder;
import com.fl.spi.SPI;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Advertiser(keyClass = {FLVideo.class}, value = 22)
@SPI({AdapterAPI.class})
public class FlVideoAdapter extends AdViewVideoAdapter implements BiddingResult {
    private static final String TAG = CommConstant.getClassTag("FL", FlVideoAdapter.class);
    private FLVideo rewardVideoAD;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showRewardVideo$0(Activity activity) {
        FLVideo fLVideo = this.rewardVideoAD;
        if (fLVideo != null) {
            fLVideo.show();
        } else {
            onAdFailed(new YdError(20407, "成功加载广告后再进行广告展示！"));
        }
    }

    @Override // com.fl.saas.base.bidding.BiddingResult
    public void biddingResult(final boolean z, final int i, final int i2, int i3) {
        Optional.ofNullable(this.rewardVideoAD).ifPresent(new Consumer() { // from class: com.zj.adlib.fi3
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                ((FLVideo) obj).biddingResultUpload(z, i, i2);
            }
        });
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter, com.fl.saas.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (this.rewardVideoAD == null || isCache()) {
            return;
        }
        this.rewardVideoAD.destroy();
        this.rewardVideoAD = null;
    }

    @Override // com.fl.saas.base.adapter.base.BaseAdAdapter
    public void handle(Activity activity) {
        String str = TAG;
        LogcatUtil.d(str, "handle");
        FlAdManagerHolder.init(getContext(), getAppId());
        FLVideo fLVideoBuild = new FLVideo.Builder(activity).setKey(getPosId()).setLinkId(getAdSource().req_id).setVideoListener(new AdViewVideoListener() { // from class: com.fl.saas.fl.FlVideoAdapter.1
            @Override // com.fl.saas.adx.base.base.listener.InnerVideoListener
            public void onAdClick(String str2) {
                LogcatUtil.d(FlVideoAdapter.TAG, "onAdClick");
                FlVideoAdapter.this.onClickedEvent();
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerVideoListener
            public void onAdClose() {
                LogcatUtil.d(FlVideoAdapter.TAG, "onAdClose");
                FlVideoAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.adx.base.interfaces.AdViewListener
            public void onAdFailed(FLError fLError) {
                FlVideoAdapter.this.disposeError(new YdError(fLError.getCode(), fLError.getMsg()));
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerVideoListener
            public void onAdShow() {
                LogcatUtil.d(FlVideoAdapter.TAG, "onAdShow");
                FlVideoAdapter.this.onShowEvent();
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerVideoListener
            public void onSkipVideo() {
                LogcatUtil.d(FlVideoAdapter.TAG, "onSkipVideo");
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerVideoListener
            public void onVideoCompleted() {
                LogcatUtil.d(FlVideoAdapter.TAG, "onVideoCompleted");
                FlVideoAdapter.this.onVideoCompletedEvent();
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerVideoListener
            public void onVideoPrepared() {
                LogcatUtil.d(FlVideoAdapter.TAG, "onVideoPrepared");
                if (FlVideoAdapter.this.rewardVideoAD != null) {
                    if (FlVideoAdapter.this.getAdSource().isC2SBidAd) {
                        FlVideoAdapter flVideoAdapter = FlVideoAdapter.this;
                        flVideoAdapter.setECPM(flVideoAdapter.rewardVideoAD.getECPM());
                    }
                    FlVideoAdapter.this.onLoadedEvent();
                }
            }

            @Override // com.fl.saas.adx.base.base.listener.InnerVideoListener
            public void onVideoReward(double d) {
                LogcatUtil.d(FlVideoAdapter.TAG, "onVideoReward");
                FlVideoAdapter.this.onRewardEvent();
            }
        }).build();
        this.rewardVideoAD = fLVideoBuild;
        fLVideoBuild.requestRewardVideo();
        LogcatUtil.d(str, TrackLoadSettingsAtom.TYPE);
    }

    @Override // com.fl.saas.base.adapter.AdViewVideoAdapter
    public void showRewardVideo() {
        LogcatUtil.d(TAG, "showRewardVideo");
        getActivityValid().ifPresent(new Consumer() { // from class: com.zj.adlib.gi3
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f41912a.lambda$showRewardVideo$0((Activity) obj);
            }
        });
    }
}
