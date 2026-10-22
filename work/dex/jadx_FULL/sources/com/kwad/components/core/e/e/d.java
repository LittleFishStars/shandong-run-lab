package com.kwad.components.core.e.e;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends b implements View.OnClickListener {
    private TextView RN;
    private TextView RO;
    private TextView uJ;

    @Override // com.kwad.components.core.e.e.b, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public final void ay() {
        super.ay();
        if (this.RM.RL.pQ() == 1) {
            this.uJ.setText("即将打开" + com.kwad.sdk.core.response.helper.a.ct(this.mAdInfo));
        } else if (this.RM.RL.pQ() == 2) {
            this.uJ.setText("即将打开第三方页面");
        }
        com.kwad.sdk.c.a.a.a(this, this.RN, this.RO);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.RM.RL.ao(true);
        this.RM.RJ.dismiss();
        if (view == this.RN) {
            com.kwad.components.core.e.d.a.a(this.RM.RL);
            com.kwad.sdk.core.adlog.c.t(this.RM.RL.getAdTemplate(), MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT);
        } else if (view == this.RO) {
            com.kwad.sdk.core.adlog.c.t(this.RM.RL.getAdTemplate(), 231);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.uJ = (TextView) findViewById(R.id.ksad_second_confirm_content_view);
        this.RN = (TextView) findViewById(R.id.ksad_second_confirm_ensure);
        this.RO = (TextView) findViewById(R.id.ksad_second_confirm_cancle);
    }
}
