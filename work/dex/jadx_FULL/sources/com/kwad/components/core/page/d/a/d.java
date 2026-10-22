package com.kwad.components.core.page.d.a;

import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends a {
    private View aet;
    private TextView aeu;
    private int aev;
    private Runnable aew = new Runnable() { // from class: com.kwad.components.core.page.d.a.d.1
        @Override // java.lang.Runnable
        public final void run() {
            if (com.kwad.components.core.r.a.wm().wp()) {
                by.runOnUiThreadDelay(this, 500L);
                return;
            }
            if (d.this.aev <= 0) {
                d.this.aeu.setText("已获得权益");
                by.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.d.a.d.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.aet.setVisibility(8);
                    }
                }, 500L);
                com.kwad.components.core.r.a.wm().ba(true);
            } else {
                d.this.aeu.setText(String.format("倒计时%d秒", Integer.valueOf(d.this.aev)));
                d.c(d.this);
                com.kwad.components.core.r.a.wm().bW(d.this.aev);
                by.runOnUiThreadDelay(this, 1000L);
            }
        }
    };

    public static /* synthetic */ int c(d dVar) {
        int i = dVar.aev;
        dVar.aev = i - 1;
        return i;
    }

    private void ur() {
        TextView textView;
        if (this.aet == null || (textView = this.aeu) == null) {
            return;
        }
        textView.setText(String.format("倒计时%d秒", Integer.valueOf(this.aev)));
        this.aet.setVisibility(0);
        by.runOnUiThreadDelay(this.aew, 1000L);
    }

    @Override // com.kwad.components.core.page.d.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aev = com.kwad.sdk.core.response.helper.a.aS(com.kwad.sdk.core.response.helper.e.eO(this.adZ.mAdTemplate));
        com.kwad.components.core.r.a.wm().bW(this.aev);
        ur();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aet = findViewById(R.id.ksad_web_reward_task_layout);
        this.aeu = (TextView) findViewById(R.id.ksad_web_reward_task_text);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        by.b(this.aew);
    }
}
