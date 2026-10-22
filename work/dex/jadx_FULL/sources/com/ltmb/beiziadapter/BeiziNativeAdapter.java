package com.ltmb.beiziadapter;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.core.load.draw.LTAdDrawLoadListener;
import com.ltmb.ltsdk.core.load.draw.LTAdDrawNativeEventListener;
import com.ltmb.ltsdk.core.load.draw.LTDrawAd;
import com.ltmb.ltsdk.core.load.slot.LTAdSlot;
import java.util.ArrayList;
import java.util.List;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdAdapterListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdExpressListener;
import xyz.adscope.amps.ad.nativead.adapter.AMPSNativeAdapter;
import xyz.adscope.amps.ad.nativead.inter.AMPSNativeAdExpressInfo;
import xyz.adscope.amps.common.AMPSError;
import xyz.adscope.amps.init.inter.IAMPSChannelInitCallBack;
import xyz.adscope.amps.inner.AMPSAdBiddingListener;
import xyz.adscope.amps.model.AMPSAdapterModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class BeiziNativeAdapter extends AMPSNativeAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LTDrawAd f40245a;
    public AMPSNativeAdExpressListener b;
    public final AMPSNativeAdExpressInfo c = new AMPSNativeAdExpressInfo() { // from class: com.ltmb.beiziadapter.BeiziNativeAdapter.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FrameLayout f40246a;

        public void destroy() {
            try {
                if (BeiziNativeAdapter.this.f40245a != null) {
                    BeiziNativeAdapter.this.f40245a.destroy();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public int getECPM() {
            if (BeiziNativeAdapter.this.f40245a != null) {
                return (int) BeiziNativeAdapter.this.f40245a.getEcpm();
            }
            return 0;
        }

        public View getNativeExpressAdView() {
            return this.f40246a;
        }

        public void render() {
            if (BeiziNativeAdapter.this.f40245a == null) {
                if (BeiziNativeAdapter.this.b != null) {
                    BeiziNativeAdapter.this.b.onRenderFail((View) null, "信息流广告为空", 0);
                    return;
                }
                return;
            }
            if (this.f40246a == null) {
                this.f40246a = new FrameLayout(((AMPSNativeAdapter) BeiziNativeAdapter.this).mContext);
                BeiziNativeAdapter.this.f40245a.showAd(this.f40246a);
            }
            if (BeiziNativeAdapter.this.b != null) {
                BeiziNativeAdapter.this.f40245a.setLTAdEventListener(new LTAdDrawNativeEventListener() { // from class: com.ltmb.beiziadapter.BeiziNativeAdapter.1.1
                    public void onAdClicked() {
                        if (BeiziNativeAdapter.this.b != null) {
                            BeiziNativeAdapter.this.b.onAdClicked();
                        }
                        BeiziNativeAdapter.this.onAdClicked();
                    }

                    public void onAdRenderFail(int i, String str) {
                        if (BeiziNativeAdapter.this.b != null) {
                            BeiziNativeAdapter.this.b.onRenderFail(AnonymousClass1.this.f40246a, str, i);
                        }
                        BeiziNativeAdapter.this.onAdFailed(String.valueOf(i), str);
                    }

                    public void onAdShow() {
                        if (BeiziNativeAdapter.this.b != null) {
                            BeiziNativeAdapter.this.b.onAdShow();
                        }
                        BeiziNativeAdapter.this.onAdShow();
                    }

                    public void onClosed() {
                        if (BeiziNativeAdapter.this.b != null) {
                            BeiziNativeAdapter.this.b.onAdClosed(AnonymousClass1.this.f40246a);
                        }
                        BeiziNativeAdapter.this.onAdDismiss();
                    }
                });
                if (BeiziNativeAdapter.this.b != null) {
                    AMPSNativeAdExpressListener aMPSNativeAdExpressListener = BeiziNativeAdapter.this.b;
                    FrameLayout frameLayout = this.f40246a;
                    aMPSNativeAdExpressListener.onRenderSuccess(frameLayout, frameLayout.getWidth(), this.f40246a.getHeight());
                }
            }
        }

        public void setAMPSNativeAdExpressListener(AMPSNativeAdExpressListener aMPSNativeAdExpressListener) {
            BeiziNativeAdapter.this.b = aMPSNativeAdExpressListener;
        }
    };

    private void initSDK() {
        BeiziInitAdapter.getInstance().initSDK(((AMPSNativeAdapter) this).mInitAdapterConfig, new IAMPSChannelInitCallBack() { // from class: com.ltmb.beiziadapter.BeiziNativeAdapter.2
            public void failCallBack(AMPSError aMPSError) {
                BeiziNativeAdapter.this.onAdFailed(aMPSError.getCode(), aMPSError.getMessage());
            }

            public void successCallBack() {
                BeiziNativeAdapter.this.loadAd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd() {
        LTAdSdk.getInstance().getLTAdDrawLoader(new LTAdSlot.Builder().setAdId(((AMPSNativeAdapter) this).mSpaceId).setAdCount(1).setRequestAdSize(BeiziAdapterSizeUtils.getWidth(((AMPSNativeAdapter) this).mContext), BeiziAdapterSizeUtils.getHeight(((AMPSNativeAdapter) this).mContext)).build(), new LTAdDrawLoadListener() { // from class: com.ltmb.beiziadapter.BeiziNativeAdapter.3
            public void onAdLoadFailed(int i, String str) {
                BeiziNativeAdapter.this.onAdFailed(String.valueOf(i), str);
            }

            public void onLoaded(LTDrawAd lTDrawAd) {
                if (lTDrawAd == null) {
                    BeiziNativeAdapter.this.onAdFailed("0", "广告为空");
                    return;
                }
                BeiziNativeAdapter.this.f40245a = lTDrawAd;
                BeiziNativeAdapter beiziNativeAdapter = BeiziNativeAdapter.this;
                if (((AMPSNativeAdapter) beiziNativeAdapter).isBidding) {
                    beiziNativeAdapter.onC2SBiddingSuccess((int) lTDrawAd.getEcpm());
                } else {
                    beiziNativeAdapter.onAdLoad();
                }
            }
        });
    }

    public List<AMPSNativeAdExpressInfo> getNativeListInfo() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.c);
        return arrayList;
    }

    public boolean isValid() {
        LTDrawAd lTDrawAd = this.f40245a;
        return (lTDrawAd == null || !lTDrawAd.isReady() || this.f40245a.isDestroy()) ? false : true;
    }

    public void startBid(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSAdBiddingListener aMPSAdBiddingListener) {
        super.startBid(context, aMPSAdapterModel, aMPSAdBiddingListener);
        initSDK();
    }

    public void loadNetworkAd(Context context, AMPSAdapterModel aMPSAdapterModel, AMPSNativeAdAdapterListener aMPSNativeAdAdapterListener) {
        super.loadNetworkAd(context, aMPSAdapterModel, aMPSNativeAdAdapterListener);
        if (((AMPSNativeAdapter) this).isBidding) {
            onAdLoad();
        } else {
            initSDK();
        }
    }
}
