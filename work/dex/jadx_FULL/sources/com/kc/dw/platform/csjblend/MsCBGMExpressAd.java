package com.kc.dw.platform.csjblend;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd;
import com.kc.dw.activity.a;
import com.kc.dw.core.ad.recycler.ExpressMediaListener;
import com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener;
import com.kc.dw.core.ad.recycler.RecyclerAdData;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCBGMExpressAd extends MediationCustomNativeAd {
    private static final String TAG = "MsCBGMExpressAd";
    private RecyclerAdData adData;
    private Context context;
    private View mExpressView;

    public MsCBGMExpressAd(Context context, RecyclerAdData recyclerAdData) {
        this.context = context;
        this.adData = recyclerAdData;
        setExpressAd(true);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public View getExpressView() {
        return this.mExpressView;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad.MediationCustomNativeAd, com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void render() {
        super.render();
        try {
            RecyclerAdData recyclerAdData = this.adData;
            if (recyclerAdData != null) {
                if (recyclerAdData.getAdPatternType() == 2) {
                    this.adData.setExpressMediaListener(new ExpressMediaListener(this) { // from class: com.kc.dw.platform.csjblend.MsCBGMExpressAd.1
                        public final MsCBGMExpressAd this$0;

                        {
                            this.this$0 = this;
                        }

                        @Override // com.kc.dw.core.ad.recycler.ExpressMediaListener
                        public void onVideoCompleted() {
                            StringBuilder sbA = a.a("DEMO ADEVENT ");
                            sbA.append(new Throwable().getStackTrace()[0].getMethodName());
                            LogUtil.d(MsCBGMExpressAd.TAG, sbA.toString());
                            this.this$0.callVideoCompleted();
                        }

                        @Override // com.kc.dw.core.ad.recycler.ExpressMediaListener
                        public void onVideoError(int i, String str) {
                            StringBuilder sbA = a.a("DEMO ADEVENT ");
                            sbA.append(new Throwable().getStackTrace()[0].getMethodName());
                            LogUtil.d(MsCBGMExpressAd.TAG, sbA.toString());
                            this.this$0.callVideoError(i, str);
                        }

                        @Override // com.kc.dw.core.ad.recycler.ExpressMediaListener
                        public void onVideoLoaded() {
                            StringBuilder sbA = a.a("DEMO ADEVENT ");
                            sbA.append(new Throwable().getStackTrace()[0].getMethodName());
                            LogUtil.d(MsCBGMExpressAd.TAG, sbA.toString());
                        }

                        @Override // com.kc.dw.core.ad.recycler.ExpressMediaListener
                        public void onVideoPause() {
                            StringBuilder sbA = a.a("DEMO ADEVENT ");
                            sbA.append(new Throwable().getStackTrace()[0].getMethodName());
                            LogUtil.d(MsCBGMExpressAd.TAG, sbA.toString());
                            this.this$0.callVideoPause();
                        }

                        @Override // com.kc.dw.core.ad.recycler.ExpressMediaListener
                        public void onVideoResume() {
                            StringBuilder sbA = a.a("DEMO ADEVENT ");
                            sbA.append(new Throwable().getStackTrace()[0].getMethodName());
                            LogUtil.d(MsCBGMExpressAd.TAG, sbA.toString());
                            this.this$0.callVideoResume();
                        }

                        @Override // com.kc.dw.core.ad.recycler.ExpressMediaListener
                        public void onVideoStart() {
                            StringBuilder sbA = a.a("DEMO ADEVENT ");
                            sbA.append(new Throwable().getStackTrace()[0].getMethodName());
                            LogUtil.d(MsCBGMExpressAd.TAG, sbA.toString());
                            this.this$0.callVideoStart();
                        }
                    });
                }
                this.adData.setExpressAdInteractionListener(new FeedExpressAdInteractionListener(this) { // from class: com.kc.dw.platform.csjblend.MsCBGMExpressAd.2
                    public final MsCBGMExpressAd this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener, com.kc.dw.core.loader.InteractionListener
                    public void onAdClicked() {
                        StringBuilder sbA = a.a("DEMO ADEVENT ");
                        sbA.append(new Throwable().getStackTrace()[0].getMethodName());
                        LogUtil.d(MsCBGMExpressAd.TAG, sbA.toString());
                        this.this$0.callAdClick();
                    }

                    @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener, com.kc.dw.core.loader.InteractionListener
                    public void onAdClosed() {
                        StringBuilder sbA = a.a("DEMO ADEVENT ");
                        sbA.append(new Throwable().getStackTrace()[0].getMethodName());
                        LogUtil.d(MsCBGMExpressAd.TAG, sbA.toString());
                        this.this$0.callDislikeSelected(-1, "模板关闭");
                    }

                    @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener, com.kc.dw.core.loader.InteractionListener
                    public void onAdExposure() {
                        StringBuilder sbA = a.a("DEMO ADEVENT ");
                        sbA.append(new Throwable().getStackTrace()[0].getMethodName());
                        LogUtil.d(MsCBGMExpressAd.TAG, sbA.toString());
                        this.this$0.callAdShow();
                    }

                    @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener
                    public void onRenderError(int i, String str) {
                        StringBuilder sbA = a.a("DEMO ADEVENT ");
                        sbA.append(new Throwable().getStackTrace()[0].getMethodName());
                        LogUtil.d(MsCBGMExpressAd.TAG, sbA.toString());
                        MsCBGMExpressAd msCBGMExpressAd = this.this$0;
                        msCBGMExpressAd.callRenderFail(msCBGMExpressAd.mExpressView, i, str);
                    }

                    @Override // com.kc.dw.core.ad.recycler.FeedExpressAdInteractionListener
                    public void onRenderSuccess() {
                        StringBuilder sbA = a.a("DEMO ADEVENT ");
                        sbA.append(new Throwable().getStackTrace()[0].getMethodName());
                        Log.d(MsCBGMExpressAd.TAG, sbA.toString());
                        MsCBGMExpressAd msCBGMExpressAd = this.this$0;
                        msCBGMExpressAd.mExpressView = msCBGMExpressAd.adData.getExpressView();
                        this.this$0.callRenderSuccess(-1.0f, -2.0f);
                    }
                });
                Context context = this.context;
                if (context instanceof Activity) {
                    this.adData.render((Activity) context);
                } else {
                    callRenderFail(this.mExpressView, -1, "context must is activity");
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            View view = this.mExpressView;
            StringBuilder sbA = a.a("render error.");
            sbA.append(th.toString());
            callRenderFail(view, -1, sbA.toString());
        }
    }
}
