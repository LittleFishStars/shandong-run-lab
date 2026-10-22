package cj.mobile.wm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kc.openset.sdk.dsp.util.QdActivityType;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.api.listener.INativeInteractionListener;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class r1 {
    public final com.wangmai.insightvision.openadsdk.common.f dexb;
    public List<View> dexh;
    public INativeInteractionListener dexa = null;
    public int dexc = 300;
    public int dexd = 30;
    public View dexe = null;
    public boolean dexf = true;
    public com.wangmai.insightvision.openadsdk.h.f.a dexg = null;
    public m1.dexa dexi = new dexa();
    public final Handler dexj = new dexc(Looper.getMainLooper());

    public class dexa implements m1.dexa {
        public dexa() {
        }

        @Override // cj.mobile.wm.m1.dexa
        public void a() {
            f1.dexb("ViewInteractionHandler", "onDeepLinkCanceled : ");
            if (r1.this.dexb != null) {
                h1.dexa().dexa(r1.this.dexb, "click_user_cancel");
                if (dex03.dexb(r1.this.dexb) == 1) {
                    r1.this.dexd();
                }
            }
        }

        @Override // cj.mobile.wm.m1.dexa
        public void a(boolean z) {
            h1 h1VarDexa;
            com.wangmai.insightvision.openadsdk.common.f fVar;
            String str;
            f1.dexa("ViewInteractionHandler", "onDeepLinkJumped: userConfirmed = " + z);
            if (r1.this.dexb != null) {
                if (z) {
                    h1VarDexa = h1.dexa();
                    fVar = r1.this.dexb;
                    str = "click_user_confirm";
                } else {
                    h1VarDexa = h1.dexa();
                    fVar = r1.this.dexb;
                    str = "click_deeplink_a_jump";
                }
                h1VarDexa.dexa(fVar, str);
            }
            r1.this.dexd();
        }
    }

    public class dexb implements com.wangmai.insightvision.openadsdk.h.f.a.dexa {
        public dexb() {
        }

        public void a(View view) {
            r1.this.dexb(view);
            r1.this.dexj.sendEmptyMessageDelayed(1000, 500L);
        }

        public void dexa(View view) {
        }
    }

    public class dexc extends Handler {
        public dexc(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1000) {
                r1.this.dexj.removeCallbacksAndMessages(1000);
                r1.this.dexb();
            }
        }
    }

    public r1(com.wangmai.insightvision.openadsdk.common.f fVar) {
        this.dexb = fVar;
    }

    private com.wangmai.insightvision.openadsdk.h.f.a dexa(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            com.wangmai.insightvision.openadsdk.h.f.a childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.wangmai.insightvision.openadsdk.h.f.a) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexa(View view) {
        this.dexe = view;
        this.dexf = true;
        dexa();
    }

    private void dexa(String str) {
        if (this.dexb == null) {
            f1.dexb("ViewInteractionHandler", "onExposure ... unifyAdInfo is null ");
        } else if (QdActivityType.IMP.equals(str)) {
            f1.dexa("ViewInteractionHandler", "reportExposeEvent");
            h1.dexa().dexd((INativeAd) this.dexb);
        }
    }

    private void dexa(List<View> list, com.wangmai.insightvision.openadsdk.h.f.a aVar) {
        if (list == null || aVar == null) {
            return;
        }
        aVar.dexa(list, new View.OnClickListener() { // from class: com.zj.adlib.wob
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f45650a.dexa(view);
            }
        });
    }

    private com.wangmai.insightvision.openadsdk.h.f.a dexb(ViewGroup viewGroup) {
        com.wangmai.insightvision.openadsdk.h.f.a aVar = new com.wangmai.insightvision.openadsdk.h.f.a(viewGroup.getContext(), viewGroup, true, this.dexc, false, this.dexd);
        aVar.setCallBack(new dexb());
        viewGroup.addView(aVar);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexb() {
        this.dexf = dex03.dexa(this.dexb);
        n1.dexa(this.dexb, "", new n1.dexa() { // from class: com.zj.adlib.xob
            @Override // cj.mobile.wm.n1.dexa
            public final void a() {
                this.f45866a.dexa();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexb(View view) {
        dexa(QdActivityType.IMP);
        f1.dexa("ViewInteractionHandler", "onShowActions: " + this.dexa);
        INativeInteractionListener iNativeInteractionListener = this.dexa;
        if (iNativeInteractionListener != null) {
            iNativeInteractionListener.onAdShow(view, this.dexb);
        }
    }

    private void dexc() {
        if (this.dexb == null) {
            return;
        }
        dexe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexd() {
        f1.dexa("ViewInteractionHandler", "onAdClickCallback: " + this.dexf + " , mAdInteractionListener = " + this.dexa);
        INativeInteractionListener iNativeInteractionListener = this.dexa;
        if (iNativeInteractionListener != null && this.dexf) {
            try {
                iNativeInteractionListener.onAdClicked(this.dexe, this.dexb);
            } catch (Exception e) {
                f1.dexb("ViewInteractionHandler", "onAdClickCallback: ", e);
            }
            h1.dexa().dexa((INativeAd) this.dexb);
        }
        h1.dexa().dexa((INativeAd) this.dexb, new hc());
    }

    private void dexe() {
        com.wangmai.insightvision.openadsdk.common.f fVar = this.dexb;
        if (fVar != null) {
            fVar.a(true);
            w1.dexb(this.dexb);
        }
    }

    public void dexa() {
        if (be.dexc(this.dexb)) {
            m1.dexb().dexa(this.dexi);
        } else {
            dexd();
        }
        dexc();
        dexa(this.dexh, this.dexg);
    }

    public void dexa(int i) {
        this.dexc = i;
    }

    public void dexa(ViewGroup viewGroup, List<View> list, INativeInteractionListener iNativeInteractionListener) {
        this.dexa = iNativeInteractionListener;
        f1.dexa("ViewInteractionHandler", "handleEvent:  mAdInteractionListener = " + this.dexa);
        com.wangmai.insightvision.openadsdk.h.f.a aVarDexa = dexa(viewGroup);
        if (aVarDexa != null) {
            viewGroup.removeView(aVarDexa);
        }
        float fDexg = dexv.dexj().dexg();
        dexa((int) dexv.dexj().dexh());
        dexb((int) (fDexg * 100.0f));
        com.wangmai.insightvision.openadsdk.h.f.a aVarDexb = dexb(viewGroup);
        aVarDexb.dexa();
        aVarDexb.setClickViews(list);
        aVarDexb.setNativeAd(this.dexb);
        this.dexh = list;
        this.dexg = aVarDexb;
        dexa(list, aVarDexb);
    }

    public void dexb(int i) {
        this.dexd = i;
    }
}
