package com.kwad.components.ad.reward.n;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.helper.SlideConvertHelper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSRatingBar;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends com.kwad.sdk.core.download.a.a implements com.kwad.sdk.widget.d {
    private View CQ;
    private View CR;
    private Button CS;
    private Button CU;
    private TextView CV;
    private ImageView CW;
    private TextView CX;
    private TextView CY;
    private KSRatingBar CZ;
    private KsAppTagsView Da;
    private a Db;
    private volatile boolean Dc = false;
    private com.kwad.components.ad.j.a Dd;
    private Runnable De;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    public interface a {
        void d(boolean z, int i);
    }

    public static class b {
        private float Dg;
        private List<String> Dh;
        private int Di = 15;
        private String Dj;
        private String appName;
        private String tT;
        private String tU;

        public static b af(AdTemplate adTemplate) {
            if (adTemplate == null) {
                return null;
            }
            AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
            b bVar = new b();
            if (com.kwad.sdk.core.response.helper.e.S(adTemplate)) {
                bVar.appName = com.kwad.sdk.core.response.helper.a.aD(adInfoEO);
            } else {
                bVar.appName = com.kwad.sdk.core.response.helper.a.aB(adInfoEO);
            }
            bVar.Dg = com.kwad.sdk.core.response.helper.a.aI(adInfoEO);
            bVar.tU = com.kwad.sdk.core.response.helper.a.aA(adInfoEO);
            if (com.kwad.sdk.core.response.helper.e.S(adTemplate)) {
                bVar.tT = com.kwad.sdk.core.response.helper.a.cV(adInfoEO);
            } else {
                bVar.tT = com.kwad.sdk.core.response.helper.a.cv(adInfoEO);
            }
            if (com.kwad.sdk.core.response.helper.e.n(adTemplate, com.kwad.components.ad.reward.a.b.l(com.kwad.sdk.core.response.helper.e.eO(adTemplate)))) {
                bVar.Di = com.kwad.components.ad.reward.a.b.hN();
                bVar.Dj = "安装并体验%s秒  可领取奖励";
            } else {
                bVar.Di = com.kwad.sdk.core.config.e.JY();
                bVar.Dj = "浏览详情页%s秒，领取奖励";
            }
            bVar.Dh = com.kwad.sdk.core.response.helper.d.eF(adTemplate);
            return bVar;
        }

        public final String lx() {
            return String.format(this.Dj, Integer.valueOf(this.Di));
        }
    }

    public c(View view) {
        this.CQ = view;
        initView();
        this.Dd = new com.kwad.components.ad.j.a(view);
    }

    private void e(View view, boolean z) {
        int id = view.getId();
        if (id == R.id.ksad_reward_apk_info_install_container || id == R.id.ksad_reward_apk_info_install_action || id == R.id.ksad_reward_apk_info_install_start) {
            com.kwad.sdk.core.d.c.d("ApkInfoCardViewHelper", "onClick install");
            this.Dc = true;
            a aVar = this.Db;
            if (aVar != null) {
                aVar.d(z, 1);
            }
        }
    }

    private void initView() {
        this.CS = (Button) this.CQ.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.CU = (Button) this.CQ.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.CR = this.CQ.findViewById(R.id.ksad_reward_apk_info_install_container);
        this.CW = (ImageView) this.CQ.findViewById(R.id.ksad_reward_apk_info_icon);
        this.CV = (TextView) this.CQ.findViewById(R.id.ksad_reward_apk_info_name);
        this.CX = (TextView) this.CQ.findViewById(R.id.ksad_reward_apk_info_desc);
        this.CZ = (KSRatingBar) this.CQ.findViewById(R.id.ksad_reward_apk_info_score);
        this.Da = (KsAppTagsView) this.CQ.findViewById(R.id.ksad_reward_apk_info_tags);
    }

    public final void j(String str, int i) {
        Button button = this.CU;
        if (button == null || str == null || i == 0) {
            return;
        }
        button.setText(str);
    }

    public final void lv() {
        Runnable runnable;
        com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
        if (dVar != null) {
            dVar.c(this);
        }
        com.kwad.components.ad.j.a aVar = this.Dd;
        if (aVar != null) {
            aVar.lv();
        }
        View view = this.CR;
        if (view == null || (runnable = this.De) == null) {
            return;
        }
        view.removeCallbacks(runnable);
        this.De = null;
    }

    public final void lw() {
        this.Dd.ol();
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFailed() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.CU.setText(adTemplate != null ? com.kwad.sdk.core.response.helper.a.aK(com.kwad.sdk.core.response.helper.e.eO(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadFinished() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.CU.setText(adTemplate == null ? "" : com.kwad.sdk.core.response.helper.a.cK(adTemplate));
    }

    @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
    public final void onDownloadStarted() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onIdle() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.CU.setText(adTemplate != null ? com.kwad.sdk.core.response.helper.a.aK(com.kwad.sdk.core.response.helper.e.eO(adTemplate)) : "立即下载");
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onInstalled() {
        AdTemplate adTemplate = this.mAdTemplate;
        this.CU.setText(adTemplate != null ? com.kwad.sdk.core.response.helper.a.af(com.kwad.sdk.core.response.helper.e.eO(adTemplate)) : "立即打开");
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i) {
        super.onPaused(i);
        if (i != 0) {
            this.Dd.ol();
            this.CU.setText(com.kwad.sdk.core.response.helper.a.eG(i));
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public final void onProgressUpdate(int i) {
        if (i != 0) {
            this.Dd.ol();
            this.CU.setText(com.kwad.sdk.core.response.helper.a.eF(i));
        }
    }

    public final void a(com.kwad.components.core.e.d.d dVar) {
        this.mApkDownloadHelper = dVar;
        if (dVar != null) {
            dVar.b(this);
        }
    }

    public final void c(AdTemplate adTemplate, boolean z) {
        this.mAdTemplate = adTemplate;
        b bVarAf = b.af(adTemplate);
        if (bVarAf == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.CW, bVarAf.tT, adTemplate, 12);
        this.CV.setText(bVarAf.appName);
        this.CX.setText(bVarAf.tU);
        this.CZ.setStar(bVarAf.Dg);
        if (com.kwad.sdk.core.response.helper.e.n(adTemplate, com.kwad.components.ad.reward.a.b.l(com.kwad.sdk.core.response.helper.e.eO(adTemplate)))) {
            this.CU.setText(com.kwad.sdk.core.response.helper.a.aK(com.kwad.sdk.core.response.helper.e.eO(adTemplate)));
            this.CZ.setVisibility(0);
        } else {
            this.CU.setText("查看详情");
            this.CZ.setVisibility(8);
        }
        this.CS.setText(bVarAf.lx());
        this.CS.setClickable(true);
        this.CU.setClickable(true);
        this.CR.setClickable(true);
        new com.kwad.sdk.widget.h(this.CS, this);
        new com.kwad.sdk.widget.h(this.CU, this);
        new com.kwad.sdk.widget.h(this.CR, this);
        List<String> list = bVarAf.Dh;
        if (z && list.size() == 0) {
            this.CX.setVisibility(8);
            TextView textView = (TextView) this.CQ.findViewById(R.id.ksad_reward_apk_info_desc_2);
            this.CY = textView;
            textView.setVisibility(0);
            this.CY.setText(bVarAf.tU);
        }
        if (list.size() == 0) {
            this.Da.setVisibility(8);
        }
        this.Da.setAppTags(list);
        if (this.De == null) {
            this.De = new Runnable() { // from class: com.kwad.components.ad.reward.n.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.c.d("ApkInfoCardViewHelper", hashCode() + " parentHeight: " + c.this.CR.getHeight());
                    if (c.this.Dc) {
                        return;
                    }
                    c.this.Dd.jq();
                }
            };
        }
        this.CR.postDelayed(this.De, 1600L);
    }

    public final void a(a aVar) {
        this.Db = aVar;
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        e(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view, float f, float f2, float f3, float f4) {
        if (SlideConvertHelper.a(this.mAdTemplate, f, f2, f3, f4)) {
            e(view, false);
        }
    }
}
