package com.kwad.components.ad.reward.n;

import android.app.DialogFragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class m extends d implements View.OnClickListener {
    private DialogFragment DT;
    private View DW;
    private ViewGroup Ej;
    private View Ek;
    private TextView El;
    private TextView Em;
    private TextView En;
    private View Eo;
    private ImageView iF;
    private TextView kO;
    private com.kwad.components.ad.reward.h.a tI;

    public m(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, com.kwad.components.ad.reward.h.a aVar) {
        this.DT = dialogFragment;
        this.tI = aVar;
        if (com.kwad.sdk.core.response.helper.a.cY(com.kwad.sdk.core.response.helper.e.eO(adTemplate))) {
            this.Ej = (ViewGroup) layoutInflater.inflate(R.layout.ksad_live_origin_dialog, viewGroup, false);
            t(true);
        } else {
            this.Ej = (ViewGroup) layoutInflater.inflate(R.layout.ksad_live_subscribe_dialog, viewGroup, false);
            t(false);
        }
    }

    private void t(boolean z) {
        this.Ek = this.Ej.findViewById(R.id.ksad_live_subscribe_dialog_btn_close);
        this.kO = (TextView) this.Ej.findViewById(R.id.ksad_live_subscribe_dialog_title);
        this.iF = (ImageView) this.Ej.findViewById(R.id.ksad_live_subscribe_dialog_icon);
        this.Em = (TextView) this.Ej.findViewById(R.id.ksad_live_subscribe_dialog_content_txt);
        this.El = (TextView) this.Ej.findViewById(R.id.ksad_live_subscribe_dialog_content);
        this.DW = this.Ej.findViewById(R.id.ksad_live_subscribe_dialog_btn_continue);
        this.Eo = this.Ej.findViewById(R.id.ksad_live_subscribe_dialog_btn_deny);
        this.En = (TextView) this.Ej.findViewById(R.id.ksad_live_subscribe_dialog_vide_detail);
        if (z) {
            this.Ek.setVisibility(8);
        }
        this.Ek.setOnClickListener(this);
        this.DW.setOnClickListener(this);
        this.Eo.setOnClickListener(this);
        this.En.setOnClickListener(this);
    }

    public final void a(com.kwad.components.ad.reward.h.c cVar) {
        KSImageLoader.loadCircleIcon(this.iF, cVar.hA(), this.Ej.getContext().getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar));
        String title = cVar.getTitle();
        if (this.kO != null && title != null) {
            SpannableString spannableString = new SpannableString(title);
            int color = ib().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 2, 4, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = title.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.kO.setText(spannableString);
        }
        this.El.setText(cVar.hB());
        this.Em.setText(cVar.hC());
        this.En.setText(String.format("%s", cVar.tR));
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup ib() {
        return this.Ej;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ad.reward.h.a aVar;
        if (view.equals(this.Ek)) {
            this.DT.dismiss();
            com.kwad.components.ad.reward.h.a aVar2 = this.tI;
            if (aVar2 != null) {
                aVar2.hv();
                return;
            }
            return;
        }
        if (view.equals(this.DW)) {
            this.DT.dismiss();
            com.kwad.components.ad.reward.h.a aVar3 = this.tI;
            if (aVar3 != null) {
                aVar3.hv();
                return;
            }
            return;
        }
        if (!view.equals(this.Eo)) {
            if (!view.equals(this.En) || (aVar = this.tI) == null) {
                return;
            }
            aVar.h(131, 2);
            return;
        }
        this.DT.dismiss();
        com.kwad.components.ad.reward.h.a aVar4 = this.tI;
        if (aVar4 != null) {
            aVar4.H(false);
        }
    }
}
