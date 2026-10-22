package cj.mobile.wm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cj.mobile.wm.appsdkdex.R;
import cj.mobile.wm.td;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.api.listener.ITemplateInteractionListener;
import com.wangmai.insightvision.openadsdk.player.ui.InsightPlayerView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class td extends com.wangmai.insightvision.openadsdk.o.a.a {
    public rd dex02;
    public boolean dex03;
    public boolean dex04;
    public View dex05;
    public View dex06;
    public TextView dex07;
    public ImageView dex08;
    public TextView dex09;
    public boolean dex10;
    public String dex11;

    public td(Context context, com.wangmai.insightvision.openadsdk.template.rendering.splash.a aVar, AdSlot adSlot, INativeAd iNativeAd) {
        super(context, aVar, adSlot, iNativeAd);
        this.dex03 = true;
        this.dex04 = false;
        this.dex10 = false;
    }

    public static /* synthetic */ void dexb(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexe(View view) {
        rd rdVar = this.dex02;
        if (rdVar != null) {
            rdVar.dexa();
        }
        dexq();
        i();
        h1.dexa().dexe(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc);
        ITemplateInteractionListener iTemplateInteractionListener = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexo;
        if (iTemplateInteractionListener != null) {
            iTemplateInteractionListener.onAdClosed();
        }
    }

    private int h() {
        int iDexe = be.dexe(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc);
        if (iDexe <= 0) {
            return 5;
        }
        return iDexe;
    }

    private void i() {
    }

    private void j() {
        if (this.dex02 == null) {
            this.dex02 = new rd(this.dex07, h(), new rd.dexb() { // from class: com.zj.adlib.srb
                @Override // cj.mobile.wm.rd.dexb
                public final void a() {
                    this.f44763a.e();
                }
            }, new rd.dexc() { // from class: com.zj.adlib.trb
                @Override // cj.mobile.wm.rd.dexc
                public final void a(int i) {
                    td.dexb(i);
                }
            });
        }
        this.dex02.dexc();
    }

    public View a() {
        return this.dex06;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void b() {
        if (this.dex06 != null) {
            this.dex10 = false;
            AdSlot adSlot = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexd;
            String slotId = adSlot != null ? adSlot.getSlotId() : "";
            if (o1.dexa(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc, slotId)) {
                f1.dexa(com.wangmai.insightvision.openadsdk.o.a.a.dex01, "isTouchJumpEnable: true, slotId = " + slotId);
                ViewGroup viewGroup = (ViewGroup) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.root_ad_stub_view);
                viewGroup.setClickable(true);
                dexb(viewGroup);
                ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexk = true;
            } else {
                dexb(this.dex06);
            }
        }
        View view = this.dex05;
        if (view != null) {
            view.setClickable(true);
            this.dex05.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.rrb
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f44523a.dexe(view2);
                }
            });
        }
    }

    public void c() {
        ITemplateInteractionListener iTemplateInteractionListener = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexo;
        if (iTemplateInteractionListener != null) {
            iTemplateInteractionListener.onAdFinished();
        }
    }

    public void d() {
        rd rdVar;
        f1.dexa(com.wangmai.insightvision.openadsdk.o.a.a.dex01, "notifyViewClick: mClickedOnce = " + this.dex04 + "mAdClickable = " + this.dex03);
        if (this.dex04) {
            return;
        }
        this.dex04 = true;
        if (!this.dex03 || (rdVar = this.dex02) == null) {
            return;
        }
        rdVar.dexd();
    }

    public ImageView dex01() {
        return (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_dsp_logo);
    }

    public TextView dex02() {
        return (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_txt_dsp_name);
    }

    public InsightPlayerView dex03() {
        return ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_video_view);
    }

    public ImageView dex04() {
        return null;
    }

    public void dex05() {
        this.dex05 = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_count_and_skip_container_ex);
        this.dex06 = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_click_message_container_ex);
        this.dex07 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_txt_count_down);
        this.dex08 = (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_youku_logo);
        this.dex09 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_txt_title);
        this.dex09.setText(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexa.getResources().getString(R.string.fanti_ad_splash_click_tips_pre) + w1.dexa(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc, ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexa));
        b();
    }

    public void dexa(Activity activity) {
        super.dexa(activity);
        if (this.dex10 && TextUtils.isEmpty(this.dex11) && activity != null) {
            f1.dexa(com.wangmai.insightvision.openadsdk.o.a.a.dex01, "onActivityPaused:" + activity.getLocalClassName() + ", mNeedCloseAd = " + this.dex10);
            this.dex11 = activity.getLocalClassName();
        }
    }

    public void dexa(boolean z) {
        if (this.dex10) {
            return;
        }
        if (z) {
            g();
        } else {
            f();
        }
    }

    public void dexb(Activity activity) {
        super.dexb(activity);
        if (!this.dex10 || TextUtils.isEmpty(this.dex11) || activity == null || !this.dex11.equals(activity.getLocalClassName())) {
            return;
        }
        f1.dexa(com.wangmai.insightvision.openadsdk.o.a.a.dex01, "onActivityResumed:" + activity.getLocalClassName());
        this.dex10 = false;
        c();
    }

    public void dexb(ViewGroup viewGroup) {
        if (((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc instanceof com.wangmai.insightvision.openadsdk.common.f) {
            h1.dexa().dexk((com.wangmai.insightvision.openadsdk.common.f) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc);
        }
        super.dexb(viewGroup);
    }

    public void dexc(View view) {
        super.dexc(view);
        d();
    }

    public void dexi() {
        super.dexi();
        j();
    }

    public void dexk() {
        super.dexk();
        this.dex10 = true;
    }

    public ImageView dexz() {
        return (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_image_view);
    }

    public void e() {
        dexq();
        i();
        h1.dexa().dexb(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc);
        c();
    }

    public void f() {
        rd rdVar = this.dex02;
        if (rdVar != null) {
            rdVar.dexa();
        }
        dexl();
    }

    public void g() {
        rd rdVar = this.dex02;
        if (rdVar != null) {
            rdVar.dexb();
        }
        dexo();
    }
}
