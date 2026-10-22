package com.fl.saas.adx.base.inner.spread;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.fl.saas.AbstractC1409g;
import com.fl.saas.AbstractC1418k0;
import com.fl.saas.C1415j;
import com.fl.saas.S0;
import com.fl.saas.a1;
import com.fl.saas.adx.api.AdParams;
import com.fl.saas.adx.api.mixNative.NativeAd;
import com.fl.saas.adx.api.mixNative.NativeAdView;
import com.fl.saas.adx.api.mixNative.NativeClickCallbackListener;
import com.fl.saas.adx.api.mixNative.NativeEventListener;
import com.fl.saas.adx.api.mixNative.NativeLoadListener;
import com.fl.saas.adx.api.mixNative.NativeMaterial;
import com.fl.saas.adx.api.mixNative.NativePrepareInfo;
import com.fl.saas.adx.base.bean.AdInfo;
import com.fl.saas.adx.base.bidding.C2SBiddingECPM;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.inner.InnerNativeAdapter;
import com.fl.saas.adx.base.inner.spread.coustomView.NativeSpreadView;
import com.fl.saas.adx.base.innterNative.ActionView;
import com.fl.saas.adx.base.innterNative.BaseNativeAd;
import com.fl.saas.adx.base.innterNative.NativeStyle;
import com.fl.saas.adx.base.interfaces.AdChangeCacheData;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.adx.util.ViewHelper;
import com.fl.saas.b1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class InnerNativeSpreadAdapter extends AbstractC1409g implements InnerNativeAdapter, AdChangeCacheData {
    private AbstractC1418k0 handler;
    private boolean hasShowView;
    private NativeAd mNativeAd;
    private NativeSpreadView nativeSpreadView;
    private ViewGroup spreadViewGroup;

    /* JADX INFO: renamed from: com.fl.saas.adx.base.inner.spread.InnerNativeSpreadAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements NativeLoadListener {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Integer lambda$onNativeAdLoaded$0(NativeAd nativeAd) {
            return Integer.valueOf(C2SBiddingECPM.getC2SBiddingECPM(nativeAd, InnerNativeSpreadAdapter.this.handler));
        }

        @Override // com.fl.saas.adx.base.interfaces.AdViewListener
        public void onAdFailed(FLError fLError) {
            InnerNativeSpreadAdapter.this.disposeError(fLError);
        }

        @Override // com.fl.saas.adx.api.mixNative.NativeLoadListener
        public void onNativeAdLoaded(final NativeAd nativeAd) {
            InnerNativeSpreadAdapter innerNativeSpreadAdapter = InnerNativeSpreadAdapter.this;
            innerNativeSpreadAdapter.setAdSource(innerNativeSpreadAdapter.handler.getAdSource());
            InnerNativeSpreadAdapter.this.bindC2SBidECPM(new b1() { // from class: com.fl.saas.adx.base.inner.spread.a
                @Override // com.fl.saas.b1
                public final Object a() {
                    return this.f1741a.lambda$onNativeAdLoaded$0(nativeAd);
                }
            });
            InnerNativeSpreadAdapter.this.mNativeAd = nativeAd;
            InnerNativeSpreadAdapter.this.render(nativeAd);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x009f  */
    private boolean checkStyle() {
        int i;
        int i2;
        String str = getAdSource().L;
        int i3 = getAdSource().K;
        int i4 = getAdSource().J;
        String[] strArrSplit = str.split(",");
        long jB = S0.a().b("value4");
        int iA = S0.a().a("value5");
        int iA2 = S0.a().a("value6");
        long jB2 = S0.a().b("value7");
        long bootTime = DeviceUtil.getBootTime();
        long j = bootTime - jB;
        long j2 = bootTime - jB2;
        int i5 = iA + 1;
        S0.a().b("value5", i5);
        if (j > 86400000 || j < 0) {
            S0.a().b("value6", 0);
            S0.a().b("value4", bootTime);
            S0.a().b("value5", 1);
            i = 0;
            i2 = 1;
        } else {
            i = iA2;
            i2 = i5;
        }
        if (TextUtils.isEmpty(str)) {
            if (j2 <= ((long) i3) * 60000) {
                S0.a().b("value6", i + 1);
                S0.a().b("value7", bootTime);
                return true;
            }
            S0.a().b("value6", i + 1);
            S0.a().b("value7", bootTime);
            return true;
        }
        if (a1.a(strArrSplit, i2 + "")) {
            if ((j2 <= ((long) i3) * 60000 || j2 < 0) && i < i4) {
                S0.a().b("value6", i + 1);
                S0.a().b("value7", bootTime);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$render$0() {
        if (canUseEcpm()) {
            return getAdSource().f();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$responseAd$1(ViewGroup viewGroup) {
        this.spreadViewGroup = viewGroup;
        if (viewGroup != null) {
            showSpreadView();
        } else {
            disposeError(new FLError(20407, "展示时传入ViewGroup为null"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSpreadView$2() {
        View viewBindActionView;
        try {
            NativeAd nativeAd = this.mNativeAd;
            if (nativeAd instanceof ActionView) {
                viewBindActionView = ((ActionView) nativeAd).bindActionView(ActionView.Type.Spread);
                if (viewBindActionView != null) {
                    this.nativeSpreadView.getSelfView().addView(viewBindActionView);
                }
            } else {
                viewBindActionView = null;
            }
            this.nativeSpreadView.setViewType(getAdSource().M == 1, checkStyle(), getAdSource().I);
            this.nativeSpreadView.setClickAreaVisibility(viewBindActionView);
            this.nativeSpreadView.show();
            NativePrepareInfo nativePrepareInfo = new NativePrepareInfo();
            nativePrepareInfo.setActivity(getActivityOrNull());
            nativePrepareInfo.setCtaView(this.nativeSpreadView.getCATView());
            nativePrepareInfo.setClickView(this.nativeSpreadView.getClicks());
            this.mNativeAd.prepare(nativePrepareInfo);
            this.spreadViewGroup.addView(this.nativeSpreadView.getNativeAdView(), ViewHelper.getMatchParent());
        } catch (Exception e) {
            e.printStackTrace();
            disposeError(new FLError(20405, "展示异常"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(NativeAd nativeAd) {
        if (nativeAd instanceof BaseNativeAd) {
            BaseNativeAd baseNativeAd = (BaseNativeAd) nativeAd;
            baseNativeAd.setEcpmMapper(new BaseNativeAd.EcpmMapper() { // from class: com.zj.adlib.x94
                @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd.EcpmMapper
                public final int getECPM() {
                    return this.f45770a.lambda$render$0();
                }
            });
            baseNativeAd.setAdInfoMapper(new BaseNativeAd.AdInfoMapper() { // from class: com.fl.saas.adx.base.inner.spread.InnerNativeSpreadAdapter.2
                @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd.AdInfoMapper
                public AdInfo getAdInfo() {
                    return AdInfo.create(InnerNativeSpreadAdapter.this.getAdSource().p, InnerNativeSpreadAdapter.this.getAdSource().q, InnerNativeSpreadAdapter.this.getAdSource().j, InnerNativeSpreadAdapter.this.getAdSource().k);
                }

                @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd.AdInfoMapper
                public C1415j getSource() {
                    return InnerNativeSpreadAdapter.this.getAdSource();
                }
            });
        }
        NativeMaterial adMaterial = nativeAd.getAdMaterial();
        if (DeviceUtil.filling_timing == 0) {
            if (ViewHelper.checkMateria(adMaterial)) {
                responseAd();
            } else {
                disposeError(FLError.create(20405, "media and imgUrl is empty"));
            }
        }
        final SpreadViewHelper spreadViewHelper = new SpreadViewHelper(getContext(), adMaterial, new SpreadViewEvent() { // from class: com.fl.saas.adx.base.inner.spread.InnerNativeSpreadAdapter.3
            @Override // com.fl.saas.adx.base.inner.InnerViewLoaderEvent
            public void onAdFailed(FLError fLError) {
                InnerNativeSpreadAdapter.this.disposeError(fLError);
            }

            @Override // com.fl.saas.adx.base.inner.spread.SpreadViewEvent
            public void onDismiss() {
                InnerNativeSpreadAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.adx.base.inner.InnerViewLoaderEvent
            public void onLoaded(NativeSpreadView nativeSpreadView) {
                InnerNativeSpreadAdapter.this.nativeSpreadView = nativeSpreadView;
                if (DeviceUtil.filling_timing != 0) {
                    InnerNativeSpreadAdapter.this.responseAd();
                } else {
                    if (InnerNativeSpreadAdapter.this.hasShowView || InnerNativeSpreadAdapter.this.spreadViewGroup == null) {
                        return;
                    }
                    InnerNativeSpreadAdapter.this.showSpreadView();
                }
            }
        });
        nativeAd.renderAdContainer(spreadViewHelper.getNativeAdView(), spreadViewHelper.getSelfView());
        nativeAd.setNativeEventListener(new NativeEventListener() { // from class: com.fl.saas.adx.base.inner.spread.InnerNativeSpreadAdapter.4
            private boolean isReportExposure = false;

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdClicked(NativeAdView nativeAdView) {
                InnerNativeSpreadAdapter.this.onClickedEvent();
                spreadViewHelper.onClicked();
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdClose(NativeAdView nativeAdView) {
                InnerNativeSpreadAdapter.this.onClosedEvent();
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdFailed(NativeAdView nativeAdView, FLError fLError) {
                InnerNativeSpreadAdapter.this.onAdFailed(fLError);
                spreadViewHelper.cancelCountdown();
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdImpressed(NativeAdView nativeAdView) {
                if (this.isReportExposure) {
                    return;
                }
                this.isReportExposure = true;
                spreadViewHelper.startCountdown();
                InnerNativeSpreadAdapter.this.onShowEvent();
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdVideoEnd(NativeAdView nativeAdView) {
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdVideoProgress(NativeAdView nativeAdView, long j) {
            }

            @Override // com.fl.saas.adx.api.mixNative.NativeEventListener
            public void onAdVideoStart(NativeAdView nativeAdView) {
            }
        });
        nativeAd.setClickCallBackListener(new NativeClickCallbackListener() { // from class: com.fl.saas.adx.base.inner.spread.InnerNativeSpreadAdapter.5
            @Override // com.fl.saas.adx.api.mixNative.NativeClickCallbackListener
            public void onAdClicked(String str) {
                InnerNativeSpreadAdapter.this.onClickedEvent(str);
            }
        });
        spreadViewHelper.initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void responseAd() {
        onSpreadLoadedEvent(new AbstractC1409g.a() { // from class: com.zj.adlib.z94
            @Override // com.fl.saas.AbstractC1409g.a
            public final void a(ViewGroup viewGroup) {
                this.f46216a.lambda$responseAd$1(viewGroup);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSpreadView() {
        if (this.nativeSpreadView != null) {
            this.hasShowView = true;
            DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.y94
                @Override // java.lang.Runnable
                public final void run() {
                    this.f45981a.lambda$showSpreadView$2();
                }
            });
        }
    }

    @Override // com.fl.saas.AbstractC1409g, com.fl.saas.AbstractC1423n, com.fl.saas.adx.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (isCache()) {
            return;
        }
        innerDestroy(this.handler, this.mNativeAd);
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeAdapter
    @Nullable
    public NativeAd getNativeAd() {
        return this.mNativeAd;
    }

    @Override // com.fl.saas.AbstractC1423n
    public void handle(Context context) {
        this.handler = loadNativeHandler();
        this.handler.setContext(getContext()).a(getAppId(), getPosId()).setLinkId(getLinkId()).a(new AdParams.Builder(getKey()).setIsMixNative(false).build()).a(new AnonymousClass1());
        this.handler.a(NativeStyle.NATIVE);
        this.handler.a(isHot());
        this.handler.a(context);
    }

    @Override // com.fl.saas.adx.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, C1415j c1415j) {
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd instanceof AdChangeCacheData) {
            ((AdChangeCacheData) nativeAd).setCacheData(str, c1415j);
        }
    }
}
