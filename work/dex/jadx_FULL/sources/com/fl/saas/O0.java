package com.fl.saas;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.adx.base.bidding.BiddingResult;
import com.fl.saas.adx.base.exception.FLError;
import com.fl.saas.adx.base.interfaces.AdChangeCacheData;
import com.fl.saas.adx.util.LogcatUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class O0 extends AbstractC1411h implements BiddingResult, AdChangeCacheData {
    private M0 c = null;
    private C1415j d;
    private N0 e;
    private InterfaceC1426o0 f;

    public class a implements InterfaceC1426o0 {
        public a() {
        }

        @Override // com.fl.saas.InterfaceC1426o0
        public void a(String str) {
            LogcatUtil.d("FLSDK-S2S-Video", "onADClick");
            O0.this.onClickedEvent();
        }

        @Override // com.fl.saas.InterfaceC1426o0
        public void b(double d) {
            O0.this.c();
        }

        @Override // com.fl.saas.InterfaceC1426o0
        public void onClose() {
            LogcatUtil.d("FLSDK-S2S-Video", "onADClose");
            O0.this.onClosedEvent();
        }

        @Override // com.fl.saas.InterfaceC1426o0
        public void a(double d) {
            O0.this.d();
        }

        @Override // com.fl.saas.InterfaceC1426o0
        public void b(FLError fLError) {
            O0.this.disposeError(fLError);
        }

        @Override // com.fl.saas.InterfaceC1426o0
        public void a(FLError fLError) {
            b(fLError);
        }

        @Override // com.fl.saas.InterfaceC1426o0
        public void a(N0 n0) {
            if (n0 == null || n0.b() == null) {
                a(FLError.create(0, "S2SRewardVideoADManager is null"));
                return;
            }
            O0.this.setAdSource(n0.b());
            O0.this.e = n0;
            O0.this.d = n0.b();
            O0.this.d.j0 = O0.this.isHot();
            if (O0.this.d != null && O0.this.d.P0 != null && !TextUtils.isEmpty(O0.this.d.P0.f30178a)) {
                O0.this.getAdSource().z = O0.this.d.P0.f30178a;
            }
            O0.this.onLoadedEvent();
        }
    }

    @Override // com.fl.saas.adx.base.bidding.BiddingResult
    public void biddingResult(boolean z, int i, int i2, int i3) {
        C1415j c1415j = this.d;
        if (c1415j == null) {
            return;
        }
        c1415j.e = i2;
        if (!z) {
            if (i > 0) {
                c1415j.d = i;
            }
            C1443x.a().a(this.d);
        } else {
            if (i > 0 && i <= c1415j.d) {
                c1415j.d = i;
            }
            C1443x.a().b(this.d);
        }
    }

    @Override // com.fl.saas.AbstractC1423n, com.fl.saas.adx.base.base.AdapterAPI
    public void destroy() {
        super.destroy();
        if (this.c == null || isCache()) {
            return;
        }
        this.c.a();
    }

    @Override // com.fl.saas.AbstractC1411h
    public void e() {
        getActivityValid().a(new B() { // from class: com.zj.adlib.r46
            @Override // com.fl.saas.B
            public final void a(Object obj) {
                this.f44364a.c((Activity) obj);
            }
        });
    }

    @Override // com.fl.saas.AbstractC1423n
    public void handle(Context context) {
        if (this.f == null) {
            this.f = new a();
        }
        M0 m0 = new M0(this.f, false);
        this.c = m0;
        m0.a(getPlaceId(), getLinkId(), isHot());
    }

    @Override // com.fl.saas.adx.base.interfaces.AdChangeCacheData
    public void setCacheData(String str, C1415j c1415j) {
        C1415j c1415j2 = this.d;
        if (c1415j2 != null) {
            c1415j2.r = str;
            c1415j2.Z = c1415j.Z;
            c1415j2.i = c1415j.i;
            c1415j2.b0 = c1415j.h;
            c1415j2.a0 = c1415j.i;
            c1415j2.c0 = c1415j.j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Activity activity) {
        onShowEvent();
        if (this.e == null) {
            disposeError(new FLError(400, "暂无可用激励视频广告，请等待缓存加载或者重新刷新"));
            return;
        }
        if (getAdSource() != null) {
            getAdSource().d0 = this.e.d() ? 1 : 0;
        }
        this.e.a(activity);
    }
}
