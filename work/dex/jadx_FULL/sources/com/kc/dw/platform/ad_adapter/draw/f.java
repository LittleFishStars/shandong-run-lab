package com.kc.dw.platform.ad_adapter.draw;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kc.dw.ad.draw.SsdDrawRootView;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.draw.DrawCommonAdLoader;
import com.kc.dw.core.router.log.bean.LoadResState;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.DimensionUtils;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.t0;
import com.kc.dw.core.utils.z;
import com.kc.dw.core.view.DownloadView;
import com.kc.dw.core.view.TouchAdContainer;
import com.kc.dw.core.view.TouchPositionListener;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class f implements z.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f39462a;

    @Keep
    public class a implements com.kc.dw.ad.nativ.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f39463a;

        public a(f fVar) {
            this.f39463a = fVar;
        }

        @Override // com.kc.dw.ad.z
        public void a(List<com.kc.dw.ad.nativ.d> list) {
            g gVar;
            AdError adError;
            List<com.kc.dw.ad.nativ.d> list2 = list;
            if (list2 == null || list2.isEmpty()) {
                gVar = this.f39463a.f39462a;
                adError = new AdError(200002, "ad is isEmpty");
            } else {
                com.kc.dw.ad.nativ.d dVar = list2.get(0);
                if (dVar.getMediaView() instanceof NormalMediaView) {
                    this.f39463a.f39462a.k = System.currentTimeMillis();
                    View adView = dVar.getAdView();
                    SsdDrawRootView ssdDrawRootView = (SsdDrawRootView) LayoutInflater.from(this.f39463a.f39462a.context).inflate(R.layout.ssd_draw_ad_layout, (ViewGroup) null).findViewById(R.id.ms_draw_rootView);
                    new DownloadView().handleDownloadView(ssdDrawRootView, (BaseAdSlot) this.f39463a.f39462a.f39477a);
                    FrameLayout frameLayout = (FrameLayout) ssdDrawRootView.findViewById(R.id.ms_draw_ad_video);
                    com.kc.dw.core.bquery.d dVar2 = new com.kc.dw.core.bquery.d(ssdDrawRootView);
                    int i = R.id.ms_draw_ad_detail_logo;
                    TextView textView = (TextView) ssdDrawRootView.findViewById(R.id.draw_ad_detail_title);
                    TextView textView2 = (TextView) ssdDrawRootView.findViewById(R.id.ms_draw_ad_detail_desc);
                    TextView textView3 = (TextView) ssdDrawRootView.findViewById(R.id.ms_draw_ad_detail_btn);
                    ImageView imageView = (ImageView) ssdDrawRootView.findViewById(R.id.ms_draw_close_button);
                    if (!TextUtils.isEmpty(((i) this.f39463a.f39462a.f39477a).getVideo_cover())) {
                        dVar2.b(i).a(((i) this.f39463a.f39462a.f39477a).iconUrl, false);
                    }
                    textView.setText(((i) this.f39463a.f39462a.f39477a).title);
                    textView2.setText(((i) this.f39463a.f39462a.f39477a).c);
                    if (com.kc.dw.base.a.adConfig() != null && !com.kc.dw.base.a.adConfig().showLogo()) {
                        dVar2.b(R.id.ssd_img_ad_tag).d(8);
                    } else if (!TextUtils.isEmpty(((i) this.f39463a.f39462a.f39477a).getFromLogo())) {
                        dVar2.b(R.id.ssd_img_ad_tag).a(((i) this.f39463a.f39462a.f39477a).getFromLogo(), false);
                    }
                    g gVar2 = this.f39463a.f39462a;
                    com.kc.dw.platform.ad_adapter.draw.a aVar = gVar2.h;
                    aVar.f39457a = gVar2.f39477a;
                    aVar.b = adView;
                    TouchAdContainer touchAdContainer = new TouchAdContainer(this.f39463a.f39462a.context);
                    touchAdContainer.setTouchPositionListener(new TouchPositionListener(dVar));
                    touchAdContainer.addView(ssdDrawRootView);
                    if (adView != null) {
                        this.f39463a.f39462a.getContext();
                        g gVar3 = this.f39463a.f39462a;
                        dVar.a(frameLayout, new com.kc.dw.platform.ad_adapter.recycler.d((i) gVar3.f39477a, gVar3.m), new com.kc.dw.core.service.logrecord.util.a(this.f39463a.f39462a, false));
                        if (adView instanceof NormalMediaView) {
                            this.f39463a.f39462a.getContext().getResources().getDisplayMetrics();
                            ((NormalMediaView) adView).setRecycler(true);
                        }
                        ssdDrawRootView.setOnVisibilityChangeListener(new b(this, adView));
                        this.f39463a.f39462a.h.setAdView(touchAdContainer);
                        imageView.setOnClickListener(new c(this));
                        boolean z = (((i) this.f39463a.f39462a.f39477a).getAct_type() & 1) == 1;
                        if (!z && (((i) this.f39463a.f39462a.f39477a).getAct_type() & 2) == 2) {
                            textView3.setOnClickListener(new d(this, dVar));
                        }
                        if (z) {
                            ssdDrawRootView.setOnClickListener(new e(this, dVar));
                        }
                    }
                    g gVar4 = this.f39463a.f39462a;
                    if (gVar4.i != null) {
                        gVar4.l.a(-1, 5);
                        g gVar5 = this.f39463a.f39462a;
                        gVar5.i.onRenderSuccess(gVar5.h);
                        return;
                    }
                    return;
                }
                gVar = this.f39463a.f39462a;
                adError = new AdError(200002, "ad isn`t video");
            }
            gVar.a(adError);
        }

        @Override // com.kc.dw.ad.z
        public void onADExposure() {
            g gVar = this.f39463a.f39462a;
            if (gVar.f) {
                return;
            }
            t0.a(((i) gVar.f39477a).getPosId(), 3);
            String[] strArrB = g0.b(((i) this.f39463a.f39462a.f39477a).getMonitorUrl(), this.f39463a.f39462a.b());
            g0.a(strArrB, this.f39463a.f39462a.h.getAdView(), (View) null);
            if (strArrB != null) {
                LogUtil.d("MeishuDrawAdWrapper", "send onADExposure");
                for (String str : strArrB) {
                    if (!TextUtils.isEmpty(str)) {
                        com.kc.dw.ad.interstitial.c.a(this.f39463a.f39462a.getContext(), g0.a(g0.a(str, ((i) this.f39463a.f39462a.f39477a).getAct_type(), AdType.DRAW)));
                    }
                }
            }
            com.kc.dw.platform.ad_adapter.draw.a aVar = this.f39463a.f39462a.h;
            if (aVar != null && aVar.getInteractionListener() != null) {
                this.f39463a.f39462a.h.getInteractionListener().onAdExposure();
            }
            this.f39463a.f39462a.f = true;
        }

        @Override // com.kc.dw.ad.z
        public void onAdRenderFail(String str, int i) {
            if (((i) this.f39463a.f39462a.f39477a).getErrorUrl() != null) {
                z.a(((i) this.f39463a.f39462a.f39477a).getErrorUrl()[0], Integer.valueOf(i), str);
            }
            this.f39463a.f39462a.a(new AdError(i, str));
        }
    }

    public f(g gVar) {
        this.f39462a = gVar;
    }

    @Override // com.kc.dw.core.utils.z.k
    public void fail() {
        if (((i) this.f39462a.f39477a).getErrorUrl() != null) {
            z.a(((i) this.f39462a.f39477a).getErrorUrl()[0], (Integer) (-1), "图片加载失败");
        }
        com.kc.dw.core.service.logrecord.a.a(5, "f4", this.f39462a, new LoadResState().setFail(3));
        this.f39462a.a(new AdError(9000001, "图片加载失败"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kc.dw.core.utils.z.k
    public void success() {
        Context context = this.f39462a.getContext();
        g gVar = this.f39462a;
        new com.kc.dw.platform.ad_adapter.e(context, gVar).a((i) gVar.f39477a, new a(this), false, false, false, DimensionUtils.px2dip(gVar.getContext(), ((DrawCommonAdLoader) this.f39462a.getAdLoader()).getAccept_ad_width().intValue()), DimensionUtils.px2dip(this.f39462a.getContext(), ((DrawCommonAdLoader) this.f39462a.getAdLoader()).getAccept_ad_height().intValue()));
    }
}
