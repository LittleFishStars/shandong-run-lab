package com.fl.saas;

import android.content.Context;
import com.fl.saas.B;
import com.fl.saas.adx.api.mixNative.NativeAd;
import com.fl.saas.adx.api.mixNative.NativeLoadListener;
import com.fl.saas.adx.base.bean.AdInfo;
import com.fl.saas.adx.base.bidding.BiddingResult;
import com.fl.saas.adx.base.bidding.C2SBiddingECPM;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.innterNative.BaseNativeAd;
import com.fl.saas.adx.base.interfaces.AdChangeCacheData;
import com.fl.saas.adx.base.interfaces.AdGetWinInfo;
import com.fl.saas.adx.base.interfaces.AdMaterial;
import com.fl.saas.adx.base.interfaces.AdValid;
import com.fl.saas.adx.base.interfaces.MixNativeCycleDataListener;
import com.fl.saas.adx.base.manager.MixNativeManager;
import com.fl.saas.adx.base.widget.WinAdInfo;
import com.fl.saas.adx.util.CommConstant;
import com.fl.saas.adx.util.LogcatUtil;
import java.util.List;

/* JADX INFO: renamed from: com.fl.saas.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class C1407f extends AbstractC1423n implements NativeLoadListener, BiddingResult, AdValid, AdMaterial, AdChangeCacheData, AdGetWinInfo, MixNativeCycleDataListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30161a = CommConstant.getObjTag(this);
    private final InterfaceC1416j0 b;
    private B c;
    private B d;
    private NativeAd e;
    private MixNativeManager.OnNativeReleaseListener f;

    /* JADX INFO: renamed from: com.fl.saas.f$a */
    public class a implements D0 {
        public a() {
        }

        @Override // com.fl.saas.D0
        public void onClickedEvent() {
            C1407f.this.onClickedEvent();
        }

        @Override // com.fl.saas.D0
        public void onShowEvent() {
            C1407f.this.onShowEvent();
        }

        @Override // com.fl.saas.D0
        public void reportRequestShow() {
            C1407f.this.reportRequestShow();
        }
    }

    /* JADX INFO: renamed from: com.fl.saas.f$b */
    public class b implements BaseNativeAd.AdInfoMapper {
        public b() {
        }

        @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd.AdInfoMapper
        public AdInfo getAdInfo() {
            return AdInfo.create(C1407f.this.getAdSource().p, C1407f.this.getAdSource().q, C1407f.this.getAdSource().j, C1407f.this.getAdSource().k);
        }

        @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd.AdInfoMapper
        public C1415j getSource() {
            return C1407f.this.getAdSource();
        }
    }

    public C1407f(InterfaceC1416j0 interfaceC1416j0) {
        this.b = interfaceC1416j0;
        interfaceC1416j0.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer a(NativeAd nativeAd) {
        return Integer.valueOf(C2SBiddingECPM.getC2SBiddingECPM(nativeAd, this.b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int c() {
        if (canUseEcpm()) {
            return getAdSource().f();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        onAdFailed(FLError.create(20407, "showAd but mNativeAd is null"));
    }

    public InterfaceC1416j0 b() {
        return this.b;
    }

    @Override // com.fl.saas.adx.base.bidding.BiddingResult
    public void biddingResult(boolean z, int i, int i2, int i3) {
        Object obj = this.e;
        BiddingResult biddingResult = ((obj == null || !(obj instanceof BiddingResult)) && ((obj = this.b) == null || !(obj instanceof BiddingResult))) ? null : (BiddingResult) obj;
        if (biddingResult != null) {
            biddingResult.biddingResult(z, i, i2, i3);
        }
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.adx.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (isCache()) {
            return;
        }
        NativeAd nativeAd = this.e;
        if (nativeAd != null) {
            nativeAd.release();
        }
        this.c = null;
        this.b.destroy();
    }

    @Override // com.fl.saas.adx.base.interfaces.AdMaterial
    public AdMaterial.AdMaterialData getAdMaterialData() {
        NativeAd nativeAd = this.e;
        if (nativeAd == null || !(nativeAd instanceof AdMaterial)) {
            return null;
        }
        return ((AdMaterial) nativeAd).getAdMaterialData();
    }

    @Override // com.fl.saas.adx.base.interfaces.MixNativeCycleDataListener
    public NativeAd getCycleNativeAd() {
        return this.e;
    }

    @Override // com.fl.saas.adx.base.interfaces.AdGetWinInfo
    public WinAdInfo getWinAdInfo() {
        NativeAd nativeAd = this.e;
        if (nativeAd == null || nativeAd.getAdMaterial() == null) {
            return null;
        }
        WinAdInfo winAdInfo = new WinAdInfo();
        try {
            if (this.e.getAdMaterial().getAdAppInfo() != null) {
                winAdInfo.setAdUserName(this.e.getAdMaterial().getAdAppInfo().getAppName());
            }
            winAdInfo.setPosId(getAdSource().f);
            winAdInfo.setTitle(this.e.getAdMaterial().getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return winAdInfo;
    }

    @Override // com.fl.saas.AbstractC1423n
    public void handle(Context context) {
        this.b.setContext(context);
        this.b.a(context);
    }

    @Override // com.fl.saas.adx.base.interfaces.AdValid
    public boolean isValid() {
        NativeAd nativeAd = this.e;
        if (nativeAd == null) {
            return false;
        }
        if (nativeAd instanceof AdValid) {
            return ((AdValid) nativeAd).isValid();
        }
        return true;
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.adx.base.interfaces.AdViewListener
    public void onAdFailed(FLError fLError) {
        LogcatUtil.d(this.f30161a, "onAdFailed: " + fLError);
        disposeError(fLError);
        B b2 = this.d;
        if (b2 != null) {
            b2.a(fLError);
        }
    }

    @Override // com.fl.saas.adx.api.mixNative.NativeLoadListener
    public void onNativeAdLoaded(final NativeAd nativeAd) {
        setAdSource(this.b.getAdSource());
        bindC2SBidECPM(new b1() { // from class: com.zj.adlib.a3b
            @Override // com.fl.saas.b1
            public final Object a() {
                return this.f15148a.a(nativeAd);
            }
        });
        this.e = nativeAd;
        if (nativeAd instanceof BaseNativeAd) {
            nativeAd.setOnNativeReleaseListener(this.f);
            BaseNativeAd baseNativeAd = (BaseNativeAd) nativeAd;
            baseNativeAd.setReportEventListener(new a());
            baseNativeAd.setEcpmMapper(new BaseNativeAd.EcpmMapper() { // from class: com.zj.adlib.e3b
                @Override // com.fl.saas.adx.base.innterNative.BaseNativeAd.EcpmMapper
                public final int getECPM() {
                    return this.f41339a.c();
                }
            });
            baseNativeAd.setAdInfoMapper(new b());
        }
        onLoadedEvent();
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.adx.base.base.AdapterAPI
    public void setCache() {
        super.setCache();
        this.b.setCache();
    }

    @Override // com.fl.saas.adx.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, C1415j c1415j) {
        NativeAd nativeAd = this.e;
        if (nativeAd instanceof AdChangeCacheData) {
            ((AdChangeCacheData) nativeAd).setCacheData(str, c1415j);
        }
    }

    @Override // com.fl.saas.adx.base.interfaces.MixNativeCycleDataListener
    public void setCycleNativeAd(List list, int i) {
        NativeAd nativeAd = this.e;
        if (nativeAd instanceof MixNativeCycleDataListener) {
            ((MixNativeCycleDataListener) nativeAd).setCycleNativeAd(list, i);
        }
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.adx.base.base.AdapterAPI
    public void showAd() {
        super.showAd();
        this.b.clearCache();
        NativeAd nativeAd = this.e;
        if (nativeAd == null || !nativeAd.isNativeExpress() || this.e.getAdMaterial() == null || this.e.getAdMaterial().getAdMediaView() != null) {
            C1428p0.b(this.e).a(new B() { // from class: com.zj.adlib.h3b
                @Override // com.fl.saas.B
                public final void a(Object obj) {
                    this.f42043a.b((NativeAd) obj);
                }
            }, new Runnable() { // from class: com.zj.adlib.j3b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42500a.d();
                }
            });
        } else {
            onAdFailed(FLError.create(20407, "联盟返回了模版广告，但是广告view为null"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final NativeAd nativeAd) {
        C1428p0.b(this.c).a(new B() { // from class: com.zj.adlib.t2b
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                ((B) obj).a(nativeAd);
            }
        });
    }

    public C1407f a(B b2) {
        this.d = b2;
        return this;
    }

    public C1407f b(B b2) {
        this.c = b2;
        return this;
    }

    public void a(MixNativeManager.OnNativeReleaseListener onNativeReleaseListener) {
        this.f = onNativeReleaseListener;
    }
}
