package cj.mobile.wm;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.api.listener.ITemplateInteractionListener;
import com.wangmai.insightvision.openadsdk.common.AdError;
import com.wangmai.insightvision.openadsdk.view.InsightAdView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class gc {
    public static String dexh = "BaseTemplateRenderer";
    public Context dexa;
    public ITemplateInteractionListener dexb;
    public INativeAd dexc;
    public InsightAdView dexd;
    public AdSlot dexe;
    public com.wangmai.insightvision.openadsdk.o.a.a dexf;
    public final Handler dexg = new dexb(Looper.getMainLooper());

    public class dexa implements i1 {
        public dexa() {
        }

        @Override // cj.mobile.wm.i1
        public void a() {
            h1.dexa().dexd(gc.this.dexc);
            f1.dexa(gc.dexh, "exposure " + gc.this.dexb);
            if (gc.this.dexb != null) {
                gc.this.dexb.onAdShow(gc.this.dexd);
            }
            gc.this.dexg.sendEmptyMessageDelayed(1000, 500L);
        }

        @Override // cj.mobile.wm.i1
        public void a(long j) {
        }
    }

    public class dexb extends Handler {
        public dexb(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1000) {
                gc.this.dexg.removeCallbacksAndMessages(1000);
                gc.this.dexc();
            }
        }
    }

    public gc(Context context, AdSlot adSlot, INativeAd iNativeAd, ITemplateInteractionListener iTemplateInteractionListener) {
        dexh = getClass().getSimpleName();
        this.dexa = context;
        this.dexe = adSlot;
        this.dexc = iNativeAd;
        this.dexb = iTemplateInteractionListener;
        InsightAdView insightAdViewDexa = dexa(context);
        this.dexd = insightAdViewDexa;
        if (insightAdViewDexa == null) {
            ITemplateInteractionListener iTemplateInteractionListener2 = this.dexb;
            if (iTemplateInteractionListener2 != null) {
                iTemplateInteractionListener2.onAdRenderFail(new AdError(20004, "根视图为空"));
                return;
            }
            return;
        }
        com.wangmai.insightvision.openadsdk.o.a.a aVarDexb = dexb(context);
        this.dexf = aVarDexb;
        if (aVarDexb != null) {
            dexd();
            return;
        }
        ITemplateInteractionListener iTemplateInteractionListener3 = this.dexb;
        if (iTemplateInteractionListener3 != null) {
            iTemplateInteractionListener3.onAdRenderFail(new AdError(20006, "无匹配模板"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexa(com.wangmai.insightvision.openadsdk.common.f fVar) {
        this.dexf.dexb(dex03.dexa(fVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexc() {
        final com.wangmai.insightvision.openadsdk.common.f fVar = this.dexc;
        AdSlot adSlot = this.dexe;
        n1.dexa(fVar, adSlot != null ? adSlot.getSlotId() : "", new n1.dexa() { // from class: com.zj.adlib.n6b
            @Override // cj.mobile.wm.n1.dexa
            public final void a() {
                this.f43463a.dexa(fVar);
            }
        });
    }

    private void dexd() {
        InsightAdView insightAdView = this.dexd;
        if (insightAdView == null) {
            return;
        }
        insightAdView.setAdMonitor(new u1(new dexa()));
    }

    public abstract InsightAdView dexa(Context context);

    public void dexa() {
        if (this.dexc instanceof com.wangmai.insightvision.openadsdk.common.f) {
            h1.dexa().dexa((com.wangmai.insightvision.openadsdk.common.f) this.dexc);
        }
        com.wangmai.insightvision.openadsdk.o.a.a aVar = this.dexf;
        if (aVar != null) {
            aVar.dexy();
            this.dexf = null;
        }
    }

    public void dexa(ViewGroup viewGroup) {
        com.wangmai.insightvision.openadsdk.o.a.a aVar = this.dexf;
        if (aVar != null) {
            aVar.dexb(viewGroup);
        }
    }

    public void dexa(ITemplateInteractionListener iTemplateInteractionListener) {
        this.dexb = iTemplateInteractionListener;
        com.wangmai.insightvision.openadsdk.o.a.a aVar = this.dexf;
        if (aVar != null) {
            aVar.dexa(iTemplateInteractionListener);
        }
    }

    public abstract com.wangmai.insightvision.openadsdk.o.a.a dexb(Context context);

    public void dexb() {
        if (this.dexc instanceof com.wangmai.insightvision.openadsdk.common.f) {
            h1.dexa().dexl((com.wangmai.insightvision.openadsdk.common.f) this.dexc);
        }
        com.wangmai.insightvision.openadsdk.o.a.a aVar = this.dexf;
        if (aVar != null) {
            aVar.dexs();
        }
    }
}
