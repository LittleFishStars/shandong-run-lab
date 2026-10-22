package cj.mobile.wm;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cj.mobile.wm.appsdkdex.R;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.api.listener.ITemplateInteractionListener;
import com.wangmai.insightvision.openadsdk.entity.insight.AdApkInfo;
import com.wangmai.insightvision.openadsdk.player.ui.InsightPlayerView;
import com.wangmai.insightvision.openadsdk.proxy.InsightProxy;
import com.wangmai.insightvision.openadsdk.template.rendering.reward.IRewardInteractionListener;
import com.wangmai.insightvision.openadsdk.view.InsightAdView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class od extends com.wangmai.insightvision.openadsdk.o.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f22671a;
    public int b;
    public String c;
    public int d;
    public ImageView dex02;
    public RelativeLayout dex03;
    public TextView dex04;
    public TextView dex05;
    public TextView dex06;
    public View dex07;
    public TextView dex08;
    public TextView dex09;
    public TextView dex10;
    public ImageView dex11;
    public int dex12;
    public boolean dex13;
    public rd dex14;
    public ImageView dex15;
    public boolean dex16;
    public TextView dex17;
    public TextView dex18;
    public TextView dex19;
    public TextView dex20;
    public boolean e;
    public boolean f;
    public boolean g;

    public class dexa extends com.wangmai.insightvision.openadsdk.o.a.a.dexg {
        public dexa() {
        }

        public void dexa(boolean z, Bitmap bitmap, String str) {
            if (!z || bitmap == null || bitmap.isRecycled()) {
                return;
            }
            od.this.dex15.setImageBitmap(bitmap);
            od.this.dex15.setVisibility(0);
        }
    }

    public class dexb implements kd<Boolean> {
        public dexb() {
        }

        @Override // cj.mobile.wm.kd
        public void a(int i, String str) {
            HashMap map = new HashMap();
            map.put("errorCode", String.valueOf(i));
            map.put("errorMsg", str);
            od.this.dexb(false, 1, map);
        }

        @Override // cj.mobile.wm.kd
        /* JADX INFO: renamed from: dexa, reason: merged with bridge method [inline-methods] */
        public void a(Boolean bool) {
            od.this.dexb(bool.booleanValue(), 1, null);
        }
    }

    public class dexc implements kd<String> {
        public dexc() {
        }

        @Override // cj.mobile.wm.kd
        public void a(int i, String str) {
        }

        @Override // cj.mobile.wm.kd
        /* JADX INFO: renamed from: dexa, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            od.this.c = str;
        }
    }

    public od(Context context, InsightAdView insightAdView, AdSlot adSlot, INativeAd iNativeAd) {
        super(context, insightAdView, adSlot, iNativeAd);
        this.dex13 = false;
        this.dex16 = false;
        this.e = false;
        this.f = false;
        this.g = false;
    }

    private void dexa(boolean z, int i, Map<String, String> map) {
        ITemplateInteractionListener iTemplateInteractionListener = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexo;
        if (iTemplateInteractionListener != null && (iTemplateInteractionListener instanceof IRewardInteractionListener)) {
            f1.dexa(com.wangmai.insightvision.openadsdk.o.a.a.dex01, "onRewardArrived ... mListener " + z + " , rewardType = " + i);
            ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexo.onRewardArrived(z, i, map);
        }
        if (z) {
            h1.dexa().dexj((com.wangmai.insightvision.openadsdk.common.f) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc);
        } else {
            h1.dexa().dexi((com.wangmai.insightvision.openadsdk.common.f) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexb(int i) {
        this.dex12 = i;
        if (this.d == 0 || i > 5 || TextUtils.isEmpty(this.c) || this.e) {
            return;
        }
        dexc(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexb(boolean z, int i, Map<String, String> map) {
        f1.dexa(com.wangmai.insightvision.openadsdk.o.a.a.dex01, "onRewardArrived ... " + z + " , rewardType = " + i);
        this.f22671a = z;
        this.b = i;
        dexa(z, i, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexe(View view) {
        if (this.dex13) {
            q();
            dexw();
        } else {
            n();
            this.dex16 = true;
            dexl();
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexf(View view) {
        this.dex07.setVisibility(8);
        this.dex16 = false;
        dexo();
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexg(View view) {
        this.dex07.setVisibility(8);
        dexw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexh(View view) {
        this.dex07.setVisibility(8);
        this.dex16 = false;
        dexo();
        o();
    }

    private int e() {
        int iDexc = be.dexc(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc);
        if (iDexc <= 0) {
            return 25;
        }
        return iDexc;
    }

    private String f() {
        return ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc.w();
    }

    private com.wangmai.insightvision.openadsdk.d.e g() {
        String str;
        String str2;
        com.wangmai.insightvision.openadsdk.d.e eVar = new com.wangmai.insightvision.openadsdk.d.e();
        Map extraInfo = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc.getExtraInfo();
        String str3 = "";
        if (extraInfo != null) {
            String str4 = extraInfo.containsKey("req_id") ? (String) extraInfo.get("req_id") : "";
            str2 = extraInfo.containsKey("imp_id") ? (String) extraInfo.get("imp_id") : "";
            str = extraInfo.containsKey("slot_id") ? (String) extraInfo.get("slot_id") : "";
            str3 = str4;
        } else {
            str = "";
            str2 = str;
        }
        String strDexa = tc.dexa(g1.dexc().dexa());
        eVar.a("trans_id", str3);
        eVar.a("imp_id", str2);
        eVar.a("utdid", strDexa);
        eVar.a("slot_id", str);
        return eVar;
    }

    private void h() {
        this.dex02.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.mlb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f43331a.dexe(view);
            }
        });
    }

    private void i() {
        String str;
        this.f22671a = false;
        this.e = false;
        this.f = false;
        AdApkInfo adApkInfoF = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc.f();
        String subtitle = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc.getSubtitle();
        String title = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc.getTitle();
        if (adApkInfoF != null) {
            String packageName = adApkInfoF.getPackageName();
            str = (TextUtils.isEmpty(packageName) || he.dexd(InsightProxy.getApplication(), packageName) == null) ? "立即下载" : "打开应用";
        } else {
            str = "查看详情";
        }
        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(subtitle)) {
            if (TextUtils.isEmpty(subtitle)) {
                subtitle = title;
            }
            this.dex18.setVisibility(8);
            this.dex17.setVisibility(8);
            this.dex20.setVisibility(0);
            this.dex20.setText(subtitle);
        } else {
            this.dex17.setText(title);
            this.dex18.setText(subtitle);
            this.dex17.setVisibility(0);
            this.dex18.setVisibility(0);
            this.dex20.setVisibility(8);
        }
        l();
        this.dex19.setText(str);
    }

    private boolean j() {
        String strF = f();
        f1.dexa(com.wangmai.insightvision.openadsdk.o.a.a.dex01, "isValidByServer ... rewardValidType : " + strF);
        return "server".equals(strF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        this.dex04.setVisibility(8);
        this.dex05.setVisibility(8);
        this.dex06.setText((this.b == 0 || this.f22671a) ? "恭喜获得奖励" : "奖励发放失败");
    }

    private void l() {
        String adLogoUrl = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc.getAdLogoUrl();
        this.dex15.setVisibility(8);
        if (TextUtils.isEmpty(adLogoUrl)) {
            return;
        }
        dexa(adLogoUrl, new dexa());
    }

    private void m() {
        if (this.f) {
            return;
        }
        this.f = true;
        this.c = null;
        if (j()) {
            new ld().dexa(g(), new dexc());
        }
    }

    private void n() {
        rd rdVar = this.dex14;
        if (rdVar != null) {
            rdVar.dexa();
        }
    }

    private void o() {
        rd rdVar = this.dex14;
        if (rdVar != null) {
            rdVar.dexb();
        }
    }

    private void p() {
        rd rdVar = this.dex14;
        if (rdVar != null) {
            rdVar.dexc();
            return;
        }
        int iE = e();
        this.d = iE;
        rd rdVar2 = new rd(this.dex04, iE, new rd.dexb() { // from class: com.zj.adlib.klb
            @Override // cj.mobile.wm.rd.dexb
            public final void a() {
                this.f42853a.b();
            }
        }, new rd.dexc() { // from class: com.zj.adlib.llb
            @Override // cj.mobile.wm.rd.dexc
            public final void a(int i) {
                this.f43098a.dexb(i);
            }
        });
        this.dex14 = rdVar2;
        rdVar2.dexc();
    }

    private void q() {
        rd rdVar = this.dex14;
        if (rdVar != null) {
            rdVar.dexd();
        }
    }

    private void r() {
        AdSlot adSlot = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexd;
        String slotId = adSlot != null ? adSlot.getSlotId() : "";
        if (!o1.dexa(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc, slotId)) {
            dexa(dexz());
            dexa(dex03());
            dexb(this.dex19);
            return;
        }
        f1.dexa(com.wangmai.insightvision.openadsdk.o.a.a.dex01, "isTouchJumpEnable: true, slotId = " + slotId);
        dexb(dexz());
        dexb(dex03());
        dexb(this.dex19);
        ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexk = true;
    }

    public abstract int a();

    public void b() {
        f1.dexa(com.wangmai.insightvision.openadsdk.o.a.a.dex01, "onContentShowComplete.");
        this.dex13 = true;
        n();
        dexa(new Runnable() { // from class: com.zj.adlib.qlb
            @Override // java.lang.Runnable
            public final void run() {
                this.f44242a.k();
            }
        });
        if (this.g) {
            ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexy.postDelayed(new Runnable() { // from class: com.zj.adlib.rlb
                @Override // java.lang.Runnable
                public final void run() {
                    this.f44481a.dexw();
                }
            }, 1000L);
        }
        if (j()) {
            return;
        }
        dexb(true, 0, null);
    }

    public void c() {
        n();
        this.dex16 = true;
        dexl();
        d();
    }

    public void d() {
        this.dex07.setVisibility(0);
        int i = this.dex12;
        if (i <= 0) {
            i = 1;
        }
        this.dex08.setText("再看" + i + "秒就可以获得奖励");
        this.dex09.setText("继续播放");
        this.dex10.setText("坚持退出");
        this.dex11.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.nlb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f43555a.dexf(view);
            }
        });
        this.dex10.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.olb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f43776a.dexg(view);
            }
        });
        this.dex09.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.plb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f44010a.dexh(view);
            }
        });
    }

    public ImageView dex01() {
        return (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_dsp_logo);
    }

    public TextView dex02() {
        return (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.fanti_ad_txt_dsp_name);
    }

    public InsightPlayerView dex03() {
        return ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_ad_video);
    }

    public ImageView dex04() {
        return (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_ad_mute);
    }

    public void dex05() {
        this.dex02 = (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_ad_close);
        this.dex03 = (RelativeLayout) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_ad_header_layout);
        this.dex04 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_ad_count_text);
        this.dex05 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_ad_count_text_pre);
        this.dex06 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_ad_count_text_post);
        this.dex15 = (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_ad_image_logo);
        this.dex17 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_ad_txt_title);
        this.dex18 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_ad_txt_subtitle);
        this.dex19 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_ad_btn_download);
        this.dex20 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_ad_video_title);
        this.dex07 = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_exit_dialog_layout);
        this.dex08 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_exit_title);
        this.dex09 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_exit_continue_play);
        this.dex10 = (TextView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_exit_cancel);
        this.dex11 = (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_ad_dialog_close);
        this.dex07.setClickable(true);
        i();
        h();
        r();
        if (be.dexa(((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc)) {
            dexa((ViewGroup) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_ad_shake_layout));
        }
    }

    public void dex13() {
        super.dex13();
        r();
    }

    public void dexa(boolean z) {
        f1.dexa(com.wangmai.insightvision.openadsdk.o.a.a.dex01, "onWindowFocusChanged  ... hasFocus = " + z + " , isManualPaused = " + this.dex16);
        if (!z) {
            n();
            dexl();
        } else {
            if (this.dex16) {
                return;
            }
            o();
            dexo();
        }
    }

    public void dexc(String str) {
        this.e = true;
        com.wangmai.insightvision.openadsdk.d.e eVarG = g();
        eVarG.a("token", str);
        Map extraInfo = ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexc.getExtraInfo();
        if (extraInfo != null) {
            eVarG.a("reward_param", extraInfo.get("req_params"));
        }
        new md().dexa(eVarG, new dexb());
    }

    public void dexd(boolean z) {
        this.g = z;
    }

    public void dexf() {
        super.dexf();
        m();
    }

    public void dexg() {
        super.dexg();
    }

    public void dexi() {
        super.dexi();
        if (this.dex16) {
            return;
        }
        p();
        dexo();
    }

    public void dexj() {
        super.dexj();
        n();
        dexl();
    }

    public ImageView dexz() {
        return (ImageView) ((com.wangmai.insightvision.openadsdk.o.a.a) this).dexb.findViewById(R.id.reward_ad_image);
    }
}
