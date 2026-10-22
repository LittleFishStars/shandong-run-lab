package com.kwad.components.core.page.d.a;

import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.b.h;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends a {
    private LinearLayout aej;
    private TextView aek;
    private TextView ael;
    private TextView aem;
    private TextView aen;
    private int aeo;
    private boolean aep = false;
    private boolean aeq = false;
    private Runnable aer = new Runnable() { // from class: com.kwad.components.core.page.d.a.c.1
        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.aep) {
                by.runOnUiThreadDelay(this, 500L);
                return;
            }
            if (c.this.aeo <= 0) {
                c.this.aek.setText("任务已完成");
                c.this.ael.setVisibility(8);
                c.this.aem.setVisibility(8);
                c.this.aen.setVisibility(8);
                h hVar = (h) com.kwad.sdk.components.d.f(h.class);
                if (hVar != null && !c.this.aeq) {
                    hVar.notifyRewardVerify();
                }
            } else {
                c.this.uo();
                by.runOnUiThreadDelay(this, 1000L);
            }
            c.i(c.this);
        }
    };
    private final com.kwad.sdk.core.c.c Bq = new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.core.page.d.a.c.2
        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* JADX INFO: renamed from: onActivityPaused */
        public final void c(Activity activity) {
            super.c(activity);
            c.this.aep = true;
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* JADX INFO: renamed from: onActivityResumed */
        public final void d(Activity activity) {
            super.d(activity);
            c.this.aep = false;
        }
    };

    public static /* synthetic */ int i(c cVar) {
        int i = cVar.aeo;
        cVar.aeo = i - 1;
        return i;
    }

    private void un() {
        this.aej.setVisibility(0);
        if (!this.adZ.mAdTemplate.mRewardVerifyCalled) {
            uo();
            by.runOnUiThreadDelay(this.aer, 1000L);
        } else {
            this.aek.setText("任务已完成");
            this.ael.setVisibility(8);
            this.aem.setVisibility(8);
            this.aen.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uo() {
        this.ael.setText(up());
        this.aen.setText(uq());
    }

    private String up() {
        int i = this.aeo / 60;
        if (i >= 10) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            return sb.toString();
        }
        return "0" + i;
    }

    private String uq() {
        int i = this.aeo % 60;
        if (i >= 10) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            return sb.toString();
        }
        return "0" + i;
    }

    @Override // com.kwad.components.core.page.d.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.a(this.Bq);
        this.aeo = com.kwad.sdk.core.config.e.JY();
        un();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aej = (LinearLayout) findViewById(R.id.ksad_reward_land_page_open_tip);
        this.aek = (TextView) findViewById(R.id.ksad_reward_land_page_open_desc);
        this.ael = (TextView) findViewById(R.id.ksad_reward_land_page_open_minute);
        this.aem = (TextView) findViewById(R.id.ksad_reward_land_page_open_colon);
        this.aen = (TextView) findViewById(R.id.ksad_reward_land_page_open_second);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.b(this.Bq);
        by.b(this.aer);
    }
}
